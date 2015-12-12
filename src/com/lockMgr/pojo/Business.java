package com.lockMgr.pojo;

import java.sql.Timestamp;

import com.lockMgr.core.SpringFactory;
import com.lockMgr.service.IUserService;

/**
 * Business entity. @author MyEclipse Persistence Tools
 */

public class Business extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int verify;
	private String company;
	private String realName;
	private String address;
	private String tel;
	private Double pointX;
	private Double pointY;
	private int status;
	private String image;
	private String userId;
	private int rating;
	private int type;
	
	private double distance;
	private String userRoleName;  //userrole表用户角色名

	//得到商户user表的用户名
	public String getAccount() {
		String account = null;
		if(userId != null && userId.length() != 0) {
			IUserService userService = (IUserService) SpringFactory.getBean("userService");
			User user = userService.findById(userId);
			if(user != null)
				account = user.getAccount();
		}
		return account;
	}
	
	// Constructors

	/** default constructor */
	public Business() {
	}

	/** minimal constructor */
	public Business(String id, String userId, int type) {
		this.id = id;
		this.userId = userId;
		this.type = type;
	}

	/** full constructor */
	public Business(String id, String name, String comment,
			Timestamp createtime, int verify, String company,
			String realName, String address, String tel, Double pointX,
			Double pointY, int status, String image, String userId,
			int rating, int type) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.verify = verify;
		this.company = company;
		this.realName = realName;
		this.address = address;
		this.tel = tel;
		this.pointX = pointX;
		this.pointY = pointY;
		this.status = status;
		this.image = image;
		this.userId = userId;
		this.rating = rating;
		this.type = type;
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

	public int getVerify() {
		return this.verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Double getPointX() {
		return this.pointX;
	}

	public void setPointX(Double pointX) {
		this.pointX = pointX;
	}

	public Double getPointY() {
		return this.pointY;
	}

	public void setPointY(Double pointY) {
		this.pointY = pointY;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Business other = (Business) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}