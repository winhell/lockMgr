package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;


import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.CarLogo;

@SuppressWarnings("unchecked")
public class CarLogoService extends BaseDao<CarLogo> implements ICarLogoService {
	
	private IResourceService resourceService;
	
	/**
	 * 根据资源类型和车系查询该车系下车型所有商标
	 */
	public List<CarLogo> findImageByCountryAndResource(String resourceType, String dataType, String carCountry) {
		List<CarLogo> carLogoList = new ArrayList<CarLogo>();
		List<String> carNameList = new ArrayList<String>();
		if(carCountry != null && carCountry.length() != 0) {
			if(dataType != null && dataType.length() != 0) {
				String hql = " select distinct carName from Resource where resourceType=? and dataType=? and carCountry=? ";
				carNameList = resourceService.publicFind(hql, new Object[]{resourceType, dataType, carCountry});
			} else {
				String hql = " select distinct carName from Resource where resourceType=? and carCountry=? ";
				carNameList = resourceService.publicFind(hql, new Object[]{resourceType, carCountry});
			}
		} else {
			if(dataType != null && dataType.length() != 0) {
				String hql = " select distinct carName from Resource where resourceType=? and dataType=? ";
				carNameList = resourceService.publicFind(hql, new Object[]{resourceType, dataType});
			} else {
				String hql = " select distinct carName from Resource where resourceType=? ";
				carNameList = resourceService.publicFind(hql, new Object[]{resourceType});
			}
		}
		String hql1 = " from CarLogo where carName=? ";
		if(carNameList != null && carNameList.size() != 0) {
			for(String carName : carNameList) {
				List<CarLogo> cl = new ArrayList<CarLogo>();
				cl = find(hql1, new Object[]{carName});
				if(cl != null && cl.size() != 0) 
					carLogoList.add(cl.get(0));
			}
		}
		return carLogoList;
	}

	public IResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}
	

}
