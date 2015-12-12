package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Businessoflifeservice;

/**
 * 生活服务商户实现类
 */

public class BusinessoflifeserviceService extends BaseDao<Businessoflifeservice>
		implements IBusinessoflifeserviceService  {
	
	/**
	 * 分页查询生活服务商户
	 */
	public List<Businessoflifeservice> findBusinessOfLiftServiceByPage(int page, int pageSize, int type) {
		List<Businessoflifeservice> bolsList = new ArrayList<Businessoflifeservice>();
		String hql = " from Businessoflifeservice where type=? order by createtime ";
		if(page != 0 && pageSize != 0) {
			bolsList = findByPage(hql, new Object[]{type}, (page-1)*pageSize, pageSize);
		} else{
			bolsList = find(hql, new Object[]{type});
		}
		return bolsList;
	}
	
	/**
	 * 新增生活服务商户
	 */
	public boolean addBusinessOfLifeService(int type, String userId, 
			String company, int phone, String address, String description) {
		try {
			Businessoflifeservice b = new Businessoflifeservice();
			b.setType(type);
			b.setUserId(userId);
			b.setCompany(java.net.URLDecoder.decode(company, "UTF-8"));
			b.setPhone(phone);
			b.setAddress(java.net.URLDecoder.decode(address, "UTF-8"));
			b.setDescription(java.net.URLDecoder.decode(description, "UTF-8"));
			save(b);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
