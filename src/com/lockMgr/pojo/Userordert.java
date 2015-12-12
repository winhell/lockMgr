package com.lockMgr.pojo;

import java.sql.Timestamp;
import java.util.List;

import com.lockMgr.core.SpringFactory;
import com.lockMgr.core.Utils;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.IGroupbuyLocksService;
import com.lockMgr.service.ILockService;
import com.lockMgr.service.IUserorderService;

/**
 * Userordert entity. @author MyEclipse Persistence Tools
 */

public class Userordert extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String userOrderId;
	private String locksId;
	private String userId;
	private String businessId;
	private int number;
	private int status;
	private int businessStatus;
	private int groupLocks;
	
	private String userName;
	private String locksName;
	private String locksType;
	private double price;		//基本锁价格
	private double gbPrice;		//团购价格
	private String consignee;
	private String consigneePhone;
	private String deliveryAddress;
	private String statusName;
	
	public String getLockName() {
		String lockName = "";
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			lockName = lockService.findById(locksId).getName();
		}else if (groupLocks == 2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			lockName = glService.findById(locksId).getName();
		}
		return lockName;
	}
	public String getLockType() {
		String lockType = "";
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			lockType = lockService.findById(locksId).getType();
		}else if (groupLocks == 2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			lockType = glService.findById(locksId).getType();
		}
		return lockType;
	}
	public String getImage() {
		String image = "";
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			image = Utils.getimagepath() + lockService.findById(locksId).getImage();
		}else if (groupLocks == 2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			image = Utils.getimagepath() + glService.findById(locksId).getImage();
		}
		return image;
	}
	public double getUnitPrice() {
		double unitPrice = 0;
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			unitPrice = lockService.findById(locksId).getPrice();
		}else if (groupLocks == 2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			unitPrice = glService.findById(locksId).getGbprice();
		}
		return unitPrice;
	}
	public String getBusinessName(){
		String businessId = "";
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			businessId = lockService.findById(locksId).getBusinessId();
		}else if(groupLocks ==2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			businessId = glService.findById(locksId).getBusinessId();
		}
		IBusinessService businessService = (IBusinessService) SpringFactory.getBean("businessService");
		String businessName = businessService.findById(businessId).getCompany();
		return businessName;
	}
	public String getBusinessPhone() {
		String businessId = "";
		if(groupLocks == 1) {
			ILockService lockService = (ILockService) SpringFactory.getBean("lockService");
			businessId = lockService.findById(locksId).getBusinessId();
		}else if(groupLocks ==2) {
			IGroupbuyLocksService glService = (IGroupbuyLocksService) SpringFactory.getBean("gbService");
			businessId = glService.findById(locksId).getBusinessId();
		}
		IBusinessService businessService = (IBusinessService) SpringFactory.getBean("businessService");
		String businessPhone = businessService.findById(businessId).getTel();
		return businessPhone;
	}
	public String getConsignee() {
		IUserorderService uoService = (IUserorderService) SpringFactory.getBean("userorderService");
		Userorder u = uoService.findOrderByOrderId(userOrderId);
		String c = u.getConsignee();
		return c;
	}
	public String getConsigneePhone() {
		IUserorderService uoService = (IUserorderService) SpringFactory.getBean("userorderService");
		Userorder u = uoService.findOrderByOrderId(userOrderId);
		String cp = u.getConsigneePhone();
		return cp;
	}
	public String getDeliveryAddress() {
		IUserorderService uoService = (IUserorderService) SpringFactory.getBean("userorderService");
		Userorder u = uoService.findOrderByOrderId(userOrderId);
		String d = u.getDeliveryAddress();
		return d;
	}
	
	
	// Constructors

	/** default constructor */
	public Userordert() {
	}

	/** minimal constructor */
	public Userordert(String id, String userOrderId, String locksId,
			String userId, String businessId, int number, int status,
			int businessStatus, int groupLocks) {
		this.id = id;
		this.userOrderId = userOrderId;
		this.locksId = locksId;
		this.userId = userId;
		this.businessId = businessId;
		this.number = number;
		this.status = status;
		this.businessStatus = businessStatus;
		this.groupLocks = groupLocks;
	}

	/** full constructor */
	public Userordert(String id, String name, String comment,
			Timestamp createtime, String userOrderId, String locksId,
			String userId, String businessId, int number, int status,
			int businessStatus, int groupLocks) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.userOrderId = userOrderId;
		this.locksId = locksId;
		this.userId = userId;
		this.businessId = businessId;
		this.number = number;
		this.status = status;
		this.businessStatus = businessStatus;
		this.groupLocks = groupLocks;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public String getUserOrderId() {
		return this.userOrderId;
	}

	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}

	public String getLocksId() {
		return this.locksId;
	}

	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGroupLocks() {
		return this.groupLocks;
	}

	public void setGroupLocks(int groupLocks) {
		this.groupLocks = groupLocks;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocksName() {
		return locksName;
	}

	public void setLocksName(String locksName) {
		this.locksName = locksName;
	}

	public String getLocksType() {
		return locksType;
	}

	public void setLocksType(String locksType) {
		this.locksType = locksType;
	}

	public double getGbPrice() {
		return gbPrice;
	}

	public void setGbPrice(double gbPrice) {
		this.gbPrice = gbPrice;
	}

//	public String getConsignee() {
//		return consignee;
//	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

//	public String getConsigneePhone() {
//		return consigneePhone;
//	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

//	public String getDeliveryAddress() {
//		return deliveryAddress;
//	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public int getBusinessStatus() {
		return businessStatus;
	}
	public void setBusinessStatus(int businessStatus) {
		this.businessStatus = businessStatus;
	}
	
}