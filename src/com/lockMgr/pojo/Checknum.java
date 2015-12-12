package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Checknum entity. @author MyEclipse Persistence Tools
 */

public class Checknum extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private Timestamp endtime;  //失效时间
	private String userId;
	private int checkNum;

	// Constructors

	/** default constructor */
	public Checknum() {
	}

	/** minimal constructor */
	public Checknum(String id, Timestamp createtime, Timestamp endtime,
			String userId, int checkNum) {
		this.id = id;
		this.createtime = createtime;
		this.endtime = endtime;
		this.userId = userId;
		this.checkNum = checkNum;
	}

	/** full constructor */
	public Checknum(String id, String name, String comment,
			Timestamp createtime, Timestamp endtime, String userId,
			int checkNum) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.endtime = endtime;
		this.userId = userId;
		this.checkNum = checkNum;
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

	public int getCheckNum() {
		return this.checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

}