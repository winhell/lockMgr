package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Collect entity. @author MyEclipse Persistence Tools
 */

public class Collect extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String userId;
	private String newsId;
	//title userName image viewCount reviewCount
	private String title;
	private String userName;
	private String image;
	private int viewCount;
	private int reviewCount;

	// Constructors

	/** default constructor */
	public Collect() {
	}

	/** minimal constructor */
	public Collect(String id) {
		this.id = id;
	}

	/** full constructor */
	public Collect(String id, String name, String comment,
			Timestamp createtime, int status, String userId, String newsId) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.userId = userId;
		this.newsId = newsId;
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
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	

}