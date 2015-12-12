package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Checknum;

@SuppressWarnings("unchecked")
public class CheckNumService extends BaseDao<Checknum> implements ICheckNumService {
	/*
	 * 判断用户输入校验码
	 */
	@SuppressWarnings("rawtypes")
	public boolean checkUserNum(String userId, int checkNum) {
		boolean re = false;
		List createtimeList = publicFind(" select MAX(createtime) from Checknum where userid='" + userId + "'");
		if(createtimeList == null){
			re = false;
		} else {
			List<Checknum> checkNumList = 
					find(" from Checknum where createtime=? and userId=?", new Object[]{createtimeList.get(0), userId});
			if(checkNumList != null && checkNumList.size() != 0) {
				int dbcn = checkNumList.get(0).getCheckNum();
				if(dbcn == checkNum) 
					re = true;
			}
		}
		return re;
	}

}
