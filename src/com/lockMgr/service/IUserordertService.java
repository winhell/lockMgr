package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Userordert;

public interface IUserordertService extends IBaseDao<Userordert> {
	/**
	 * 分页查询团购订单
	 */
	@SuppressWarnings("rawtypes")
	public void findGroupOrderByPage(Map map, int page, int pageSize, String gblocksId, int status,
			String userName, String sortAttr, String businessId, Timestamp beginDate, Timestamp endDate);
	
	/**
	 * 发货
	 */
	public void updateOrderDelivery(String[] idList);
	
	/**
	 * 退货
	 */
	public void updateOrderReturn(String[] idList);
	
	/**
	 * 分页查询基本锁订单
	 */
	@SuppressWarnings("rawtypes")
	public void findLockOrderByPage(Map map, int page, int pageSize, String locksId, int status,
			String userName, String sortAttr, String businessId, Timestamp beginDate, Timestamp endDate);
	
	/**
	 * 分解uoserorder记录添加详细记录到uoserordert表中
	 */
	public void addOrderT(String id);
	
	/**
	 * 付款成功修改status,businessStatus状态(1)
	 */
	public void modifyStatusAndBS(String id);
	
	/**
	 * 根据用户id查询相应订单
	 */
	public List<Userordert> findOrderByUser(int page, int pageSize, String userId, int orderStatus);
	
	/**
	 * 根据订单号查询订单
	 */
	public List<Userordert> findOrderByOrderId(String orderId);
	
	/**
	 * 根据商户id查询至今为止的营业额
	 */
	public double findRevenueByBusinessId(String businessId);

}
