package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Menu;
import com.lockMgr.pojo.Operator;

public interface IOperatorService  extends IBaseDao<Operator>{
	public Operator verifyUser(String username, String password);
	public void getOperatorByPage(Map map, final int page, final int pageSize,String account,String roleId,Operator oper);
	public int txSave(Operator operator,Operator OperatorToSave);
	public void txDel(Operator operator, String[] idlist);
	public boolean txUpdate(Operator oper,Operator operator,String id);
	public List<Menu> getPrivileges(Operator operator);
	public void txCommonOperator(String id ,String account,String password, String roleId);
	public void txUpgradeCommonToStore(String userId);
	/**
	 * 会员完善信息
	 */
	public void txEditOperator(String name, String account, String userRoleId);
	
	/**
	 * 修改密码
	 */
	public void updatePassword(String userId, String password);
}
