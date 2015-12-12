package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Review entity. @author MyEclipse Persistence Tools
 */

public class Review extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String newsId;
	private String userId;
	private int showOrder;
	private String content;
	private String userName;
    
	// Constructors

	/** default constructor */
	public Review() {
	}

	/** minimal constructor */
	public Review(String id) {
		this.id = id;
	}

	/** full constructor */
	public Review(String id, String name, String comment, Timestamp createtime,
			int status, String newsId, String userId, int showOrder,
			String content,String userName) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.newsId = newsId;
		this.userId = userId;
		this.showOrder = showOrder;
		this.content = content;
		this.userName =userName;
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

	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getShowOrder() {
		return this.showOrder;
	}
	public void setShowOrder(int showOrder)
	{
		this.showOrder = showOrder;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}