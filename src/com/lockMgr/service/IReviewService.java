package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Review;

public interface IReviewService extends IBaseDao<Review> {
	
	/**
	 * 根据论坛帖id查询评论(一张贴对应多条评论记录)
	 */
	public List<Review> findReviewByNewsId(int page, int pageSize, String newsId);
	
	/**
	 * 查询评论总页数
	 */
	public int findReviewTotalPage(String newsId);

	public void txDel(Operator operator, String[] idlist);
	public void getReviewByPage(Map map, final int page, final int pageSize,String newsId,String orderType, String sortAttr);
}
