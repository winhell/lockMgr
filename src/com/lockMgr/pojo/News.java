package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String userId;
	private int type;
	//private String userName;
	private int viewCount;
	private int reviewCount;
	private String title;
	private String content;
	private String userName;
	private String typeName;
	private String simpleContent;  //简单内容,用于论坛列表预览
	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String id) {
		this.id = id;
	}

	/** full constructor */
	public News(String id, String name, String comment, Timestamp createtime,
			int status, String userId, int type, String title,
			String content, String userName, int viewCount,
			int reviewCount) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.userId = userId;
		this.type = type;
		this.title = title;
		this.content = content;
		this.userName = userName;
		this.viewCount = viewCount;
		this.reviewCount = reviewCount;
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

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getReviewCount() {
		return this.reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSimpleContent() {
		return simpleContent;
	}

	public void setSimpleContent(String simpleContent) {
		this.simpleContent = simpleContent;
	}

}