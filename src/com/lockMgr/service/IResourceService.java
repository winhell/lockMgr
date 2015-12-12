package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resource;

public interface IResourceService extends IBaseDao<Resource>
{
	public void getResourceByPage(Map map, final int page, final int pageSize,String title,int type,int rank,String orderType, String sortAttr);
	
	/**
	 * 查询软件下载资料
	 */
	public void getResourceOfSoftwareByPage(Map m, int page, int pageSize, String title);
	
	public void txImportResource(Operator oper,Resource resource);
	
	public void txDel(Operator operator, String[] idlist);
	
	public boolean txUpdate(Operator oper,int rank,int type,int score,String title,String describe,String id,String carName,String carType,String resourceType,String dataType);
	
	/**
	 * 根据车类查询相关资料
	 */
	public List<Resource> findResourceByCar(int page, int pageSize, String carIndex);
	
	/**
	 * 根据用户角色查询对应资料
	 */
	public List<Resource> findResourceByUserrole(int rank, int page, int pageSize);
	
	/**
	 * 根据车类名查询所有对应资源
	 */
	public List<Resource> findAllResourceByCarName(int page, int pageSize, String carName);
	
	/**
	 * 根据车类型查询所有对应资源(搜索框)
	 */
	public List<Resource> findAllResourceByCarType(int page, int pageSize, String resourceType, String dataType, String carName, String carType);
	
	/**
	 * 根据资源类型(resourceType),车型(carName)查询所有资源
	 */
	public List<Resource> findAllByResourceTypeAndCarName(int page, int pageSize, String resourceType, String carName);
}
