package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.CarLogo;

public interface ICarLogoService extends IBaseDao<CarLogo> {
	
	/**
	 * 根据资源类型和车系查询该车系下车型所有商标
	 */
	public List<CarLogo> findImageByCountryAndResource(String resourceType, String dataType, String carCountry);

}
