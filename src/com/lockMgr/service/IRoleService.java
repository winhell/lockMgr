package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Role;
import com.lockMgr.pojo.Tree;

public interface IRoleService  extends IBaseDao<Role>{
	public List<Role> getRole(Operator oper);
	public void txSaveRole(Operator oper,Role role);
	public void txDeleteRole(Operator oper,String[] idList);
	public void txUpdateRole(Operator oper,Role role,String id);
	public Tree getPrivilegesTree(Operator oper, String roleId);
	public void txSavePrivilege(Operator oper, String roleId, String[] menuOrderList);
	public List<NameAndId> getAllRoleNameAndId(Operator oper); //获取所有的角色名和id
	
	public List<NameAndId> getRoleNameAndId(Operator oper); //获取belongId为空的角色名和id
}
