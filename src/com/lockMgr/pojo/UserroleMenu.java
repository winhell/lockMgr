package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * UserroleMenu entity. @author MyEclipse Persistence Tools
 */

public class UserroleMenu extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private int status;
	private String roleId;
	private String menuId;

	// Constructors

	/** default constructor */
	public UserroleMenu() {
	}

	/** minimal constructor */
	public UserroleMenu(String id, String roleId, String menuId) {
		this.id = id;
		this.roleId = roleId;
		this.menuId = menuId;
	}

	/** full constructor */
	public UserroleMenu(String id, String name, String comment,
			Timestamp createtime, int status, String roleId, String menuId) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.status = status;
		this.roleId = roleId;
		this.menuId = menuId;
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

	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return this.menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

}