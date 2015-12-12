package com.lockMgr.pojo;

/**
 * 首页实体类
 */

public class Busilocks extends BasePojo{
	private String locksId;
	private String busiaddr;
	private String busiName;
	private String locksName;
	private double price;
	private double oprice;
	private String image;
	private int sales;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOprice() {
		return oprice;
	}
	public void setOprice(double oprice) {
		this.oprice = oprice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public String getBusiaddr() {
		return busiaddr;
	}
	public void setBusiaddr(String busiaddr) {
		this.busiaddr = busiaddr;
	}
	public String getBusiName() {
		return busiName;
	}
	public void setBusiName(String busiName) {
		this.busiName = busiName;
	}
	public String getLocksName() {
		return locksName;
	}
	public void setLocksName(String locksName) {
		this.locksName = locksName;
	}
	public String getLocksId() {
		return locksId;
	}
	public void setLocksId(String locksId) {
		this.locksId = locksId;
	}
	
}
