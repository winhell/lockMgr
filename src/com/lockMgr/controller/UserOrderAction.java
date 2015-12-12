package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.util.KeyEnum;

/**
 * 用户订单(后台)
 */
public class UserOrderAction extends BaseAction {
	private int page;
	private int rows;
	private String[] idlist;
	private String id;
	
	/**
	 * 分页查询团购锁订单
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void getGroupOrderByPage() throws IOException {
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		
		jsonViewIE(json);
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
	}
	
	

}
