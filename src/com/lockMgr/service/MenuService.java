package com.lockMgr.service;

import java.util.List;


import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Menu;
import com.lockMgr.pojo.Operator;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings("unchecked")
public class MenuService extends BaseDao<Menu> implements IMenuService
{


	@Override
	public List<Menu> getMenuNav()
	{
		
		String hql = "from Menu where  porder='0' order by order";
		return find(hql);
	}

	@Override
	public List<Menu> getSubMenu(int porder)
	{
		Object[] obj=new Object[1];
		obj[0]=porder;
		String hql = "from Menu where  porder=? order by order";
		return find(hql,obj);
	}


	@Override
	public void txSaveMenu(Operator oper, Menu menu)
	{
		menu.setId(null);
		 int order=0;
		 Object object=null;
		 Object[] obj=new Object[1];
		if(menu.getPorder()==0)
		{
	       object=uniqueResult("select Max(m.order) from Menu m where  porder='0'");
	       if(object!=null)
	       {
	    	  order=(Integer) object;
	          menu.setOrder(order+1);
	       }
	       else
	       {
	    	   menu.setOrder(0);
	       }
		}
		else
		{
			obj[0]=menu.getPorder();
			object=uniqueResult("select Max(m.order) from Menu m where porder=?",obj);
			if(object!=null)
			{
				order=(Integer)object;
			    menu.setOrder(order+1);
			}
			else
			{
				menu.setOrder(menu.getPorder()*100+1);
			}
		}
		menu.setStatus(0);
		save(menu);
		writeLog(oper,"添加","菜单",menu);
	}

	@Override
	public void txDeleteMenu(Operator oper, String[] idList)
	{
		Menu menu=null;
		Object[] obj=new Object[1];
		for (String id : idList)
		{
			menu=findById(id);
			if(menu.getPorder()==0)
			{
				obj[0]=menu.getOrder();
				delete(find("from Menu where porder=?",obj));
				delete(menu);
				
			}
			else
			{
				delete(menu);
			}
			writeLog(oper, "删除", "菜单", menu);
		}
		return;
		
	}

	@Override
	public void txUpdateMenu(Operator oper, Menu menu, String id)
	{
		   Menu newMenu=findById(id);
		    newMenu.setName(menu.getName());
		    newMenu.setComment(menu.getComment());
			newMenu.setIcon(menu.getIcon());
			newMenu.setUrl(menu.getUrl());
			 saveOrUpdate(newMenu);
	    writeLog(oper,"修改","菜单",newMenu);		
		
	}

}
