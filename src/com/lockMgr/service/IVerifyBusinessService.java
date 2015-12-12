package com.lockMgr.service;

import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.VerifyBusiness;

public interface IVerifyBusinessService extends IBaseDao<VerifyBusiness> {
	/**
	 * 分页查询同行
	 */
	@SuppressWarnings("rawtypes")
	public void findPeersByPage(Map m, int page, int pageSize, int verify,
			String orderType, String sortAttr, String path);
	
	/**
	 * 通过审核
	 */
	public void passVerify(String id);
	
	/**
	 * 拒绝审核
	 */
	public void refuseVerify(String id);
	
	/**
	 * 删除同行
	 */
	public void deletePeers(String[] id);
	
	/**
	 * 判断用户是否为同行
	 */
	public boolean isVerifyBusiness(String userId);

}
