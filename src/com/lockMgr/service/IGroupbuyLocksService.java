package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.GroupbuyLocks;
import com.lockMgr.pojo.Operator;

public interface IGroupbuyLocksService extends IBaseDao<GroupbuyLocks>{
	/**
	 * 查询所有团购锁
	 */
	public List<GroupbuyLocks> findAllGbLocks(int page, int pageSize);
	
	/**
	 * 根据locksId(锁id)查询该团购锁信息
	 */
	public List<GroupbuyLocks> findGbLocksByLocks(String locksId);
	
	/**
	 * 分页查询团购锁信息
	 */
	@SuppressWarnings("rawtypes")
	public void findGbByPage(Map map, int page, int pageSize, String locksId,
			String type, String origin, String businessId, String orderType,
			String sortAttr);

	/**
	 * 添加团购锁
	 */
	public void txAddGb(Operator oper, GroupbuyLocks gb);
	
	/**
	 * 修改团购锁
	 */
	public boolean txUpdate(Operator oper, GroupbuyLocks gb, String id);
	
	/**
	 * 删除团购锁
	 */
	public void txDel(Operator operator, String[] idlist);
	
	/**
	 * 更新团购锁销量
	 */
	public void updateGblocksSales(String allOrderLocksId, String allOrderNumber);
}
