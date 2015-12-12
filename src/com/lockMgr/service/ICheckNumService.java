package com.lockMgr.service;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Checknum;

public interface ICheckNumService extends IBaseDao<Checknum> {
	/*
	 * 判断用户输入校验码
	 */
	public boolean checkUserNum(String userId, int checkNum);

}
