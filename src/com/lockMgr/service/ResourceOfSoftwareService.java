package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resourceofsoftware;

/**
 * 软件下载实现类
 */

@SuppressWarnings("unchecked")
public class ResourceOfSoftwareService 
		extends BaseDao<Resourceofsoftware> implements IResourceOfSoftwareService {
	/**
	 * 分页查询软件下载资源
	 */
	@SuppressWarnings({  "rawtypes" })
	public void getResourceOfSoftwareByPage(Map m, int page, int pageSize, String title) {
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = " from Resourceofsoftware where status=1";
		if (null != title && title.trim().length() != 0) {
			hql += " and title like ?";
			al.add("%" + title + "%");
			paramNums++;
		}
		Object[] values = al.toArray(new Object[paramNums]);
        Long count = getCount(hql, values);
        List<Resourceofsoftware> list = findByPage(hql, values, (page-1)*pageSize, pageSize);
        if(list != null && list.size() != 0) {
        	for(int i=0; i<list.size(); i++) 
        		list.get(i).setResourceAndDataType("软件下载资源");
        }
        m.put("total", count);
        m.put("rows", list);
	}
	
	/**
	 * 手机端分页查询软件下载资源
	 */
	public List<Resourceofsoftware> findPhoneResourceOfSoftwareByPage(int page, int pageSize) {
		List<Resourceofsoftware> list = new ArrayList<Resourceofsoftware>();
		if(page == 0 || pageSize == 0) 
			list = find(" from Resourceofsoftware where status=1 ");
		else
			list = findByPage(" from Resourceofsoftware where status=1 ", null, (page - 1) * pageSize, pageSize);
		return list;
	}
	
	/**
	 * 增加软件下载资源
	 */
	public void addResourceOfSoftware(Operator o, int score, String title, String describe, String address) {
		Resourceofsoftware ros = new Resourceofsoftware();
		if(o != null)
			ros.setUploaderName(o.getAccount());
		ros.setScore(score);
		ros.setTitle(title);
		ros.setResDescribe(describe);
		ros.setAddress(address);
		ros.setStatus(1);
		save(ros);
	}
	
	/**
	 * 修改(oper,rank,type,score,title,describe,id,carName,resourceType,dataType)
	 */
	public boolean editResourceOfSoftware(String id, Operator o, int score, String title, String describe) {
		Resourceofsoftware r = findById(id);
		if(r != null) {
			r.setScore(score);
			r.setTitle(title);
			r.setResDescribe(describe);
			saveOrUpdate(r);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 删除
	 */
	public void deleteResourceOfSoftware(String[] idlist, Operator o) {
		Resourceofsoftware r = null;
		for(String id : idlist) {
			r = this.findById(id);
			if(r != null)
				delete(r);
		}
	}
	
}
