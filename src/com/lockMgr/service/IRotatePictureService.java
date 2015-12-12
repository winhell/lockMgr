package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.RotatePicture;

/**
 * 滚动图片接口
 */

public interface IRotatePictureService extends IBaseDao<RotatePicture> {
	/**
	 * 增加滚动图片
	 */
	public void addRotatePicture(Operator o, String address, int type, String comment);
	
	/**
	 * 分页查询滚动图片
	 */
	@SuppressWarnings("rawtypes")
	public void findRotatePictureByPage(Map m, int page, int pageSize, String path, 
			int[] typeArray, int type);
	
	/**
	 * 分页查询各广告图片(合并在上面方法中)
	 */
	//public void findImgOfAdvertisement(Map m, int page, int pageSize, String path);
	
	/**
	 * 删除滚动图片
	 */
	public void deleteRotatePicture(Operator o, String[] idlist);
	
	/**
	 * 修改滚动图片
	 */
	public void editRotatePicture(Operator o, String id, String address, int type);
	
	/**
	 * 前端查询滚动图片
	 */
	public List<RotatePicture> findRotatePictureToFront(int type);

}
