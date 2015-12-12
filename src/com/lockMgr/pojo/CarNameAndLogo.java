package com.lockMgr.pojo;

import java.io.Serializable;

public class CarNameAndLogo implements Serializable {
	private String carName;
	private String  carLogo;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarLogo() {
		return carLogo;
	}
	public void setCarLogo(String carLogo) {
		this.carLogo = carLogo;
	}
	

}
