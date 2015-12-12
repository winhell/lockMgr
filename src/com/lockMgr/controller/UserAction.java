/**
 * 
 */
package com.lockMgr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.struts2.ServletActionContext;
import org.hibernate.event.SaveOrUpdateEvent;

import sun.misc.BASE64Decoder;

import com.google.gson.Gson;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Car;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resource;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Userorder;
import com.lockMgr.pojo.Userrole;
import com.lockMgr.pojo.VerifyBusiness;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.ICarService;
import com.lockMgr.service.IOperatorService;
import com.lockMgr.service.IResourceService;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.service.IUserService;
import com.lockMgr.service.IVerifyBusinessService;
import com.lockMgr.service.IVipService;
import com.lockMgr.util.Encrypt;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.OpenfireEncrytionAndDecryption;
import com.lockMgr.util.OpenfireofuserHandle;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings({ "unchecked", "serial" })
public class UserAction extends BaseAction {
	private int money = 10; //每次打卡所得金币数
	
	private String account;
	private String password;
	private String oldPassword;
	private String newPassword;
	private String verifyPassword;
	private String validateCode;
	private String name;
	private String[] idlist;
	private String id;
	private String userId; //同上id
	private int page;
	private int rows;
	private String roleId;
	private int status; //状态，表示是否在线
	private String ImgData;
	private boolean gender;
	private Date birthday;
	private String email;
	private String phone;
	private long coins;
	private String carCountry; //车系
	private String carIndex; //车资源类别
	private int limit; //同pageSize
	private String order;
	private String sort;
	private int verify = -1;
	private String userRoleId;
	private String comment;
	private String image;
	//审核同行
	private String idCard; //身份证号码
	private String imageIdCard; //身份证照片
	private String imageBusinessLicense; //营业执照
	private String imagePoliceProve; //警局证明
	private String content; //介绍
	private String companyName;
	private String companyAddress;
	private String imgName; //仅限于电脑版网页端使用(对应的是手机端的ImgData)
	private String imgNameOfIdCard;  //网页端身份证图片名称
	private String imgNameOfBusinessLicense;  //网页端营业执照图片名称
	private String imgNameOfPoliceProve;  //网页端警局证明图片
	
	String path = ServletActionContext.getServletContext().getContextPath(); // /lockMgr
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL(); // http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action
	

	private File file;
	private String fileFileName;
	private String fileContentType;
	
	private User user;
	private User operator;
	
	private IUserService userService;
	private ICarService carService;
	private IResourceService resourceService;
	private IOperatorService  operatorService;
	private IVerifyBusinessService verifyBusinessService;
	private IUserRoleService userRoleService;
	private IBusinessService businessService;
	private IVipService vipService;
	
	/**
	 * 更新session
	 */
	@SuppressWarnings("rawtypes")
	public void updateUserSession(User user) {
		Map session = getSession();
		User u = user;
		u.setUserRoleName(userRoleService.findById(u.getUserRoleId()).getName()); //用户角色名
		if( ! u.getImage().contains("http"))
			u.setImage(Utils.getimagepath() + u.getImage());
		session.put(KeyEnum.STATUS, StatusEnum.success);
		session.put(KeyEnum.USER, u);
	}


	public String uploadImg() throws IOException {
		if (!fileContentType.contains("image")) {
			jsonViewIE("1");
			return null;
		}
		if (file.length() > 2048000) {
			jsonViewIE("2");
			return null;
		}
		if (!fileFileName.contains(".") || id == null || id.length() == 0) {
			jsonViewIE("3");
			return null;
		}
		String newFileName = id + ".jpg";
		// User user=userService.findById(id);
		// if(user!=null)
		// {
		// user.setImage(newFileName);
		// userService.saveOrUpdate(user);
		// }
		String path = ServletActionContext.getServletContext().getRealPath(
				"file/img/");
		FileOutputStream out = new FileOutputStream(path + "/" + newFileName);
		FileInputStream in = new FileInputStream(file);

		byte[] buffer = new byte[200];
		file.length();
		int length = 0;

		while (-1 != (length = in.read(buffer, 0, 200))) {
			out.write(buffer);
		}
		out.close();
		in.close();
		jsonViewIE(newFileName);
		return null;
	}

	public String getOperatorByPage() throws IOException {
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();

		if (operator == null) {
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		} else {
			userService.getUserByPage(jsondata, page, rows, account, roleId,
					operator);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		jsonViewIE(jsondata);
		account = null;
		roleId = null;

		return null;
	}

	public String addOperator() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null) {
			int flag = userService.txSave(oper, operator);
			if (flag == 1)
				jsondata.put(KeyEnum.STATUS, StatusEnum.success);
			else {
				jsondata.put(KeyEnum.STATUS, StatusEnum.failed);
				jsondata.put(KeyEnum.REASON, "操作失败，该操作员已存在！请重新输入！");
			}

		} else {
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;

	}

	public String deleteOperator() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		if (oper != null) {
			userService.txDel(oper, idlist);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		} else {
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
		}
		jsonViewIE(jsondata);
		return null;
	}

	public String editOperator() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
		if (oper != null) {
			if (null != newPassword && newPassword.length() != 0) {
				if (newPassword != null && verifyPassword != null
						&& !newPassword.equals(verifyPassword)) {
					status = StatusEnum.failed;
					reason = "新密码两次输入不一致";
				} else {
					operator.setPassword(newPassword);
				}
			}
			if (!userService.txUpdate(oper, operator, id)) {
				status = StatusEnum.failed;
				reason = "账号已存在";
			}

		} else {
			status = StatusEnum.timeout;
		}

		jsondata.put(KeyEnum.STATUS, status);
		jsondata.put(KeyEnum.REASON, reason);
		jsonViewIE(jsondata);
		return null;
	}
	
	/**
	 * 后台会员完善信息
	 * @throws IOException 
	 */
	public void editOperatorAndUser() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map m = new HashMap();
		userService.editUser(id, name, account, gender, phone, birthday, email, userRoleId, comment, image);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	public String veryfyUser() throws IOException {
		Map json = new HashMap();
		User u = null;
		if (null == account || null == password) {
			json.put("success", "fail");
			json.put("msg", "用户名或密码失败！");
		} else {
			u = this.userService.verifyUser(account, password);
			if (null == u) {
				json.put("success", "fail");
				json.put("msg", "用户名或密码失败！");
			} else {
				json.put("success", "success");
				json.put("msg", "");
				json.put("usr", u);
				getSession().put("account", u);
			}
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
		System.out.println(str);
		out.print(str);
		if (jsonP) {
			out.write(")");
		}
		out.flush();
		out.close();
		return null;
	}
	
	/**
	 * 注册
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public String addUser() throws IOException {
//		userService.registerUser(user);
		Map json = new HashMap();
		try {
			if(account==null || account.length()==0 || 
				password==null || password.length()==0 ||
				email==null || email.length()==0) {
				json.put("success", false);
				json.put("msg", "请重新输入必填项值！！");
			} else if(userService.checkingUser(account, email) == true) {
				json.put("success", false);
				json.put("msg", "该用户名或邮箱已注册，请重新输入！！");
			} else {
				user = new User();
				user.setAccount(account);
			//	user.setPassword(Encrypt.encryptPassword(password));
			user.setPassword(password);
//				user.setUserRoleId("2daae34e-274d-4661-b8da-e4891c83948e"); //初始注册即为普通用户
				List<Userrole> ol = userRoleService.find(" from Userrole where name='普通会员' ");
				if(ol != null && ol.size() != 0)
					user.setUserRoleId(ol.get(0).getId());
				user.setStatus(1); //注册时表示在线(1)
				user.setGender(gender); //false(0,表示男),true(1,表示女)
				user.setEmail(email);
				/*
				 * 注册成功自动打卡一次，
				 * 打卡时间初始化为注册时间
				 */
				user.setCoins(money);
				user.setCoinsTime(Utils.getNow());
				userService.txSave(null,user);
				//userService.save(user);
				/**
				 * 注册用户自动升级为VIP(详情请见本类中registerVIP方法)
				 * 150521
				 * 由于APP原因升级VIP还是要手动(xuyuan必须要按普通用户，认证用户，vip等级),
				 * 改成手动
				 * 150526
				 */
				//registerVIP(user.getId());
				getSession().put(KeyEnum.USER, user);
				json.put("success", true);
				json.put("status", "T");
				json.put("msg", "注册成功！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("status", "F");
			json.put("msg", "注册失败，请稍后重试！！");
			System.err.println(e.getMessage());
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 用户升级为VIP
	 * 用户付费升级是是直接jsp(notify_url.jsp)页面控制UserorderService类操作的,
	 * 该方法的作用是当用户注册为普通用户直接升级为VIP来解决苹果手机APP商店审核不成功问题。
	 * 2015-05-21
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void registerVIP() throws IOException {
		Map json = new HashMap();
		boolean status = false;
		try {
			status = vipService.registerVIP(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(status) {
			json.put("success", true);
			json.put("msg", "升级VIP成功，期限一年");
		} else 
			json.put("success", false);
		Utils.senchaview(json);
	}
	/**
	 * 用户登录验证
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public String checkingUser() throws IOException {
		Map json = new HashMap();
		String message = "";
		try {
			if(account!=null) {
				User user = userService.findUserByAccount(account);
				if(user==null) {
					json.put("success", false);
					json.put("msg", "该用户不存在，请重新输入！！");
				} else if(Encrypt.encryptPassword(password).equals(user.getPassword())){
//					else if(OpenfireEncrytionAndDecryption.getDecryptPWD(user.getPassword()).equals(password)){
					/*
					 * 首先判断是否vip
					 * 是：再次判断是否过期
					 * 		过期：更新用户角色(查询原来是普通用户还是商户(看商户表是否有状态正常记录), 还是同行(看该用户同行申请表是否有通过审核))
					 * 			注：由于商户比同行理论上权限高，所以先判断是否是商户
					 * 		没过期：vip登录成功
					 * 否：登录成功
					 */
					String vipRoleId = "4195f48e-6aba-466f-bdda-8152fb10074d";  //vip角色id
					if(user.getUserRoleId().equals(vipRoleId)) {  //判断是否会员
						if(vipService.isExpire(user.getId())) {  //如果过期，更新用户角色后，再重新获得用户信息
							//判断是否为商户
							if(businessService.isBusiness(user.getId())) {
								//是商户就更新该用户角色为商户
								user.setUserRoleId("91b61db6-397f-4c64-b7b5-a575c3c70281");  //验证会员 id
								userService.saveOrUpdate(user);
							} else {
								//不是商户就判断是否为同行
								if(verifyBusinessService.isVerifyBusiness(user.getId())) {
									user.setUserRoleId("85431849-d438-4f20-986d-a5ffebdd11a6");  //同行 id
									userService.saveOrUpdate(user);
								} else {
									//最后不是同行的话，就只能是普通用户了
									user.setUserRoleId("a6ec52b8-4e56-4856-aa25-547348e66ebc");  //普通用户 id
									userService.saveOrUpdate(user);
								}
							}
							message = "您的会员已过期,请尽快充值!";
						}
					}
					/*
					 * 不管有无修改用户角色都重新获取用户数据
					 */
					user = userService.findUserByAccount(account);
					user.setUserRoleName(userRoleService.findById(user.getUserRoleId()).getName()); //用户角色名
					user.setImage(Utils.getimagepath() + user.getImage());
					//根据userId查询businessId(是商户就返回有值的id,普通用户就返回空)
					String businessId = businessService.findBusinessIdByUserId(user.getId());
					if(businessId != null && businessId.length() != 0) {
						Business bs = businessService.findById(businessId);
						json.put("business", bs);
					}
					json.put("success", true);
					if(message != null && message.length() != 0)
						json.put("msg", message);
					else
						json.put("msg", "登录成功！！");
					json.put("user", user);
					//登录成功绑定session
//					getSession().clear();
					Map session = getSession();
					session.put(KeyEnum.STATUS, StatusEnum.success);
					session.put(KeyEnum.USER, user);
//					json.put("businessId", businessId);
				} else {
					json.put("success", false);
					json.put("msg", "密码输入错误，请重新输入！！");
				}
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "登录失败，请重试！！");
			System.err.println(e.getMessage());
		}
		Utils.senchaview(json);
		return null;
	}
	
	
	/**
	 * 打卡
	 * @throws IOException 
	 */
	@SuppressWarnings({ "deprecation", "rawtypes" })
	public String clockIn() throws IOException {
		Map json = new HashMap();
		Map session = getSession();
		try {
			User user = userService.findById(id);
			Date nowTime = Utils.getNow(); //当前时间
			Date lastTime = user.getCoinsTime(); //上次打卡时间
			if(nowTime.after(lastTime)) {
				int nowTimeMonth = nowTime.getMonth();
				int nowTimeDay = nowTime.getDate();
				int lastTimeMonth = lastTime.getMonth();
				int lastTimeDay = lastTime.getDate();
				//当前月份大于上次打卡月份
				if(nowTimeMonth > lastTimeMonth) {
					user.setCoins(user.getCoins() + money); //打卡成功加上金币数
					user.setCoinsTime(Utils.getNow());  //打卡成功把上次打卡时间改为当前时间
					userService.saveOrUpdate(user);
					json.put("success", true);
					json.put("msg", "今日打卡成功！获得金币数" + money);
					//打卡成功更新session
					User u = user;
					u.setUserRoleName(userRoleService.findById(u.getUserRoleId()).getName()); //用户角色名
					u.setImage(Utils.getimagepath() + u.getImage());
					session.put(KeyEnum.STATUS, StatusEnum.success);
					session.put(KeyEnum.USER, u);
				} else {
					json.put("success", false);
					json.put("msg", "今日您已打卡过，请明日再来！");
				}
				//当前月份等于上次打卡月份
				if(nowTimeMonth == lastTimeMonth) {
					if(nowTimeDay-lastTimeDay >= 1) {
						user.setCoins(user.getCoins() + money); //打卡成功加上金币数
						user.setCoinsTime(Utils.getNow());  //打卡成功把上次打卡时间改为当前时间
						userService.saveOrUpdate(user);
						json.put("success", true);
						json.put("msg", "今日打卡成功！获得金币数" + money);
						//打卡成功更新session
						User u = user;
						u.setUserRoleName(userRoleService.findById(u.getUserRoleId()).getName()); //用户角色名
						u.setImage(Utils.getimagepath() + u.getImage());
						session.put(KeyEnum.STATUS, StatusEnum.success);
						session.put(KeyEnum.USER, u);
					} else {
						json.put("success", false);
						json.put("msg", "今日您已打卡过，请明日再来！");
					}
				}
			} else {
				json.put("success", false);
				json.put("msg", "今日您已打卡过，请明日再来！");
			}
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "打卡失败，请稍后重试！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 测试
	 */
	@SuppressWarnings("deprecation")
	public void test() {
		Date nowTime = Utils.getNow();
		user = userService.findById(id);
		Date lastTime = user.getCoinsTime();
		int nowTimeDay = nowTime.getHours();
		int lastTimeDay = lastTime.getDay();
		System.out.println("lastTime.getDate();"+lastTime.getDate());
		System.out.println(nowTime.toString());
		System.out.println(lastTime.toString());
		System.out.println(nowTimeDay);
		System.out.println(lastTimeDay);
	}
	
	/**
	 * 修改用户密码
	 * @throws IOException 
	 */
	public String modifyUserPassword() throws IOException {
		Map json = new HashMap();
		try {
			User user = userService.findById(id);
			String mingwen = new String(newPassword);
			//	user.setPassword(Encrypt.encryptPassword(newPassword));
//				user.setPassword(OpenfireEncrytionAndDecryption.getEncryPWD(newPassword));
//				userService.saveOrUpdate(user);
				//user, operator表更新密码
				userService.updatePassword(user.getId(), newPassword);
				//ofUser表(在218.65.113.14中openfire数据库中的ofUser表)更新密码
				OpenfireofuserHandle.modifyPwd(user.getAccount(), mingwen);
				json.put("success", true);
				json.put("msg", "密码修改成功！！");
		} catch (Exception e) {
			json.put("success", false);
			json.put("msg", "密码修改失败，请稍后重试！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 修改用户信息(除密码)
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings({ "rawtypes", "deprecation" })
	public String modifyUser() throws IOException {
		Map json = new HashMap();
		try {
			User user = userService.findById(id);
			if(account != null && account.length() != 0)
				user.setAccount(account);
//			user.setGender(gender);
			if(birthday != null)
				user.setBirthday(birthday);
			if(email != null && email.length() != 0)
				user.setEmail(email);
			if(phone != null && phone.length() != 0)
				user.setPhone(phone);
			//仅限于电脑版网页端使用(对应的是手机端的ImgData)
			if(imgName != null && imgName.length() != 0)
				user.setImage(imgName);
			BASE64Decoder decode = new BASE64Decoder();
			if (ImgData != null) {
				byte[] b = decode.decodeBuffer(ImgData);
				for (int i = 0; i < b.length; i++) {
					if(b[i]<0){
						b[i]+=256;
					}
				}
//				String saved = getRequest().getRealPath("/")+"/images/";  // E:\apache-tomcat-7.0.54\webapps\lockMgr\/images/
				String saved = getRequest().getRealPath("/") + "/file/img/";
				System.out.println(saved);
				String sname = Utils.getNewUUID().replaceAll("-", "");
				File f = new File(saved);
				if(!f.exists()){
					f.mkdir();
				}
				saved = saved + sname + ".jpg";
				OutputStream out = new FileOutputStream(new File(saved));
				out.write(b);
//				ImageIO.write(im, formatName, output);
				out.flush();
				out.close();
				user.setImage(sname + ".jpg");
			}
			userService.saveOrUpdate(user);
			//返回图片设置地址
			if(user.getImage() != null && user.getImage().length() != 0)
				user.setImage(Utils.getimagepath() + user.getImage());
			json.put("success", true);
			json.put("msg", "修改信息成功！！");
			json.put("user", user);
			updateUserSession(user);  //更新用户session
		} catch (Exception e) {
			e.printStackTrace();
			json.put("success", false);
			json.put("msg", "修改信息失败！！");
		}
		Utils.senchaview(json);
		return null;
	}
	
	/**
	 * 根据车系查询车种类
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void getCarByCountry() throws IOException {
		Map json = new HashMap();
		List<Car> carList = carService.findCarByCountry(page, limit, carCountry);
		if(carList.size() == 0) {
			json.put("success", true);
			json.put("msg", "该车系暂无车类！！");
		} else {
			for(int i=0; i<carList.size(); i++) {
				carList.get(i).setImage(Utils.getimagepath() + carList.get(i).getImage());
			}
			json.put("success", true);
			json.put("car", carList);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 根据车种类查询相关资源
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void getResourceByCar() throws IOException {
		Map json = new HashMap();
		List<Resource> resourceList = resourceService.findResourceByCar(page, limit, carIndex);
		if(resourceList.size() == 0) {
			json.put("success", true);
			json.put("msg", "该车类暂无任何资源！！");
		} else {
			json.put("success", true);
			json.put("resource", resourceList);
		}
		Utils.senchaview(json);
	}
	
	/**
	 * 普通用户审核成为同行
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void verifyUser() throws IOException {
		Map m = new HashMap();
		if(userId == null || userId.length() == 0) {
			m.put("success", false);
			m.put("msg", "请先登录!");
		} else {
			try {
				VerifyBusiness vb = new VerifyBusiness();
				vb.setVerify(0);
				vb.setUserId(userId);
				vb.setPhone(phone);
				vb.setContent(content);
				vb.setIdCard(idCard);
				/*
				 * 手机端传的是图片字符流过来(imageBusinessLicense, imagePoliceProve, imageIdCard)
				 * 网页端直接是图片名称(imgNameOfBusinessLicense, imgNameOfPoliceProve, imgNameOfIdCard)
				 * 所以需要判断下
				 */
				if(imgNameOfBusinessLicense != null && imgNameOfBusinessLicense.length() != 0)
					vb.setImageBusinessLicense(imgNameOfBusinessLicense);
				else if(imageBusinessLicense != null && imageBusinessLicense.length() != 0)
					vb.setImageBusinessLicense(saveImage(imageBusinessLicense) + ".jpg");
				if(imgNameOfPoliceProve != null && imgNameOfPoliceProve.length() != 0)
					vb.setImagePoliceProve(imgNameOfPoliceProve);
				else if(imagePoliceProve != null && imagePoliceProve.length() != 0)
					vb.setImagePoliceProve(saveImage(imagePoliceProve) + ".jpg");
				if(imgNameOfIdCard != null && imgNameOfIdCard.length() != 0)
					vb.setImageIdCard(imgNameOfIdCard);
				else if(imageIdCard != null && imageIdCard.length() != 0)
					vb.setImageIdCard(saveImage(imageIdCard) + ".jpg");
				vb.setCompanyAddress(companyAddress);
				vb.setCompanyName(companyName);
				vb.setName(name); //姓名
				verifyBusinessService.save(vb);
				m.put("success", true);
				m.put("msg", "您已成功申请,管理员会尽快处理!");
			} catch (Exception e) {
				e.printStackTrace();
				m.put("success", false);
				m.put("msg", "申请失败,请确认完善信息稍后重试!");
			}
		}
		Utils.senchaview(m);
		jsonViewIE(m);
	}
	
	/**
	 * 上传图片公共方法
	 * @param ImageData
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	private String saveImage(String ImageData) throws IOException {
		String sname = "";
		BASE64Decoder decode = new BASE64Decoder();
		if (ImageData != null) {
			byte[] b = decode.decodeBuffer(ImageData);
			for (int i = 0; i < b.length; i++) {
				if(b[i]<0){
					b[i]+=256;
				}
			}
			String saved =getRequest().getRealPath("/")+"/file/verify/";
			System.out.println(saved);
			sname =Utils.getNewUUID().replaceAll("-", "");
			File f =new File(saved);
			if(!f.exists()){
				f.mkdir();
			}
			saved=saved+sname+".jpg";
			OutputStream out =new FileOutputStream(new File(saved));
			out.write(b);
			out.flush();
			out.close();
		}
		return sname;
	}
	
	/**
	 * 分页查询同行
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void getPeersByPage() throws IOException {
		String[] path2 = path1.toString().split(path);
		String realPath = path2[0] + path + "/file/verify/"; //同行图片路径
		Map m = new HashMap();
		verifyBusinessService.findPeersByPage(m, page, rows, verify, order, sort, realPath);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 通过审核同行(1)
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void passVerify() throws IOException {
		Map m = new HashMap();
		verifyBusinessService.passVerify(idlist[0]);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 拒绝审核同行(2)
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void refuseVerify() throws IOException {
		Map m = new HashMap();
		verifyBusinessService.refuseVerify(idlist[0]);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}
	
	/**
	 * 删除同行
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void deletePeers() throws IOException {
		Map m = new HashMap();
		verifyBusinessService.deletePeers(idlist);
		m.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(m);
	}

	
	public String getAccount() {
		return account;
		
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getVerifyPassword() {
		return verifyPassword;
	}

	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public String[] getIdlist() { return idlist; }
	 * 
	 * public void setIdlist(String[] idlist) { this.idlist = idlist; }
	 */

	public User getOperator() {
		return operator;
	}

	public void setOperator(User operator) {
		this.operator = operator;
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

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public IUserService getUserService() {
		return userService;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getImgData() {
		return ImgData;
	}

	public void setImgData(String imgData) {
		ImgData = imgData;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getCoins() {
		return coins;
	}

	public void setCoins(long coins) {
		this.coins = coins;
	}

	public String getCarCountry() {
		return carCountry;
	}

	public void setCarCountry(String carCountry) {
		this.carCountry = carCountry;
	}

	public ICarService getCarService() {
		return carService;
	}

	public void setCarService(ICarService carService) {
		this.carService = carService;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getCarIndex() {
		return carIndex;
	}

	public void setCarIndex(String carIndex) {
		this.carIndex = carIndex;
	}

	public IResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public void setOperatorService(IOperatorService operatorService)
	{
		this.operatorService = operatorService;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IOperatorService getOperatorService() {
		return operatorService;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getImageBusinessLicense() {
		return imageBusinessLicense;
	}

	public void setImageBusinessLicense(String imageBusinessLicense) {
		this.imageBusinessLicense = imageBusinessLicense;
	}

	public String getImagePoliceProve() {
		return imagePoliceProve;
	}

	public void setImagePoliceProve(String imagePoliceProve) {
		this.imagePoliceProve = imagePoliceProve;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public IVerifyBusinessService getVerifyBusinessService() {
		return verifyBusinessService;
	}

	public void setVerifyBusinessService(
			IVerifyBusinessService verifyBusinessService) {
		this.verifyBusinessService = verifyBusinessService;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
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

	public int getVerify() {
		return verify;
	}

	public void setVerify(int verify) {
		this.verify = verify;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getImageIdCard() {
		return imageIdCard;
	}

	public void setImageIdCard(String imageIdCard) {
		this.imageIdCard = imageIdCard;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	public String getImgNameOfIdCard() {
		return imgNameOfIdCard;
	}

	public void setImgNameOfIdCard(String imgNameOfIdCard) {
		this.imgNameOfIdCard = imgNameOfIdCard;
	}

	public String getImgNameOfBusinessLicense() {
		return imgNameOfBusinessLicense;
	}

	public void setImgNameOfBusinessLicense(String imgNameOfBusinessLicense) {
		this.imgNameOfBusinessLicense = imgNameOfBusinessLicense;
	}

	public String getImgNameOfPoliceProve() {
		return imgNameOfPoliceProve;
	}

	public void setImgNameOfPoliceProve(String imgNameOfPoliceProve) {
		this.imgNameOfPoliceProve = imgNameOfPoliceProve;
	}

	public IVipService getVipService() {
		return vipService;
	}

	public void setVipService(IVipService vipService) {
		this.vipService = vipService;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
