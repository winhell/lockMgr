package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.GroupbuyLocks;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.Operator;


public class GroupbuyLocksService extends BaseDao<GroupbuyLocks> implements IGroupbuyLocksService {
	private ILockService lockService;
	private IBusinessService businessService;
	
	/**
	 * 查询所有团购锁
	 */
	public List<GroupbuyLocks> findAllGbLocks(int page, int pageSize) {
		String hql = "from GroupbuyLocks where status=1 order by createtime desc";
		List<GroupbuyLocks> list = new ArrayList<GroupbuyLocks>();
		if(page==0 && pageSize==0) {
			list = findByPage(hql, null, 0, 20);
		} else {
			list = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		return list;
	}
	
	/**
	 * 根据locksId(锁id)查询该团购锁信息
	 */
	public List<GroupbuyLocks> findGbLocksByLocks(String locksId) {
		String hql = "from GroupbuyLocks where locksId=?";
		List<GroupbuyLocks> list = find(hql, new Object[]{locksId});
		return list;
	}
	
	/**
	 * 分页查询团购锁信息
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findGbByPage(Map map, int page, int pageSize, String locksId,
			String type, String origin, String businessId, String orderType,
			String sortAttr) {
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = " from GroupbuyLocks where status=1 ";
		if (null != businessId && businessId.length() != 0) {
			hql += " and businessId =? ";
			al.add(businessId);
			paramNums++;
		}
		if (null != locksId && locksId.trim().length() != 0) {
			hql += " and locksId=? ";
			al.add(locksId);
			paramNums++;
		}
		if (null != type && type.length() != 0) {
			hql += " and type =? ";
			al.add(type);
			paramNums++;
		}
		if (null != origin && origin.length() != 0) {
			hql += " and origin =? ";
			al.add(origin);
			paramNums++;
		}
		if (orderType != null && sortAttr != null) {
			hql += " order by " + sortAttr + " " + orderType;
		} else {
			hql += "  ORDER BY createtime desc";
		}
		Object[] values = al.toArray(new Object[paramNums]);
		Long count = getCount(hql, values);
		List<GroupbuyLocks> list = findByPage(hql, values, (page - 1) * pageSize,pageSize);
//		fillPagetoMap(map, hql, values, page, pageSize);
		GroupbuyLocks gbl = new GroupbuyLocks();
		if(list.size() != 0 && list != null) {
			for(int i=0; i<list.size(); i++) {
				gbl = list.get(i);
				gbl.setLocksName(lockService.findById(gbl.getLocksId()).getName());
				gbl.setBusinessName(businessService.findById(gbl.getBusinessId()).getCompany());
			}
		}
		map.put("total", count);
		map.put("rows", list);
	}
	
	/**
	 * 添加团购锁
	 */
	public void txAddGb(Operator oper, GroupbuyLocks gb) {
		gb.setStatus(1);
		gb.setCreatetime(Utils.getNow());
		save(gb);
		writeLog(oper, "添加", "团购商品", gb);
	}
	
	/**
	 * 修改团购锁
	 */
	public boolean txUpdate(Operator oper, GroupbuyLocks gb, String id) {
		gb.setId(id);
		saveOrUpdate(gb);
		writeLog(oper, "修改", "团购商品信息", gb);
		return true;
	}
	
	/**
	 * 删除团购锁
	 */
	public void txDel(Operator operator, String[] idlist) {
		GroupbuyLocks gb = null;
		for(String id : idlist) {
			gb = this.findById(id);
			gb.setStatus(0);
			writeLog(operator, "删除", "团购商品信息", gb);
		}
	}

	/**
	 * 更新团购锁销量
	 */
	public void updateGblocksSales(String allOrderLocksId, String allOrderNumber) {
		String[] orderLockId = allOrderLocksId.split(",");
		String[] orderNumber = allOrderNumber.split(",");
		for(int i=0; i<orderLockId.length; i++) {
			GroupbuyLocks gbl = findById(orderLockId[i]);
			gbl.setSales(gbl.getSales() + Integer.parseInt(orderNumber[i]));
			saveOrUpdate(gbl);
		}
	}

	public ILockService getLockService() {
		return lockService;
	}

	public void setLockService(ILockService lockService) {
		this.lockService = lockService;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}
	
	
	
}
