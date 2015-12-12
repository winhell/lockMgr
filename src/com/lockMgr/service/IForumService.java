package com.lockMgr.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Baseforum;
import com.lockMgr.pojo.News;
import com.lockMgr.pojo.Operator;

public interface IForumService extends IBaseDao<News>{
	public List<Baseforum> getposts();
	public List<News> getblocks();
	public void txUpdate(Operator oper,String title,String content,String id);
	public void txDel(Operator operator, String[] idlist);
	public void getForumByPage(Map map, int page, int pageSize,String userName, String title, int status, Date beginDate,Date endDate, String orderType, String sortAttr);
}
