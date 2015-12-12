package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Businessoflifeservice;
import com.lockMgr.service.IBusinessoflifeserviceService;

/**
 * 生活服务商户action
 */

public class BusinessoflifeserviceAction {
	private int page;
	private int limit; //同pageSize
	private int type;
	private String userId;
	private String company;
	private int phone;
	private String address;
	private String description;
	
	private IBusinessoflifeserviceService businessoflifeserviceService;
	
	/**
	 * 分页查询生活服务商户
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getBusinessOfLiftServiceByPage() throws IOException {
		Map m = new HashMap();
		List<Businessoflifeservice> list = 
				businessoflifeserviceService.findBusinessOfLiftServiceByPage(page, limit, type);
		if(list != null && list.size() != 0) {
			m.put("success", true);
			m.put("BusinessoflifeserviceList", list);
		} else {
			m.put("success", true);
			m.put("msg", "目前该分类暂无信息!");
		}
		Utils.senchaview(m);
	}
	
	/**
	 * 新增生活服务商户
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addBusinessOfLifeService() throws IOException {
		Map m = new HashMap();
		boolean b = businessoflifeserviceService.addBusinessOfLifeService(type, userId, company, phone, address, description);
		if(b == true) {
			m.put("success", true);
			m.put("msg", "添加成功!");
		} else {
			m.put("success", false);
			m.put("msg", "添加失败,请稍后重试!");
		}
		Utils.senchaview(m);
	}

	
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IBusinessoflifeserviceService getBusinessoflifeserviceService() {
		return businessoflifeserviceService;
	}

	public void setBusinessoflifeserviceService(
			IBusinessoflifeserviceService businessoflifeserviceService) {
		this.businessoflifeserviceService = businessoflifeserviceService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
