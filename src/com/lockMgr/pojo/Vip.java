package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Vip entity. @author MyEclipse Persistence Tools
 */

public class Vip extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private Timestamp endtime;
	private String userId;
	private Integer status;

	// Constructors

	/** default constructor */
	public Vip() {
	}

	/** minimal constructor */
	public Vip(String id, Timestamp createtime, Timestamp endtime,
			String userId, Integer status) {
		this.id = id;
		this.createtime = createtime;
		this.endtime = endtime;
		this.userId = userId;
		this.status = status;
	}

	/** full constructor */
	public Vip(String id, String name, String comment, Timestamp createtime,
			Timestamp endtime, String userId, Integer status) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.endtime = endtime;
		this.userId = userId;
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

	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}