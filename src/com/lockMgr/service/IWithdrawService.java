package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Withdraw;

/**
 * 提现表接口
 */

public interface IWithdrawService extends IBaseDao<Withdraw> {
	
	/**
	 * 根据不同角色查询(商户和管理员)提现记录
	 */
	@SuppressWarnings("rawtypes")
	public List<Withdraw> findWithdrawByPage(Map map, int page, int pageSize, String sortAttr,
			String operId, Timestamp beginDate, Timestamp endDate, int status);
	
	/**
	 * 最近一次商户提现成功日期
	 * 查询到：返回查询到的日期
	 * 查询不到：1.一次(上次)或多次(上上次...)申请的提现都未审核通过
	 * 			2.该商户至今未申请过提现
	 */
	public Date lastApplyTimeSuccess(String businessId);
	
	/**
	 * 保存商户提现申请
	 */
	public void applySave(String businessId, double amount, String alipayAccount, String accountName);
	
	/**
	 * 商户撤销提现申请
	 */
	public void cancelApply(String[] idList, Operator o);
	
	/**
	 * 商户撤销申请时检查状态该提现申请是否已通过管理员审核
	 * true：表示可以撤销(idList中的所有记录都未审核)
	 * false:表示不能撤销
	 */
	public boolean checkCancelApply(String[] idList);

	/**
	 * 通过审核
	 */
	public void passed(String[] withdrawIdList);
	
	/**
	 * 拒绝审核
	 */
	public void denyAudit(String[] withdrawIdList);
	
	/**
	 * 根据支付宝传递过来的参数组(批量付款id),修改审核状态
	 * success调用
	 */
	public void updateWithdraw(HttpServletRequest request, String[] idList, int status);
	
	/**
	 * 根据idlist[] 查询各提现申请详情
	 */
	public Map findDetailsByIdlist(String[] idlist);
}
