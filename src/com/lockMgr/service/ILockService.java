package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Busilocks;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;

public interface ILockService extends IBaseDao<Locks>{
	public List<Busilocks> findBusilocks(int start,int limit);
	public List<Locks> find();
	public List<Locks> findByBusinessId(String buseinssId);
	public void txAddLockInfo(Operator oper,Locks lock);
	public void getLocksByPage(Map map, final int page, final int pageSize,String name,String type,String origin,String businessId ,String orderType, String sortAttr);
	public void txDel(Operator operator, String[] idlist);
	public boolean txUpdate(Operator oper,Locks lock,String id);
	
	/**
	 * 查询所有锁
	 */
	public List<Locks> findAllLocks(int page, int pageSize);
	
	/**
	 * 根据商户id查询锁信息
	 */
	public List<Locks> findLocksByBusiness(int page, int pageSize, String BusinessId);
	
	/**
	 * 根据商户id查询最优一条锁记录
	 */
	public Locks findAlocksByBusiness(String BusinessId);
	
	/**
	 * 搜索锁(模糊查询locks表中name字段)
	 * String index:搜索关键字
	 */
	public List<Locks> searchLocksByName(int page, int pageSize, String keywords);
	
	/**
	 * 查询所有锁类型
	 */
	public List findAllLocksType(int page, int pageSize);
	
	/**
	 * 根据类型查询锁
	 */
	public List<Locks> findLocksByType(int page, int pageSize, String type);
	
	/**
	 * 更新锁销量
	 */
	public void updateLocksSales(String allOrderLocksId, String allOrderNumber);
	
	/**
	 * 得到所有锁的id和name
	 * @param oper
	 * @return
	 */
	public List<NameAndId> getAllLocksIdAndName(Operator oper);
	
	/**
	 * 上传商品
	 */
	public boolean uploadLocks(String imagePath, String name, String type, String origin, 
			double oprice, double price, String comment, String businessId);
	
	/**
	 * 根据商户list查询每个商户top 3商品
	 */
	public List findTopThreeLocks(List<Business> businessList);
}
