package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * 用于论坛帖数据回显的javabean
 * @author lzc
 *
 */
public class NewsEcho {
	private String NewsId;
	private String NewsName;
	private String NewsComment;
	private Timestamp NewsCreatetime;
	private int NewsStatus;
	private String userId;
	private String userName;
	private int viewCount;
	private int reviewCount;
	private int type;
	private String title;
	private String NewsContent;
	
	private String reviewId;
	private String reviewName;
	private String reviewComment;
	private Timestamp reviewCreatetime;
	private int reviewStatus;
	private int order;
	private String reviewContent;
	
	
	public String getNewsId() {
		return NewsId;
	}
	public void setNewsId(String newsId) {
		NewsId = newsId;
	}
	public String getNewsName() {
		return NewsName;
	}
	public void setNewsName(String newsName) {
		NewsName = newsName;
	}
	public String getNewsComment() {
		return NewsComment;
	}
	public void setNewsComment(String newsComment) {
		NewsComment = newsComment;
	}
	public Timestamp getNewsCreatetime() {
		return NewsCreatetime;
	}
	public void setNewsCreatetime(Timestamp newsCreatetime) {
		NewsCreatetime = newsCreatetime;
	}
	public int getNewsStatus() {
		return NewsStatus;
	}
	public void setNewsStatus(int newsStatus) {
		NewsStatus = newsStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getNewsContent() {
		return NewsContent;
	}
	public void setNewsContent(String newsContent) {
		NewsContent = newsContent;
	}
	public String getReviewId() {
		return reviewId;
	}
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	public String getReviewName() {
		return reviewName;
	}
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public Timestamp getReviewCreatetime() {
		return reviewCreatetime;
	}
	public void setReviewCreatetime(Timestamp reviewCreatetime) {
		this.reviewCreatetime = reviewCreatetime;
	}
	public int getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	
	
	
	

}
