package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * CarLogo entity. @author MyEclipse Persistence Tools
 */

public class CarLogo extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String carName;
	private String carCountry;
	private String logo;
	private String logoImage;

	// Constructors

	/** default constructor */
	public CarLogo() {
	}

	/** minimal constructor */
	public CarLogo(String id, int status, String carName,
			String carCountry, String logoImage) {
		this.id = id;
		this.status = status;
		this.carName = carName;
		this.carCountry = carCountry;
		this.logoImage = logoImage;
	}

	/** full constructor */
	public CarLogo(String id, String name, String comment,
			Timestamp createtime, int status, String carName,
			String carCountry, String logo, String logoImage) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.carName = carName;
		this.carCountry = carCountry;
		this.logo = logo;
		this.logoImage = logoImage;
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

	public String getCarName() {
		return this.carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarCountry() {
		return this.carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogoImage() {
		return this.logoImage;
	}

	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
	}

}