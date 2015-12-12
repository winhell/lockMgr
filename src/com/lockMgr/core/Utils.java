package com.lockMgr.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.ServletActionContext;
import org.codehaus.jackson.map.ObjectMapper;

import com.google.gson.Gson;
import com.lockMgr.pojo.Business;

public class Utils {
	public static String getNewUUID() {
		return java.util.UUID.randomUUID().toString();
	}

	public static Timestamp getNow() {
		return new Timestamp((new Date()).getTime());
	}

	// file/img
	public static String getimagepath() {
		String p = ServletActionContext.getServletContext().getContextPath();
		StringBuffer ppp = ServletActionContext.getRequest().getRequestURL();
		String ad = ppp.substring(0, ppp.indexOf(p));
		String imgaddr = ad + p + "/file/img/";
		return imgaddr;
	}

	// file/rotatePicture
	public static String getRotatePictureImgPath() {
		String p = ServletActionContext.getServletContext().getContextPath();
		StringBuffer ppp = ServletActionContext.getRequest().getRequestURL();
		String ad = ppp.substring(0, ppp.indexOf(p));
		String imgaddr = ad + p + "/file/rotatePicture/";
		return imgaddr;
	}

	/**
	 * 替换简介中图片路径
	 */
	public static String replaceComment(String comment) {
		String path = ServletActionContext.getServletContext().getContextPath();
		StringBuffer path1 = ServletActionContext.getRequest().getRequestURL();
		String[] path2 = path1.toString().split(path);
		if (comment != null && comment.length() != 0 && comment.contains(path)) {
			comment = comment.replaceAll(path, path2[0] + path);
		}
		return comment;
	}

	public static boolean senchaview(Map data) throws IOException {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		PrintWriter out = ServletActionContext.getResponse().getWriter();
		ServletActionContext.getResponse().setHeader(
				"Access-Control-Allow-Origin", "*");
		boolean jsonP = false;
		String cb = ServletActionContext.getRequest().getParameter("callback");
		if (cb != null) {
			jsonP = true;
			ServletActionContext.getResponse()
					.setContentType("text/javascript");
		} else {
			ServletActionContext.getResponse().setContentType(
					"application/json");
		}
		Gson g = new Gson();
		ObjectMapper mapper = new ObjectMapper();
		if (jsonP) {
			out.write(cb + "(");
		}
		// String str = "";
		// try {
		// str = g.toJson(data);
		//
		// } catch (Exception e) {
		// System.err.println(e.getMessage());
		// }
		// out.print(str);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		mapper.setDateFormat(format);
		// mapper.writeValue(out, data);
		String str = mapper.writeValueAsString(data);
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
		return false;
	}

	public static double getDistatce(double lat1, double lat2, double lon1,
			double lon2) {
		// latitude(纬度),longitude(经度)
		double R = 6378.137;// 地球半径
		double distance = 0.0;
		double dLat = (lat2 - lat1) * Math.PI / 180;
		double dLon = (lon2 - lon1) * Math.PI / 180;
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(lat1 * Math.PI / 180)
				* Math.cos(lat2 * Math.PI / 180) * Math.sin(dLon / 2)
				* Math.sin(dLon / 2);
		distance = (2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a))) * R;
		return distance;
	}

	/**
	 * 分页中对指定集合返回特定页数的集合
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List getListByPageAndPagesize(List allList, int page,
			int pageSize) {
		List l = new ArrayList();
		int size = allList.size();
		// 第一页的可能性
		if (pageSize > size) {
			if (page == 1)
				return allList;
			if (page != 1)
				return null;
		}
		// 不是第一页，但请求页数没数据可能性(与该请求页数上一页最后条数据比较)
		if (size <= (page - 1) * pageSize)
			return null;
		// 正常可能性
		int max = pageSize * page - 1;
		int min = max - pageSize + 1;
		if (max > size - 1)
			max = size - 1;
		if (min > size - 1)
			min = size - 1;
		for (int i = min; i <= max; i++)
			l.add(allList.get(i));
		return l;
	}

	/**
	 * 根据已有集合按照"商户优先级"各个等级中相同等级进行随机排序 商户共有"普通0","优先1","特级2"这三种等级,
	 * eg:特级有3个商户,就对这三个商户随机排序,但不影响之前等级的划分
	 */
	public static List<Business> getListByRatingBusinessList(
			List<Business> businessList) {
		List<Business> lastBusinessList = new ArrayList<Business>(); // 最后返回的最终商户集合
		List<Business> twoBusinessList = new ArrayList<Business>(); // 等级(rating)为2的商户-->特级
		List<Business> oneBusinessList = new ArrayList<Business>(); // 等级(rating)为1的商户-->优先
		List<Business> zeroBusinessList = new ArrayList<Business>(); // 等级(rating)为0的商户-->普通
		// 不管各等级的商户是否有,先全部赋值,之后if判断
		for (int i = 0; i < businessList.size(); i++) {
			Business b = businessList.get(i);
			if (b.getRating() == 2)
				twoBusinessList.add(b);
			if (b.getRating() == 1)
				oneBusinessList.add(b);
			if (b.getRating() == 0)
				zeroBusinessList.add(b);
		}
		if (twoBusinessList != null && twoBusinessList.size() != 0) {
			twoBusinessList = ratingBusinessList(twoBusinessList);
			lastBusinessList.addAll(twoBusinessList);
		}
		if (oneBusinessList != null && oneBusinessList.size() != 0) {
			oneBusinessList = ratingBusinessList(oneBusinessList);
			lastBusinessList.addAll(oneBusinessList);
		}
		if (zeroBusinessList != null && zeroBusinessList.size() != 0) {
			zeroBusinessList = ratingBusinessList(zeroBusinessList);
			lastBusinessList.addAll(zeroBusinessList);
		}
		return lastBusinessList;
	}

	/**
	 * 私有方法(供getListByRatingBusinessList方法使用)，对相同等级的商户集合随机排序
	 */
	private static List<Business> ratingBusinessList(List<Business> businessList) {
		List<Business> newBusinessList = new ArrayList<Business>();
		if (businessList != null && businessList.size() != 0) {
			int size = businessList.size();
			int[] array = new int[size]; // 初始化整型数组(此时为空),用于最后确定集合的排序顺序
			p: for (int i = 0; i < size;) {
				Random r = new Random();
				int value = r.nextInt(size); // 生成该集合长度内的整型随机数
				for (int m = 0; m < i; m++) { // 判断是否有重复
					if (value == array[m])
						continue p;
				}
				array[i] = value; // for判断不重复之后给array赋值
				i++;
			}
			// 最后对随机排序好的数组索引逐个添加到新集合并返回
			for (int j = 0; j < array.length; j++)
				newBusinessList.add(businessList.get(array[j]));
		}
		return newBusinessList;
	}

	/**
	 * 对不同等级用户按距离排序
	 * 
	 * @param businessList
	 *            service查询到的商户列表
	 * @param lati
	 *            用户当前纬度
	 * @param lngti
	 *            用户当前经度
	 * @return
	 */
	public static List<Business> getListByRatingAndDistanceBusinessList(
			List<Business> businessList, double lati, double lngti) {
		List<Business> lastBusinessList = new ArrayList<Business>(); // 最后返回的最终商户集合
		List<Business> twoBusinessList = new ArrayList<Business>(); // 等级(rating)为2的商户-->特级
		List<Business> oneBusinessList = new ArrayList<Business>(); // 等级(rating)为1的商户-->优先
		List<Business> zeroBusinessList = new ArrayList<Business>(); // 等级(rating)为0的商户-->普通
		// 不管各等级的商户是否有,先全部赋值,之后if判断
		for (int i = 0; i < businessList.size(); i++) {
			Business b = businessList.get(i);
			if (b.getRating() == 2)
				twoBusinessList.add(b);
			if (b.getRating() == 1)
				oneBusinessList.add(b);
			if (b.getRating() == 0)
				zeroBusinessList.add(b);
		}
		// 再根据不同等级用户按距离排序
		if (twoBusinessList != null && twoBusinessList.size() != 0) {
			twoBusinessList = distanceBusinessList(twoBusinessList, lati, lngti);
			lastBusinessList.addAll(twoBusinessList);
		}
		if(oneBusinessList != null && oneBusinessList.size() != 0) {
			oneBusinessList = distanceBusinessList(oneBusinessList, lati, lngti);
			lastBusinessList.addAll(oneBusinessList);
		}
		if(zeroBusinessList != null && zeroBusinessList.size() != 0) {
			zeroBusinessList = distanceBusinessList(zeroBusinessList, lati, lngti);
			lastBusinessList.addAll(zeroBusinessList);
		}
		return lastBusinessList;
	}

	/**
	 * 根据用户当前坐标和商户得出距离
	 * 
	 * @param businessList
	 * @param lati
	 * @param lngti
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static List<Business> distanceBusinessList(List<Business> businessList,
			double lati, double lngti) {
		for (Business b : businessList) {
			b.setDistance(getDistatce(lati, b.getPointX(), lngti, b.getPointY()));
		}
		Collections.sort(businessList, new Comparator<Business>() {
			public int compare(Business b1, Business b2) {
				//按距离升序
				if (b1.getDistance() > b2.getDistance())
					return 1;
				if (b1.getDistance() == b2.getDistance())
					return 0;
				return -1;
				//return String.valueOf(b1.getDistance()).compareTo(String.valueOf(b2.getDistance()));
			}
		});
		return businessList;
	}

}
