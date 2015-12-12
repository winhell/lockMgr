package com.lockMgr.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Radio;
import com.lockMgr.service.IRadioService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

/**
 *  广播action
 */

public class RadioAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -818800041035084638L;
	
	String path = ServletActionContext.getServletContext().getContextPath(); // /lockMgr
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL(); // http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action
	
	private String id;
	private String[] idlist;
	private int rows;
	private int page;
	private String word;  //广播内容
	
	private IRadioService radioService;
	
	/**
	 * 分页查询广播
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void getRadioByPage() throws IOException {
		Map m = new HashMap();
		radioService.findRadioByPage(m, page, rows);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 查询全部广播(radio_findAllRadio.action)
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void findAllRadio() throws IOException {
		Map m = new HashMap();
		List<Radio> all = radioService.findAllRadio();
		m.put("success", true);
		m.put("radioList", all);
		Utils.senchaview(m);
	}
	
	/**
	 * 添加一条广播
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addRadio() throws IOException {
		Map m = new HashMap();
		radioService.addRadio(word);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 删除一条广播
	 * @throws IOException 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void deleteRadio() throws IOException {
		Map m = new HashMap();
		radioService.deleteRadio(idlist);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
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

	public IRadioService getRadioService() {
		return radioService;
	}

	public void setRadioService(IRadioService radioService) {
		this.radioService = radioService;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
}
