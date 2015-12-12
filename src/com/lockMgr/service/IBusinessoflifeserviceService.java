package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Businessoflifeservice;

/**
 * 生活服务商户接口
 */

public interface IBusinessoflifeserviceService extends IBaseDao<Businessoflifeservice> {
	/**
	 * 分页查询生活服务商户
	 */
	public List<Businessoflifeservice> findBusinessOfLiftServiceByPage(int page, int pageSize, int type);
	
	/**
	 * 新增生活服务商户
	 */
	public boolean addBusinessOfLifeService(int type, String userId, 
			String company, int phone, String address, String description);

}
