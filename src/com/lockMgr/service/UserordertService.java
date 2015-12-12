package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Userorder;
import com.lockMgr.pojo.Userordert;

@SuppressWarnings("unchecked")
public class UserordertService extends BaseDao<Userordert> implements IUserordertService {
	private int beforeTime = -7;  //当beginDate为空时默认设置为当前时间的前7天
	
	private IUserorderService userorderService;
	private ILockService lockService;
	private IBusinessService businessService;
	private IGroupbuyLocksService gbService;
	private IUserService userService;
	private IWithdrawService withdrawService;  //提现service
	
	/**
	 * 分页查询团购订单
	 */
	@SuppressWarnings("rawtypes")
	public void findGroupOrderByPage(Map map, int page, int pageSize, String gblocksId, int businessStatus,
			String userName, String sortAttr, String businessId, Timestamp beginDate, Timestamp endDate) {
		int paramNums = 0;
		List<Object> list = new ArrayList<Object>();
		String hql = " from Userordert where groupLocks=2 and status=1 ";
		if (null != businessId && businessId.length() != 0) {
			hql += " and businessId =? ";
			list.add(businessId);
			paramNums++;
		}
		//状态(1:待发货,2:已发货,-1:已退货)
		if(businessStatus == 0)
			hql += " and businessStatus=1 ";
		else{
			hql += " and businessStatus=? ";
			list.add(businessStatus);
			paramNums ++;
		}
		if(gblocksId != null && gblocksId.trim().length() != 0) {
			hql += " and gblocksId=? ";
			list.add(gblocksId);
			paramNums ++;
		}
		if(userName != null && userName.trim().length() != 0) {
			hql += " and userName=? ";
			list.add(userName);
			paramNums ++;
		}
		if(beginDate != null && endDate != null) {
			hql += " and createtime between ? and ? ";
			list.add(beginDate);
			list.add(endDate);
			paramNums = paramNums + 2;
		} else if(beginDate == null && endDate != null) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, beforeTime);
			beginDate = new Timestamp(c.getTimeInMillis());
			hql += " and createtime between '" + beginDate + "' and ? ";
			list.add(endDate);
			paramNums ++;
		} else if(beginDate != null && endDate == null) {
			hql += " and createtime between ? and '" + Utils.getNow() + "' ";
			list.add(beginDate.toString());
			paramNums ++;
		} else if (beginDate == null && endDate == null) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, beforeTime);
			beginDate = new Timestamp(c.getTimeInMillis());
			hql += " and createtime between '" + beginDate + "' and '" + Utils.getNow() + "' ";
		}
		if (sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += "  ORDER BY createtime desc";
		}
		Object[] values = list.toArray(new Object[paramNums]);
//		fillPagetoMap(map, hql, values, page, pageSize);
		Long count = getCount(hql, values);
		List<Userordert> uotList = findByPage(hql, values, (page-1)*pageSize, pageSize);
		Userordert u = new Userordert();
		if(uotList != null && uotList.size() != 0) {
			for(int i=0; i<uotList.size(); i++) {
				u = uotList.get(i);
				u.setConsignee(userorderService.findOrderByName(u.getUserOrderId()).getConsignee());
				u.setConsigneePhone(userorderService.findOrderByName(u.getUserOrderId()).getConsigneePhone());
				u.setDeliveryAddress(userorderService.findOrderByName(u.getUserOrderId()).getDeliveryAddress());
				u.setLocksName(gbService.findById(u.getLocksId()).getName());
				u.setGbPrice(gbService.findById(u.getLocksId()).getGbprice());
				u.setLocksType(gbService.findById(u.getLocksId()).getType());
				u.setUserName(userService.findById(u.getUserId()).getAccount());
				u.setStatusName(checkStatus(u.getBusinessStatus()));
			}
		}
		map.put("total", count);
		map.put("rows", uotList);
	}
	
	/**
	 * 判断该订单锁的状态
	 */
	public String checkStatus(int businessStatus) {
		String statusName = "";
		if(businessStatus == 1)
			statusName = "待发货";
		else if(businessStatus == 2) 
			statusName = "已发货";
		else if(businessStatus == -1)
			statusName = "已退货";
		return statusName;
	}
	
	/**
	 * 发货
	 */
	public void updateOrderDelivery(String[] idList) {
		Userordert u = null;
		for(String id : idList) {
			u = this.findById(id);
			u.setBusinessStatus(2);
			saveOrder(u);
		}
	}
	
	/**
	 * 退货
	 */
	public void updateOrderReturn(String[] idList) {
		Userordert u = null;
		for(String id : idList) {
			u = this.findById(id);
			u.setBusinessStatus(-1);
			saveOrder(u);
		}
		
	}
	
	/**
	 * 分页查询基本锁订单
	 */
	@SuppressWarnings("rawtypes")
	public void findLockOrderByPage(Map map, int page, int pageSize, String locksId, int businessStatus,
			String userName, String sortAttr, String businessId, Timestamp beginDate, Timestamp endDate) {
		int paramNums = 0;
		List<Object> list = new ArrayList<Object>();
		String hql = " from Userordert where groupLocks=1 and status=1 ";
		if (null != businessId && businessId.length() != 0) {
			hql += " and businessId =? ";
			list.add(businessId);
			paramNums++;
		}
		//状态(1:待发货,2:已发货,-1:已退货)
		if(businessStatus == 0)
			hql += " and businessStatus=1 ";
		else{
			hql += " and businessStatus=? ";
			list.add(businessStatus);
			paramNums ++;
		}
		if(locksId != null && locksId.trim().length() != 0) {
			hql += " and gblocksId=? ";
			list.add(locksId);
			paramNums ++;
		}
		if(userName != null && userName.trim().length() != 0) {
			hql += " and userName=? ";
			list.add(userName);
			paramNums ++;
		}
		if(beginDate != null && endDate != null) {
			hql += " and createtime between ? and ? ";
			list.add(beginDate);
			list.add(endDate);
			paramNums = paramNums + 2;
		} else if(beginDate == null && endDate != null) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, beforeTime);
			beginDate = new Timestamp(c.getTimeInMillis());
			hql += " and createtime between '" + beginDate + "' and ? ";
			list.add(endDate);
			paramNums ++;
		} else if(beginDate != null && endDate == null) {
			hql += " and createtime between ? and '" + Utils.getNow() + "' ";
			list.add(beginDate.toString());
			paramNums ++;
		} else if (beginDate == null && endDate == null) {
			Calendar c = Calendar.getInstance();
			c.add(Calendar.DATE, beforeTime);
			beginDate = new Timestamp(c.getTimeInMillis());
			hql += " and createtime between '" + beginDate + "' and '" + Utils.getNow() + "' ";
		}
		if (sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += "  ORDER BY createtime desc";
		}
		Object[] values = list.toArray(new Object[paramNums]);
//		fillPagetoMap(map, hql, values, page, pageSize);
		Long count = getCount(hql, values);
		List<Userordert> uotList = findByPage(hql, values, (page-1)*pageSize, pageSize);
		Userordert u = new Userordert();
		if(uotList != null && uotList.size() != 0) {
			for(int i=0; i<uotList.size(); i++) {
				u = uotList.get(i);
				u.setConsignee(userorderService.findOrderByName(u.getUserOrderId()).getConsignee());
				u.setConsigneePhone(userorderService.findOrderByName(u.getUserOrderId()).getConsigneePhone());
				u.setDeliveryAddress(userorderService.findOrderByName(u.getUserOrderId()).getDeliveryAddress());
				u.setLocksName(lockService.findById(u.getLocksId()).getName());
				u.setPrice(lockService.findById(u.getLocksId()).getPrice());
				u.setLocksType(lockService.findById(u.getLocksId()).getType());
				u.setUserName(userService.findById(u.getUserId()).getAccount());
				u.setStatusName(checkStatus(u.getBusinessStatus()));
			}
		}
		map.put("total", count);
		map.put("rows", uotList);
	}
	
	/**
	 * 分解uoserorder记录添加详细记录到uoserordert表中
	 */
	public void addOrderT(String id) {
		Userorder uo = userorderService.findById(id);
		if(uo == null)
			return;
		String allLocksId = uo.getLockId();
		String[] locksId = allLocksId.split(",");
		String allNumber = uo.getOrderNum();
		String[] number = allNumber.split(",");
		String userOrderId = uo.getName();
		String userId = uo.getUserId();
		int orderType = uo.getGroupLocks(); //1:基本锁,2团购锁
		for(int i=0; i<locksId.length; i++) {
			Userordert uot = new Userordert();
			uot.setLocksId(locksId[i]);
			uot.setNumber(Integer.parseInt(number[i]));
			uot.setUserOrderId(userOrderId);
			uot.setUserId(userId);
			uot.setStatus(0);  //用户状态：0,未付款;1,已付款.
			uot.setBusinessStatus(0);  //商户状态:-1为退货；0无意义(可理解为该订单用户未付款)；1为未发货(已付款)；2为已发货。
			uot.setGroupLocks(orderType);
			if(orderType == 1)
				uot.setBusinessId(lockService.findById(locksId[i]).getBusinessId());
			else if(orderType == 2)
				uot.setBusinessId(gbService.findById(locksId[i]).getBusinessId());
			save(uot);
		}
	}
	
	/**
	 * 付款成功修改status,businessStatus状态(1)
	 */
	public void modifyStatusAndBS(String id) {
		Userorder uo = userorderService.findById(id);
		if(uo == null)
			return;
		String userOrderId = uo.getName();
		String hql = " from Userordert where userOrderId='" + userOrderId + "'";
		List<Userordert> uotList = find(hql);
		if(uotList != null && uotList.size() != 0) {
			for(int i=0; i<uotList.size(); i++) {
				Userordert uot = uotList.get(i);
				uot.setStatus(1);
				uot.setBusinessStatus(1);
				saveOrder(uot);
			}
		}
	}
	
	/**
	 * 根据用户id查询相应订单
	 */
	@SuppressWarnings("rawtypes")
	public List<Userordert> findOrderByUser(int page, int pageSize, String userId, int orderStatus) {
		List All = new ArrayList();
		String hql = " select distinct userOrderId from Userordert where userId=? and status=? order by createtime";
		List<String> orderIdList = publicFind(hql, new Object[]{userId,orderStatus});
		if(orderIdList != null && orderIdList.size() != 0) {
			//根据控制订单号实现分页
			List<String> newOrderIdList = new ArrayList<String>();
			int max = pageSize*page - 1;
			int min = max - pageSize + 1;
			if(max > orderIdList.size() - 1)
				max = orderIdList.size() - 1;
			if(min > orderIdList.size() - 1)
				min = orderIdList.size() - 1;
			for(int i=min; i<=max; i++)
				newOrderIdList.add(orderIdList.get(i));
			//控制分页结束
			for(int i=0; i<newOrderIdList.size(); i++) {
				Map m = new HashMap();
				String orderId = newOrderIdList.get(i);
				String hql2 = " from Userordert where userId=? and status=? and userOrderId='" + orderId + "'";
				List<Userordert> uotList = find(hql2, new Object[]{userId,orderStatus});
				String hql3 = " select id from Userorder where name='" + orderId + "'";
				List<String> realIdList = publicFind(hql3);
				if(realIdList != null && realIdList.size() != 0) {
					String realId = realIdList.get(0);
					m.put("orderID", orderId);
					m.put("realId", realId);
					m.put("orderList", uotList);
					All.add(m);
				}
			}
		}
		return All;
	}
	/**
	 * 根据订单号查询订单
	 */
	public List<Userordert> findOrderByOrderId(String orderId) {
		String hql = " from Userordert where userOrderId='" + orderId +"'";
		List<Userordert> list = find(hql);
		/*if(list != null && list.size() != 0) {
			t = list.get(0);
		}*/
		return list;
	}
	
	/**
	 * 根据商户id查询
	 * 该商户从上次成功提现到现在的营业额
	 */
	public double findRevenueByBusinessId(String businessId) {
		double money = 0;
		String hql = " from Userordert where status=1 and businessStatus=2 and businessId=? " +
				" and createtime between ? and ? ";
		Date lastDate = withdrawService.lastApplyTimeSuccess(businessId);
		if(lastDate == null) {
			Calendar cal = Calendar.getInstance();
			cal.set(2014, 01, 01);
			lastDate = cal.getTime();
		}
		List<Userordert> all = find(hql, new Object[]{businessId, lastDate, Utils.getNow()});
		if(all != null && all.size() != 0) {
			for(int i=0; i<all.size(); i++) {
				//如果为基本锁
				if(all.get(i).getGroupLocks() == 1) {
					money = money + lockService.findById(all.get(i).getLocksId()).getPrice();
				}
				//如果为团购锁
				else if(all.get(i).getGroupLocks() == 2) {
					money = money + gbService.findById(all.get(i).getLocksId()).getGbprice();
				}
			}
		}
		return money;
	}

	public IUserorderService getUserorderService() {
		return userorderService;
	}

	public void setUserorderService(IUserorderService userorderService) {
		this.userorderService = userorderService;
	}

	public ILockService getLockService() {
		return lockService;
	}

	public void setLockService(ILockService lockService) {
		this.lockService = lockService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IGroupbuyLocksService getGbService() {
		return gbService;
	}

	public void setGbService(IGroupbuyLocksService gbService) {
		this.gbService = gbService;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public IWithdrawService getWithdrawService() {
		return withdrawService;
	}

	public void setWithdrawService(IWithdrawService withdrawService) {
		this.withdrawService = withdrawService;
	}
	
}
