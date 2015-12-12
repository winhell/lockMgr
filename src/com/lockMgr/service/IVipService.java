package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Vip;

/**
 * vip接口
 */
public interface IVipService extends IBaseDao<Vip> {
	/**
	 * 查询vip是否过期
	 * true：代表过期
	 * false：没过期
	 */
	public boolean isExpire(String userId);
	
	/**
	 * 根据用户id判断是否会员
	 */
	public List<Vip> isVIP(String userId);
	
	/**
	 * 根据用户id由普通用户升级为VIP
	 */
	public boolean registerVIP(String userId);

}
