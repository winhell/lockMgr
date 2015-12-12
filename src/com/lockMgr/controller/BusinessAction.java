/**
 * 
 */
package com.lockMgr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings({ "rawtypes" })
public class BusinessAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4779692247834026042L;
	private String[] idlist;
	private String id;
	private IBusinessService businessService;
	private int page;
	private int rows;
	private String realName;
	private int verify = -1;
	private String order;
	private String sort;
	private int isPass;
	private double lat;
	private double lngti;
	// private Business business;
	private String image;
	private String company;
	private double pointX;
	private double pointY;
	private String address;
	private String tel;
	private String comment;
	private String addressOne;   //省
	private String addressTwo;   //市
	private String addressThree; //区
	private String addressFour;  //街
	private String b_a_rating; //优先级0普通;1优先;2特级.
	private int type;  //商户类型0批发商,1零售商.
	
	private Business business;

	/**
	 * 申请商户：该处申请的商户是默认级别(为普通)
	 * @return
	 * @throws IOException
	 */
	public String commonApply() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null) {
			if( ! addressOne.contains("省"))
				addressOne = addressOne + "省";
			if( ! addressTwo.contains("市"))
				addressTwo = addressTwo + "市";
			if( ! addressThree.contains("区"))
				addressThree = addressThree + "区";
			Business business = new Business();
//			String address = addressOne + "省" +addressTwo + "市" +addressThree + "区" +addressFour;
			String address = addressOne + addressTwo + addressThree + addressFour;
			business.setAddress(address);
			business.setComment(comment);
			business.setCompany(company);
			business.setImage(image);
			business.setPointX(pointX);
			business.setPointY(pointY);
			business.setRealName(realName);
			business.setTel(tel);
			business.setType(type);  //商户类型0批发商,1零售商.
//			business.setRating(Integer.parseInt(b_a_rating));
			business.setRating(0); //商户自己申请时默认给予等级0(普通)
			businessService.txAddBusiness(business, oper);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		} else {
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}
	
	/**
	 * 修改商户信息
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void modifyBusiness() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map m = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if (!businessService.txUpdate(oper, id, business)){
			status = StatusEnum.failed;
			reason = "修改失敗";
		}
		m.put(KeyEnum.STATUS, status);
		m.put(KeyEnum.REASON, reason);
		jsonViewIE(m);
	}

	public String getAllBusinessIdAndComment() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(businessService.getAllBusinessNameAndId(oper));
		return null;
	}

	public String getBusinessByPage() throws IOException {
		Map jsondata = new HashMap();
		businessService.getBusinessByPage(jsondata, page, rows, realName,
				verify, order, sort);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;
	}

	/**
	 * 审核商户
	 * @return
	 * @throws IOException
	 */
	public String auditBusiness() throws IOException {
		StatusEnum status;
		Map jsondata = new HashMap();
		Map map = getSession();
		Operator oper = (Operator) map.get(KeyEnum.OPERATOR);
		businessService.txAuidtBusiness(oper, idlist, isPass);
		status = StatusEnum.success;
		jsondata.put(KeyEnum.STATUS, status);
		jsonViewIE(jsondata);
		return null;
	}

	public String deleteBusiness() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null) {
			businessService.txDel(oper, idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		} else {
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}

	public String getBusinessIdAndComment() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(businessService.getBusinessNameAndId(oper));
		return null;
	}

	public String getAllbusi() throws IOException {
		Map json = new HashMap();
		List<Business> list = this.businessService.listAll();
		if (list.size() == 0) {
			json.put("success", false);
			json.put("msg", "暂无商家");
		} else if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setImage(
						Utils.getimagepath() + list.get(i).getImage());
			}
			json.put("success", true);
			json.put("msg", "");
			json.put("business", list);
		} else {
			json.put("success", false);
			json.put("msg", "系统异常");
		}
		Utils.senchaview(json);
		return null;
	}

	public String getBusinessById() throws IOException {
		Map json = new HashMap();
		Business business = this.businessService.findById(id);
		if (business == null) {
			json.put("success", false);
			json.put("msg", "暂无商家");
		} else {
			if (business.getImage() != null) {
				business.setImage(Utils.getimagepath() + business.getImage());
			}
			if(business.getComment() != null && business.getComment().length() != 0) {
				String comment = replaceComment(business.getComment());
				business.setComment(comment);
			}
			//暂时把商户的用户名(account)存入business表中的name
			if(business.getAccount() != null && business.getAccount().length() != 0)
				business.setName(business.getAccount());
			json.put("success", true);
			json.put("msg", "");
			json.put("business", business);
		}
		Utils.senchaview(json);
		return null;
	}

	public String getnearbusi() throws IOException {
		Map session = this.getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map json = new HashMap();
		List<Business> nearbusi = new ArrayList<Business>();
		if (oper == null) {
			json.put(KeyEnum.STATUS, StatusEnum.timeout);
			jsonViewIE(json);
		} else {
			List<Business> list = this.businessService.listAll();
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setImage(
						Utils.getimagepath() + list.get(i).getImage());
				if (lat != 0.0 || lngti != 0.0) {
					double dis = Utils.getDistatce(lat,
							list.get(i).getPointX(), lngti, list.get(i)
									.getPointY());
					if (dis <= 10) {
						list.get(i).setDistance(dis);
						nearbusi.add(list.get(i));
						json.put("success", true);
					}
				}
			}
		}
		json.put("msg", "");
		Utils.senchaview(json);
		return null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
		idlist = id.replaceAll("'", "").split(",");
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getRealName2() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public int getIsPass() {
		return isPass;
	}

	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLngti() {
		return lngti;
	}

	public void setLngti(double lngti) {
		this.lngti = lngti;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPointX() {
		return pointX;
	}

	public void setPointX(double pointX) {
		this.pointX = pointX;
	}

	public double getPointY() {
		return pointY;
	}

	public void setPointY(double pointY) {
		this.pointY = pointY;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public String getRealName() {
		return realName;
	}

	public String getAddressOne() {
		return addressOne;
	}

	public void setAddressOne(String addressOne) {
		this.addressOne = addressOne;
	}

	public String getAddressTwo() {
		return addressTwo;
	}

	public void setAddressTwo(String addressTwo) {
		this.addressTwo = addressTwo;
	}

	public String getAddressThree() {
		return addressThree;
	}

	public void setAddressThree(String addressThree) {
		this.addressThree = addressThree;
	}

	public String getAddressFour() {
		return addressFour;
	}

	public void setAddressFour(String addressFour) {
		this.addressFour = addressFour;
	}

	public String getB_a_rating() {
		return b_a_rating;
	}

	public void setB_a_rating(String b_a_rating) {
		this.b_a_rating = b_a_rating;
	}

	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	

}
