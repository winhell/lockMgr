package com.lockMgr.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import sun.misc.BASE64Decoder;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Busilocks;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Collect;
import com.lockMgr.pojo.GroupbuyLocks;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.Userorder;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.ICollectService;
import com.lockMgr.service.IGroupbuyLocksService;
import com.lockMgr.service.ILockService;
import com.lockMgr.service.IShopService;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IUserorderService;
import com.lockMgr.service.IUserordertService;

public class ShopAction extends BaseAction {
	private static final long serialVersionUID = -530179918264796801L;
	//private String businessRoleId = "d8f7bba0-77ba-48c7-9870-8281cc28a3ce"; //验证(商户,同行)用户id(不能这样写，数据库id会改变)
	private int page;
	private int limit; //同pageSize
	private String ImgData;
	private String locksId;
	private String locksName;
	private String origin;
	private double oprice; //商品原始价格
	private double price;  //商品出售价格
	private String comment;
	private String userId;
	private String consignee; //收件人
	private String consigneePhone;
	private String deliveryAddress;
	private int number;
	private String orderId; //订单id
	private String businessId;
	private double lati;  //纬度
	private double lngti; //经度
	private String city;
	private String area;  //地区(青山湖区)
	private String keywords; //用于搜索关键字
	private String type;
	private String allOrderLocksId; //用户的所有订单锁id
	private String allOrderNumber;  //用户的所有订单对应锁数量
	private double totalPrice;
	private String gbId;  //团购锁id
	private int orderType; //订单类型(用来区分是商城购买的锁(1)还是团购锁(2))
	private int orderStatus; //订单(userorder)状态:0,未付款;1,已付款.
	

	private IBusinessService businessService;
	private ILockService lockService;
	private ICollectService collectService;
	private IUserorderService userorderService;
	private IUserordertService uotService;
	private IShopService shopService;
	private IUserService userService;
	private IGroupbuyLocksService gblService;
	private IUserRoleService userRoleService;
	
	private Collect collect;
	private Userorder userorder;
	private Busilocks busilocks;

	String path = ServletActionContext.getServletContext().getContextPath() + "/";
	
	/**
	 * 查询商城首页(只包含商品商户的6个信息)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getHomePage() throws IOException {
		Map json = new HashMap();
		List<Busilocks> list = this.shopService.findHomePage(page, limit);
		if(list.size() == 0) {
			json.put("success", false);
			json.put("msg", "商城现在还无任何商品呢！！");
		} else {
			json.put("success", true);
			json.put("busilocks", list);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 零售商
	 * 推荐商户(单纯的按优先级排序),不显示普通商户(business.rating = 0)
	 * 2015.03.25：也要根据城市筛选
	 * 151122：这个Action是按城市显示推荐商户列表，咱们之前弄的是如果当前城市没有的话就默认显示南昌的商户，
	 * 			但他要求就是没有就显示空。
	 * 151206：首页推荐商户按距离排序（不是全部，还是特别推荐的在前，剩下的按距离排序）
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getRecommendBusiness() throws IOException {
		String cityNew = java.net.URLDecoder.decode(city,"UTF-8");
//		String cityNew = new String(city.getBytes("iso-8859-1"), "utf-8");
		Map json = new HashMap();
		try {
//			List<Business> businessList = businessService.findRecommendBusiness(page, limit);
			List<Business> businessList = businessService.findBusinessByCityAndRating(page, limit, cityNew);
			for(int i=0; i<businessList.size(); i++) {
				Business b = businessList.get(i);
				if(b.getImage() != null && b.getImage().length() != 0)
					b.setImage(Utils.getimagepath() + b.getImage());
				if(b.getComment() != null && b.getComment().contains("<img"))
					b.setComment(replaceComment(b.getComment()));
			}
			/**
			 * 对不同等级的商户随机排序
			 */
			//List<Business> newBusinessList = Utils.getListByRatingBusinessList(businessList);
			/**
			 * 151206：对不同等级用户按距离排序
			 */
			List<Business> newBusinessList = Utils.getListByRatingAndDistanceBusinessList(businessList, lati, lngti);
			json.put("success", true);
			json.put("business", newBusinessList);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("msg", "查询推荐商户失败，请稍后重试！！");
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 查询附近商户(零售商)
	 * (1.只包含商户信息
	 * 2.前4条永远是推荐商户
	 * 3.后面的按照距离排序)  --> 下面覆盖了该方法
	 * @throws IOException 
	 */
	/*@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getBusinessByNear() throws IOException {
		double Distance = 5000; //设置附近半径
		Map json = new HashMap();
		//查询所有零售商
		List<Business> businessAllList = businessService.find(" from Business where status=1 and type=1 ");
		List<Business> businessList = businessService.findRecommendBusiness(page, limit);
		List<Business> list = new ArrayList<Business>();
		if(lngti>180 || lngti<0 || lati>90 || lati<0 ) {
			json.put("success", false);
			json.put("msg", "地理数据错误，请重试！！");
		} else if(lngti==0 || lati==0) {
			//没获取到用户当前经纬度就显示一些推荐商户
			for(int i=0; i<businessList.size(); i++) {
				Business b = businessList.get(i);
				if(b.getImage() != null && b.getImage().length() != 0)
					b.setImage(Utils.getimagepath() + b.getImage());
				if(b.getComment() != null && b.getComment().contains("<img"))
					b.setComment(replaceComment(b.getComment()));
			}
			json.put("success", true);
			json.put("msg", "获取地理位置失败，显示推荐商户！！");
//			json.put("business", businessList);
			json.put("businessAndLocks", lockService.findTopThreeLocks(businessList));
		} else {
			List<Business> RecommendBusinessList = businessService.findBusinessFirstFour();
			//去重：去除所有商户(businessAllList)中显示最前端的4条商户数据.
			businessAllList.removeAll(RecommendBusinessList);
			for(int i=0; i<businessAllList.size(); i++) {
				double x = businessAllList.get(i).getPointX();
				double y = businessAllList.get(i).getPointY();
				double distance = Utils.getDistatce(lati, x, lngti, y);
				if(distance < Distance){
					Business b = businessAllList.get(i);
					if(b.getImage() != null && b.getImage().length() != 0)
						b.setImage(Utils.getimagepath() + b.getImage());
					if(b.getComment() != null && b.getComment().contains("<img"))
						b.setComment(replaceComment(b.getComment()));
					//设置距离
					b.setDistance(distance);
					list.add(businessAllList.get(i));
				}
			}
			Collections.sort(list, new Comparator<Business>(){
				public int compare(Business o1, Business o2) {
					return String.valueOf(o1.getDistance()).compareTo(String.valueOf(o2.getDistance()));
				}
			});
			//把list集合追加到RecommendBusinessList中
			RecommendBusinessList.addAll(list);
			*//**
			 * 分页不能在最开始对集合进行操作，要对处理好的集合分页返回
			 *//*
			List<Business> nowList = Utils.getListByPageAndPagesize(RecommendBusinessList, page, limit);
			json.put("success", true);
//			json.put("recommendBusiness", RecommendBusinessList);
//			json.put("business", list);
			json.put("businessAndLocks", lockService.findTopThreeLocks(nowList));
		}
		Utils.senchaview(json);
	}*/
	
	/**
	 * 查询附近商户(零售商)
	 * (1.只包含商户信息
	 * 2.前4条永远是推荐商户
	 * 3.后面的按照距离排序)  --> 修改
	 * 1.先按城市划分
	 * 2.再按距离有近到远排序(不设置规定距离)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getBusinessByNear() throws IOException {
		String cityNew = java.net.URLDecoder.decode(city,"UTF-8");
		Map json = new HashMap();
		List<Business> defaultRecommendBusinessList = new ArrayList<Business>();
		if(cityNew != null && cityNew.length() != 0) {
			//根据城市查询推荐零售商(不含普通)
			defaultRecommendBusinessList = businessService.findRecommendBusinessByCityAndXY(page, limit, cityNew, lati, lngti);
		} else {
			//查询推荐零售商(不含普通,无地理位置)
			defaultRecommendBusinessList = businessService.findRecommendBusiness(page, limit);
		}
		if(lngti>180 || lngti<0 || lati>90 || lati<0 ) {
			json.put("success", false);
			json.put("msg", "地理数据错误，请重试！！");
		} else if(lngti==0 || lati==0) {
			//没获取到用户当前经纬度就显示一些默认推荐商户
			for(int i=0; i<defaultRecommendBusinessList.size(); i++) {
				Business b = defaultRecommendBusinessList.get(i);
				if(b.getImage() != null && b.getImage().length() != 0)
					b.setImage(Utils.getimagepath() + b.getImage());
				if(b.getComment() != null && b.getComment().contains("<img"))
					b.setComment(replaceComment(b.getComment()));
			}
			/**
			 * 最后对不同等级的商户随机排序
			 * 注：此处是附近(按距离排序)，不需要按等级排序
			 */
//			List<Business> newBusinessList = Utils.getListByRatingBusinessList(defaultRecommendBusinessList);
			json.put("success", true);
			json.put("msg", "获取地理位置失败，显示城市推荐商户！！");
			json.put("businessAndLocks", lockService.findTopThreeLocks(defaultRecommendBusinessList));
		} else {
			List<Business> businessList = businessService.findRecommendBusinessByCityAndXY(page, limit, cityNew, lati, lngti);
			for(int i=0; i<businessList.size(); i++) {
				Business b = businessList.get(i);
				if(b.getImage() != null && b.getImage().length() != 0)
					b.setImage(Utils.getimagepath() + b.getImage());
				if(b.getComment() != null && b.getComment().contains("<img"))
					b.setComment(replaceComment(b.getComment()));
			}
			/**
			 * 最后对不同等级的商户随机排序
			 * 注：此处是附近(按距离排序)，不需要按等级排序
			 */
//			List<Business> newBusinessList = Utils.getListByRatingBusinessList(businessList);
			json.put("success", true);
			json.put("businessAndLocks", lockService.findTopThreeLocks(businessList));
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 根据城市查询商户(包括该商户一条锁信息)
	 * 开锁服务：先按照商户优先级排序（同样优先级的滚动），普通商户只在该处显示
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getBusinessByCity() throws IOException {
		String cityNew = java.net.URLDecoder.decode(city,"UTF-8");
		Map json = new HashMap();
		List<Business> businessList = businessService.findBusinessByCity(page, limit, cityNew);
		if(businessList.size()==0) {
			json.put("success", false);
			json.put("msg", "该城市暂时还无验证商户！");
		} else {
			/**
			 * 需要先对查询好的不同等级的商户集合(这是确定排序好最终集合)随机排序
			 */
			List<Business> newBusinessList = Utils.getListByRatingBusinessList(businessList);
			//再按排序好的商户顺序查询他们各自的锁信息
			List<Locks> locksList = new ArrayList<Locks>();
			if(newBusinessList != null && newBusinessList.size() != 0) {
				for(int i=0; i<newBusinessList.size(); i++) {
					Business business = newBusinessList.get(i);
					if(business.getImage() != null && business.getImage().length() != 0)
						business.setImage(Utils.getimagepath() + business.getImage());
					if(business.getComment() != null && business.getComment().contains("<img"))
						business.setComment(replaceComment(business.getComment()));
					Locks locks = lockService.findAlocksByBusiness(business.getId());
					if(locks != null) {
						if(locks.getImage() != null && locks.getImage().length() != 0)
							locks.setImage(Utils.getimagepath() + locks.getImage());
						if(locks.getComment() != null && locks.getComment().contains("<img"))
							locks.setComment(replaceComment(locks.getComment()));
						locksList.add(locks);
					} else {
						locksList.add(null);
					}
				}
			}
			json.put("success", true);
			json.put("business", newBusinessList);
			json.put("locks", locksList);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据城市和城区查询商户，并对商户由近到远进行排序(由于附近功能普通商户不能显示,
	 * 故该处也不能显示,将在service hql语句中处理)
	 */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public void getBusinessByCityAndArea() throws IOException{
    	String cityNew = java.net.URLDecoder.decode(city, "UTF-8");
    	String areaNew = java.net.URLDecoder.decode(area, "UTF-8");
    	Map json = new HashMap();
    	String sb = cityNew + "市" + areaNew;
    	List<Business> businessList = businessService.findBusiness(page, limit, sb, lati, lngti);
    	if(businessList != null && businessList.size() != 0) {
    		for(int i=0; i<businessList.size(); i++){
    			Business business = businessList.get(i);
    			if(business.getImage() != null && business.getImage().length() != 0)
					business.setImage(Utils.getimagepath() + business.getImage());
				if(business.getComment() != null && business.getComment().contains("<img"))
					business.setComment(replaceComment(business.getComment()));
    		}
    		json.put("success", true);
    		json.put("business", businessList);
    	} else {
    		json.put("success", true);
    		json.put("msg", "该区域暂无商户!");
    	}
    	Utils.senchaview(json);
    }
	
	/**
	 * 查询所有锁(锁列表)
	 * @throws IOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAllLocks() throws IOException {
		Map json = new HashMap();
		List<Locks> locksList = this.lockService.findAllLocks(page, limit);
		if (locksList.size() == 0) {
			json.put("msg", "暂时还没有任何锁商品！！");
			json.put("success", false);
		} else {
			for (int i = 0; i < locksList.size(); i++) {
				Locks locks = locksList.get(i);
				if(locks.getImage() != null && locks.getImage().length() != 0)
					locks.setImage(Utils.getimagepath() + locks.getImage());
				if(locks.getComment() != null && locks.getComment().contains("<img"))
					locks.setComment(replaceComment(locks.getComment()));
			}
			json.put("success", true);
			json.put("locks", locksList);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 查询所有商户(商户列表),批发商(business.type=0)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getAllWholesaler() throws IOException {
		Map<String, Object> json = new HashMap();
		try {
			List<Business> businessList = this.businessService.findAllWholesaler(page, limit);
			for(int i=0; i<businessList.size(); i++) {
				Business b = businessList.get(i);
				if(b.getImage() != null && b.getImage().length() != 0)
					b.setImage(Utils.getimagepath() + b.getImage());
				if(b.getComment() != null && b.getComment().contains("<img"))
					b.setComment(replaceComment(b.getComment()));
			}
			/**
			 * 最后对不同等级的商户随机排序
			 */
			List<Business> newBusinessList = Utils.getListByRatingBusinessList(businessList);
			json.put("success", true);
			json.put("business", newBusinessList);
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "查询商户信息失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据锁id查询该锁(单条记录)信息
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getLocksByLocksId() throws IOException {
		Map json = new HashMap();
		try {
			Locks locks = lockService.findById(locksId);
			if(locks.getImage() != null && locks.getImage().length() != 0)
				locks.setImage(Utils.getimagepath() + locks.getImage());
			if(locks.getComment() != null && locks.getComment().contains("<img"))
				locks.setComment(replaceComment(locks.getComment()));
			json.put("success", true);
			json.put("locks", locks);
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "根据锁id查询锁失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据锁id查询锁(包括商户)具体信息
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getbusilks() throws IOException {
		Map json = new HashMap();
		Locks locks = this.lockService.findById(locksId);
		Business b = this.businessService.findById(locks.getBusinessId());
		if(locks.getImage() != null && locks.getImage().length() != 0)
			locks.setImage(Utils.getimagepath() + locks.getImage());
		if(locks.getComment() != null && locks.getComment().contains("<img"))
			locks.setComment(replaceComment(locks.getComment()));
		if(b.getImage() != null && b.getImage().length() != 0)
			b.setImage(Utils.getimagepath() + b.getImage());
		if(b.getComment() != null && b.getComment().contains("<img"))
			b.setComment(replaceComment(b.getComment()));
		if(locks == null || b == null) {
			json.put("success", false);
			json.put("msg", "查询失败，请稍后重试！！");
		} else {
			json.put("success", true);
			json.put("locks", locks);
			json.put("business", b);
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 商户根据商户id查询锁信息(userId, businessId, page, limit)
	 * step1:根据该用户的userId查询他是否是商户
	 * step2:如果是商户则进入下一步,否则返回false
	 * step3:检测该用户要查询商户的状态(status)是否为1(验证通过)
	 * step4:验证通过的进入下一步,否则返回"该商户暂时还未通过审核"
	 * step5:根据要查询的商户id(businessId)查询所有锁信息返回.
	 * @throws IOException 
	 * 注：加了VIP和同行
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getLocksByBusiness() throws IOException {
		Map json = new HashMap();
		try {
//			if(businessService.checkingUser(userId)) {
			String tonghangId = userRoleService.findIdByName("同行");					//同行id
			String businessRoleId = userRoleService.findIdByName("验证会员");  	//验证会员id
			String VIPRoleId = userRoleService.findIdByName("VIP会员");		   		//VIP会员id
			String userRoleId = userService.findById(userId).getUserRoleId();		//该用户id
			/*
			 * 如果该用户是同行，商户或者VIP就能查看
			 */
			if(userRoleId.equals(tonghangId) || userRoleId.equals(businessRoleId) || userRoleId.equals(VIPRoleId)){
				int businessStatus = businessService.findById(businessId).getStatus();
				if(businessStatus == 0) {
					json.put("success", true);
					json.put("msg", "该商户还未通过审核！！");
				} else if(businessStatus == 1) {
					List<Locks> locksList = lockService.findLocksByBusiness(page, limit, businessId);
					if(locksList.size()==0) {
						json.put("success", true);
						json.put("msg", "该商户暂时还未上架任何商品！！");
					} else {
						for(int i=0; i<locksList.size(); i++) {
							Locks locks = locksList.get(i);
							if(locks.getImage() != null && locks.getImage().length() != 0)
								locks.setImage(Utils.getimagepath() + locks.getImage());
							if(locks.getComment() != null && locks.getComment().contains("<img"))
								locks.setComment(replaceComment(locks.getComment()));
						}
						json.put("success", true);
						json.put("locks", locksList);
					}
				}
			} else {
				json.put("success", false);
				json.put("msg", "您还不是同行,商户或VIP,不能进行此类操作!");
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "根据商户id查询锁信息失败，请稍后重试!");
			e.printStackTrace();
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 搜索锁(模糊查询)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void searchLocks() throws IOException {
		Map json = new HashMap();
		List<Locks> locksList = lockService.searchLocksByName(page, limit, keywords);
		if(locksList.size()==0) {
			List<Business> businessList = businessService.searchBusinessByCompany(page, limit, keywords);
			if(businessList.size()==0) {
				json.put("success", false);
				json.put("msg", "搜索结果为空！！");
			} else {
				List<Locks> secondLocksList = new ArrayList<Locks>();
				Locks secondLocks = new Locks();
				for(int i=0; i<businessList.size(); i++) {
					Business business = businessList.get(i);
					if(business.getImage() != null && business.getImage().length() != 0)
						business.setImage(Utils.getimagepath() + business.getImage());
					if(business.getComment() != null && business.getComment().contains("<img"))
						business.setComment(replaceComment(business.getComment()));
					//现在根据businessId查询该商户一条锁信息
					secondLocks = lockService.findAlocksByBusiness(businessList.get(i).getId());
					if(secondLocks.getImage() != null && secondLocks.getImage().length() != 0)
						secondLocks.setImage(Utils.getimagepath() + secondLocks.getImage());
					if(secondLocks.getComment() != null && secondLocks.getComment().contains("<img"))
						secondLocks.setComment(replaceComment(secondLocks.getComment()));
					secondLocksList.add(secondLocks);
				}
				json.put("success", true);
				json.put("msg", "模糊查询商户成功,并返回对应商户一条锁信息!!");
				json.put("business", businessList);
				json.put("locks", secondLocksList);
			}
		} else {
			List<Business> secondBusinessList = new ArrayList<Business>();
			Business secondBusiness = new Business();
			for(int i=0; i<locksList.size(); i++) {
				Locks locks = locksList.get(i);
				if(locks.getImage() != null && locks.getImage().length() != 0)
					locks.setImage(Utils.getimagepath() + locks.getImage());
				if(locks.getComment() != null && locks.getComment().contains("<img"))
					locks.setComment(replaceComment(locks.getComment()));
				//现在查询该锁的商户信息
				secondBusiness = businessService.findById(locks.getBusinessId());
				if(secondBusiness.getImage() != null && secondBusiness.getImage().length() != 0)
					secondBusiness.setImage(Utils.getimagepath() + secondBusiness.getImage());
				if(secondBusiness.getComment().contains("<img"))
					secondBusiness.setComment(replaceComment(secondBusiness.getComment()));
				secondBusinessList.add(secondBusiness);
			}
			json.put("success", true);
			json.put("msg", "模糊查询商品成功,并返回对应商品商户信息!!");
			json.put("locks", locksList);
			json.put("business", secondBusinessList);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 添加一份订单(未付款,status为0)
	 * 往userorder插入一条笼统记录(status=0)
	 * 接着分解lockid往userordert表中逐条插入(status=0,businessStatus=0)
	 * @throws IOException 
	 */
	//http://localhost:8080/lockMgr/shop_addOrder.action?allOrderLocksId=27c3d26d-e78f-48b9-b676-b1278fdac7bb&allOrderNumber=1&userId=4a3b0049-2c3b-43d7-94c6-102dc779fa16&consignee=%E6%A2%81%E5%9C%A8%E8%B6%85&consigneePhone=1807004&deliveryAddress=%E5%A4%A9%E5%A0%82
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String addOrder() throws IOException {
		Map json = new HashMap();
		try {
			String[] orderLockId = allOrderLocksId.split(",");
			String[] orderNumber = allOrderNumber.split(",");
			if(orderLockId.length != orderNumber.length) {
				json.put("success", false);
				json.put("msg", "订单保存失败(锁id与数量不一致)！！");
			}else {
				//计算出总价格
				//double price = 0;
				/*for(int i=0; i<orderLockId.length; i++) {
					double onePrice = lockService.findById(orderLockId[i]).getPrice();
					int oneNumber = Integer.parseInt(orderNumber[i]);
					price = price + onePrice*oneNumber;
				}*/
				String orderId = userorderService.addOrder(allOrderLocksId, allOrderNumber, userId, consignee, consigneePhone, deliveryAddress, totalPrice, orderType);
				uotService.addOrderT(orderId);
				//locks或groupbuyLocks表销量需要更新
				if(orderType != 0 && orderType == 1) {
					lockService.updateLocksSales(allOrderLocksId, allOrderNumber);
				} else if(orderType != 0 && orderType == 2) {
					gblService.updateGblocksSales(allOrderLocksId, allOrderNumber);
				}
				json.put("success", true);
				json.put("msg", "您的订单已提交！！");
				json.put("price", totalPrice);
				json.put("orderId", orderId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("msg", "订单提交失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 添加订单(付款后,status改变为1时)
	 * 根据订单号对未付款时的订单逐句插入
	 */
	//locksId : 27c3d26d-e78f-48b9-b676-b1278fdac7bb,04ac2b60-1e8b-4a98-a454-d5ab20cd3535,
	//orderNum : 10,20,
	/*
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addOrderT() {
		if(orderId == null || orderId.length()<=0) {
			Map json = new HashMap();
			Userorder uo = userorderService.findById(orderId);
			uotService.addOrderT(uo);
			json.put("success", true);
			json.put("msg", "付款成功!");
		}
	}
	*/
	
	/**
	 * 根据订单id查找该条订单
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getOrderById() throws IOException {
		Map json = new HashMap();
		try {
			userorder = userorderService.findById(orderId);
			json.put("success", true);
			json.put("userorder", userorder);
		} catch (Exception e) {
			json.put("success", false);
			json.put("mgr", "查询该项订单失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据用户id查找相应订单
	 * orderStatus: 0,未付款; 1,已付款. 默认返回未付款的订单.
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getOrderByUser() throws IOException {
		Map json = new HashMap();
		try {
//			json.put("userOrder", userorderService.findOrderByUser(page, limit, userId, orderStatus));
			json.put("userOrder", uotService.findOrderByUser(page, limit, userId, orderStatus));
			json.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("msg", "查询用户订单失败，请稍后重试！！");
		}
//		jsonViewIE(json);
		Utils.senchaview(json);
	}
	
	/**
	 * 根据用户id查询订单号和时间
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getOrderAndTime() throws IOException {
		Map json = new HashMap();
		json.put("orderAndTime", userorderService.findOrderAndTime(page, limit, userId, orderStatus));
		json.put("success", true);
		Utils.senchaview(json);
	}
	
	/**
	 * 取消一项订单(直接删除，不能设状态设为0，因为未付款订单状态就是0)
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String cancelOrder() throws IOException {
		Map json = new HashMap();
		try {
//			userorderService.delete(orderId); //真正删除
			userorderService.cancelOrder(orderId);
			json.put("success", true);
			json.put("msg", "您该项订单已取消！！");
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "订单取消失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}

	/**
	 * 修改订单
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String modifyOrder() throws IOException {
		Map json = new HashMap();
		try {
			String[] orderLockId = allOrderLocksId.split(",");
			String[] orderNumber = allOrderNumber.split(",");
			if(orderLockId.length != orderNumber.length) {
				json.put("success", false);
				json.put("msg", "订单保存失败(锁id与数量不一致)！！");
			}else {
				//计算出总价格
				double price = 0;
				for(int i=0; i<orderLockId.length; i++) {
					double onePrice = lockService.findById(orderLockId[i]).getPrice();
					int oneNumber = Integer.parseInt(orderNumber[i]);
					price = price + onePrice*oneNumber;
				}
				userorderService.modifyOrder(orderId, allOrderLocksId, allOrderNumber, userId, consignee, consigneePhone, deliveryAddress, price);
				json.put("success", true);
				json.put("msg", "您的订单已修改！！");
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "订单修改失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 查询所有锁型号
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getAllLocksType() throws IOException {
		Map json = new HashMap();
		List typeList = lockService.findAllLocksType(page, limit);
		if(typeList.size()==0) {
			json.put("success", true);
			json.put("msg", "目前商城还无任何商品！！");
		} else {
			json.put("success", true);
			json.put("type", typeList);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 根据商品类型查询锁(包括该商品商户信息)
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getLocksByType() throws IOException {
		Map json = new HashMap();
		List<Locks> locksList = lockService.findLocksByType(page, limit, type);
		List<Business> businessList = new ArrayList<Business>();
		if(locksList.size()==0) {
			json.put("success", true);
			json.put("msg", "商城目前还无任何商品！！");
		} else {
			for(int i=0; i<locksList.size(); i++) {
				Locks locks = locksList.get(i);
				if(locks.getImage() != null && locks.getImage().length() != 0)
					locks.setImage(Utils.getimagepath() + locks.getImage());
				if(locks.getComment() != null && locks.getComment().contains("<img"))
					locks.setComment(replaceComment(locks.getComment()));
				//返回该商品对应商户信息
				Business business = businessService.findById(locks.getBusinessId());
				if(business.getImage() != null && business.getImage().length() != 0)
					business.setImage(Utils.getimagepath() + business.getImage());
				if(business.getComment() != null && business.getComment().contains("<img"))
					business.setComment(replaceComment(business.getComment()));
				businessList.add(business);
			}
			json.put("success", true);
			json.put("locks", locksList);
			json.put("business", businessList);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 显示所有团购锁
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getAllGroupbuyLocks() throws IOException {
		Map json = new HashMap();
		try {
			List<GroupbuyLocks> gblList = gblService.findAllGbLocks(page, limit);
			Locks l = null;
			Business b = null;
			if(gblList.size() != 0 && gblList != null) {
				for (int i = 0; i < gblList.size(); i++) {
					GroupbuyLocks g = gblList.get(i);
					//设置locksName字段
					l =  lockService.findById(g.getLocksId());
					g.setLocksName(l.getName());
					//设置businessName字段
					b = businessService.findById(g.getBusinessId());
					g.setBusinessName(b.getCompany());
					//设置团购商品原价(oprice)
					g.setPrice(l.getPrice());
					g.setOprice(l.getOprice());
					//设置团购图片
					if(g.getImage() != null && g.getImage().length() != 0)
						g.setImage(Utils.getimagepath() + g.getImage());
					//设置comment(简介)
					if(g.getComment() != null && g.getImage().contains("<img"))
						g.setComment(replaceComment(g.getComment()));
				}
			}
			json.put("success", true);
			json.put("groupbuyLocks", gblList);
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("msg", "查询团购信息失败，请稍后重试！！");
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 根据团购id(gbId)查询团购锁和该商户信息
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void getGblocksAndBusinessBygbId() throws IOException {
		Map json = new HashMap();
		GroupbuyLocks gbl = gblService.findById(gbId);
		if(gbl == null) {
			json.put("success", false);
			json.put("msg", "查询失败(无该锁信息)！");
			Utils.senchaview(json);
			return;
		}
		Locks locks = lockService.findById(gbl.getLocksId());
		Business business = businessService.findById(gbl.getBusinessId());
		//设置锁名称和商户名称
		gbl.setLocksName(locks.getName());
		gbl.setBusinessName(business.getCompany());
		//设置该团购锁原来两个价格
		gbl.setPrice(locks.getPrice());
		gbl.setOprice(locks.getOprice());
		//设置图片和简介
		if(gbl.getImage() != null && gbl.getImage().length() != 0)
			gbl.setImage(Utils.getimagepath() + gbl.getImage());
		if(gbl.getComment() != null && gbl.getComment().contains("<img"))
			gbl.setComment(replaceComment(gbl.getComment()));
		json.put("success", true);
		json.put("groupbuyLocks", gbl);
		Utils.senchaview(json);
	}
	
	/**
	 * 上传商品
	 * @throws IOException 
	 */
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public void uploadLock() throws IOException {
		Map m = new HashMap();
		/*
		 * 首先判断是否为商户
		 * 管理员不能直接上传商品（locks表中的businessId字段存入问题，还可能导致其他方法出现空指针）
		 * 是同行也不行（因为同行只是user表中的角色信息改变了，business表中并没有记录）
		 * 所以得判断business表中是否有该用户记录
		 */
		Business business = businessService.checkingUser(userId);
		if(business == null) {
			m.put("success", false);
			m.put("msg", "您还不是商户，暂不能上传商品！");
		} else if(business.getRating() == 0) {
			//根据谭2015.12.26需求普通商户(rating = 0)不具有上传商品功能
			m.put("success", false);
			m.put("msg", "普通商户不能上传商品,请联系管理员修改权限后再次操作!");
		} else {
			String imagePath = "";
			String businessId = businessService.findBusinessIdByUserId(userId);
			if (ImgData != null) {
//				ImgData = ImgData.substring(ImgData.lastIndexOf(",")+1);
				BASE64Decoder decode = new BASE64Decoder();
				byte[] b = decode.decodeBuffer(ImgData);
				for (int i = 0; i < b.length; i++) {
					if(b[i]<0){
						b[i]+=256;
					}
				}
				String saved = getRequest().getRealPath("/")+"/file/img/";
				System.out.println(saved);
				String sname = Utils.getNewUUID().replaceAll("-", "");
				File f = new File(saved);
				if(!f.exists()){
					f.mkdir();
				}
				saved = saved+sname+".jpg";
				OutputStream out = new FileOutputStream(new File(saved));
				out.write(b);
				out.flush();
				out.close();
				imagePath = sname + ".jpg";
			}
			boolean b = lockService.uploadLocks(imagePath, locksName, type, origin, oprice, price, comment, businessId);
			if(b == true) {
				m.put("success", true);
				m.put("msg", "商品上传成功，请耐心等待审核！");
			} else {
				m.put("success", false);
				m.put("msg", "商品上传失败，请稍后重试！");
			}
		}
		Utils.senchaview(m);
	}

	/**
	 * 查询商户和该商户3件商品(按商户优先级排序)
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getBusinessAndThreeLock() throws IOException {
		Map m = new HashMap();
		List list = businessService.findBusinessAndThreeLock(page, limit);
		if (list.size() != 0 && list != null) {
			m.put("success", true);
			m.put("businessAndLocks", list);
		} else {
			m.put("success", false);
			m.put("msg", "查询失败,请稍后重试!");
		}
		Utils.senchaview(m);
	}
	
	/**
	 * 获取全部商户(零售和批发)信息
	 * 不包含等级为普通的
	 * 目前聊天列表用到
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getAllBusiness() throws IOException {
		Map m = new HashMap();
		List<Business> businessList = businessService.findAllBusiness(page, limit);
		if(businessList != null && businessList.size() != 0) {
			for(int i=0; i<businessList.size(); i++) {
				Business business = businessList.get(i);
				if(business.getImage() != null && business.getImage().length() != 0)
					business.setImage(Utils.getimagepath() + business.getImage());
				if(business.getComment() != null && business.getComment().contains("<img"))
					business.setComment(replaceComment(business.getComment()));
			}
			m.put("success", true);
			m.put("allBusiness", businessList);
		} else {
			m.put("success", true);
			m.put("msg", "暂无商户信息!");
		}
		Utils.senchaview(m);
	}
	
	/**
	 * 测试
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void test() throws IOException {
		Map json = new HashMap();
		List<Business> list = businessService.findBusinessFirstFour();
		json.put("business", list);
		Utils.senchaview(json);
	}
	
	public String getLocksId() {
		return locksId;
	}

	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public ILockService getLockService() {
		return lockService;
	}

	public void setLockService(ILockService lockService) {
		this.lockService = lockService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Collect getCollect() {
		return collect;
	}

	public void setCollect(Collect collect) {
		this.collect = collect;
	}

	public ICollectService getCollectService() {
		return collectService;
	}

	public void setCollectService(ICollectService collectService) {
		this.collectService = collectService;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Userorder getUserorder() {
		return userorder;
	}

	public void setUserorder(Userorder userorder) {
		this.userorder = userorder;
	}

	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public Busilocks getBusilocks() {
		return busilocks;
	}

	public void setBusilocks(Busilocks busilocks) {
		this.busilocks = busilocks;
	}

	public IUserorderService getUserorderService() {
		return userorderService;
	}

	public void setUserorderService(IUserorderService userorderService) {
		this.userorderService = userorderService;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getBusinessId() {
		return businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public double getLati() {
		return lati;
	}

	public void setLati(double lati) {
		this.lati = lati;
	}

	public double getLngti() {
		return lngti;
	}

	public void setLngti(double lngti) {
		this.lngti = lngti;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IGroupbuyLocksService getGblService() {
		return gblService;
	}

	public void setGblService(IGroupbuyLocksService gblService) {
		this.gblService = gblService;
	}

	public String getAllOrderLocksId() {
		return allOrderLocksId;
	}

	public void setAllOrderLocksId(String allOrderLocksId) {
		this.allOrderLocksId = allOrderLocksId;
	}

	public String getAllOrderNumber() {
		return allOrderNumber;
	}

	public void setAllOrderNumber(String allOrderNumber) {
		this.allOrderNumber = allOrderNumber;
	}

	public double getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice)
	{
		this.totalPrice = totalPrice;
	}

	public String getGbId() {
		return gbId;
	}

	public void setGbId(String gbId) {
		this.gbId = gbId;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	public IUserordertService getUotService() {
		return uotService;
	}

	public void setUotService(IUserordertService uotService) {
		this.uotService = uotService;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getImgData() {
		return ImgData;
	}

	public void setImgData(String imgData) {
		ImgData = imgData;
	}

	public String getLocksName() {
		return locksName;
	}

	public void setLocksName(String locksName) {
		this.locksName = locksName;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public double getOprice() {
		return oprice;
	}

	public void setOprice(double oprice) {
		this.oprice = oprice;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	
}
