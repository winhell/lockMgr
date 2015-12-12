package com.lockMgr.pojo;

import java.sql.Timestamp;

import com.lockMgr.service.BusinessService;
import com.lockMgr.service.IBusinessService;

/**
 * Locks entity. @author MyEclipse Persistence Tools
 */

public class Locks extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String businessId;
	private String type;
	private double price;
	private double oprice;
	private String image;
	private String origin;
	private int sales;
	private int rating;
	private int rank;
	private int status;
	
	private String businessName;
	private int number;
	// Constructors

	/** default constructor */
	public Locks() {
	}

	/** minimal constructor */
	public Locks(String id) {
		this.id = id;
	}

	/** full constructor */
	public Locks(String id, String businessId, String name, String comment,
			Timestamp createtime, String type, double price, double oprice,
			String image, String origin, int sales, int rating,
			int rank, int status,String businessName) {
		this.id = id;
		this.businessId = businessId;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.type = type;
		this.price = price;
		this.oprice = oprice;
		this.image = image;
		this.origin = origin;
		this.sales = sales;
		this.rating = rating;
		this.rank = rank;
		this.status = status;
		this.businessName =businessName;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBusinessId() {
		return this.businessId;
	}
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
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
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOprice() {
		return this.oprice;
	}
	public void setOprice(double oprice) {
		this.oprice = oprice;
	}
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getOrigin() {
		return this.origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getSales() {
		return this.sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getRating() {
		return this.rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getRank() {
		return this.rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getStatus() {
		return this.status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getBusinessName() {
		//TODO
//		IBusinessService b = new BusinessService();
//		businessName = b.findNameById(businessId);
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	
}