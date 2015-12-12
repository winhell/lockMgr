package com.lockMgr.pojo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String account;
	private String password;
	private String userRoleId;
	private int status;
	private String image;
	private boolean gender;
	private Date birthday;
	private String email;
	private String phone;
	private long coins;
	private String userRoleName;
	private Timestamp coinsTime; //打卡时间
	
	private Timestamp vipTime;  //会员开通时间
	private String address;  //地址(是商户就显示商户地址,否则是同行就显示同行地址,否则不显示)
	private String genderName;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String id) {
		this.id = id;
	}

	/** full constructor */
	public User(String id, String name, String comment, Timestamp createtime,
			String account, String password, String userRoleId, int status,
			String image, boolean gender, Date birthday, String email,
			String phone, long coins, Timestamp coinsTime) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.account = account;
		this.password = password;
		this.userRoleId = userRoleId;
		this.status = status;
		this.image = image;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.phone = phone;
		this.coins = coins;
		this.coinsTime = coinsTime;
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

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserRoleId() {
		return this.userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
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

	public boolean getGender() {
		return this.gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getCoins() {
		return this.coins;
	}

	public void setCoins(long coins) {
		this.coins = coins;
	}

	public String getUserRoleName() {
		return userRoleName;
	}

	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}

	public Timestamp getCoinsTime() {
		return coinsTime;
	}

	public void setCoinsTime(Timestamp coinsTime) {
		this.coinsTime = coinsTime;
	}

	public Timestamp getVipTime() {
		return vipTime;
	}

	public void setVipTime(Timestamp vipTime) {
		this.vipTime = vipTime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}