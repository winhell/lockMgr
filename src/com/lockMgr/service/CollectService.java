package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Collect;
import com.lockMgr.pojo.News;
import com.lockMgr.pojo.Newslocks;

/**
 * 收藏实现类
 * @author lzc
 *
 */
@SuppressWarnings("unchecked")
public class CollectService extends BaseDao<Collect> implements ICollectService {
	
	/**
	 * 根据用户id查询是否是否收藏过该论坛帖
	 * true：找到
	 * false：没找到
	 */
	public boolean checkingCollectByUser(String userId, String newsId) {
		String hql = " from Collect where userId=? ";
		List<Collect> collectList = find(hql, new Object[]{userId});
		for(int i=0; i<collectList.size(); i++) {
			String newsid = collectList.get(i).getNewsId();
			int status = collectList.get(i).getStatus();
			if(newsid.equals(newsId) && status==1) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据用户id查询该用户收藏帖(状态为1的)
	 */
	@Override
	public List<Collect> findCollectByUser(int page, int pageSize, String userId) {
		String hql = " from Collect where userId=? and status=1 order by createtime ";
		List<Collect> collectList = new ArrayList<Collect>();
		if(page==0 && pageSize==0) {
			collectList = findByPage(hql, new Object[]{userId}, 0, 20);
		} else {
			collectList = findByPage(hql, new Object[]{userId}, (page-1)*pageSize, pageSize);
		}
		return collectList;
	}
	
	/**
	 * 根据收藏表中newsId查询该帖5个主要信息(在findCollectByUser方法后调用)
	 */
	@SuppressWarnings("rawtypes")
	public List<Newslocks> findNewsById(String newsid, String userid) {
		String hql = " select n.id,n.title,n.userName,u.image,n.viewCount,n.reviewCount from News n,User u where n.id=? and u.id=? ";
		List l = find(hql, new Object[]{newsid,userid});
		List<Newslocks> nl = new ArrayList<Newslocks>();
		Newslocks n = new Newslocks();
		/*
		 * 首先要判断在收藏表(collect)中的newsId是否真在news表中(可能已经被删除了)
		 */
		if(l != null && l.size() != 0) {
			Object[] obj = (Object[]) l.get(0);
			n.setId(obj[0].toString());
			n.setTitle(obj[1].toString());
			n.setUserName(obj[2].toString());
			n.setImage(Utils.getimagepath() + obj[3].toString());
			n.setViewCount(Integer.parseInt(obj[4].toString()));
			n.setReviewCount(Integer.parseInt(obj[5].toString()));
			nl.add(n);
		}
		return nl;
	}
	
}
