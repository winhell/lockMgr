package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.lockMgr.pojo.GroupbuyLocks;
import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.IGroupbuyLocksService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

public class GroupbuyAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1103507631891254355L;
	private String id;
	private int page;
	private int rows;
	private String locksId;
	private String type;
	private String origin;
	private String businessId;
	private String order;
	private String sort;
	private String[] idlist;
	
	private GroupbuyLocks gb;
	
	private IGroupbuyLocksService gbService;
	private IBusinessService businessService;
	
	/**
	 * 分页查询团购锁
	 * @throws IOException
	 */
	@SuppressWarnings({"unchecked", "rawtypes" })
	public void getGroupbuyByPage() throws IOException {
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		if(operator.getRoleName().equals("管理员"))
			gbService.findGbByPage(json, page, rows, locksId, type, origin, businessId, order, sort);
		else 
			gbService.findGbByPage(json, page, rows, locksId, type, origin, 
					businessService.findBusinessIdByUserId(operator.getId()), order, sort);
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 添加团购锁
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addGbLocks() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		gbService.txAddGb(oper, gb);
		json.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(json);
	}
	
	/**
	 * 修改团购锁
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void editGbLocks() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if (!gbService.txUpdate(oper, gb, id)) {
			status = StatusEnum.failed;
			reason = "修改失敗";
		}
		jsondata.put(KeyEnum.STATUS, status);
		jsondata.put(KeyEnum.REASON, reason);
		jsonViewIE(jsondata);
	}
	
	/**
	 * 删除团购锁
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteGbLocks() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		gbService.txDel(oper, idlist);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
	}

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public GroupbuyLocks getGb() {
		return gb;
	}

	public void setGb(GroupbuyLocks gb) {
		this.gb = gb;
	}

	public IGroupbuyLocksService getGbService() {
		return gbService;
	}

	public void setGbService(IGroupbuyLocksService gbService) {
		this.gbService = gbService;
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

	public String getLocksId() {
		return locksId;
	}

	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}
	

}
