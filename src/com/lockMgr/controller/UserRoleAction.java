/**
 * 
 */
package com.lockMgr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Tree;
import com.lockMgr.pojo.Userrole;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings({ "rawtypes" })
public class UserRoleAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4779692247834026042L;
	private IUserRoleService userRoleService;
	private Userrole role;
	private String roleId;
	private String[] idlist;
	private String id;
	private String menuId;
	private String[] menuIdList;
	
	
	public void setUserRoleService(IUserRoleService userRoleService)
	{
		this.userRoleService = userRoleService;
	}
	@SuppressWarnings("unchecked")
	public String getAllRole() throws IOException
	{
		List<Userrole> list = null;
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null)
		{
			list = userRoleService.getRole(oper);
			jsondata.put("rows", list);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		else
		{
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}
	@SuppressWarnings("unchecked")
	public String addRole() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null)
		{
		    userRoleService.txSaveRole(oper,role);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		else
		{
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public String deleteRole() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null)
		{
		    userRoleService.txDeleteRole(oper,idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		else
		{
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}
	@SuppressWarnings("unchecked")
	public String editRole() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null)
		{
		    userRoleService.txUpdateRole(oper,role,id);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		else
		{
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}
	@SuppressWarnings("unchecked")
	public String getPrivilegesTree() throws IOException
	{

		Map<String, Object> session = this.getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		if (null != oper)
		{
				Tree tree = userRoleService.getPrivilegesTree(oper, roleId);
				List<Tree> list = new ArrayList<Tree>();
				list.add(tree);
				jsonViewIE(list);
		}
		else
		{
           return null;
		}
		return null;
	}
	@SuppressWarnings("unchecked")
	public String savePrivilege() throws Exception
	{
		StatusEnum status;
		Map jsondata = new HashMap();
		Map map = getSession();
		Operator oper = (Operator) map.get(KeyEnum.OPERATOR);
			if (null == oper)
			{
				status = StatusEnum.timeout;
			}
			else
			{
				userRoleService.txSavePrivilege(oper,roleId,menuIdList);
				status = StatusEnum.success;
			}
		jsondata.put(KeyEnum.STATUS, status);
		jsonViewIE(jsondata);
		return null;
	}
	
	 public String getAllRoleIdAndComment() throws IOException
	    {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(userRoleService.getAllRoleNameAndId(oper));
		return null;
	    }
	    
	 public String getRoleIdAndComment() throws IOException
	    {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(userRoleService.getRoleNameAndId(oper));
		return null;
	    }
	 


	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}
	public String getRoleId()
	{
		return roleId;
	}
	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}
	public String getMenuId()
	{
		return menuId;
	}
	public void setMenuId(String menuId)
	{
		this.menuId = menuId;
		menuIdList=menuId.replaceAll("'", "").split(",");
	}
	public Userrole getRole() {
		return role;
	}
	public void setRole(Userrole role) {
		this.role = role;
	}
	public String[] getIdlist() {
		return idlist;
	}
	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}
	public String[] getMenuIdList() {
		return menuIdList;
	}
	public void setMenuIdList(String[] menuIdList) {
		this.menuIdList = menuIdList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	
}
