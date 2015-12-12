package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * GroupbuyLocks entity. @author MyEclipse Persistence Tools
 */

public class GroupbuyLocks extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String locksId;
	private String businessId;
	private String type;
	private String origin;
	private Double gbprice;
	private String image;
	private int sales;
	
	private String locksName;
	private String businessName;
	private double price; //为locks表中的price
	private double oprice; //团购中的原价(也为locks表中的oprice)

	// Constructors

	/** default constructor */
	public GroupbuyLocks() {
	}

	/** minimal constructor */
	public GroupbuyLocks(String id, String locksId) {
		this.id = id;
		this.locksId = locksId;
	}

	/** full constructor */
	public GroupbuyLocks(String id, String name, String comment,
			Timestamp createtime, int status, String locksId,
			String businessId, String type, String origin, Double gbprice,
			String image, int sales) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.locksId = locksId;
		this.businessId = businessId;
		this.type = type;
		this.origin = origin;
		this.gbprice = gbprice;
		this.image = image;
		this.sales = sales;
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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getLocksId() {
		return this.locksId;
	}

	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}

	public String getBusinessId() {
		return this.businessId;
	}

	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOrigin() {
		return this.origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public Double getGbprice() {
		return this.gbprice;
	}

	public void setGbprice(Double gbprice) {
		this.gbprice = gbprice;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getLocksName() {
		return locksName;
	}

	public void setLocksName(String locksName) {
		this.locksName = locksName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getOprice() {
		return oprice;
	}

	public void setOprice(double oprice) {
		this.oprice = oprice;
	}


}