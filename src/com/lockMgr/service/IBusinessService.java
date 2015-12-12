package com.lockMgr.service;


import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;

public interface IBusinessService  extends IBaseDao<Business>

{
	public void getBusinessByPage(Map map, final int page, final int pageSize,String realName,int verify,String orderType, String sortAttr);

	public void txAuidtBusiness(Operator oper,String[] businessIdList,int isPass);
	public void txDel(Operator operator, String[] idlist);
	public List<NameAndId> getAllBusinessNameAndId(Operator oper); //获取所有的角色名和id
	public List<NameAndId> getBusinessNameAndId(Operator oper); //获取belongId为空的角色名和id	
	
	
	
	public void txAddBusiness(Business businesss,Operator common);
	
	
	/**
	 * 查询所有批发商户
	 */
	public List<Business> findAllWholesaler(int page, int pageSize);
	
	/**
	 * 根据城市查询商户
	 */
	public List<Business> findBusinessByCity(int page, int pageSize, String city);
	
	/**
	 * 查找附近商户(根据用户当前地址查询附近商户)
	 */
//	public String[] findBusinessByNear();
	
	/**
	 * 根据用户id查询该用户是否是商户
	 */
	public Business checkingUser(String userId);
	
	/**
	 * 搜索商户(模糊查询business表中company字段)
	 */
	public List<Business> searchBusinessByCompany(int page, int pageSize, String keywords);
	
	/**
	 * 查询推荐商户(零售商)
	 */
	public List<Business> findRecommendBusiness(int page, int pageSize);
	
	/**
	 * 根据城市查询推荐商户(零售商,不含普通)，然后根据距离排序
	 */
	public List<Business> findRecommendBusinessByCityAndXY(int page, int pageSize, String city, double x, double y);
	
	/**
	 * 根据城市和优先级查询商户(零售商,不含普通)
	 */
	public List<Business> findBusinessByCityAndRating(int page, int pageSize, String city);
	
	/**
	 * 根据城市和坐标查询推荐商户(零售商)
	 */
	
	/**
	 * 查询优先级前4的商户(零售商)
	 */
	public List<Business> findBusinessFirstFour();
	
	/**
	 * 查询商户
	 */
	public List<Business> findBusiness(int page, int pageSize, String address, double lati, double lngti);
	
	/**
	 * 根据商户id查询商户名称
	 */
	public String findNameById(String businessId);
	
	/**
	 * 根据用户id查询他的商户id
	 */
	public String findBusinessIdByUserId(String userId);
	
	/**
	 * 修改商户信息
	 */
	public boolean txUpdate(Operator o, String id, Business b);
	
	/**
	 * 查询商户和该商户3件商品(按商户优先级排序)
	 */
	public List findBusinessAndThreeLock(int page, int pageSize);
	
	/**
	 * 查询用户目前是否为商户
	 */
	public boolean isBusiness(String userId);
	
	/**
	 * 获取全部商户(零售和批发)信息
	 * 不包含等级为普通的
	 * 目前聊天列表用到
	 */
	public List<Business> findAllBusiness(int page, int pageSize);

}
