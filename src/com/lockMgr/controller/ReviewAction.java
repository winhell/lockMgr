package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.service.ICarService;
import com.lockMgr.service.IReviewService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

public class ReviewAction extends BaseAction {
	private IReviewService reviewService;
	
	private int page;
	private int rows;
	private String order;
	private String sort;
	private String newsId;
	private String[] idlist;
	private String id;
	
	public String getForumByPage() throws IOException
	{
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();

		reviewService.getReviewByPage(jsondata,page,rows,newsId,order,sort);
		jsonViewIE(jsondata);

		return null;
	}
	public String deleteReview() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		 reviewService.txDel(oper, idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;
	}

	

	public String getblocks() throws IOException {
		return null;
	}

	public void setReviewService(IReviewService reviewService)
	{
		this.reviewService = reviewService;
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

	public String getNewsId()
	{
		return newsId;
	}

	public void setNewsId(String newsId)
	{
		this.newsId = newsId;
	}
	public void setId(String id)
	{
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}
	
}
