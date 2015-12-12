package com.lockMgr.pojo;

public class Baseforum extends BasePojo{
	private String title;
	private String uname;
	private String image;
	private long his;
	private long review;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public long getHis() {
		return his;
	}
	public void setHis(long his) {
		this.his = his;
	}
	public long getReview() {
		return review;
	}
	public void setReview(long review) {
		this.review = review;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
}
