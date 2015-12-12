package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * ResourceCopy entity. @author MyEclipse Persistence Tools
 */

public class ResourceCopy extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String comment;
	private Timestamp createtime;
	private Integer status;
	private Integer rank;
	private Integer score;
	private Integer type;
	private String title;
	private String describe;

	// Constructors

	/** default constructor */
	public ResourceCopy() {
	}

	/** minimal constructor */
	public ResourceCopy(String id) {
		this.id = id;
	}

	/** full constructor */
	public ResourceCopy(String id, String name, String comment,
			Timestamp createtime, Integer status, Integer rank, Integer score,
			Integer type, String title, String describe) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.rank = rank;
		this.score = score;
		this.type = type;
		this.title = title;
		this.describe = describe;
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

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescribe() {
		return this.describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

}