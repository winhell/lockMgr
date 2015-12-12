package com.lockMgr.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Userrole;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings("unchecked")
public class BusinessService extends BaseDao<Business> implements IBusinessService {
	private int pifa = 0;      //批发商
	private int lingshou = 1;  //零售商
	
	private Business business;
	private Locks lock;
	
	private ILockService lockService;
	private IOperatorService operatorService;
	private IUserService userService;
	private IUserRoleService userRoleService;
	private IBusinessService businessService;
	
	@SuppressWarnings("rawtypes")
	@Override
	public void getBusinessByPage(Map map, int page, int pageSize,
			String realName, int verify, String orderType, String sortAttr) {
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = "from Business where 1=1 ";
		if (verify != -1) {
			hql += " and verify=?";
			al.add(verify);
			paramNums++;
		}

		if (null != realName && realName.trim().length() != 0) {
			hql += " and  realName like ?";
			al.add("%" + realName + "%");
			paramNums++;
		}
		if (orderType != null && sortAttr != null) {
			hql += " order by " + sortAttr + " " + orderType;
		} else {
			hql += "  ORDER BY verify";
		}
		Object[] values = al.toArray(new Object[paramNums]);

		fillPagetoMap(map, hql, values, page, pageSize);
	}
	

	@Override
	public void txAuidtBusiness(Operator oper, String[] businessIdList,int isPass)
	{
		Business business=null;
		for (String id : businessIdList)
		{
			business=this.findById(id);
			//如果是审核通过(isPass==1)就涉及到修改用户表角色,否则不涉及.
			if(isPass == 1) {
				//在查询要审核商户的用户信息
				Operator opera = operatorService.findById(business.getUserId());
				/*
				 * operator表更新用户角色(role)
				 * 如果不是管理员就更新角色(管理员也是要申请商户的,不然他就不能发布商品)
				 */
				if(opera != null) {
					if( ! opera.getRoleId().equals("1")) {
						operatorService.txUpgradeCommonToStore(business.getUserId());
						//user表更新用户角色(userRole)
						userService.txUpgradeCommonToStore(business.getUserId());
					}
				}
			}
			//business表更新状态
			business.setVerify(isPass);
			business.setStatus(isPass);
			businessService.saveOrUpdate(business);
			writeLog(oper, "审核", "商户", business);
		}	
	}
	
	@Override
	public void txDel(Operator operator, String[] idlist)
	{
		Business business=null;
		for (String id : idlist)
		{
			business=this.findById(id);
			delete(lockService.findByBusinessId(id));
			delete(business);
			writeLog(operator, "删除", "操作员", business);
		}		
	}
	
	public List<NameAndId> getAllBusinessNameAndId(Operator oper)
	{
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Business> roleList = null;
		// if(null!=oper&&(oper.getRoleName().equals("admin")||oper.getRoleName().equals("touristAdmin")))
		// {
		String hql = "from Business where status!=" + StatusEnum.disable.ordinal();
		roleList = find(hql);
		// }
		nameAndId = new NameAndId();
		nameAndId.setId("");
		nameAndId.setName("所有商铺");
		list.add(nameAndId);
		for (Business role : roleList)
		{
			nameAndId = new NameAndId();
			nameAndId.setId(role.getId());
			nameAndId.setName(role.getCompany());
			list.add(nameAndId);
		}

		return list;
	}

	public List<NameAndId> getBusinessNameAndId(Operator oper)
	{
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Business> roleList = null;
		// if(null!=oper&&(oper.getRoleName().equals("admin")||oper.getRoleName().equals("touristAdmin")))
		// {
		String hql = "from Business where status!=" + StatusEnum.disable.ordinal();
		roleList = find(hql);
		// }
		for (Business role : roleList)
		{
			nameAndId = new NameAndId();
			nameAndId.setId(role.getId());
			nameAndId.setName(role.getCompany());
			list.add(nameAndId);
		}

		return list;
	}
	
	public List<NameAndId> getBusinessNameAndId(String businessId) {
		NameAndId nameAndId = new NameAndId();
		String hql = " from Business where id=" + businessId;
		List<Business> businessList = find(hql);
		List<NameAndId> list = new ArrayList<NameAndId>();
		if(businessList.size() != 0) {
			Business business = businessList.get(0);
			nameAndId.setId(business.getId());
			nameAndId.setName(business.getCompany());
			list.add(nameAndId);
		}
		return list;
	}
	
	public void setLockService(ILockService lockService)
	{
		this.lockService = lockService;
	}

	/**
	 * 查询所有批发商户
	 */
	public List<Business> findAllWholesaler(int page, int pageSize) {
		/*
		 * status =1 : 该商户可用
		 * type = 0 : 批发商
		 * rating in(1,2) : 所有商户中排序优先和特级的, 普通商户(raing=0)不显示
		 */
		String hql = " from Business where status=1 and type=0 and rating in(1,2) order by rating desc ";
		List<Business> businessList = new ArrayList<Business>();
		if(page==0 && pageSize==0) {
			businessList = findByPage(hql, null, 0, 20);
		} else {
			businessList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		//循环查询该商户的用户角色名
		if(businessList != null && businessList.size() != 0) {
			for(int i=0; i<businessList.size(); i++) {
				Business business = businessList.get(i);  //取得商户
				if(business.getUserId() != null && business.getUserId().length() != 0) {
					String userId = business.getUserId();
					User user = userService.findById(userId);  //取得商户的用户信息
					if(user != null ) {
						if(user.getUserRoleId() != null && user.getUserRoleId().length() != 0) {
							String userRoleId = user.getUserRoleId();
							Userrole userRole = userRoleService.findById(userRoleId);
							if(userRole != null) {
								if(userRole.getName() != null && userRole.getName().length() != 0)
									business.setUserRoleName(userRole.getName());
							}
						}
					}
				}
			}
		}
		return businessList;
	}
	
	/**
	 * 根据城市查询商户
	 */
	public List<Business> findBusinessByCity(int page, int pageSize, String city) {
		String hql = " from Business where address like '%" + city + "%' and type=" + lingshou + " order by rating desc  ";
		List<Business> allBusinessList = find(hql);
		List<Business> businessList = new ArrayList<Business>();
		if(allBusinessList != null && allBusinessList.size() != 0) {
//			计算总页数(BaseDao封装了方法,calculateTotalPage(int, int))
//			Map m = new HashMap();
//			int totalNums = allBusinessList.size();
//			int totalPage = 0;
//			if(totalNums > pageSize) {
//				if(totalNums % pageSize == 0)
//					totalPage = totalNums / pageSize;
//				else 
//					totalPage = totalNums / pageSize + 1;
//			} else {
//				totalPage = 1;
//			}
//			m.put("totalPage", totalPage);
			
			/*int max = pageSize*page - 1;
			int min = max - pageSize + 1;
			if(max > allBusinessList.size() - 1)
				max = allBusinessList.size() - 1;
			if(min > allBusinessList.size() - 1)
				min = allBusinessList.size() - 1;
			for(int i=min; i<=max; i++)
				businessList.add(allBusinessList.get(i));*/
			
			businessList = Utils.getListByPageAndPagesize(allBusinessList, page, pageSize);
		}
		return businessList;
	}
	
	/**
	 * 计算总页数
	 * @param listNums 集合总条数(size)
	 * @param pageSize 需要分页的页容量
	 * @return
	 */
	@SuppressWarnings("unused")
	private int calculateTotalPage(int listNums, int pageSize) {
		int totalPage = 0;
		if(listNums > pageSize) {
			if(listNums % pageSize == 0)
				totalPage = listNums / pageSize;
			else 
				totalPage = listNums / pageSize + 1;
		} else {
			totalPage = 1;
		}
		return totalPage;
	}
	
	/**
	 * 根据城市和区域（地址）查询商户
	 */
	public List<Business> findBusiness(int page, int pageSize, String address, double lati, double lngti) {
		String hql = " from Business where address like '%" + address + "%' and rating in(1,2) ";
		List<Business> allBusinessList = find(hql);
		List<Business> businessList = new ArrayList<Business>();
		if (allBusinessList!=null) {
    		for(Business b : allBusinessList){
        		b.setDistance(Utils.getDistatce(lati, b.getPointX(), lngti, b.getPointY()));
        	}
        	Collections.sort(allBusinessList, new Comparator<Business>(){  
                /* 
                 * int compare(Business o1, Business o2) 返回一个基本类型的整型， 
                 * 返回负数表示：o1 小于o2， 
                 * 返回0 表示：o1和o2相等， 
                 * 返回正数表示：o1大于o2。 
                 */  
                public int compare(Business o1, Business o2) {  
                    //升序排列  
                    if(o1.getDistance() > o2.getDistance()){  
                        return 1;  
                    }  
                    if(o1.getDistance() == o2.getDistance()){  
                        return 0;  
                    }  
                    return -1;  
                }  
            });
        	/*int max = pageSize*page - 1;
			int min = max - pageSize + 1;
			if(max > allBusinessList.size() - 1)
				max = allBusinessList.size() - 1;
			if(min > allBusinessList.size() - 1)
				min = allBusinessList.size() - 1;
			for(int i=min; i<=max; i++)
				businessList.add(allBusinessList.get(i));*/
			businessList = Utils.getListByPageAndPagesize(allBusinessList, page, pageSize);
		}
		//循环查询该商户的用户角色名
		if(businessList != null && businessList.size() != 0) {
			for(int i=0; i<businessList.size(); i++) {
				Business business = businessList.get(i);  //取得商户
				if(business.getUserId() != null && business.getUserId().length() != 0) {
					String userId = business.getUserId();
					User user = userService.findById(userId);  //取得商户的用户信息
					if(user != null) {
						if(user.getUserRoleId() != null && user.getUserRoleId().length() != 0) {
							String userRoleId = user.getUserRoleId();
							Userrole userRole = userRoleService.findById(userRoleId);
							if(userRole.getName() != null && userRole.getName().length() != 0)
								business.setUserRoleName(userRole.getName());
						}
					}
				}
			}
		}
		return businessList;
	}
	
	
	
	/**
	 * 修改商户信息
	 */
	@SuppressWarnings("rawtypes")
	public Map modifyBusiness(Business b) {
		Map json = new HashMap();
		try {
			saveOrUpdate(b);
			json.put("result", "success");
		} catch (DataAccessException e) {
			json.put("result", "false");
			throw e;
		}
		return json;
	}
	
	/**
	 * 根据用户id查询该用户是否是商户
	 * true:找到(该用户是商户)
	 * false:没找到(该用户不是商户)
	 */
	public Business checkingUser(String userId) {
		String hql = "from Business where userId=?";
		List<Business> businessList = find(hql, new Object[]{userId});
		return businessList.get(0);
	}
	
	/**
	 * 搜索商户(模糊查询business表中company字段)
	 */
	public List<Business> searchBusinessByCompany(int page, int pageSize, String keywords) {
		String hql = "from Business where status=1 and company like ?"; //business表company字段模糊查
		List<Business> businessList = new ArrayList<Business>();
		if(page==0 && pageSize==0) {
			businessList = findByPage(hql, new Object[]{"%"+keywords+"%"}, 0, 20);
		} else {
			businessList = findByPage(hql, new Object[]{"%"+keywords+"%"}, (page-1)*pageSize, pageSize);
		}
		return businessList;
	}
	
	/**
	 * 查询推荐商户(零售商)
	 */
	public List<Business> findRecommendBusiness(int page, int pageSize) {
		String hql = " from Business where status=1 and type=1 and rating in(1,2) order by rating desc ";
		List<Business> businessList = new ArrayList<Business>();
		if(page==0 && pageSize==0) {
			businessList = findByPage(hql, null, 0, 50);
		} else {
			businessList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		//循环查询该商户的用户角色名
		if(businessList != null && businessList.size() != 0) {
			for(int i=0; i<businessList.size(); i++) {
				Business business = businessList.get(i);  //取得商户
				if(business.getUserId() != null && business.getUserId().length() != 0) {
					String userId = business.getUserId();
					User user = userService.findById(userId);  //取得商户的用户信息
					if(user != null) {
						if(user.getUserRoleId() != null && user.getUserRoleId().length() != 0) {
							String userRoleId = user.getUserRoleId();
							Userrole userRole = userRoleService.findById(userRoleId);
							if(userRole.getName() != null && userRole.getName().length() != 0)
								business.setUserRoleName(userRole.getName());
						}
					}
				}
			}
		}
		return businessList;
	}
	
	/**
	 * 根据城市查询推荐商户(零售商,不含普通)，然后根据距离排序
	 */
	public List<Business> findRecommendBusinessByCityAndXY(int page, int pageSize, String city, double x, double y) {
		List<Business> lastBusinessList = new ArrayList<Business>();
		List<Business> cityOfBusinessList = new ArrayList<Business>();
		//首先查询所有商户
		String hql = " from Business where status=1 and type=1 and rating in(1,2) order by rating desc ";
		List<Business> allBusinessList = find(hql);
		if(allBusinessList != null && allBusinessList.size() != 0) {
			if(city != null && city.length() != 0 ) {
				for(int i=0; i<allBusinessList.size(); i++) {
					String databaseCity = getCityByAddress(allBusinessList.get(i).getAddress());
					//然后添加符合要求城市的商户集合(现在还是所有的,需要分页)
					if(city.equals(databaseCity)) {
						cityOfBusinessList.add(allBusinessList.get(i));
					}
				}
				//再对上面符合要求的商户集合(cityOfBusinessList)进行分页操作进行筛选
				lastBusinessList = Utils.getListByPageAndPagesize(allBusinessList, page, pageSize);
				//如果参数经纬度不为空,就按照经纬度算出距离排序
				if(x != 0 && y != 0) {
					//先对各商户设置距离
					for(Business b : lastBusinessList){
		        		b.setDistance(Utils.getDistatce(x, b.getPointX(), y, b.getPointY()));
		        	}
					//再按距离排序
					Collections.sort(lastBusinessList, new Comparator<Business>(){
						public int compare(Business o1, Business o2) {
							return String.valueOf(o1.getDistance()).compareTo(String.valueOf(o2.getDistance()));
						}
					});
				}
			} else {
				lastBusinessList.addAll(allBusinessList);
			}
		}
		//循环查询该商户的用户角色名
		if(lastBusinessList != null && lastBusinessList.size() != 0) {
			for(int i=0; i<lastBusinessList.size(); i++) {
				Business business = lastBusinessList.get(i);  //取得商户
				if(business.getUserId() != null && business.getUserId().length() != 0) {
					String userId = business.getUserId();
					User user = userService.findById(userId);  //取得商户的用户信息
					if(user != null) {
						if(user.getUserRoleId() != null && user.getUserRoleId().length() != 0) {
							String userRoleId = user.getUserRoleId();
							Userrole userRole = userRoleService.findById(userRoleId);
							if(userRole.getName() != null && userRole.getName().length() != 0)
								business.setUserRoleName(userRole.getName());
						}
					}
				}
			}
		}
		return lastBusinessList;
	}
	
	/**
	 * 根据城市和优先级查询商户(零售商,不含普通)
	 */
	public List<Business> findBusinessByCityAndRating(int page, int pageSize, String city) {
		String hql = " from Business where status=1 and type=1 and rating in(1,2) and address like '%" + city + "%' order by rating desc ";
		List<Business> businessList = findByPage(hql, null, (page - 1) * pageSize, pageSize);
		// 如果该城市没有商户，默认查询南昌市
		/*
		 * 151122：这个Action是按城市显示推荐商户列表，咱们之前弄的是如果当前城市没有的话就默认显示南昌的商户，
		 * 但他要求就是没有就显示空
		 */
		/*if (businessList == null || businessList.size() == 0) {
			hql = " from Business where status=1 and type=1 and rating in(1,2) and address like '%南昌市%' order by rating desc ";
			businessList = findByPage(hql, null, (page - 1) * pageSize, pageSize);
		}*/
		return businessList;
	}
	
	/**
	 * 查询优先级前4的商户(零售商)
	 */
	public List<Business> findBusinessFirstFour() {
		String hql = " from Business where status=1 and type=1 order by rating desc ";
		List<Business> businessList =findByPage(hql, null, 0, 4);
		return businessList;
	}
	
	/**
	 * 根据商户id查询商户名称
	 */
	public String findNameById(String businessId) {
		String sql = " select * from business where id=" + businessId;
		List<Business> businessList = findBySQL(sql);
		String businessName = businessList.get(0).getCompany();
		return businessName;
	}
	
	/**
	 * 根据用户id查询他的商户id
	 */
	public String findBusinessIdByUserId(String userId) {
		String businessId = "";
		String hql = " from Business where userId=? ";
		List<Business> list = find(hql, new Object[]{userId});
		if(list != null && list.size() != 0) {
			businessId = list.get(0).getId();
		}
		return businessId;
	}
	
	/**
	 * 修改商户信息
	 */
	public boolean txUpdate(Operator o, String id, Business b) {
		b.setId(id);
		saveOrUpdate(b);
		writeLog(o, "修改", "商户信息", b);
		return true;
	}
	
	/**
	 * 查询商户和该商户3件商品(按商户优先级排序)
	 */
	public List findBusinessAndThreeLock(int page, int pageSize) {
		//按照UserordertService中的findOrderByUser方法，全局List，里面各种数据for中重新初始化，put进map,再把map add进List,返回List
		List All = new ArrayList();
		String hql = " from Business order by rating desc ";
		String hql1 = " from Locks where businessId=? "; //不用用limit
		List<Business> businessList = find(hql);
		for(int i=0; i<businessList.size(); i++) {
			Map m = new HashMap();
			Business business = businessList.get(i);
			List locksList = findByPage(hql1, new Object[]{business.getId()}, 0, 3);
			m.put("business", business);
			m.put("locks", locksList);
			All.add(m);
		}
		return All;
	}
	
	/**
	 * 根据商户地址得到城市
	 * @return
	 */
	private String getCityByAddress(String address) {
		String city = null;
		if(address != null && address.length() != 0) {
			int provinceIndex = address.indexOf("省");
			int cityIndex = address.indexOf("市");
			if(provinceIndex != -1 && cityIndex != -1 && cityIndex > provinceIndex) {
				city = address.substring(provinceIndex + 1, cityIndex);
			}
		}
		return city;
	}
	
	/**
	 * 查询用户目前是否为商户
	 * true : 是商户
	 * false : 不是商户
	 */
	public boolean isBusiness(String userId) {
		List<Business> list = find(" from Business where userId=? ", new Object[]{userId});
		if(list != null && list.size() != 0) {
			if(list.get(0).getStatus() == 1)
				return true;
			else 
				return false;
		} else 
			return false;
	}
	
	/**
	 * 获取全部商户(零售和批发)信息
	 * 不包含等级为普通的
	 * 目前聊天列表用到
	 */
	public List<Business> findAllBusiness(int page, int pageSize) {
		String hql = " from Business where status=1 and rating in(1,2) order by rating desc ";
		List<Business> businessList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		//循环查询该商户的用户角色名
		if(businessList != null && businessList.size() != 0) {
			for(int i=0; i<businessList.size(); i++) {
				Business business = businessList.get(i);  //取得商户
				if(business.getUserId() != null && business.getUserId().length() != 0) {
					String userId = business.getUserId();
					User user = userService.findById(userId);  //取得商户的用户信息
					if(user != null) {
						if(user.getUserRoleId() != null && user.getUserRoleId().length() != 0) {
							String userRoleId = user.getUserRoleId();
							Userrole userRole = userRoleService.findById(userRoleId);
							if(userRole.getName() != null && userRole.getName().length() != 0)
								business.setUserRoleName(userRole.getName());
						}
					}
				}
			}
		}
		return businessList;
	}
	
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Locks getLock() {
		return lock;
	}

	public void setLock(Locks lock) {
		this.lock = lock;
	}

	public void setOperatorService(IOperatorService operatorService)
	{
		this.operatorService = operatorService;
	}

	@Override
	public void txAddBusiness(Business business, Operator common)
	{
		business.setName(common.getAccount());
		business.setUserId(common.getId());
		save(business);
		
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ILockService getLockService() {
		return lockService;
	}

	public IOperatorService getOperatorService() {
		return operatorService;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}
	

}
