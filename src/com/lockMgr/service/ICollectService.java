package com.lockMgr.service;

import java.util.List;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Collect;
import com.lockMgr.pojo.Newslocks;

/**
 * 收藏类接口
 * @author lzc
 *
 */
public interface ICollectService extends IBaseDao<Collect> {
	
	/**
	 * 根据用户id查询是否是否收藏过该论坛帖
	 */
	public boolean checkingCollectByUser(String userId, String newsId);
	
	/**
	 * 根据用户id查询该用户收藏帖(状态为1的)
	 */
	public List<Collect> findCollectByUser(int page, int pageSize, String userId);
	
	/**
	 * 根据收藏表中newsId查询该帖5个主要信息(在findCollectByUser方法后调用)
	 */
	public List<Newslocks> findNewsById(String newsid, String userid);

}
