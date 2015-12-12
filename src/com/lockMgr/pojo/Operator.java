package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Operator entity. @author MyEclipse Persistence Tools
 */

public class Operator extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String comment;
	private Timestamp createtime;
	private String account;
	private String password;
	private String roleId;
	private int status;
	private String roleName;

	// Constructors

	/** default constructor */
	public Operator() {
	}

	/** minimal constructor */
	public Operator(String id) {
		this.id = id;
	}

	/** full constructor */
	public Operator(String id, String name, String comment,
			Timestamp createtime, String account, String password,
			String roleId, int status,String roleName) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.account = account;
		this.password = password;
		this.roleId = roleId;
		this.status = status;
		this.roleName =roleName;
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}