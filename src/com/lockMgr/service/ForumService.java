package com.lockMgr.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Baseforum;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.News;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Review;
import com.lockMgr.pojo.Viewhistory;
import com.lockMgr.util.StatusEnum;

public class ForumService extends BaseDao<News> implements IForumService
{

	@Override
	public List<Baseforum> getposts()
	{
		// String
		// hql="select n.title,u.name,u.image,count(his),count(re) from News n,Viewhistory his,User u,Review re where n.id =re.newsId and n.id=his.newsId and n.userId =u.id group by n.title order by n.createtime asc";
		/*
		 * String hql1="from News ns order by ns.createtime desc"; String hql2 =
		 * "select ns.id,u.name,u.image from News ns,User u where u.id in (select ns.userId from News ns) order by ns.createtime"
		 * ; String hql3 =
		 * "select ns.id,count(his.id) from news ns left join viewhistory his on ns.id in (select his.newsId from viewhistory his) order by ns.createtime"
		 * ; String hql4 =
		 * "select ns.id,count(re.id) from news ns left join review re on ns.id in (select re.newsId from review re) order by ns.createtime"
		 * ;
		 */
		String hql5 = "select n.id,n.title,u.name,u.image from News n,User u where n.userId =u.id group by n.id order by n.createtime";
		String hql6 = "select ns.id,count(his.id) from news ns left join viewhistory his on ns.id in (select his.newsId from viewhistory his) order by ns.createtime";
		String hql7 = "select ns.id,count(re.id) from news ns left join review re on ns.id in (select re.newsId from review re) order by ns.createtime";

		String hql8 = "select n.id,n.title,u.name,u.image,count(his.id),count(re.id) from news n,user u left join viewhistory his on n.id in (select newsId from viewhistory) left join review re on n.id in (select newsId from viewhistory) where n.userId =u.id group by n.id order by n.createtime";
		List l5 = publicFind(hql5);
		List l6 = findBySQL(hql6);
		List l7 = findBySQL(hql7);
		/*
		 * List l1 = publicFind(hql1); List l2 = publicFind(hql2); List l3 =
		 * findBySQL(hql3); List l4 = findBySQL(hql4);
		 */
		List<Baseforum> list = new ArrayList<Baseforum>();
		for (int i = 0; i < l5.size(); i++)
		{
			Baseforum forum = new Baseforum();
			Object[] obj5 = (Object[]) l5.get(i);
			Object[] obj6 = (Object[]) l6.get(i);
			Object[] obj7 = (Object[]) l7.get(i);
			if (obj5[0].toString().equals(obj6[0].toString())
					&& obj5[0].toString().equals(obj7[0].toString()))
			{
				forum.setId(obj5[0].toString());
				forum.setTitle(obj5[1].toString());
				forum.setUname(obj5[2].toString());
				forum.setImage(Utils.getimagepath() + obj5[3].toString());
				forum.setHis(Long.parseLong(obj6[1].toString()));
				forum.setReview(Long.parseLong(obj7[1].toString()));
				list.add(forum);
			}
		}
		// for (int i = 0; i < l.size(); i++) {
		// Baseforum forum =new Baseforum();
		// Object[] obj =(Object[])l.get(i);
		// forum.setTitle(obj[0].toString());
		// forum.setUname(obj[1].toString());
		// forum.setImage(obj[2].toString());
		// forum.setHis(Long.parseLong(obj[3].toString()));
		// forum.setReview(Long.parseLong(obj[4].toString()));
		// list.add(forum);
		// }
		/*
		 * for (int i = 0; i < l1.size(); i++) { News obj1 =(News)l1.get(i);
		 * Object[] obj2 =(Object[])l2.get(i); Object[] obj3
		 * =(Object[])l3.get(i); Object[] obj4 =(Object[])l4.get(i); Baseforum
		 * forum =new Baseforum();
		 * if(obj1.getId().equals(obj2[0].toString())&&obj1
		 * .getId().toString().equals
		 * (obj3[0].toString())&&obj1.getId().toString(
		 * ).equals(obj4[0].toString())){ forum.setId(obj1.getId().toString());
		 * forum.setTitle(obj1.getTitle().toString());
		 * forum.setUname(obj2[1].toString());
		 * forum.setImage(obj2[2].toString());
		 * forum.setHis(Long.parseLong(obj3[1].toString()));
		 * forum.setReview(Long.parseLong(obj4[1].toString())); list.add(forum);
		 * } }
		 */
		return list;
	}

	public List<News> getblocks()
	{
		return null;
	}

	@Override
	public void getForumByPage(Map map, int page, int pageSize,
			String userName, String title, int status, Date beginDate,
			Date endDate, String orderType, String sortAttr)
	{

		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = "from News where 1=1";

		if (null != userName && userName.length() != 0)
		{
			hql += " and userName  like ?";
			al.add("%"+userName+"%");
			paramNums++;
		}

		if (null != title && title.length() != 0)
		{
			hql += " and title like ?";
			al.add("%" +title+"%");
			paramNums++;
		}
		if (status != -1)
		{
			hql += " and status =?";
			al.add(status);
			paramNums++;
		}
		if (null != beginDate&&null != endDate)
		{
			hql += " and createtime >=?";
			al.add(beginDate);
			paramNums++;
			hql += " and createtime <=?";
			al.add(endDate);
			paramNums++;
		}
		else if (null == beginDate || null == endDate)
		{
			Calendar cal = Calendar.getInstance();
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			Date date = new Date(cal.getTimeInMillis());
			// Timestamp date = new Timestamp(System.currentTimeMillis());
			Date nextDate = new Date(date.getTime() + 86400000);
			// Timestamp nextDate=new
			// Timestamp(System.currentTimeMillis()+86400000);
			hql += " and createtime >=? and createtime <=? "; // ////////
			al.add(date);
			paramNums++;
			al.add(nextDate);
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
		News news = null;
		for (String id : idlist) {
			news = this.findById(id);
			delete(news);
			writeLog(operator, "删除", "帖子", news);
		}
	}


	@Override
	public void txUpdate(Operator oper, String title, String content, String id)
	{
		
	 News news=findById(id);
	 news.setTitle(title);
	 news.setContent(content);
	 saveOrUpdate(news);
	 writeLog(oper, "修改", "帖子", news);
		
	}

}
