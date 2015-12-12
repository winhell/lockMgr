package com.lockMgr.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Userrole;
import com.lockMgr.pojo.VerifyBusiness;
import com.lockMgr.pojo.Vip;
import com.lockMgr.util.Encrypt;
import com.lockMgr.util.OpenfireEncrytionAndDecryption;
import com.lockMgr.util.OpenfireofuserHandle;
import com.lockMgr.util.StatusEnum;

public class UserService extends BaseDao<User> implements IUserService
{
	private IUserRoleService userRoleService;
	private IOperatorService operatorService;
	private IVipService vipService;
	private IBusinessService businessService;
	private IVerifyBusinessService verifyBusinessService;
	

	@Override
	public void getUserByPage(Map map, int page, int pageSize, String account,
			String roleId, Operator oper)
	{
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		List<NameAndId> roleList = userRoleService.getAllRoleNameAndId(oper);
		String hql = " from User u  where  status!=" + StatusEnum.disable.ordinal();
		if (roleId != null && roleId.length() != 0)
		{
			hql += " and userRoleId=?";
			al.add(roleId);
			paramNums++;

		}
		if (null != account && account.length() != 0)
		{
			hql += " and account like ?";
			al.add("%" + account + "%");
			paramNums++;
		}
		
		Object[] values = (Object[]) al.toArray(new Object[paramNums]);
		Long count = getCount(hql, values);
		List<User> operatorList = findByPage(hql, values,
				(page - 1) * pageSize, pageSize);
		// fillPagetoMap(map, hql, values, page, pageSize);
		for (User temp : operatorList)
		{
			// String roleid=temp.getRoleId().toString();
			if (null != temp.getUserRoleId()
					&& temp.getUserRoleId().length() != 0)
			{
				String roleid = temp.getUserRoleId().toString();
				for (NameAndId roleTemp : roleList)
				{
					String id = roleTemp.getId().toString();
					if (roleid.equals(id))
					{
						temp.setUserRoleName(roleTemp.getName().toString());
						break;
					}
				}
			}
		}
		//查询用户是否会员，是会员列出开通日期
		if(operatorList != null && operatorList.size() != 0) {
			for(int i=0; i<operatorList.size(); i++) {
				User user = operatorList.get(i);
				if(user != null) {
					//如果是会员就赋值会员日期
					List<Vip> vipList = vipService.isVIP(user.getId());
					if(vipList != null && vipList.size() != 0) {
						user.setVipTime(vipList.get(0).getCreatetime());
					}
					//给性别赋值具体中文字符
					if(user.getGender() == false) 
						user.setGenderName("女");
					else if(user.getGender() == true)
						user.setGenderName("男");
				}
			}
		}
		//最后检查地址
		operatorList = getAddressByUserList(operatorList);
		map.put("total", count);
		map.put("rows", operatorList);
	}
	
	/*
	 * 对用户集合查询地址
	 * 1.根据userId从商户表(bussiness)中查询,得到地址
	 * 2.如果商户表中没有地址就从同行表(verifyBussiness)中查询
	 */
	private List<User> getAddressByUserList(List<User> userList) {
		if(userList != null && userList.size() != 0) {
			for(int i=0; i<userList.size(); i++) {
				List<Business> businessList = businessService.find(" from Business where userId=? ", 
						new Object[]{userList.get(i).getId()});
				if(businessList != null && businessList.size() != 0) {  //如果商户有地址
					Business business = businessList.get(0);
					if(business.getAddress() != null && business.getAddress().length() != 0) {
						userList.get(i).setAddress(business.getAddress());
					} else {  //否则就检查同行(如果同行还没就不显示)
						List<VerifyBusiness> vbList = verifyBusinessService.find(
								" from VerifyBusiness where userId=? ", new Object[]{userList.get(i).getId()});
						if(vbList != null && vbList.size() != 0) {
							VerifyBusiness vb = vbList.get(0);
							if(vb.getCompanyAddress() != null && vb.getCompanyAddress().length() != 0)
								userList.get(i).setAddress(vb.getCompanyAddress());
						}
					}
				} else {  //否则就检查同行(如果同行还没就不显示)
					List<VerifyBusiness> vbList = verifyBusinessService.find(
							" from VerifyBusiness where userId=? ", new Object[]{userList.get(i).getId()});
					if(vbList != null && vbList.size() != 0) {
						VerifyBusiness vb = vbList.get(0);
						if(vb.getCompanyAddress() != null && vb.getCompanyAddress().length() != 0)
							userList.get(i).setAddress(vb.getCompanyAddress());
					}
				}
			}
		}
		return userList;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}
	
	public void setUserRoleService(IUserRoleService userRoleService)
	{
		this.userRoleService = userRoleService;
	}

	public IOperatorService getOperatorService() {
		return operatorService;
	}
	
	public void setOperatorService(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}

	@Override
	public int txSave(Operator operator, User OperatorToSave) {
		int value = 0; // 标示保存操作是否成功。1为成功，0为失败
		OperatorToSave.setId(null);
		if (OperatorToSave.getUserRoleId() == null || OperatorToSave.getUserRoleId().length() == 0) {
			OperatorToSave.setUserRoleId(operator.getRoleId());
		}
		OperatorToSave.setStatus(StatusEnum.initialize.ordinal());
		
		String password = OperatorToSave.getPassword().toString();
		String mingwen=new String(password);
		/*
		 * OpenfireEncrytionAndDecryption.getEncryPWD(password)
		 * 不知道该加密方式什么情况，同样的密码，不同时间加密之后的显示不同
		 */
	//	OperatorToSave.setPassword(OpenfireEncrytionAndDecryption.getEncryPWD(password)); //openfire加密
		OperatorToSave.setPassword(Encrypt.encryptPassword(password));
		if (!checkAccountWhetherExist(OperatorToSave.getAccount(),OperatorToSave.getId())) {
			OperatorToSave.setImage("default.jpg");
			OperatorToSave.setCoinsTime(Utils.getNow());  //初始化打卡时间
			save(OperatorToSave);
			
			OpenfireofuserHandle.addOfuser(OperatorToSave.getAccount(), 	mingwen); // 添加openfire用户
			
			operatorService.txCommonOperator(OperatorToSave.getId(),
					OperatorToSave.getAccount(), OperatorToSave.getPassword(), OperatorToSave.getUserRoleId());
			// 添加后台登入用户
			if (operator != null) {
				writeLog(operator, "添加", "会员", OperatorToSave);
			}
			value = 1;
		}
		return value;
	}

	@Override
	public void txDel(Operator operator, String[] idlist)
	{
		for (String id : idlist)
		{
			User oper = this.findById(id);
			// oper.setStatus(StatusEnum.disable.ordinal());
			// saveOrUpdate(oper);
			delete(oper);
			operatorService.delete(id);
			OpenfireofuserHandle.delOfuser(oper.getAccount());
			writeLog(operator, "删除", "会员", oper);
			// delete(id);
		}
	}

	@Override
	public boolean txUpdate(Operator oper, User operator, String id)
	{
		User oldOper = findById(id);
		if (checkAccountWhetherExist(operator.getAccount(), operator.getId()))
		{
			// oldOper.setAccount(operator.getAccount());
			// oldOper.setPassword(Encrypt.encryptPassword(operator.getPassword()));
			// oldOper.setComment(operator.getComment());
			// oldOper.setName(operator.getName());
			operator.setId(id);
			OpenfireofuserHandle.updateOfuser(oldOper.getAccount(),
					operator.getAccount(), operator.getPassword());

			operator.setPassword(OpenfireEncrytionAndDecryption
					.getEncryPWD(operator.getPassword()));

			saveOrUpdate(operator);

			writeLog(oper, "修改", "会员", operator);
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean checkAccountWhetherExist(String account, String id)
	{
		long oper_flag = getCount("select count(*) from User where  status!="
				+ StatusEnum.disable.ordinal() + " and account='" + account
				+ "' and id!='" + id + "'");
		if (oper_flag == 0)
		{
			return false;
		}
		else
		{
			return true;
		}

	}

	public User verifyUser(String account, String password)
	{
		Object[] obj = new Object[1];
		obj[0] = account;
		// obj[1] =password;
		User u = (User) uniqueResult("from User u where u.account=?", obj);
		if (u != null)
		{
			if (password != null
					&& password.equals(OpenfireEncrytionAndDecryption
							.getDecryptPWD(u.getPassword())))
			{
				return u;
			}
			else
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * 根据用户名查询该用户信息
	 */
	public User findUserByAccount(String account)
	{
		String hql = " from User user where user.account=? ";
		User user = (User) uniqueResult(hql, new Object[] { account });
		return user;
	}

	/**
	 * 根据邮箱查询该用户信息
	 */
	public User findUserByEmail(String email)
	{
		String hql = " from User where email=? ";
		User user = (User) uniqueResult(hql, new Object[] { email });
		return user;
	}

	public static void main(String[] args)
	{

	}

	/**
	 * 注册判断是否重名(用户名和邮箱两者判断) 返回true:表示有重复 返回false:表示无重复
	 */
	public boolean checkingUser(String account, String email)
	{
		List<User> userList = listAll();
		for (int i = 0; i < userList.size(); i++)
		{
			String existAccount = userList.get(i).getAccount(); // 数据库已经注册的用户名
			String existEmail = userList.get(i).getEmail(); // 数据库已经注册的邮箱
			if (account.equals(existAccount) == true
					|| email.equals(existEmail) == true)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 普通用户升级为商户
	 */
	public void txUpgradeCommonToStore(String userId) {
		User user = findById(userId);
		if(user != null) {
			List<Userrole> ul = userRoleService.find(" from Userrole where name='验证会员' ");
			if(ul != null && ul.size() != 0) {
				user.setUserRoleId(ul.get(0).getId());
				saveOrUpdate(user);
			}
		}
	}
	
	/**
	 * 检查用户角色
	 */
	public String checkUserrole(String userId) {
		User user = findById(userId);
		String userroleId = user.getUserRoleId();
		String userroleName = userRoleService.findById(userroleId).getName();
		return userroleName;
	}
	
	/**
	 * 完善会员信息
	 */
	public void editUser(String id, String name, String account, boolean gender, String phone, 
			Date birthday, String email, String userRoleId, String comment, String image) {
		User user = findById(id);
		user.setName(name);
		user.setAccount(account);
		user.setGender(gender);
		user.setPhone(phone);
		user.setBirthday(birthday);
		user.setEmail(email);
		user.setUserRoleId(userRoleId);
		user.setComment(comment);
		user.setImage(image);
		saveOrUpdate(user);
		//operator表也要相应修改
		Operator oper = operatorService.findById(id);
		if(oper != null) {
			oper.setAccount(account);
			oper.setComment(comment);
			oper.setName(name);
			oper.setRoleId(userRoleId);
			operatorService.saveOrUpdate(oper);
		}
	}
	
	/**
	 * 根据邮箱查询用户
	 */
	public User findByUserByEmail(String email) {
		return (User) find(" find User where email=? ", new Object[]{email});
	}
	
	/**
	 * 修改密码
	 */
	public void updatePassword(String userId, String password) {
		User user = findById(userId);
		user.setPassword(Encrypt.encryptPassword(password));
		saveOrder(user);
		//还要修改operator表中密码
		operatorService.updatePassword(userId, password);
	}
	
	/**
	 * 判断用户是否vip
	 * (这里是在userrole表中查询出vip角色的id与用户角色id对比判断该用户是否vip)
	 * 另外在vipService中也有个判断是否vip的方法,返回是vip集合
	 */
	public boolean isVIP(String userId) {
		User user = findById(userId);
		if(user != null) {
			//会员角色
			List<Userrole> list =  userRoleService.find(" from Userrole where name='VIP会员' ");
			Userrole userrole = list.get(0);
			if(userrole != null) {
				//如果该用户角色id和上面查询出来的"VIP会员"角色id相同的话，该用户就是会员了
				if(user.getUserRoleId() == userrole.getId())
					return true;
				else 
					return false;
			}
		}
		return false;
	}

	public IVipService getVipService() {
		return vipService;
	}

	public void setVipService(IVipService vipService) {
		this.vipService = vipService;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public IVerifyBusinessService getVerifyBusinessService() {
		return verifyBusinessService;
	}

	public void setVerifyBusinessService(
			IVerifyBusinessService verifyBusinessService) {
		this.verifyBusinessService = verifyBusinessService;
	}
	
}
