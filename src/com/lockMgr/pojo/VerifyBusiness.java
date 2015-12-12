package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * VerifyBusiness entity. @author MyEclipse Persistence Tools
 */

public class VerifyBusiness extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private Integer verify;
	private String userId;
	private String phone;
	private String idCard;
	private String imageBusinessLicense;
	private String imagePoliceProve;
	private String content;
	private String imageIdCard;
	private String companyName;
	private String companyAddress;
	
	private String verifyName;

	// Constructors

	/** default constructor */
	public VerifyBusiness() {
	}

	/** minimal constructor */
	public VerifyBusiness(String id, Integer verify, String userId,
			String phone, String idCard, String imageBusinessLicense,
			String imagePoliceProve) {
		this.id = id;
		this.verify = verify;
		this.userId = userId;
		this.phone = phone;
		this.idCard = idCard;
		this.imageBusinessLicense = imageBusinessLicense;
		this.imagePoliceProve = imagePoliceProve;
	}

	/** full constructor */
	public VerifyBusiness(String id, String name, String comment,
			Timestamp createtime, Integer verify, String userId, String phone,
			String idCard, String imageBusinessLicense,
			String imagePoliceProve, String content, String imageIdCard,
			String companyName, String companyAddress) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.verify = verify;
		this.userId = userId;
		this.phone = phone;
		this.idCard = idCard;
		this.imageBusinessLicense = imageBusinessLicense;
		this.imagePoliceProve = imagePoliceProve;
		this.content = content;
		this.imageIdCard = imageIdCard;
		this.companyName = companyName;
		this.companyAddress = companyAddress;
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

	public Integer getVerify() {
		return this.verify;
	}

	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getImageBusinessLicense() {
		return this.imageBusinessLicense;
	}

	public void setImageBusinessLicense(String imageBusinessLicense) {
		this.imageBusinessLicense = imageBusinessLicense;
	}

	public String getImagePoliceProve() {
		return this.imagePoliceProve;
	}

	public void setImagePoliceProve(String imagePoliceProve) {
		this.imagePoliceProve = imagePoliceProve;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageIdCard() {
		return this.imageIdCard;
	}

	public void setImageIdCard(String imageIdCard) {
		this.imageIdCard = imageIdCard;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getVerifyName() {
		if(verify == 0)
			verifyName = "未审核";
		if(verify == 1) 
			verifyName = "审核通过";
		if(verify == 2)
			verifyName = "拒绝审核";
		return verifyName;
	}

	public void setVerifyName(String verifyName) {
		this.verifyName = verifyName;
	}
	
	

}