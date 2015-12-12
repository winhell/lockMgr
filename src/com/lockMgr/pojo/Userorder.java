package com.lockMgr.pojo;

import java.sql.Timestamp;

import com.lockMgr.core.SpringFactory;
import com.lockMgr.core.Utils;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.ILockService;

/**
 * Userorder entity. @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class Userorder extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int privilege;
	private int status;
	private String orderNum;
	private String userId;
	private String consignee;
	private String consigneePhone;
	private String deliveryAddress;
	private int groupLocks; //是否为团购锁
	private String lockId;
	private Double price;
	
//	private String lockName; //锁名
//	private String lockNumber; //锁数量
//	private String lockType; //锁类型
//	private String image; //锁图片
//	private double unitPrice; //单价
//	private String businessName; //该锁商户名

	
	
	// Constructors

	/** default constructor */
	public Userorder() {
	}

	/** minimal constructor */
	public Userorder(String id, int status, String orderNum, String userId,
			String consigneePhone, String deliveryAddress, int groupLocks,
			String lockId, Double price) {
		this.id = id;
		this.status = status;
		this.orderNum = orderNum;
		this.userId = userId;
		this.consigneePhone = consigneePhone;
		this.deliveryAddress = deliveryAddress;
		this.groupLocks = groupLocks;
		this.lockId = lockId;
		this.price = price;
	}

	/** full constructor */
	public Userorder(String id, String name, String comment, int privilege,
			Timestamp createtime, int status, String orderNum,
			String userId, String consignee, String consigneePhone,
			String deliveryAddress, int groupLocks, String lockId,
			Double price) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.privilege = privilege;
		this.createtime = createtime;
		this.status = status;
		this.orderNum = orderNum;
		this.userId = userId;
		this.consignee = consignee;
		this.consigneePhone = consigneePhone;
		this.deliveryAddress = deliveryAddress;
		this.groupLocks = groupLocks;
		this.lockId = lockId;
		this.price = price;
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

	public int getPrivilege() {
		return this.privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	public Timestamp getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getConsignee() {
		return this.consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getConsigneePhone() {
		return this.consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getDeliveryAddress() {
		return this.deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public int getGroupLocks() {
		return this.groupLocks;
	}

	public void setGroupLocks(int groupLocks) {
		this.groupLocks = groupLocks;
	}

	public String getLockId() {
		return this.lockId;
	}

	public void setLockId(String lockId) {
		this.lockId = lockId;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}