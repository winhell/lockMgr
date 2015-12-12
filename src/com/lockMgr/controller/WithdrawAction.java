package com.lockMgr.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IUserordertService;
import com.lockMgr.service.IWithdrawService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 * 提现控制器
 */

public class WithdrawAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1161884319343024608L;
	private String[] idlist;
	private String id;
	private int page;
	private int rows;
	private String sort;
	private double amount;
	private String alipayAccount;
	private String accountName;
	private String openingBank;
	private Timestamp beginDate;
	private Timestamp endDate;
	private int status;
	
	private IWithdrawService withdrawService;
	private IBusinessService businessService;
	private IUserRoleService userRoleService;
	private IUserService userService;
	private IUserordertService uotService;
	
	/**
	 * 根据不同角色查询(商户和管理员)提现记录
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getWithdrawByPage() throws IOException {
		Map session = (Map) this.getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		if(o.getRoleName().equals("管理员") || 
				userRoleService.findById(userService.findById(o.getId()).getUserRoleId()).getName().equals("管理员")) {
			withdrawService.findWithdrawByPage(json, page, rows, sort, null, beginDate, endDate, status);
		} else {
			withdrawService.findWithdrawByPage(json, page, rows, sort,  
					businessService.findBusinessIdByUserId(o.getId()), beginDate, endDate, status);
		}
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 商户申请提现
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	public void apply() throws IOException {
		Map session = (Map) this.getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);  //此时的operator是商户登录
		Map m = new HashMap();
		/**
		 * 用户申请提现时需检查
		 * 1.他上次申请提现日期
		 * 		1.1.上次申请成功，则从上次申请日期(包括这天)开始算有多少盈利，算出是否够这次的提现申请金额
		 * 		1.2.上次申请还未审核，提示上次已经申请提现管理员还未处理，是否重新申请(需删除上次未审核的)
		 * 			1.2.1.重新申请从上上次成功开始算出是否够这次的提现金额
		 * 		1.3.上次申请失败，联系管理员或做1.2.1操作
		 */
		//提现日期是每个月的1-8号
		if(Calendar.getInstance().getTime().getDate() > 8) {
			m.put(KeyEnum.STATUS, StatusEnum.failed);
			m.put(KeyEnum.REASON, "申请失败，申请日期为每个月1-8号！");
		} else {
			//距上次成功提现至今所有营业额
			double all = uotService.findRevenueByBusinessId(businessService.findBusinessIdByUserId(o.getId()));
			if(amount > all) {
				m.put(KeyEnum.STATUS, StatusEnum.failed);
				m.put(KeyEnum.REASON, "申请失败，申请提现金额超过距上次提现成功至今营业额！");
			} else {
				withdrawService.applySave(businessService.findBusinessIdByUserId(o.getId()), 
						amount, alipayAccount, accountName);
				m.put(KeyEnum.STATUS, StatusEnum.success);
			}
		}
		jsonViewIE(m);
	}
	
	/**
	 * 商户撤销提现
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void cancelApply() throws IOException {
		Map session = (Map) this.getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);  //此时的operator是商户登录
		Map m = new HashMap();
		//先检测该请求的记录是否都能撤销
		Boolean b = withdrawService.checkCancelApply(idlist);
		if(b == true) {
			withdrawService.cancelApply(idlist, o);
			m.put(KeyEnum.STATUS, StatusEnum.success);
		} else {
			m.put(KeyEnum.STATUS, StatusEnum.failed);
			m.put(KeyEnum.REASON, "撤销失败,撤销队列中存在有'审核通过'提现记录!!");
		}
		jsonViewIE(m);
	}

	/**
	 * 通过审核
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void passed() throws IOException {
		Map m = new HashMap();
		withdrawService.passed(idlist);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 拒绝审核
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void denyAudit() throws IOException {
		Map m = new HashMap();
		withdrawService.denyAudit(idlist);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getAlipayAccount() {
		return alipayAccount;
	}

	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getOpeningBank() {
		return openingBank;
	}

	public void setOpeningBank(String openingBank) {
		this.openingBank = openingBank;
	}

	public IWithdrawService getWithdrawService() {
		return withdrawService;
	}

	public void setWithdrawService(IWithdrawService withdrawService) {
		this.withdrawService = withdrawService;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Timestamp getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserordertService getUotService() {
		return uotService;
	}

	public void setUotService(IUserordertService uotService) {
		this.uotService = uotService;
	}
	
	
	

}
