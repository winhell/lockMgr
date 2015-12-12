package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.RotatePicture;
import com.lockMgr.service.IRotatePictureService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 * 滚动图片action
 */

public class RotatePictureAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1501300026237894166L;
	
	String path = ServletActionContext.getServletContext().getContextPath(); // /lockMgr
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL(); // http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action

	private String id;
	private String[] idlist;
	private int rows;
	private int page;
	private String address;  //滚动图片路径
	/*
	 * type: 1，代表首页轮播图片；
	 * 		2，代表论坛轮播图片。
	 * 		(以下全是广告管理)：
	 * 		3，康耐尔；
	 * 		4，指纹锁专区；
	 * 		5，锁芯专区；
	 * 		6，广告专区。
	 */
	private int type;		 //滚动图片类型
	private int[] typeArray;  //应对一个参数有两个值的情况(滚动图片首页(1)论坛(2)图片就是两个值)
	private String comment;  //各张广告图片文字说明
	
	private IRotatePictureService rotatePictureService;
	
	/**
	 * 增加滚动图片
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addRotatePicture() throws IOException {
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		Map m = new HashMap();
		rotatePictureService.addRotatePicture(o, address, type, comment);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 分页查询滚动图片(首页(1)和论坛(2)图片)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getrotatePicture() throws IOException {
		String[] path2 = path1.toString().split(path);
		//滚动图片路径(upload_uploadImg.action,写死在file/img),但我重写了个方法
		String realPath = path2[0] + path + "/file/rotatePicture/";
		Map m = new HashMap();
		rotatePictureService.findRotatePictureByPage(m, page, rows, realPath, typeArray, type);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 删除滚动图片
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteRotatePicture() throws IOException {
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		Map m = new HashMap();
		rotatePictureService.deleteRotatePicture(o, idlist);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 修改滚动图片
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void editRotatePicture() throws IOException {
		Map session = getSession();
		Operator o = (Operator) session.get(KeyEnum.OPERATOR);
		Map m = new HashMap();
		rotatePictureService.editRotatePicture(o, id, address, type);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 前端查询轮播图片
	 * type 参考最上面属性
	 * type: 1，代表首页轮播图片；
	 * 		2，代表论坛轮播图片。
	 * 		(以下全是广告管理)：
	 * 		3，康耐尔；
	 * 		4，指纹锁专区；
	 * 		5，锁芯专区；
	 * 		6，广告专区。
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getRotatePictureToFront() throws IOException {
		Map m = new HashMap();
		List<RotatePicture> rpList = 
				rotatePictureService.findRotatePictureToFront(type);  //此处type(首页图片传1，论坛图片传2),其他参考最上面属性
		m.put("success", true);
		m.put("rotatePictureList", rpList);
		Utils.senchaview(m);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public IRotatePictureService getRotatePictureService() {
		return rotatePictureService;
	}

	public void setRotatePictureService(IRotatePictureService rotatePictureService) {
		this.rotatePictureService = rotatePictureService;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int[] getTypeArray() {
		return typeArray;
	}

	public void setTypeArray(int[] typeArray) {
		this.typeArray = typeArray;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	
}
