package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resource;
import com.lockMgr.pojo.Resourceofsoftware;
import com.lockMgr.service.IResourceOfSoftwareService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 * 软件下载控制器
 */

public class ResourceOfSoftwareAction extends BaseAction {
	private String title;
	private Resource resource;
	private String[] idlist;
	private String id;
	private int page;
	private int rows;
	private String describe;
	private int score;
	private String address;
	private int limit;
	
	private IResourceOfSoftwareService resourceOfSoftwareService;
	
	String path = ServletActionContext.getServletContext().getContextPath();
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL();
	
	/**
	 * 分页查询软件下载资源
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getResourceOfSoftwareByPage() throws IOException {
		Map m = new HashMap();
		resourceOfSoftwareService.getResourceOfSoftwareByPage(m, page, rows, title);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 手机端分页查询软件下载资源
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getPhoneResourceOfSoftwareByPage() throws IOException {
		Map json = new HashMap();
		String addressNow = "";
		String[] path2 = path1.toString().split(path);
		List<Resourceofsoftware> list = resourceOfSoftwareService.findPhoneResourceOfSoftwareByPage(page, limit);
		if(list.size() != 0 && list != null) {
			for(int i=0; i<list.size(); i++) {
				addressNow = list.get(i).getAddress().replace("!/", "");
				list.get(i).setAddress(path2[0] + "/" + addressNow);
			}
		}
		json.put("success", true);
		json.put("resource", list);
		Utils.senchaview(json);
	}
	
	/**
	 * 增加软件下载资源
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void addResourceOfSoftware() throws IOException {
		Map m = new HashMap();
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		resourceOfSoftwareService.addResourceOfSoftware(o, score, title, describe, address);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 修改软件下载资源
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void editResourceOfSoftware() throws IOException {
		Map m = new HashMap();
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if(! resourceOfSoftwareService.editResourceOfSoftware(id, o, score, title, describe)) {
			status = StatusEnum.failed;
			reason = "修改失败!";
		}
		m.put(KeyEnum.STATUS, status);
		m.put(KeyEnum.REASON, reason);
		jsonViewIE(m);
	}
	
	/**
	 * 删除软件下载资源
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteResourceOfSoftware() throws IOException {
		Map m = new HashMap();
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		resourceOfSoftwareService.deleteResourceOfSoftware(idlist, o);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Resource getResource() {
		return resource;
	}
	public void setResource(Resource resource) {
		this.resource = resource;
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
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public IResourceOfSoftwareService getResourceOfSoftwareService() {
		return resourceOfSoftwareService;
	}
	public void setResourceOfSoftwareService(
			IResourceOfSoftwareService resourceOfSoftwareService) {
		this.resourceOfSoftwareService = resourceOfSoftwareService;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	
}
