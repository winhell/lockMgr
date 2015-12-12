package com.lockMgr.test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IUserordertService;



public class HrTestCase {
	private ApplicationContext context=null;
	IUserordertService service;
	@Before
	public void setUp() throws Exception {
		context = JUnitHelper.getApplicationContext();
		service = (IUserordertService) context.getBean("uotService");
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException{
		
//		Map json = new HashMap();
//		int page = 1;
//		int pageSize = 10;
//		int status = -1;
//		String businessId = "31ad0d72-da34-4a03-8212-da4e13ca48f2";
//		Date now = new Date();
//		Calendar c = Calendar.getInstance();
//		c.add(Calendar.DATE, -7);
//		Timestamp beginDate = new Timestamp(c.getTimeInMillis());
//		Timestamp endDate = Utils.getNow();
//		service.findGroupOrderByPage(json, page, pageSize, null, status, null, null, businessId, beginDate, endDate);
//		Long total = (Long) json.get("total");
//		Assert.assertEquals(total, new Long(0));
////		service.findGroupOrderByPage(json, page, pageSize, null, null, null, businessId, null, null);
////		Long total = (Long) json.get("total");
////		Assert.assertEquals(total, new Long(1));
//		System.out.println(total);
		
//		String address = "南昌市西湖区";
//		List<Business> bList = service.findBusiness(2, 2, address, 28.1, 155.4);
//		System.out.println(bList.size());
//		System.out.println(bList);
		
//		List<Business> b = service.findBusinessByCity(1, 10, "南昌市");
//		System.out.println(b.size());
		
		double dd = service.findRevenueByBusinessId("31ad0d72-da34-4a03-8212-da4e13ca48f2");
		System.out.println(dd);
	}
}
