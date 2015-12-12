package com.lockMgr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.lockMgr.pojo.Baseforum;
import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IForumService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

public class ForumAction extends BaseAction {
	private IForumService forumService;
	
	private int page;
	private int rows;
	private String order;
	private String sort;
	private String userName;
	private String title;
	private int type;
	private Date beginDate;
	private Date endDate;
	private String[] idlist;
	private String id;
	private String content;
	private int status;
	
	public String getposts() throws IOException {
		Map json = new HashMap();
		List<Baseforum> list = this.forumService.getposts();
		if (list.size() <= 0) {
			json.put("success", true);
			json.put("msg", "暂无任何帖子");
		} else {
			json.put("success", true);
			json.put("forum", list);
			json.put("msg", "");
		}
		getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = getResponse().getWriter();
		getResponse().setHeader("Access-Control-Allow-Origin", "*");
		boolean jsonP = false;
		String cb = getRequest().getParameter("callback");
		if (cb != null) {
			jsonP = true;
			getResponse().setContentType("text/javascript");
		} else {
			getResponse().setContentType("application/json");
		}
		Gson g = new Gson();
		if (jsonP) {
			out.write(cb + "(");
		}
		String str = g.toJson(json);
		out.print(str);
		if (jsonP) {
			out.write(")");
		}
		try {
			if (out != null) {
				out.flush();
				out.close();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return null;
	}
	
	public String getForumByPage() throws IOException
	{
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();

		forumService.getForumByPage(jsondata,page,rows,userName,title,status,beginDate,endDate,order,sort);
		jsonViewIE(jsondata);

		return null;
	}
	public String deleteNews() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		forumService.txDel(oper, idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;
	}
	
	public String updateNews() throws IOException
	 {
		 StatusEnum status;
			Map jsondata = new HashMap();
			Map map = getSession();
			Operator oper = (Operator) map.get(KeyEnum.OPERATOR);
			forumService.txUpdate(oper,title,content,id);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
			jsonViewIE(jsondata);
		 return null;
	 }

	public String getblocks() throws IOException {
		return null;
	}

	public IForumService getForumService() {
		return forumService;
	}

	public void setForumService(IForumService forumService) {
		this.forumService = forumService;
	}

	public int getPage()
	{
		return page;
	}

	public void setPage(int page)
	{
		this.page = page;
	}

	public int getRows()
	{
		return rows;
	}

	public void setRows(int rows)
	{
		this.rows = rows;
	}

	public String getOrder()
	{
		return order;
	}

	public void setOrder(String order)
	{
		this.order = order;
	}

	public String getSort()
	{
		return sort;
	}

	public void setSort(String sort)
	{
		this.sort = sort;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public Date getBeginDate()
	{
		return beginDate;
	}

	public void setBeginDate(Date beginDate)
	{
		this.beginDate = beginDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}
	public void setId(String id)
	{
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
