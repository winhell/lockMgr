package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Review;

public class ReviewService extends BaseDao<Review> implements IReviewService {
	
	private int reviewPageSize = 10;  //电脑端每页显示评论数(仅限本类中方法使用,不需要get(),set()方法)

	/**
	 * 根据论坛帖id查询评论(一张贴对应多条评论记录)
	 */
	public List<Review> findReviewByNewsId(int page, int pageSize, String newsId) {
		String hql = " from Review where newsId=? order by createtime ";
		List<Review> l = new ArrayList<Review>();
		if(page==0 && pageSize==0) {
			l = findByPage(hql, new Object[]{newsId}, 0, 20);
		} else {
			l = findByPage(hql, new Object[]{newsId}, (page-1)*pageSize, pageSize);
		}
		//如果有图片修改显示地址
		for(int i=0; i<l.size(); i++) {
			if(l.get(i).getComment() != null && l.get(i).getComment().length() != 0)
				l.get(i).setComment(Utils.getimagepath() + l.get(i).getComment());
		}
		return l;
	}
	
	/**
	 * 查询评论总页数
	 */
	public int findReviewTotalPage(String newsId) {
		return getTotalPage(" select count(*) from Review where newsId='" + newsId + "'", reviewPageSize);
	}
	
	public List<Review> findReviewById(String newsId) {
		String sql = "from Review review where newsId=?";
		Query query = getSession().createQuery(sql);
		query.setParameter(0, newsId);
		List l = query.list();
		List<Review> reviewList = new ArrayList<Review>();
		for(int i=0; i<l.size(); i++) {
			Review r = (Review) l.get(i);
			reviewList.add(r);
		}
		return reviewList;
	}
	
	
	
	@Override
	public void getReviewByPage(Map map, int page, int pageSize,String newsId,String orderType, String sortAttr)
	{

		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = "from Review where 1=1";
		if (null != newsId && newsId.length() != 0)
		{
			hql += " and newsId =?";
			al.add(newsId);
			paramNums++;
		}
		if (orderType != null && sortAttr != null)
		{
			hql += " order by " + sortAttr + " " + orderType;
		}
		else
		{
			hql += "  ORDER BY createtime desc";
		}

		Object[] values = al.toArray(new Object[paramNums]);

		fillPagetoMap(map, hql, values, page, pageSize);

	}
	@Override
	public void txDel(Operator operator, String[] idlist) {
		Review news = null;
		for (String id : idlist) {
			news = this.findById(id);
			delete(news);
			writeLog(operator, "删除", "回帖", news);
		}
	}
	
	
	public static void main(String[] args) {
		ReviewService r = new ReviewService();
		System.out.println(r.findReviewById("31ad0d72-da34-4a03-8212-da4e13ca48f2"));
	}
	
	

}
