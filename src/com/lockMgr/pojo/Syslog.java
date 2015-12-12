package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Syslog entity. @author MyEclipse Persistence Tools
 */

public class Syslog extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String userId;

	// Constructors

	/** default constructor */
	public Syslog() {
	}

	/** minimal constructor */
	public Syslog(String id) {
		this.id = id;
	}

	/** full constructor */
	public Syslog(String id, String name, String comment, Timestamp createtime,
			String userId) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.userId = userId;
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

}