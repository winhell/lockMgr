package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.OrderAndTime;
import com.lockMgr.pojo.Userorder;
import com.lockMgr.pojo.Userordert;

/**
 * 订单类接口
 * @author lzc
 *
 */
public interface IUserorderService extends IBaseDao<Userorder> {
	/**
	 * 订单号和时间
	 */
	public List<OrderAndTime> findOrderAndTime(int page, int pageSize, String userId, int orderStatus);
	
	/**
	 * 根据订单id查询订单下所有商品信息
	 */
	@SuppressWarnings("rawtypes")
	public Map findOrderById(String id);
	
	/**
	 * 根据用户id查找相应订单
	 */
	@SuppressWarnings("rawtypes")
//	public List findOrderByUser(int page, int pageSize, String userId, int orderStatus);
	
	/**
	 * 取消一项订单(状态设为0)
	 */
	public String cancelOrder(String orderId);
	
	/**
	 * 增加订单
	 */
	public String addOrder(String allOrderLocksId, String allOrderNumber, String userId,
			String consignee, String consigneePhone, String deliveryAddress, double price, int orderType);
	
	/**
	 * 修改订单
	 */
	public void modifyOrder(String orderId, String allOrderLocksId, String allOrderNumber, String userId,
			String consignee, String consigneePhone, String deliveryAddress, double price);
	
	public void txUpdateOrder(HttpServletRequest req,String orderId,int status);
	//public void test2();
	
	/**
	 * 根据订单号查询该订单记录
	 * 订单号为Userorder中的name字段，一般来说生成的订单号唯一，可以一对一查找。
	 */
	public Userorder findOrderByName(String userOrder);
	
	/**
	 * 根据订单号查询订单
	 */
	public Userorder findOrderByOrderId(String orderId);
	
}
