package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;

public interface IUserService  extends IBaseDao<User>
{
	public void getUserByPage(Map map, final int page, final int pageSize,String account,String roleId,Operator oper);
	
	public int txSave(Operator operator,User user);
	public void txDel(Operator operator, String[] idlist);
	public boolean txUpdate(Operator operator,User user,String id);
	
	public User verifyUser(String uername,String password);
	
	
	/**
	 * 根据用户名查询该用户信息
	 */
	public User findUserByAccount(String account);
	
	/**
	 * 根据邮箱查询该用户信息
	 */
	public User findUserByEmail(String email);
	
	/**
	 * 注册判断是否重名(用户名和邮箱两者判断)
	 */
	public boolean checkingUser(String account, String email);
	
	/**
	 * 普通用户升级为商户
	 */
	public void txUpgradeCommonToStore(String userId);
	
	/**
	 * 检查用户角色
	 */
	public String checkUserrole(String userId);
	
	/**
	 * 完善会员信息
	 */
	public void editUser(String id, String name, String account, boolean gender, String phone, 
			Date birthday, String email, String userRoleId, String comment, String image);
	
	/**
	 * 根据邮箱查询用户
	 */
	public User findByUserByEmail(String email);
	
	/**
	 * 修改密码
	 */
	public void updatePassword(String userId, String password);
	
	/**
	 * 判断用户是否vip
	 */
	public boolean isVIP(String userId);
	
}
