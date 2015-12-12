/**
 * 
 */
package com.lockMgr.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Car;
import com.lockMgr.pojo.CarLogo;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resource;
import com.lockMgr.service.ICarLogoService;
import com.lockMgr.service.ICarService;
import com.lockMgr.service.IResourceService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.UserService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings({ "rawtypes" })
public class ResourceAction extends BaseAction
{
	private String title;
	private Resource resource;
	private String[] idlist;
	private String id;
	private int page;
	private int rows;
	private String describe;
	private int score;
	private String carCountry;
	private String carName;
	private String carType;
	private int limit;  //同pageSize
	private String resourceType;
	private String dataType;
	private String userId;
	
	private Car car;
	
	private int type=-1;
	private int  rank=-1;
	private String order;
	private String sort;
	
	private IResourceService resourceService;
	private ICarService carService;
	private IUserService userService;
	private ICarLogoService carLogoService;
	
	String path = ServletActionContext.getServletContext().getContextPath();
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL();
	
	/**
	 * 查询车类资料
	 */
	public String getResourceByPage() throws IOException
	{
		Map jsondata = new HashMap();
			resourceService.getResourceByPage(jsondata,page,rows,title,type,rank,order,sort);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		   jsonViewIE(jsondata);
		return null;
	}
	
	/**
	 * 查询软件下载资料
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getResourceOfSoftwareByPage() throws IOException {
		Map m = new HashMap();
		resourceService.getResourceOfSoftwareByPage(m, page, rows, title);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}

	public String addResource() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		 resourceService.txImportResource(oper, resource);
		 jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;

	}

	public String deleteResource() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		resourceService.txDel(oper, idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;
	}

	public String editResource() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
			if (!resourceService.txUpdate(oper,rank,type,score,title,describe,id,carName,carType,resourceType,dataType))
			{
				status = StatusEnum.failed;
				reason = "修改失敗";
			}
		jsondata.put(KeyEnum.STATUS, status);
		jsondata.put(KeyEnum.REASON, reason);
		jsonViewIE(jsondata);Utils.senchaview(jsondata);
		return null;
	}

	/**
	 * 得到所有车系品牌(需要去重)
	 * @return
	 * @throws IOException
	 */
	public void getAllCarNameAndId() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(carService.findAllCarsIdAndName(oper));
	}
	
	/**
	 * 根据车系查询车品牌和id
	 * @throws IOException 
	 */
	public void getCarsIdAndNameByCarCountry() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(carService.findCarsIdAndNameByCarCountry(carCountry, oper));
	}
	/**
	 * 根据车名查询车类别
	 */
	public void getCarTypeByCarName() throws IOException {
//		String carname = java.net.URLDecoder.decode(carName,"utf-8");
		String carname = new String(carName.getBytes("iso-8859-1"), "utf-8");
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(carService.findCarTypeByCarName(carname, oper));
	}
	
	/**
	 * 得到所有车类型号
	 * @throws IOException 
	 */
	public void getAllCarTypeAndId() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(carService.findAllCarsIdAndType(oper));
	}
	
	/**
	 * 分页查询车类信息
	 * @throws IOException 
	 */
	public void getCarByPage() throws IOException {
		Map session = this.getSession();
		Map jsondata = new HashMap();
		carService.findCarByPage(jsondata, page, rows,carCountry,carName,carType,sort);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
	}
	
	/**
	 * 根据车系查询车种类
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getCarByCountry() throws IOException {
		Map json = new HashMap();
		List<Car> carList = carService.findCarByCountry(page, limit, carCountry);
		if(carList.size() != 0) {
			json.put("success", true);
			json.put("cars", carList);
		}else {
			json.put("success", true);
			json.put("msg", "该车系暂无车类！！");
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 根据车系查询车种类
	 * @throws IOException 
	 */
	public void getCarsByCarCountry() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(carService.findCarsByCarCountry(carCountry, oper));
	}
	
	/**
	 * 增加车类
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void addCar() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		carService.txAddCar(oper, car);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
	}
	
	/**
	 * 修改车类
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void editCar() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if (!carService.txUpdateCar(oper, car,id)) {
			status = StatusEnum.failed;
			reason = "修改失敗";
		}
		jsondata.put(KeyEnum.STATUS, status);
		jsondata.put(KeyEnum.REASON, reason);
		jsonViewIE(jsondata);
	}
	
	/**
	 * 取消(删除)车类
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void cancelCar() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if(! carService.txCancelCar(oper, idlist)) {
			status = StatusEnum.failed;
			reason = "删除失败";
		}
		json.put(KeyEnum.STATUS, status);
		json.put(KeyEnum.REASON, reason);
		jsonViewIE(json);
	}
	
	/**
	 * 根据用户角色返回对应资源
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getResourceByUserrole() throws IOException {
		Map json = new HashMap();
		List<Resource> list = new ArrayList<Resource>();
		Resource r = new Resource();
		String address = "";
		//检查该用户的角色
		String userroleName = userService.checkUserrole(userId);
		if(userroleName.equals("普通会员")) {
			list = resourceService.findResourceByUserrole(0, page, limit);
		} else if(userroleName.equals("验证会员")) {
			list = resourceService.findResourceByUserrole(1, page, limit);
		}
		//!/lockMgr/file/resource/1407171511518.txt
		for(int i=0; i<list.size(); i++) {
			r = list.get(i);
			address = r.getAddress();
			if(address.contains("!")){
				String addressNow = address.replace("!/", "");
				r.setAddress(addressNow);
			}
		}
		json.put("success", true);
		json.put("resource", list);
		Utils.senchaview(json);
	}
	
	/**
	 * 根据资源id查询对应资源
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getResourceById() throws IOException {
		Map json = new HashMap();
		Resource r = null;
		if(id.length() != 0) {
			r = resourceService.findById(id);
			if(r!=null) {
				String addressNow = r.getAddress().replace("!/", "");
				r.setAddress(addressNow);
				if(r.getResDescribe() != null && r.getResDescribe().contains("<img")) 
					r.setResDescribe(replaceComment(r.getResDescribe()));
			}
		}
		json.put("success", true);
		json.put("resource", r);
		Utils.senchaview(json);
	}

	/**
	 * 根据车类名查询所有对应资源
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getAllResourceByCarName() throws IOException {
		Map json = new HashMap();
		String addressNow = "";
		String[] path2 = path1.toString().split(path);
		List<Resource> resourceList = resourceService.findAllResourceByCarName(page, limit, carName);
		if(resourceList.size()!=0 && resourceList!=null) {
			for(int i=0; i<resourceList.size(); i++) {
				addressNow = resourceList.get(i).getAddress().replace("!/", "");
				resourceList.get(i).setAddress(path2[0] + "/" + addressNow);
			}
		}
		json.put("success", true);
		json.put("resource", resourceList);
		Utils.senchaview(json);
	}
	
	/**
	 * 根据车类型查询所有对应资源(搜索框)
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getAllResourceByCarType() throws IOException {
		String rtype = java.net.URLDecoder.decode(resourceType,"UTF-8");
		String cname = java.net.URLDecoder.decode(carName,"UTF-8");
		String dtype = java.net.URLDecoder.decode(dataType,"UTF-8");
		Map json = new HashMap();
		String addressNow = "";
		String[] path2 = path1.toString().split(path);
		List<Resource> resourceList = resourceService.findAllResourceByCarType(page, limit, rtype, dtype, cname, carType);
		if(resourceList.size()!=0 && resourceList!=null) {
			for(int i=0; i<resourceList.size(); i++) {
				addressNow = resourceList.get(i).getAddress().replace("!/", "");
				resourceList.get(i).setAddress(path2[0] + "/" + addressNow);
			}
		}
		json.put("success", true);
		json.put("resource", resourceList);
		Utils.senchaview(json);
	}
	
	/**
	 * 根据resourceType,dataType,carCountry查询符合条件的所有图标
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getImageByCountryAndResource() throws IOException {
//		String resourcetype = java.net.URLDecoder.decode(resourceType,"UTF-8");
//		String carcountry = java.net.URLDecoder.decode(carCountry, "UTF-8");
		String[] p = path1.toString().split(path);
		String path2 = p[0] + path + "/";
		Map m = new HashMap();
		List<CarLogo> carLogoList = carLogoService.findImageByCountryAndResource(resourceType, dataType, carCountry);
		if(carLogoList == null) {
			m.put("success", true);
			m.put("msg", "该车系暂时无车型!");
		} else{
			for(int i=0; i<carLogoList.size(); i++) {
				carLogoList.get(i).setLogoImage(path2 + carLogoList.get(i).getLogoImage());
			}
			m.put("success", true);
			m.put("carLogo", carLogoList);
		}
		Utils.senchaview(m);
	}
	
	/**
	 * 根据资源类型(resourceType),车型(carName)查询所有资源
	 * @param resourceService
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void getAllByResourceTypeAndCarName() throws IOException {
		String rtype = java.net.URLDecoder.decode(resourceType,"UTF-8");
		String cname = java.net.URLDecoder.decode(carName,"UTF-8");
		Map m = new HashMap();
		String addressNow = "";
		String[] path2 = path1.toString().split(path);
		List<Resource> list = resourceService.findAllByResourceTypeAndCarName(page, limit, rtype, cname);
		if(list != null && list.size() != 0) {
			for(int i=0; i<list.size(); i++) {
				addressNow = list.get(i).getAddress().replace("!/", "");
				list.get(i).setAddress(path2[0] + "/" + addressNow);
			}
			m.put("success", true);
			m.put("resource", list);
		} else {
			m.put("success", true);
			m.put("msg", "暂无任何数据!");
		}
		Utils.senchaview(m);
	}

	public void setResourceService(IResourceService resourceService)
	{
		this.resourceService = resourceService;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Resource getResource()
	{
		return resource;
	}

	public void setResource(Resource resource)
	{
		this.resource = resource;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
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

	public String getDescribe()
	{
		return describe;
	}

	public void setDescribe(String describe)
	{
		this.describe = describe;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getRank()
	{
		return rank;
	}

	public void setRank(int rank)
	{
		this.rank = rank;
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

	public ICarService getCarService() {
		return carService;
	}

	public void setCarService(ICarService carService) {
		this.carService = carService;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public String getCarCountry() {
		return carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public IResourceService getResourceService() {
		return resourceService;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public ICarLogoService getCarLogoService() {
		return carLogoService;
	}

	public void setCarLogoService(ICarLogoService carLogoService) {
		this.carLogoService = carLogoService;
	}
    
	
}
