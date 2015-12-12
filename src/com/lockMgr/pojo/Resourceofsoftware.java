package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Resourceofsoftware entity. @author MyEclipse Persistence Tools
 */

public class Resourceofsoftware extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private int rank;
	private int score;
	private String title;
	private String resDescribe;
	private String address;
	private String uploaderName;
	private int downloadNum;
	private String resourceAndDataType; //新加字段(软件下载资源)

	// Constructors

	/** default constructor */
	public Resourceofsoftware() {
	}

	/** minimal constructor */
	public Resourceofsoftware(String id) {
		this.id = id;
	}

	/** full constructor */
	public Resourceofsoftware(String id, String name, String comment,
			Timestamp createtime, int status, int rank, int score,
			String title, String resDescribe, String address,
			String uploaderName, int downloadNum) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.rank = rank;
		this.score = score;
		this.title = title;
		this.resDescribe = resDescribe;
		this.address = address;
		this.uploaderName = uploaderName;
		this.downloadNum = downloadNum;
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

	public int getRank() {
		return this.rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResDescribe() {
		return this.resDescribe;
	}

	public void setResDescribe(String resDescribe) {
		this.resDescribe = resDescribe;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUploaderName() {
		return this.uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public int getDownloadNum() {
		return this.downloadNum;
	}

	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getResourceAndDataType() {
		return resourceAndDataType;
	}

	public void setResourceAndDataType(String resourceAndDataType) {
		this.resourceAndDataType = resourceAndDataType;
	}

}