package com.lockMgr.service;


import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Menu;
import com.lockMgr.pojo.Operator;

public interface IMenuService  extends IBaseDao<Menu>{
	public List<Menu> getMenuNav();
	public List<Menu> getSubMenu(int porder);
	public void txSaveMenu(Operator oper,Menu menu);
	public void txDeleteMenu(Operator oper,String[] idList);
	public void txUpdateMenu(Operator oper,Menu menu,String id);
		
}
