package com.lockMgr.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.HtmlUtil;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.News;
import com.lockMgr.pojo.Newslocks;
import com.lockMgr.pojo.Viewhistory;

@SuppressWarnings("unchecked")
public class NewsService extends BaseDao<News> implements INewsService {
	
	private IUserService userService;
	
	private Viewhistory viewhistory;

	/**
	 * 板块
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Map findNewsByType(int page, int pageSize, int type) {
//		String sql =" select n.id,n.title,u.account,u.image,count(hst.id),count(re.id) from news n,user u,viewhistory hst,review re " +
//				" where n.type="+type+" and n.userId =u.id and hst.newsId=n.id and n.id=re.newsId group by hst.newsId,re.newsId order by n.createtime desc";
//		String sql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount from news n,user u " +
//				" where n.userId=u.id and n.type=? order by n.createtime desc ";
		String findTotalPageHql = " select count(*) from News n,User u " +
				" where n.userId=u.id and n.status=1 and n.type='" + type + "'order by n.createtime desc ";
		//设置总页数
		int totalPage = getTotalPage(findTotalPageHql, pageSize);
		//查询内容
		String hql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount,n.createtime,n.content " +
				" from News n,User u where n.userId=u.id and n.status=1 and n.type=? order by n.createtime desc ";
		List l = new ArrayList<Newslocks>();
		if(page==0 && pageSize==0) {
			l = findByPage(hql, new Object[]{type}, 0, 20);
		} else {
			l = findByPage(hql, new Object[]{type}, (page-1)*pageSize, pageSize);
		}
		List<Newslocks> nl = new ArrayList<Newslocks>();
		for(int i=0; i<l.size(); i++) {
			Newslocks n = new Newslocks();
			Object[] obj = (Object[]) l.get(i);
			try{
				n.setId(obj[0].toString());
				n.setTitle(obj[1].toString());
				n.setUserName(obj[2].toString());
				if(obj[3] != null)
					n.setImage(Utils.getimagepath()+obj[3].toString());
				n.setViewCount(Integer.parseInt(obj[4].toString()));
				n.setReviewCount(Integer.parseInt(obj[5].toString()));
				//以下两个字段是网页版电脑端需求所加
				n.setCreatetime(obj[6].toString());
				if(obj[7] != null) {
					/*String content;
					if(obj[7].toString().length() > 130) 
						content = obj[7].toString().substring(0, 129) + "......";
					else
						content = obj[7].toString();
					n.setContent(content);*/
					//代替上面的内容简介
					String simpleContent = HtmlUtil.getTextFromHtml(obj[7].toString());
					if(simpleContent.length() > 130)
						simpleContent = simpleContent.substring(0, 129) + "......";
					n.setSimpleContent(simpleContent);
				}
				nl.add(n);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		Map all = new HashMap();
		all.put("totalPage", totalPage);
		all.put("newsLocksList", nl);
		return all;
	}

	/**
	 * 新帖
	 */
	@SuppressWarnings({ "rawtypes" })
	@Override
	public Map findNewsByTime(int page, int pageSize) {
//		String sql = " select n.id,n.title,u.account,u.image,count(hst.id),count(re.id) from news n,user u,viewhistory hst,review re " +
//				" where n.userId =u.id and hst.newsId=n.id and n.id=re.newsId group by hst.newsId,re.newsId order by n.createtime desc";
//		String sql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount from news n,user u " +
//				" where n.userId=u.id order by n.createtime desc ";
		String findTotalPageHql = " select count(*) " +
				" from News n,User u where n.userId=u.id and n.status=1 order by n.createtime desc ";
		//设置总页数
		int totalPage = getTotalPage(findTotalPageHql, pageSize);
		//查询内容
		String hql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount,n.createtime,n.content " +
				" from News n,User u where n.userId=u.id and n.status=1 order by n.createtime desc ";
		List l = new ArrayList<Newslocks>();
		if(page==0 && pageSize==0) {
			l = findByPage(hql, null, 0, 20);
		} else {
			l = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		List<Newslocks> nl = new ArrayList<Newslocks>();
		for(int i=0; i<l.size(); i++) {
			Newslocks n = new Newslocks();
			Object[] obj = (Object[]) l.get(i);
			try{
				n.setId(obj[0].toString());
				n.setTitle(obj[1].toString());
				n.setUserName(obj[2].toString());
				if(obj[3] != null)
					n.setImage(Utils.getimagepath()+obj[3].toString());
				n.setViewCount(Integer.parseInt(obj[4].toString()));
				n.setReviewCount(Integer.parseInt(obj[5].toString()));
				//以下两个字段是网页版电脑端需求所加
				n.setCreatetime(obj[6].toString());
				if(obj[7] != null) {
					/*String content;
					if(obj[7].toString().length() > 130) 
						content = obj[7].toString().substring(0, 129) + "......";
					else
						content = obj[7].toString();
					n.setContent(content);*/
					//代替上面的内容简介
					String simpleContent = HtmlUtil.getTextFromHtml(obj[7].toString());
					if(simpleContent.length() > 130)
						simpleContent = simpleContent.substring(0, 129) + "......";
					n.setSimpleContent(simpleContent);
				}
				nl.add(n);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		Map all = new HashMap();
		all.put("totalPage", totalPage);
		all.put("newsLocksList", nl);
		return all;
	}

	/**
	 * 阅读历史
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Map findNewsByHistory(int page, int pageSize, String userId) {
//		String sql = " select n.id,n.title,u.account,u.image,count(hst.id),count(re.id) from news n,user u,viewhistory hst,review re " +
//				" where hst.userId="+ userId +" n.userId =u.id and hst.newsId=n.id and n.id=re.newsId group by hst.newsId,re.newsId order by n.createtime desc";
//		String sql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount from news n,user u,viewhistory vh " +
//				" where n.userId=u.id and vh.newsId=n.id and vh.userId=? order by n.createtime desc ";
		String hql = " select distinct n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount,n.createtime,n.content " +
				" from News n,User u,Viewhistory vh " +
				" where n.userId=u.id and vh.newsId=n.id and n.status=1 and vh.userId=? order by n.createtime desc ";
//		List l = findBySQL(sql);
//		Query query = getSession().createSQLQuery(sql);
//		query.setParameter(0, userId);
//		List l = query.list();
		List l = new ArrayList<Newslocks>();
		if(page==0 && pageSize==0) {
			l = findByPage(hql, new Object[]{userId}, 0, 20);
		} else {
			l = findByPage(hql, new Object[]{userId}, (page-1)*pageSize, pageSize);
		}
		List<Newslocks> nl = new ArrayList<Newslocks>();
		for(int i=0; i<l.size(); i++) {
			Newslocks n = new Newslocks();
			Object[] obj = (Object[]) l.get(i);
			try{
				n.setId(obj[0].toString());
				n.setTitle(obj[1].toString());
				n.setUserName(obj[2].toString());
				if(obj[3] != null)
					n.setImage(Utils.getimagepath()+obj[3].toString());
				n.setViewCount(Integer.parseInt(obj[4].toString()));
				n.setReviewCount(Integer.parseInt(obj[5].toString()));
				//以下两个字段是网页版电脑端需求所加
				n.setCreatetime(obj[6].toString());
				if(obj[7] != null) {
					/*String content;
					if(obj[7].toString().length() > 130) 
						content = obj[7].toString().substring(0, 129) + "......";
					else
						content = obj[7].toString();
					n.setContent(content);*/
					//代替上面的内容简介
					String simpleContent = HtmlUtil.getTextFromHtml(obj[7].toString());
					if(simpleContent.length() > 130)
						simpleContent = simpleContent.substring(0, 129) + "......";
					n.setSimpleContent(simpleContent);
				}
				nl.add(n);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		/*
		 * 由于涉及到了"去重",直接对去重后的集合做查询总页数操作
		 */
		List allList = find(hql, new Object[]{userId});
		int totalPage = 0;
		if(allList != null && allList.size() != 0) {
			int rows = allList.size();
			if(rows % pageSize == 0)
				totalPage = (int) (rows / pageSize);
			else 
				totalPage = (int) (rows / pageSize + 1);
		}
		Map all = new HashMap();
		all.put("totalPage", totalPage);
		all.put("newsLocksList", nl);
		return all;
	}

	/**
	 * 我的发布(根据用户id查询该用户曾经发布的论坛帖)
	 */
	@SuppressWarnings("rawtypes")
	public Map findNewsByUser(int page, int pageSize, String userId) {
		String findTotalPageHql = " select count(*) from News n,User u where n.userId=u.id "
				+ " and n.userId='"+ userId +"' and n.status=1 order by n.createtime desc ";
		//设置总页数
		int totalPage = getTotalPage(findTotalPageHql, pageSize);
		String hql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount,n.createtime,n.content " +
				" from News n,User u where n.userId=u.id and n.userId=? and n.status=1 order by n.createtime desc ";
		List l = new ArrayList<Newslocks>();
		if(page==0 && pageSize==0) {
			l = findByPage(hql, new Object[]{userId}, 0, 20);
		} else {
			l = findByPage(hql, new Object[]{userId}, (page-1)*pageSize, pageSize);
		}
		List<Newslocks> nl = new ArrayList<Newslocks>();
		for(int i=0; i<l.size(); i++) {
			Newslocks n = new Newslocks();
			Object[] obj = (Object[]) l.get(i);
			try{
				n.setId(obj[0].toString());
				n.setTitle(obj[1].toString());
				n.setUserName(obj[2].toString());
				if(obj[3] != null)
					n.setImage(Utils.getimagepath() + obj[3].toString());
				n.setViewCount(Integer.parseInt(obj[4].toString()));
				n.setReviewCount(Integer.parseInt(obj[5].toString()));
				//以下两个字段是网页版电脑端需求所加
				n.setCreatetime(obj[6].toString());
				if(obj[7] != null) {
					/*String content;
					if(obj[7].toString().length() > 130) 
						content = obj[7].toString().substring(0, 129) + "......";
					else
						content = obj[7].toString();
					n.setContent(content);*/
					//代替上面的内容简介
					String simpleContent = HtmlUtil.getTextFromHtml(obj[7].toString());
					if(simpleContent.length() > 130)
						simpleContent = simpleContent.substring(0, 129) + "......";
					n.setSimpleContent(simpleContent);
				}
				nl.add(n);
			} catch(Exception e){
				System.err.println(e.getMessage());
			}
		}
		Map all = new HashMap();
		all.put("totalPage", totalPage);
		all.put("newsLocksList", nl);
		return all;
	}
	
	/**
	 * 根据id查询论坛帖
	 */
	public List<News> findNewsById(String newsId) {
//		String sql = "select * from news where id=" + newsId;
//		List<News> news = findBySQL(sql);
		String sql = "from News where id=?";
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, newsId);
		List<News> news = query.list();
		return news;
	}
	
	/**
	 * 增加一次浏览次数
	 */
	public String addViewcount(String newsId) {
//		String sql = "update news set viewCount=viewCount+1 where id=" + newsId;
//		executeQuery(sql);
		/*String sql = "update news set viewCount=viewCount+1 where id=?";
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, newsId);
		query.executeUpdate();*/
		News news = findById(newsId);
		news.setViewCount(news.getViewCount() + 1);
		saveOrUpdate(news);
		
		return null;
	}
	
	
	/**
	 * 增加一次评论次数
	 */
	public String addReviewcount(String newsId) {
		/*String sql = "update news set reviewCount=reviewCount+1 where id=?";
		Query query = getSession().createSQLQuery(sql);
		query.setParameter(0, newsId);
		query.executeUpdate();*/
		News news = findById(newsId);
		news.setReviewCount(news.getReviewCount() + 1);
		saveOrUpdate(news);
		
		return null;
	}
	
	/**
	 * 电脑端发帖
	 */
	public void saveNewsByComputer(String userId, String title, String content, int type) {
		News news = new News();
		if(userId != null && userId.length() != 0) {
			news.setUserId(userId);
			news.setUserName(userService.findById(userId).getAccount());
			if(title != null && title.length() != 0)
				news.setTitle(title);
			if(content != null && content.length() != 0)
				news.setContent(content);
			news.setType(type);
			news.setStatus(1);
			save(news);
		}
	}

	public Viewhistory getViewhistory() {
		return viewhistory;
	}

	public void setViewhistory(Viewhistory viewhistory) {
		this.viewhistory = viewhistory;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	
	/**
	 * 浏览
	 */
//	@Override
//	public List<NewsEcho> view(String newsId, Viewhistory vh) {
//		//第一步.返回需要的数据(news, review论坛帖两表内容)
//		String sql = "select n.*, r.* from news n, review r where n.id=r.newsId and n.id=" + newsId;
//		List l = findBySQL(sql);
//		List<NewsEcho> lne = new ArrayList<NewsEcho>();
//		NewsEcho ne = new NewsEcho();
//		Object[] obj = (Object[]) l.get(0);
//		ne.setNewsId(obj[0].toString());
//		ne.setNewsName(obj[1].toString());
//		ne.setNewsComment(obj[2].toString());
//		ne.setNewsCreatetime((Timestamp) obj[3]);
//		ne.setNewsStatus((Integer) obj[4]);
//		ne.setUserId(obj[5].toString());
//		ne.setUserName(obj[6].toString());
//		ne.setViewCount((Integer) obj[7]);
//		ne.setReviewCount((Integer) obj[8]);
//		ne.setType((Integer) obj[9]);
//		ne.setTitle(obj[10].toString());
//		ne.setNewsContent(obj[11].toString());
//		ne.setReviewId(obj[12].toString());
//		ne.setReviewName(obj[13].toString());
//		ne.setReviewComment(obj[14].toString());
//		ne.setReviewCreatetime((Timestamp) obj[15]);
//		ne.setReviewStatus((Integer) obj[16]);
//		ne.setOrder((Integer) obj[19]);
//		ne.setReviewContent(obj[20].toString());
//		lne.add(ne);
//		//第二步.浏览该帖时论坛表(news)该记录viewCount(浏览总数)字段需要加1
//		String hql = " update News set viewCount=viewCount+1 where id=" + newsId;
//		executeQuery(hql);
//		//第三步.另外还需往用户浏览记录表(viewHistory)中添加一条浏览记录
//		//1).调用内部方法
////		saveViewhistory(vh);
//		//2).调用另外个service保存浏览记录对象
//		SaveViewhistoryService s = new SaveViewhistoryService();
//		s.saveViewhistory(vh);
//		return lne;
//	}
	
/*
	//保存viewhistroy(用户浏览)记录
	public void saveViewhistory(Viewhistory vh) {
		if(vh == null)
			return;
		Connection conn  =DBUtil.getConnection();
		String sql = "insert into viewhistory values(?,?,?,now(),?,?,?,now()) ";
		try {
			PreparedStatement prep = conn.prepareStatement(sql);
			prep.setString(1, Utils.getNewUUID());
			prep.setString(2, vh.getName());
			prep.setString(3, vh.getComment());
			prep.setInt(4, vh.getStatus());
			prep.setString(5, vh.getUserId());
			prep.setString(6, vh.getName());
			prep.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				DBUtil.closeConnection();
		}
	}
*/	
	
//	/**
//	 * 评论
//	 */
//	@Override
//	public List<Review> review(String newsId, Review rv) {
//		//第一步.评论该帖时论坛表(news)该记录reviewCount(评论总数)字段需要加1
//		String sql = " update news set reviewCount=reviewCount+1 where id=" + newsId;
//		findBySQL(sql);
//		//第二步.再往用户评论表(review)添加一条评论记录
//		SaveReviewService s = new SaveReviewService();
//		s.saveReview(rv);
//		
//		return null;
//	}

	

}
