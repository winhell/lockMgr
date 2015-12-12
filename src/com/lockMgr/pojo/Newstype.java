package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Newstype entity. @author MyEclipse Persistence Tools
 */

public class Newstype extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int type;
	private int status;

	// Constructors

	/** default constructor */
	public Newstype() {
	}

	/** minimal constructor */
	public Newstype(String id) {
		this.id = id;
	}

	/** full constructor */
	public Newstype(String id, String name, String comment,
			Timestamp createtime, int type, int status) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.type = type;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}