package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Radio;

public interface IRadioService extends IBaseDao<Radio> {
	/**
	 * 添加一条广播
	 */
	public void addRadio(String word);
	
	/**
	 * 删除一条广播
	 */
	public void deleteRadio(String[] idlist);
	
	/**
	 * 分页查询广播列表
	 */
	@SuppressWarnings("rawtypes")
	public void findRadioByPage(Map m, int page, int pageSize);
	
	/**
	 * 查询全部广播
	 */
	public List<Radio> findAllRadio();

}
