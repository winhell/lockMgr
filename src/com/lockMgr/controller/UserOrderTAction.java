package com.lockMgr.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IUserordertService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 * 后台订单控制层
 */

public class UserOrderTAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5569044311834761253L;
	private String[] idlist;
	private String id;
	private int page;
	private int rows;
	private String sort;
	private String gblocksId;
	private String locksId;
	private String userName;
	private String businessId;
	private Timestamp beginDate;
	private Timestamp endDate;
	private int status;
	
	private IUserordertService uotService;
	private IBusinessService businessService;
	private IUserService userService;
	private IUserRoleService userRoleService;
	
	/**
	 * 分页查询团购订单
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getGLOByPage() throws IOException {
		Map session = (Map) this.getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		//判断operator表或user表中的角色是否为管理员
		if(o.getRoleName().equals("管理员") || 
				userRoleService.findById(userService.findById(o.getId()).getUserRoleId()).getName().equals("管理员")) {
			uotService.findGroupOrderByPage(json, page, rows, gblocksId, status, userName, sort, businessId, beginDate, endDate);
		}else {
			uotService.findGroupOrderByPage(json, page, rows, gblocksId, status, userName, sort, 
					businessService.findBusinessIdByUserId(o.getId()), beginDate, endDate);
		}
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 分页查询基本锁订单
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getLOByPage() throws IOException {
		Map session = (Map) this.getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
//		String operatorId = o.getId();
//		String businessId = businessService.findBusinessIdByUserId(operatorId);
		Map json = new HashMap();
		if(o.getRoleName().equals("管理员") || 
				userRoleService.findById(userService.findById(o.getId()).getUserRoleId()).getName().equals("管理员")) {
			uotService.findLockOrderByPage(json, page, rows, locksId, status, userName, sort, businessId, beginDate, endDate);
		} else {
			uotService.findLockOrderByPage(json, page, rows, locksId, status, userName, sort, 
					businessService.findBusinessIdByUserId(o.getId()), beginDate, endDate);
		}
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 发货
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateOrderDelivery() throws IOException {
		Map json = new HashMap();
		uotService.updateOrderDelivery(idlist);
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 退货
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updateOrderReturn() throws IOException {
		Map json = new HashMap();
		uotService.updateOrderReturn(idlist);
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
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

	public String getGblocksId() {
		return gblocksId;
	}

	public void setGblocksId(String gblocksId) {
		this.gblocksId = gblocksId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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

	public IUserordertService getUotService() {
		return uotService;
	}

	public void setUotService(IUserordertService uotService) {
		this.uotService = uotService;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLocksId() {
		return locksId;
	}

	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}
	
	

}
