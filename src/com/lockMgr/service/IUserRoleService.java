package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Role;
import com.lockMgr.pojo.Tree;
import com.lockMgr.pojo.Userrole;

public interface IUserRoleService  extends IBaseDao<Userrole>{
	public List<Userrole> getRole(Operator oper);
	public void txSaveRole(Operator oper,Userrole role);
	public void txDeleteRole(Operator oper,String[] idList);
	public void txUpdateRole(Operator oper,Userrole role,String id);
	public Tree getPrivilegesTree(Operator oper, String roleId);
	public void txSavePrivilege(Operator oper, String roleId, String[] menuOrderList);
	public List<NameAndId> getAllRoleNameAndId(Operator oper); //获取所有的角色名和id
	public List<NameAndId> getRoleNameAndId(Operator oper); //获取belongId为空的角色名和id
	/**
	 * 根据角色名称查询该角色id
	 */
	public String findIdByName(String name);
}
