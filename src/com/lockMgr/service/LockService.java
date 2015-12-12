package com.lockMgr.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.BasePojo;
import com.lockMgr.pojo.Busilocks;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;
import com.sun.org.apache.xml.internal.security.transforms.TransformationException;
import com.lockMgr.util.StatusEnum;

public class LockService extends BaseDao<Locks> implements ILockService {
	private IBusinessService businessService;

	@Override
	public List<Busilocks> findBusilocks(int page,int limit) {
		String hql = "select b.name,b.address,l from Locks l,Business b where l.businessId=b.id order by l.rank asc";
		List l = findByPage(hql, null, (page - 1) * limit, limit);
		List<Busilocks> ls = new ArrayList<Busilocks>();
		for (int i = 0; i < l.size(); i++) {
			Busilocks bl = new Busilocks();
			Object[] obj = (Object[]) l.get(i);
			Locks lk = (Locks) obj[2];
//			System.out.println(p);
//			System.out.println(pp);
//			System.out.println(ppp);
//			System.out.println(pppp);
//			System.out.println(ad+p+"/");
//			String servpath = "http://219.220.30.27:8080/lockMgr/images/";
			try {
				bl.setBusiName(obj[0].toString());
				bl.setBusiaddr(obj[1].toString());
				bl.setId(lk.getId());
				bl.setLocksName(lk.getName());
				bl.setPrice(lk.getPrice());
				bl.setOprice(lk.getOprice());
				bl.setImage(Utils.getimagepath()  + lk.getImage());
				bl.setSales(lk.getSales());
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			ls.add(bl);
		}
		return ls;
	}

	@Override
	public void txAddLockInfo(Operator oper, Locks lock) {
		if (lock.getBusinessId() == null) {
			lock.setBusinessId(oper.getId());// business的主键为operator的主键
		}
		save(lock);
		writeLog(oper, "添加", "商品", lock);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getLocksByPage(Map map, int page, int pageSize, String name,
			String type, String origin, String businessId, String orderType,
			String sortAttr) {

		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = "from Locks where status!=" + StatusEnum.disable.ordinal();

		if (null != businessId && businessId.length() != 0) {
			hql += " and businessId =?";
			al.add(businessId);
			paramNums++;
		}

		if (null != name && name.trim().length() != 0) {
			hql += " and name like ?";
			al.add("%" + name + "%");
			paramNums++;
		}
		if (null != type && type.length() != 0) {
			hql += " and type =?";
			al.add(type);
			paramNums++;
		}
		if (null != origin && origin.length() != 0) {
			hql += " and origin =?";
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
		List<Locks> locksList = findByPage(hql, values, (page - 1) * pageSize, pageSize);
		businessId = "";
		for (Locks lock : locksList) {
			businessId = lock.getBusinessId();
			if (businessId != null) {
				lock.setBusinessName(businessService.findById(businessId).getCompany());
			}
		}
		map.put("total", count);
		map.put("rows", locksList);
	//fillPagetoMap(map, hql, values, page, pageSize);
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	@Override
	public void txDel(Operator operator, String[] idlist) {
		Locks lock = null;
		for (String id : idlist) {
			lock = this.findById(id);
			delete(lock);
			writeLog(operator, "删除", "商品信息", lock);
		}
	}

	@Override
	public boolean txUpdate(Operator oper, Locks lock, String id) {
		lock.setId(id);
		saveOrUpdate(lock);
		writeLog(oper, "修改", "商品信息", lock);
		return true;
	}

	@Override
	public List<Locks> findByBusinessId(String businessId) {
		return find("from Locks where businessId='" + businessId + "'");
	}

	@Override
	public List<Locks> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 查询所有锁
	 */
	public List<Locks> findAllLocks(int page, int pageSize) {
		String hql = " from Locks where status=1 ";
		List<Locks> locksList = new ArrayList<Locks>();
		if(page==0 && pageSize==0) {
			locksList = findByPage(hql, null, 0, 20);
		} else {
			locksList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		return locksList;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}
	
	/**
	 * 根据商户id查询锁信息
	 */
	public List<Locks> findLocksByBusiness(int page, int pageSize, String BusinessId) {
		String hql = " from Locks where businessId=? and status=1 ";
		List<Locks> locksList = new ArrayList<Locks>();
		if(page==0 && pageSize==0) {
			locksList = findByPage(hql, new Object[]{BusinessId}, 0, 20);
		} else {
			locksList = findByPage(hql, new Object[]{BusinessId}, (page-1)*pageSize, pageSize);
		}
		return locksList;
	}

	/**
	 * 根据商户id查询最优一条锁记录
	 */
	@Override
	public Locks findAlocksByBusiness(String BusinessId) {
		String hql = " from Locks where businessId=? and status=1 order by rank desc ";
		List<Locks> locksList = find(hql, new Object[]{BusinessId});
		if(locksList.size() == 0) {
			return null;
		} else {
			return locksList.get(0);
		}
	}
	
	/**
	 * 搜索锁(模糊查询locks表中name字段)
	 */
	public List<Locks> searchLocksByName(int page, int pageSize, String keywords) {
		String hql = "from Locks where status=1 and name like ? "; //locks表name字段模糊查询
		List<Locks> locksList = new ArrayList<Locks>();
		//首先根据关键字在locks表中name字段查询
		if(page==0 && pageSize==0) {
			locksList = findByPage(hql, new Object[]{"%"+keywords+"%"}, 0, 20);
		} else {
			locksList = findByPage(hql, new Object[]{"%"+keywords+"%"}, (page-1)*pageSize, pageSize);
		}
		return locksList;
	}

	/**
	 * 查询所有锁类型
	 */
	public List findAllLocksType(int page, int pageSize) {
		String hql = " select distinct type from Locks where status=1 order by type ";
		List typeList = new ArrayList();
		if(page==0 && pageSize==0) {
			typeList = findByPage(hql, null, 0, 20);
		} else {
			typeList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		return typeList;
	}
	
	/**
	 * 根据类型查询锁
	 */
	public List<Locks> findLocksByType(int page, int pageSize, String type) {
		String hql = " from Locks where status=1 and type=? ";
		List<Locks> locksList = new ArrayList<Locks>();
		if(page==0 && pageSize==0) {
			locksList = findByPage(hql, new Object[]{type}, 0, 20);
		} else {
			locksList = findByPage(hql, new Object[]{type}, (page-1)*pageSize, pageSize);
		}
		return locksList;
	}
	
	/**
	 * 更新锁销量
	 */
	public void updateLocksSales(String allOrderLocksId, String allOrderNumber) {
		String[] orderLockId = allOrderLocksId.split(",");
		String[] orderNumber = allOrderNumber.split(",");
		for(int i=0; i<orderLockId.length; i++) {
			Locks locks = findById(orderLockId[i]);
			locks.setSales(locks.getSales() + Integer.parseInt(orderNumber[i]));
			saveOrUpdate(locks);
		}
	}
	
	/**
	 * 得到所有锁的id和name
	 * @param oper
	 * @return
	 */
	public List<NameAndId> getAllLocksIdAndName(Operator oper) {
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Locks> locksList = null;
		String hql = " from Locks where status=1 ";
		locksList = find(hql);
		nameAndId = new NameAndId();
		nameAndId.setId("");
		nameAndId.setName("所有商品");
		list.add(nameAndId);
		for (Locks l : locksList)
		{
			nameAndId = new NameAndId();
			nameAndId.setId(l.getId());
			nameAndId.setName(l.getName());
			list.add(nameAndId);
		}
		return list;
	}
	
	/**
	 * 上传商品
	 */
	public boolean uploadLocks(String imagePath, String name, String type, String origin, 
			double oprice, double price, String comment, String businessId) {
		try {
			Locks locks = new Locks();
			locks.setBusinessId(businessId);
			locks.setImage(imagePath);
			locks.setName(name);
			locks.setType(type);
			locks.setOrigin(origin);
			locks.setOprice(oprice);
			locks.setPrice(price);
			locks.setComment(comment);
			locks.setSales(0);
			locks.setStatus(1); //商户上传商品就能上架，不需要审核(0,等待审核,1审核成功)
			save(locks);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	/**
	 * 根据商户list查询每个商户top 3商品
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List findTopThreeLocks(List<Business> businessList) {
		List All = new ArrayList();
		String hql = " from Locks where businessId=? "; //不用用limit
		for(int i=0; i<businessList.size(); i++) {
			Map m = new HashMap();
			Business business = businessList.get(i);
			List locksList = findByPage(hql, new Object[]{business.getId()}, 0, 3);
			for(int j=0; j<locksList.size(); j++) {
				Locks locks = (Locks) locksList.get(j);
				if(locks.getImage() != null && locks.getImage().length() != 0) 
					locks.setImage(Utils.getimagepath() + locks.getImage());
			}
			m.put("business", business);
			m.put("locks", locksList);
			All.add(m);
		}
		return All;
	}
	
}
