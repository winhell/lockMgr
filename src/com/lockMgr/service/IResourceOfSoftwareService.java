package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resourceofsoftware;

/**
 * 软件下载资源接口
 */

public interface IResourceOfSoftwareService extends IBaseDao<Resourceofsoftware> {
	/**
	 * 分页查询软件下载资源
	 */
	@SuppressWarnings("rawtypes")
	public void getResourceOfSoftwareByPage(Map m, int page, int pageSize, String title);
	
	/**
	 * 手机端分页查询软件下载资源
	 */
	public List<Resourceofsoftware> findPhoneResourceOfSoftwareByPage(int page, int pageSize);
	
	/**
	 * 增加软件下载资源
	 */
	public void addResourceOfSoftware(Operator o, int score, String title, String describe, String address);
	
	/**
	 * 修改(oper,rank,type,score,title,describe,id,carName,resourceType,dataType)
	 */
	public boolean editResourceOfSoftware(String id, Operator o, int score, String title, String describe);
	
	/**
	 * 删除
	 */
	public void deleteResourceOfSoftware(String[] idlist, Operator o);
	
	
}
