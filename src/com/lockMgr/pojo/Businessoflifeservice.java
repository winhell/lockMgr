package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Businessoflifeservice entity. @author MyEclipse Persistence Tools
 */

public class Businessoflifeservice extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String userId;
	private Integer type;
	private String company;
	private Integer phone;
	private String address;
	private String description;

	// Constructors

	/** default constructor */
	public Businessoflifeservice() {
	}

	/** minimal constructor */
	public Businessoflifeservice(String id, String userId, Integer type,
			String company, Integer phone, String address, String description) {
		this.id = id;
		this.userId = userId;
		this.type = type;
		this.company = company;
		this.phone = phone;
		this.address = address;
		this.description = description;
	}

	/** full constructor */
	public Businessoflifeservice(String id, String name, String comment,
			Timestamp createtime, String userId, Integer type, String company,
			Integer phone, String address, String description) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.userId = userId;
		this.type = type;
		this.company = company;
		this.phone = phone;
		this.address = address;
		this.description = description;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}