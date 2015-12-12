package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Withdraw entity. @author MyEclipse Persistence Tools
 */

public class Withdraw extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private Timestamp applyTime;  //商户申请提现日期
	private Timestamp operationTime;  //管理员操作日期
	private String businessId;
	private Double amount;  //商户申请提现金额
	private String alipayAccount;  //申请支付宝银行账户
	private String accountName;  //申请商户账户户名
	private int status;  ////提现状态(1,未审核;2,审核通过;-1,审核拒绝)
	
	private String businessName;
	// Constructors

	/** default constructor */
	public Withdraw() {
	}

	/** minimal constructor */
	public Withdraw(String id, Timestamp applyTime, String businessId,
			Double amount, String alipayAccount, String accountName,
			Integer status) {
		this.id = id;
		this.applyTime = applyTime;
		this.businessId = businessId;
		this.amount = amount;
		this.alipayAccount = alipayAccount;
		this.accountName = accountName;
		this.status = status;
	}

	/** full constructor */
	public Withdraw(String id, String name, String comment,
			Timestamp createtime, Timestamp applyTime, Timestamp operationTime,
			String businessId, Double amount, String alipayAccount,
			String accountName, Integer status) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.applyTime = applyTime;
		this.operationTime = operationTime;
		this.businessId = businessId;
		this.amount = amount;
		this.alipayAccount = alipayAccount;
		this.accountName = accountName;
		this.status = status;
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

	public Timestamp getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}

	public Timestamp getOperationTime() {
		return this.operationTime;
	}

	public void setOperationTime(Timestamp operationTime) {
		this.operationTime = operationTime;
	}

	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getAlipayAccount() {
		return this.alipayAccount;
	}

	public void setAlipayAccount(String alipayAccount) {
		this.alipayAccount = alipayAccount;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}