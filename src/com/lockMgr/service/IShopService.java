package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Busilocks;

public interface IShopService extends IBaseDao<Busilocks> {
	/**
	 * 首页查询(包含商品商户的6个信息)
	 * @return
	 */
	public List<Busilocks> findHomePage(int page, int pageSize);
	
}
