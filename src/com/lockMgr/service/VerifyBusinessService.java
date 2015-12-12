package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.pojo.Userrole;
import com.lockMgr.pojo.VerifyBusiness;

@SuppressWarnings("unchecked")
public class VerifyBusinessService extends BaseDao<VerifyBusiness> implements IVerifyBusinessService {
	
	private IUserService userService;
	private IOperatorService  operatorService;
	private IUserRoleService userRoleService;
	
	/**
	 * 分页查询同行
	 */
	@SuppressWarnings("rawtypes")
	public void findPeersByPage(Map m, int page, int pageSize, int verify,
			String orderType, String sortAttr, String path) {
		
		int paramNums = 0;
		List<Object> list = new ArrayList<Object>();
		String hql = " from VerifyBusiness where 1=1 ";
		if(verify != -1){
			hql += " and verify=? ";
			list.add(verify);
			paramNums ++;
		}
		if(orderType != null && sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += " order by createtime desc ";
		}
		Object[] values = list.toArray(new Object[paramNums]);
//		fillPagetoMap(m, hql, values, page, pageSize);
		
		Long count = getCount(hql, values);
		List<VerifyBusiness> vbList = findByPage(hql, values, (page-1)*pageSize, pageSize);
		if(vbList != null && vbList.size() != 0) {
			for(int i=0; i<vbList.size(); i++) {
				VerifyBusiness vb = vbList.get(i);
				vb.setImageBusinessLicense(path + vb.getImageBusinessLicense());
				vb.setImagePoliceProve(path + vb.getImagePoliceProve());
				vb.setImageIdCard(path + vb.getImageIdCard());
			}
		}
		m.put("total", count);
		m.put("rows", vbList);
	}
	
	/**
	 * 通过审核
	 */
	public void passVerify(String id) {
		VerifyBusiness vb = findById(id);
		vb.setVerify(1);
		saveOrder(vb);
		/**
		 * 另外把该用户角色修改为同行(user,operator表都要修改)
		 */
		List<Userrole> userRoleList = userRoleService.find(" from Userrole where name='同行' ");
		if(userRoleList != null && userRoleList.size() != 0) {
			String tonghangId = userRoleList.get(0).getId();  //同行角色id
			User user = userService.findById(vb.getUserId());
			user.setUserRoleId(tonghangId);
			userService.saveOrUpdate(user);
			Operator opera = operatorService.findById(vb.getUserId());
			opera.setRoleId(tonghangId);
			operatorService.saveOrUpdate(opera);
		}
	}
	
	/**
	 * 拒绝审核
	 */
	public void refuseVerify(String id){
		VerifyBusiness vb = findById(id);
		vb.setVerify(2);
		saveOrder(vb);
	}
	
	/**
	 * 删除同行
	 */
	public void deletePeers(String[] id) {
		for(String i : id) {
			VerifyBusiness vb = findById(i);
			delete(vb);
		}
	}
	
	/**
	 * 判断用户是否为同行
	 * true : 是同行
	 * false : 不是同行
	 */
	public boolean isVerifyBusiness(String userId) {
		List<VerifyBusiness> list = find(" from VerifyBusiness where userId=? ", new Object[]{userId});
		if(list != null && list.size() != 0) {
			if(list.get(0).getVerify() == 1) 
				return true;
			else 
				return false;
		} else 
			return false;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public IUserRoleService getUserRoleService() {
		return userRoleService;
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public IOperatorService getOperatorService() {
		return operatorService;
	}

	public void setOperatorService(IOperatorService operatorService) {
		this.operatorService = operatorService;
	}
	
}
