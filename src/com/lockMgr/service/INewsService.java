package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.News;

/**
 * 论坛模块接口
 */
public interface INewsService extends IBaseDao<News> {
	
	/**
	 * 板块
	 */
	@SuppressWarnings("rawtypes")
	public Map findNewsByType(int page, int pageSize, int type);
	
	/**
	 * 新帖
	 */
	@SuppressWarnings("rawtypes")
	public Map findNewsByTime(int page, int pageSize);
	
	/**
	 * 阅读历史
	 */
	@SuppressWarnings("rawtypes")
	public Map findNewsByHistory(int page, int pageSize, String userId);
	
	/**
	 * 我的发布(根据用户id查询该用户曾经发布的论坛帖)
	 */
	@SuppressWarnings("rawtypes")
	public Map findNewsByUser(int page, int pageSize, String userId);
	
	/**
	 * 根据论坛帖id查询论坛帖
	 */
	public List<News> findNewsById(String newsId);
	
	/**
	 * 保存浏览历史
	 */
	
	/**
	 * 增加一次浏览次数
	 */
	public String addViewcount(String newsId);
	
	/**
	 * 保存评论
	 */
	
	/**
	 * 增加一次评论次数
	 */
	public String addReviewcount(String newsId);
	
	/**
	 * 电脑端发帖
	 */
	public void saveNewsByComputer(String userId, String title, String content, int type);
	
//	/**
//	 * 浏览
//	 */
//	public List<NewsEcho> view(String newsId, Viewhistory vh);
	
//	/**
//	 * 评论
//	 */
//	public List<Review> review(String newsId, Review rv);

}
