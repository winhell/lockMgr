package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * RotatePicture entity. @author MyEclipse Persistence Tools
 */

public class RotatePicture extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int type;    //1首页图片，2论坛图片
	private int status;  //0不可用，1可用
	private String address;
	
	private String typeName;  //类型名称(1首页图片，2论坛图片)
	

	// Constructors

	/** default constructor */
	public RotatePicture() {
	}

	/** minimal constructor */
	public RotatePicture(String id, int type, int status, String address) {
		this.id = id;
		this.type = type;
		this.status = status;
		this.address = address;
	}

	/** full constructor */
	public RotatePicture(String id, String name, String comment,
			Timestamp createtime, int type, int status, String address) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.type = type;
		this.status = status;
		this.address = address;
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
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}