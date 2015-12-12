package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Resource entity. @author MyEclipse Persistence Tools
 */

public class Resource extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private int rank;
	private int score;
	private int type;
	private String title;
	private String resDescribe;
	private String address;
	private String uploaderName;
	private int downloadNum;
	private String carName;
	private String carType;
	private String carCountry;
	private String resourceType;
	private String dataType;
    private String resourceAndDataType;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(String id, String carName, String resourceType) {
		this.id = id;
		this.carName = carName;
		this.resourceType = resourceType;
	}

	/** full constructor */
	public Resource(String id, String name, String comment,
			Timestamp createtime, int status, int rank, int score,
			int type, String title, String resDescribe, String address,
			String uploaderName, int downloadNum, String carName,
			String carType, String carCountry, String resourceType, String dataType) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.rank = rank;
		this.score = score;
		this.type = type;
		this.title = title;
		this.resDescribe = resDescribe;
		this.address = address;
		this.uploaderName = uploaderName;
		this.downloadNum = downloadNum;
		this.carName = carName;
		this.carType = carType;
		this.carCountry = carCountry;
		this.resourceType = resourceType;
		this.dataType = dataType;
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
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
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

	public String getResDescribe() {
		return resDescribe;
	}

	public void setResDescribe(String resDescribe) {
		this.resDescribe = resDescribe;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUploaderName() {
		return uploaderName;
	}

	public void setUploaderName(String uploaderName) {
		this.uploaderName = uploaderName;
	}

	public int getDownloadNum() {
		return downloadNum;
	}

	public void setDownloadNum(int downloadNum) {
		this.downloadNum = downloadNum;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarCountry() {
		return carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

    public String getResourceAndDataType() {
        return resourceAndDataType;
    }

    public void setResourceAndDataType(String resourceAndDataType) {
        this.resourceAndDataType = resourceAndDataType;
    }
}