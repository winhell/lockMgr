package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Viewhistory entity. @author MyEclipse Persistence Tools
 */

public class Viewhistory extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String userId;
	private String newsId;
	private Timestamp viewTime;

	// Constructors

	/** default constructor */
	public Viewhistory() {
	}

	/** minimal constructor */
	public Viewhistory(String id) {
		this.id = id;
	}

	/** full constructor */
	public Viewhistory(String id, String name, String comment,
			Timestamp createtime, int status, String userId, String newsId,
			Timestamp viewTime) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.userId = userId;
		this.newsId = newsId;
		this.viewTime = viewTime;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public Timestamp getViewTime() {
		return this.viewTime;
	}

	public void setViewTime(Timestamp viewTime) {
		this.viewTime = viewTime;
	}

}