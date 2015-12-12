package com.lockMgr.pojo;

import java.util.Date;

public class Newslocks {
	private String id;
	private String title; //论坛主题
	private String userName; //发帖人用户名
	private String image; //发帖人头像
	private int viewCount; //浏览总次数
	private int reviewCount; //评论总条数
	private String simpleContent;  //简单内容,论坛列表用到
	/*
	 * 以下是电脑版网页端需求所加字段
	 */
	private String createtime;
	private String content;  //论坛帖内容预览(指定长度)
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSimpleContent() {
		return simpleContent;
	}
	public void setSimpleContent(String simpleContent) {
		this.simpleContent = simpleContent;
	}

}
