package com.alipay;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lockMgr.core.Utils;

/**
 * 转账servlet
 */
public class TransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//通知页面
	String notifyUrlTransfer = "http://192.168.7.118:8080/lockMgr/notify_url_transfer.jsp";  //本机测试ip和端口

	public void doGet(HttpServletRequest request,HttpServletResponse response) {
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
		String accountName = "";
		//付款详细数据(格式为：流水号^收款方账号^收款账号姓名^付款金额^备注说明|...)
		String detailData = request.getParameter("detailData");
		//批量付款批次号(11-23位数字或字母组合)
		String batchNo = "";
		//付款总笔数
		String batchNum = request.getParameter("batchNum");
		//付款总金额(精确到分：10.01)
		String batchFee = request.getParameter("batchFee");
		//支付日期(当前日期，yyyyMMdd)
		String payDate = new SimpleDateFormat("yyyyMMdd").format(Utils.getNow());
		//付款账号(付款方支付宝账号)
		String email = "";
		//付款账号别名(*可空)
//		String buyerAccountName = "";
		//业务扩张参数(*可空，传递的话需要和支付宝约定)
//		String extendParam = "";
		
		/*
		 * 基本参数sign赋值
		 */
		String sign = setSignValue(service, partner, inputCharset, accountName, notifyUrl,
				detailData,batchNo, batchNum, batchFee, payDate, email);
		
		StringBuffer sb = new StringBuffer();
		sb.append("http://mapi.alipay.com/gateway.do?");
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
//		sb.append("&buyer_account_name=" + buyerAccountName);
//		sb.append("&extend_param=" + extendParam);
		
		try {
			response.sendRedirect(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		doGet(request, response);
	}
	
	/**
	 * 签名
	 */
	public String setSignValue(String service, String partner, String inputCharset, String accountName, String notifyUrl,
			String detailData, String batchNo, String batchNum, String batchFee, String payDate, String email) {
		return "_input_charset=" + inputCharset + "&account_name=" + accountName + "&batch_fee=" + batchFee 
				+ "&batch_no=" + batchNo + "&batch_num=" + batchNum + "&detail_data=" + detailData + "&email=" + email 
				+ "&notify_url=" + notifyUrl + "&partner=" + partner + "&pay_date=" + payDate + "&service=" + service;
	}

}
