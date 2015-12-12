package com.lockMgr.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.lockMgr.core.Utils;
import com.lockMgr.service.IWithdrawService;

/**
 * 批量转账Action
 */
public class AlipayAction {
	public String params;  //需要重定向所带参数
	//通知页面
	private String notifyUrlTransfer = "http://192.168.7.118:8080/lockMgr/notify_url_transfer.jsp";  //本机测试ip和端口
	private String id;  //各商户提现申请记录id(用于查询提现申请详细信息Withdraw)
	private String[] idlist; 
	
	private IWithdrawService withdrawService;
	
	@SuppressWarnings("unused")
	public String execute() throws UnsupportedEncodingException {
		/**
		 * 基本参数
		 */
		//接口名称
		String service = "batch_trans_notify"; //批量转账
		//合作身份者(潭水龙申请的)ID
		String partner = "2088411811768241"; //2088开头的16位纯数字
		//参数编码字符集
		String inputCharset = "utf-8";
		//签名方式
		String signType = "MD5"; //另外还有DSA,RSA.
		//签名(除sign,signType其他参数排序)
//		String sign = ""; //由于对近乎所有字段排序，必须各字段都有值再排序，所以sign放最后赋值
		//服务器异步通知页面路径(*可空)
		String notifyUrl = notifyUrlTransfer;
		/**
		 * 业务参数
		 */
		//付款账号名
		String accountName = java.net.URLEncoder.encode("潭水龙", "utf-8");
		//付款详细数据(格式为：流水号^收款方账号^收款账号姓名^付款金额^备注说明|...)
		String detailData = setDetailData(withdrawService.findDetailsByIdlist(idlist));
		//批量付款批次号(11-23位数字或字母组合)
		String batchNo = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + new Random().nextInt(10000);
		//付款总笔数
		String batchNum = (String) withdrawService.findDetailsByIdlist(idlist).get("count");
		//付款总金额(精确到分：10.01)
		String batchFee = (String) withdrawService.findDetailsByIdlist(idlist).get("allAmount");
		//支付日期(当前日期，yyyyMMdd)
		String payDate = new SimpleDateFormat("yyyyMMdd").format(Utils.getNow());
		//付款账号(付款方支付宝账号)
		String email = "103496758@qq.com";
		//付款账号别名(*可空)
//		String buyerAccountName = "";
		//业务扩张参数(*可空，传递的话需要和支付宝约定)
//		String extendParam = "";
		//各申请提现记录id
		String outTradeNo = idlist.toString();
		
		/*
		 * 基本参数sign赋值
		 */
		String sign = setSignValue(service, partner, inputCharset, accountName, notifyUrl,
				detailData,batchNo, batchNum, batchFee, payDate, email, outTradeNo);
		
		StringBuffer sb = new StringBuffer();
//		sb.append("http://mapi.alipay.com/gateway.do?");  //sutruts-lzc.xml中配置了
		sb.append("service=" + service);
		sb.append("&partner=" + partner);
		sb.append("&_input_charset=" + inputCharset);
		sb.append("&sign_type=" + signType);
		sb.append("&sign=" + sign);
		sb.append("&notify_url=" + notifyUrl);
		sb.append("&account_name=" + accountName);
		sb.append("&detail_data=" + detailData);
		sb.append("&batch_no=" + batchNo);
		sb.append("&batch_num=" + batchNum);
		sb.append("&batch_fee=" + batchFee);
		sb.append("&pay_date=" + payDate);
		sb.append("&email=" + email);
		sb.append("&out_trade_no=" + outTradeNo);
//		sb.append("&buyer_account_name=" + buyerAccountName);
//		sb.append("&extend_param=" + extendParam);
		//需要传递给sutruts-lzc.xml配置文件的参数
		String params = sb.toString();
		return "ok";
	}

	/**
	 * 待签名参数字符串排序
	 */
	public String setSignValue(String service, String partner, String inputCharset, String accountName, 
			String notifyUrl, String detailData, String batchNo, String batchNum, String batchFee, 
			String payDate, String email, String outTradeNo) {
		return "_input_charset=" + inputCharset + "&account_name=" + accountName + "&batch_fee=" + batchFee 
				+ "&batch_no=" + batchNo + "&batch_num=" + batchNum + "&detail_data=" + detailData 
				+ "&email=" + email + "&notify_url=" + notifyUrl + "&out_trade_no=" + outTradeNo 
				+ "&partner=" + partner + "&pay_date=" + payDate + "&service=" + service;
	}
	
	/**
	 * 设置详细数据参数
	 * @throws UnsupportedEncodingException 
	 */
	@SuppressWarnings({ "rawtypes", "null" })
	public String setDetailData(Map m) throws UnsupportedEncodingException {
		StringBuffer sb = null;
		List alipayAccountList = (List) m.get("alipayAccountList");
		List accountNameList = (List) m.get("accountNameList");
		List amountList = (List) m.get("amountList");
		for(int i=0; i<amountList.size(); i++) {
			sb.append(new SimpleDateFormat("yyMMddHHmmss").format(new Date()) + new Random().nextInt(1000));
			sb.append("^");
			sb.append(alipayAccountList.get(i));
			sb.append("^");
			sb.append(java.net.URLEncoder.encode((String) accountNameList.get(i), "utf-8"));
			sb.append("^");
			sb.append(amountList.get(i));
			sb.append("|");
		}
		String detailData = sb.substring(0, sb.length()-2);  //去掉最后个"|"
		return detailData;
	}
	
	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public IWithdrawService getWithdrawService() {
		return withdrawService;
	}

	public void setWithdrawService(IWithdrawService withdrawService) {
		this.withdrawService = withdrawService;
	}
	

}
