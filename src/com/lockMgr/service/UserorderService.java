package com.lockMgr.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.OrderAndTime;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Userorder;
import com.lockMgr.pojo.Userordert;
import com.lockMgr.pojo.Vip;

/**
 * 订单实现类
 * 
 * @author lzc
 * 
 */
@SuppressWarnings("unchecked")
public class UserorderService extends BaseDao<Userorder> implements
		IUserorderService {
	final int TRADE_FINISHED = 1;
	final int TRADE_SUCCESS = 2;
	final int TRADE_INIT = 0;

	private IBusinessService businessService;
	private ILockService lockService;
	private IGroupbuyLocksService gblService;
	private IUserordertService uotService;

	/**
	 * 订单号和时间
	 */
	public List<OrderAndTime> findOrderAndTime(int page, int pageSize,
			String userId, int orderStatus) {
		List<OrderAndTime> oatl = new ArrayList<OrderAndTime>();
		List<Userorder> userorderList = new ArrayList<Userorder>();
		String hql = " from Userorder where userId=? and status=? ";
		DateFormat f = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		if (page == 0 && pageSize == 0)
			userorderList = findByPage(hql,
					new Object[] { userId, orderStatus }, 0, 20);
		else
			userorderList = findByPage(hql,
					new Object[] { userId, orderStatus },
					(page - 1) * pageSize, pageSize);
		if (userorderList != null && userorderList.size() != 0) {
			for (int i = 0; i < userorderList.size(); i++) {
				OrderAndTime oat = new OrderAndTime();
				oat.setId(userorderList.get(i).getId());
				oat.setOrderId(userorderList.get(i).getName());
				oat.setTime(f.format(userorderList.get(i).getCreatetime()));
				oatl.add(oat);
			}
		}
		return oatl;
	}

	/**
	 * 根据订单id查询订单下所有商品信息
	 */
	@SuppressWarnings("rawtypes")
	public Map findOrderById(String id) {
		Map All = new HashMap();
		List<Userorder> newOrderListN = new ArrayList<Userorder>();
		Userorder uo = findById(id);
		if (uo.getGroupLocks() == 1) {
			Userorder y = new Userorder();
			y.setId(uo.getId());
			y.setName(uo.getName());
			y.setPrivilege(uo.getPrivilege());
			y.setCreatetime(uo.getCreatetime());
			y.setStatus(uo.getStatus());
			y.setUserId(uo.getUserId());
			y.setConsignee(uo.getConsignee());
			y.setConsigneePhone(uo.getConsigneePhone());
			y.setDeliveryAddress(uo.getDeliveryAddress());
			y.setGroupLocks(uo.getGroupLocks());
			All.put("Y", y);
			String[] lockId = uo.getLockId().split(",");
			String[] number = uo.getOrderNum().split(",");
			for (int i = 0; i < lockId.length; i++) {
				Locks l = lockService.findById(lockId[i]);
				Business b = businessService.findById(l.getBusinessId());
				Userorder n = new Userorder();
				// TODO
			}
		} else if (uo.getGroupLocks() == 2) {

		}
		return null;
	}

	/**
	 * 根据用户id查找相应订单
	 */
	@SuppressWarnings("rawtypes")
	/*
	 * public List findOrderByUser(int page, int pageSize, String userId, int
	 * orderStatus){ ArrayList All = new ArrayList(); List<Userorder>
	 * newOrderListY = new ArrayList<Userorder>(); List<Userorder> newOrderListN
	 * = new ArrayList<Userorder>(); String hql =
	 * " from Userorder where userId=? and status=? "; List<Userorder>
	 * userorderList = new ArrayList<Userorder>(); userorderList =
	 * findByPage(hql, new Object[]{userId,orderStatus},(page-1)*pageSize,
	 * pageSize); if (userorderList != null && userorderList.size() != 0) { for
	 * (int i = 0; i < userorderList.size(); i++) { List list=new ArrayList();
	 * Map s=new HashMap<String,ArrayList>(); //s.put("s", new ArrayList()); Map
	 * y=new HashMap<String, ArrayList>(); //y.put("y", new ArrayList());
	 * list.add(s); list.add(y); All.add(list); newOrderListY = new
	 * ArrayList<Userorder>(); newOrderListN = new ArrayList<Userorder>();
	 * String[] lockId = userorderList.get(i).getLockId().split(","); String[]
	 * number = userorderList.get(i).getOrderNum().split(","); //
	 * 如果grouplocks==1为基本锁 if (userorderList.get(i).getGroupLocks() == 1) {
	 * Userorder uu = userorderList.get(i); if(uu != null) { // 赋值旧数据(重复)
	 * uu.setId(userorderList.get(i).getId());
	 * uu.setName(userorderList.get(i).getName());
	 * uu.setPrivilege(userorderList.get(i).getPrivilege());
	 * uu.setCreatetime(userorderList.get(i).getCreatetime());
	 * uu.setStatus(userorderList.get(i).getStatus());
	 * uu.setUserId(userorderList.get(i).getUserId());
	 * uu.setConsignee(userorderList.get(i).getConsignee());
	 * uu.setConsigneePhone(userorderList.get(i).getConsigneePhone());
	 * uu.setDeliveryAddress(userorderList.get(i).getDeliveryAddress());
	 * uu.setGroupLocks(userorderList.get(i).getGroupLocks());
	 * newOrderListY.add(uu); } for (int j = 0; j < lockId.length; j++) { Locks
	 * l = lockService.findById(lockId[j]); Business b =
	 * businessService.findById(l.getBusinessId()); Userorder newOrder = new
	 * Userorder(); // 赋值新添加的数据(不重复) newOrder.setLockNumber(number[j]);
	 * newOrder.setLockName(l.getName()); newOrder.setUnitPrice(l.getPrice());
	 * if (l.getType() != null && l.getType().length() != 0)
	 * newOrder.setLockType(l.getType()); if (l.getImage() != null &&
	 * l.getImage().length() != 0) newOrder.setImage(Utils.getimagepath() +
	 * l.getImage()); if (b.getCompany() != null && b.getCompany().length() !=
	 * 0) newOrder.setBusinessName(b.getCompany()); newOrderListN.add(newOrder);
	 * } // All.put("N", newOrderListN); } // 如果grouplocks==2为团购锁 else if
	 * (userorderList.get(i).getGroupLocks() == 2) { Userorder uu =
	 * userorderList.get(i); if(uu != null) { // 赋值旧数据(重复)
	 * uu.setId(userorderList.get(i).getId());
	 * uu.setName(userorderList.get(i).getName());
	 * uu.setPrivilege(userorderList.get(i).getPrivilege());
	 * uu.setCreatetime(userorderList.get(i).getCreatetime());
	 * uu.setStatus(userorderList.get(i).getStatus());
	 * uu.setUserId(userorderList.get(i).getUserId());
	 * uu.setConsignee(userorderList.get(i).getConsignee());
	 * uu.setConsigneePhone(userorderList.get(i).getConsigneePhone());
	 * uu.setDeliveryAddress(userorderList.get(i).getDeliveryAddress());
	 * uu.setGroupLocks(userorderList.get(i).getGroupLocks());
	 * newOrderListY.add(uu); } for (int j = 0; j < lockId.length; j++) {
	 * GroupbuyLocks g = gblService.findById(lockId[j]); Business b =
	 * businessService.findById(g.getBusinessId()); Userorder newOrder = new
	 * Userorder(); // 赋值新添加的数据 newOrder.setLockNumber(number[j]);
	 * newOrder.setLockName(g.getName()); newOrder.setUnitPrice(g.getGbprice());
	 * if (g.getType() != null && g.getType().length() != 0)
	 * newOrder.setLockType(g.getType()); if (g.getImage() != null &&
	 * g.getImage().length() != 0) newOrder.setImage(Utils.getimagepath() +
	 * g.getImage()); if (b.getCompany() != null && b.getCompany().length() !=
	 * 0) newOrder.setBusinessName(b.getCompany()); newOrderListN.add(newOrder);
	 * } // All.put("N", newOrderListN); } // All.put("N", newOrderListN); //
	 * All.put("Y", newOrderListY); y.put("y", newOrderListY); s.put("s",
	 * newOrderListN); } } return All; }
	 */
	/**
	 * 取消一项订单(直接删除，不能设状态设为0，因为未付款订单状态就是0)
	 * 1.根据orderId(订单号：userOrder表中id)删除userOrder一条记录
	 * 2.根据name(显示给用户的订单号：userOrder表中name)循环删除userOrdert表中记录
	 */
	@Override
	public String cancelOrder(String orderId) {
		// String hql = " update Userorder uo set uo.status=0 where uo.id=? ";
		Userorder userorder = findById(orderId);
		String orderNum = userorder.getName();  //显示给用户的订单号
		// userorder.setStatus(0);
		// saveOrUpdate(userorder);
		delete(userorder);
		/**
		 * 2.根据name(显示给用户的订单号：userOrder表中name)循环删除userOrdert表中记录
		 */
		List<Userordert> uotList = uotService.findOrderByOrderId(orderNum);
		if(uotList != null && uotList.size() != 0) {
			for(int i=0; i<uotList.size(); i++) {
				if(uotList.get(i) != null) {
					uotService.delete(uotList.get(i));
				}
			}
		}
		return null;
	}

	/**
	 * 增加订单
	 */
	public String addOrder(String allOrderLocksId, String allOrderNumber,
			String userId, String consignee, String consigneePhone,
			String deliveryAddress, double price, int orderType) {
		Userorder userorder = new Userorder();
		userorder.setLockId(allOrderLocksId);
		userorder.setUserId(userId);
		userorder.setConsignee(consignee);
		userorder.setConsigneePhone(consigneePhone);
		userorder.setDeliveryAddress(deliveryAddress);
		userorder.setOrderNum(allOrderNumber);
		userorder.setPrice(price);
		userorder.setStatus(TRADE_INIT);
		userorder.setGroupLocks(orderType);
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String nameHeader = format.format(new Date());
		userorder.setName(nameHeader + new Random().nextInt(1000));
		save(userorder);
		String orderId = userorder.getId();
		return orderId;
	}

	/**
	 * 修改订单
	 */
	public void modifyOrder(String orderId, String allOrderLocksId,
			String allOrderNumber, String userId, String consignee,
			String consigneePhone, String deliveryAddress, double price) {
		Userorder userorder = findById(orderId);
		userorder.setLockId(allOrderLocksId);
		userorder.setUserId(userId);
		userorder.setConsignee(consignee);
		userorder.setConsigneePhone(consigneePhone);
		userorder.setDeliveryAddress(deliveryAddress);
		userorder.setOrderNum(allOrderNumber);
		userorder.setStatus(1);
		saveOrUpdate(userorder);
	}

	/*
	 * 手动获取session操作数据库
	 * 
	 * @see com.lockMgr.service.IUserorderService#test()
	 */
	public void txUpdateOrder(HttpServletRequest req, String orderId, int status) {
		// System.out.println(req.getSession().getServletContext());
		// System.out.println(ServletActionContext.getServletContext());
		// //ServletActionContext 在访问页面可以直接用
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(req.getSession().getServletContext());
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		// UserordertService
		// userorderService=ctx.getBean(UserordertService.class);

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Object obj = session.get(Userorder.class, orderId);
		if (obj != null) {
			// 把userorder表状态改为1
			Userorder order = (Userorder) obj;
			order.setStatus(status);
			session.saveOrUpdate(order);
			System.out.print("test!");
			// 付款成功把userordert表中的该订单id所有相关订单号的status,businessStatus都改为1
			// Userordert orderId=session.get(Userordert.class, orderId);
			// IUserordertService uotService = new UserordertService();
			// userorderService.modifyStatusAndBS(orderId);
			Query query = session
					.createQuery(" update Userordert uot set uot.status="
							+ status
							+ ",uot.businessStatus="
							+ status
							+ " where uot.userOrderId=(select uo.name from Userorder uo where uo.id='"
							+ orderId + "') ");
			query.executeUpdate();
		}
		tr.commit();
		session.close();

	}

	public void txCommonChangeVIP(HttpServletRequest req, String userid) {
		ApplicationContext ctx = WebApplicationContextUtils
				.getWebApplicationContext(req.getSession().getServletContext());
		SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
		// UserordertService
		// userorderService=ctx.getBean(UserordertService.class);

		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		User user = (User) session.get(User.class, userid);
		Operator operator = (Operator) session.get(Operator.class, userid);
		if (user != null && operator != null) {
			// String sql="select id from userrole while name='VIP会员'";
			// Query q=session.createSQLQuery(sql);
			// List list=q.list();
			// List<String> r= (List<String>) list.get(0);
			// String roleid= r.get(0);
			user.setUserRoleId("4195f48e-6aba-466f-bdda-8152fb10074d");
			operator.setRoleId("4195f48e-6aba-466f-bdda-8152fb10074d");
			session.saveOrUpdate(user);
			session.saveOrUpdate(operator);
			/**
			 * 接着在vip表添加一条数据
			 */
			String vipId = Utils.getNewUUID();
			Timestamp nowDate = Utils.getNow();
			Timestamp endDate = Utils.getNow();
			long   nDay=(nowDate.getTime()/(24*60*60*1000)+1+365)*(24*60*60*1000);
			endDate.setTime(nDay);  //endDate此时已是365天后的日期
//			String addVipHql = " insert into Vip values('"+ vipId +"',null,null,'"+ nowDate +"','"+ endDate +"','"+ userid +"',1) ";
//			Query query = session.createQuery(addVipHql);
//			query.executeUpdate();
			Vip vip = new Vip();
			vip.setId(vipId);
			vip.setCreatetime(nowDate);
			vip.setEndtime(endDate);
			vip.setUserId(userid);
			vip.setStatus(1);
			session.save(vip);
		}
		tr.commit();
		session.close();

	}

	/**
	 * 根据订单号查询该订单记录 订单号为Userorder中的name字段，一般来说生成的订单号唯一，可以一对一查找。
	 */
	public Userorder findOrderByName(String userOrder) {
		List<Userorder> list = new ArrayList<Userorder>();
		Userorder uo = new Userorder();
		if (userOrder != null && userOrder.length() > 0) {
			String hql = " from Userorder where name=? ";
			list = find(hql, new Object[] { userOrder });
			uo = list.get(0);
		}
		return uo;
	}

	/**
	 * 根据订单号查询订单
	 */
	public Userorder findOrderByOrderId(String orderId) {
		Userorder u = new Userorder();
		String hql = " from Userorder where name='" + orderId + "'";
		List<Userorder> list = find(hql);
		if (list != null && list.size() != 0) {
			u = list.get(0);
		}
		return u;
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

	public IGroupbuyLocksService getGblService() {
		return gblService;
	}

	public void setGblService(IGroupbuyLocksService gblService) {
		this.gblService = gblService;
	}

	public IUserordertService getUotService() {
		return uotService;
	}

	public void setUotService(IUserordertService uotService) {
		this.uotService = uotService;
	}
	

}
