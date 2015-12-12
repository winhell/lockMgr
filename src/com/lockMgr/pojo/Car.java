package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Car entity. @author MyEclipse Persistence Tools
 */

public class Car extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	
	private int status;
	private String carName;
	private String carType;
	private String carLogo;
	private String image;
	private String carCountry;

	// Constructors

	/** default constructor */
	public Car() {
	}

	/** minimal constructor */
	public Car(String id, String carName) {
		this.id = id;
		this.carName = carName;
	}

	/** full constructor */
	public Car(String id, String name, String comment, Timestamp createtime,
			int status, String carName, String carType, String carLogo,
			String image, String carCountry) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.carName = carName;
		this.carType = carType;
		this.carLogo = carLogo;
		this.image = image;
		this.carCountry = carCountry;
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

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCarName() {
		return this.carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return this.carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCarLogo() {
		return this.carLogo;
	}

	public void setCarLogo(String carLogo) {
		this.carLogo = carLogo;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCarCountry() {
		return this.carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

}