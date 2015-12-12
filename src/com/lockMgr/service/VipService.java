package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Vip;

/**
 * vip实现类
 */
public class VipService extends BaseDao<Vip> implements IVipService {
	private IUserRoleService userRoleService;
	private IUserService userService;
	private IOperatorService operatorService;
	
	/**
	 * 查询vip是否过期
	 * true：代表过期
	 * false：没过期
	 */
	public boolean isExpire(String userId) {
		String hql = " from Vip where userId=? and status=1 ";
		List<Vip> list = find(hql, new Object[]{userId});
		if(list != null && list.size() != 0) {
			Date endDate = list.get(0).getEndtime();
			Date nowDate = Utils.getNow();
			if(nowDate.getTime() > endDate.getTime()) {  //如果现在日期 > 会员结束日期  表示过期
				/*
				 * 过期的话就删除该条数据，以免造成再次充值会员查询同样userid问题
				 */
				delete(list.get(0));
				return true;
			} else
				return false;
		} else
			return true;
	}
	
	/**
	 * 根据用户id判断是否会员
	 */
	public List<Vip> isVIP(String userId) {
		String hql = " from Vip where status=1 and userId=? ";
		List<Vip> vipList = find(hql, new Object[]{userId});
		if(vipList != null && vipList.size() != 0) 
			return vipList;
		return null;
	}
	
	/**
	 * 根据用户id由普通用户升级为VIP
	 */
	public boolean registerVIP(String userId) {
		try {
			/**
			 * 1.更新user表用户角色
			 * 2.更新operator表用户角色
			 * 3.在vip表插入该用户信息
			 */
			String VIPRoleId = userRoleService.findIdByName("VIP会员");
			User user = userService.findById(userId);
			user.setUserRoleId(VIPRoleId);
			userService.saveOrUpdate(user);
			Operator operator = operatorService.findById(userId);
			operator.setRoleId(VIPRoleId);
			operatorService.saveOrUpdate(operator);
			//接下来插入vip数据
			Timestamp nowDate = Utils.getNow();
			Timestamp endDate = Utils.getNow();
			long   nDay=(nowDate.getTime()/(24*60*60*1000)+1+365)*(24*60*60*1000);
			endDate.setTime(nDay);  //endDate此时已是365天后的日期
			Vip vip = new Vip();
			vip.setCreatetime(nowDate);
			vip.setEndtime(endDate);
			vip.setUserId(userId);
			vip.setStatus(1);
			save(vip);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IOperatorService getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}

}
