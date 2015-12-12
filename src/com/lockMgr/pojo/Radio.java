package com.lockMgr.pojo;

import java.sql.Timestamp;

/**
 * Radio entity. @author MyEclipse Persistence Tools
 */

public class Radio extends com.lockMgr.pojo.BasePojo implements
		java.io.Serializable {

	// Fields

	private String word;

	// Constructors

	/** default constructor */
	public Radio() {
	}

	/** minimal constructor */
	public Radio(String id, String word) {
		this.id = id;
		this.word = word;
	}

	/** full constructor */
	public Radio(String id, String name, String comment, Timestamp createtime,
			String word) {
		this.id = id;
		this.name = name;
		this.comment = comment;
		this.createtime = createtime;
		this.word = word;
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

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}