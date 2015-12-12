/**
 * 
 */
package com.lockMgr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Business;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.Operator;
import com.lockMgr.service.IBusinessService;
import com.lockMgr.service.ILockService;
import com.lockMgr.service.IUserRoleService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

@SuppressWarnings({ "unchecked", "serial" })
public class lcokAction extends BaseAction
{
	private String name;
	private ILockService lockService;
	private Locks lock;
	private String[] idlist;
	private String id;
	private int page;
	private int rows;
	private String roleId;
	
	private String type;
	private String businessId;
	private String origin;
	private String order;
	private String sort;
	
	private IBusinessService businessService;
	
	/*private File file;
	private String fileFileName;
	private String fileContentType;

	
	public String uploadImg() throws IOException
	{
		if(!fileContentType.contains("image"))
		{
			jsonViewIE("1");
			return null;
		}
		if(file.length()>2048000)
		{
			jsonViewIE("2");
			return null;
		}
		if(!fileFileName.contains(".")||id==null||id.length()==0)
		{
			jsonViewIE("3");
			return null;
		}
		String newFileName=id+".jpg";
		//User user=userService.findById(id);
//		if(user!=null)
//		{
//			user.setImage(newFileName);
//			userService.saveOrUpdate(user);
//		}
		String path=ServletActionContext
		.getServletContext().getRealPath("file/img/");
		FileOutputStream  out= new FileOutputStream(path+"/"+newFileName);
		
		  FileInputStream in=new FileInputStream(file);
		
		  byte[] buffer = new byte[200];
			file.length();
			int length = 0;
			
			while(-1 != (length = in.read(buffer, 0, 200)))
			{
				out.write(buffer);
			}
			out.close();
			in.close();	
		  jsonViewIE(newFileName);
		return null;
	}*/
	
	@SuppressWarnings("rawtypes")
	public String getLockByPage() throws IOException
	{
		Map session = this.getSession();
		Operator operator = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();

		if (operator.getRoleName().equals("管理员"))
		{
			lockService.getLocksByPage(jsondata,page,rows,name,type,origin,businessId,order,sort);
		}
		else
		{
			lockService.getLocksByPage(jsondata,page,rows,name,type,origin,
					businessService.findBusinessIdByUserId(operator.getId()),order,sort);
			jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		}
		jsonViewIE(jsondata);

		return null;
	}

	public String addLock() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		/*
		 * 商户分三个等级(rating): 普通(0)，优先(1)，特级(2). 刚刚通过审核的商户为普通
		 * 按照谭的要求，普通商户不能上传商品
		 */
		List<Business> businessList = businessService.find(" from Business where userId=? ", new Object[]{oper.getId()});
		if(businessList.size() != 0 && businessList != null) {
			int rating = businessList.get(0).getRating();
			if(rating != 0) {  //rating != 0 : 该商户优先级不是0 -> 不是普通用户
				lock.setBusinessId(businessService.findBusinessIdByUserId(oper.getId()));
				lock.setStatus(1);
				lockService.txAddLockInfo(oper, lock);
				jsondata.put(KeyEnum.STATUS, StatusEnum.success);
				jsonViewIE(jsondata);
			} else {
				jsondata.put(KeyEnum.STATUS, StatusEnum.failed);
				jsondata.put(KeyEnum.REASON, "普通商户不能上传商品,请联系管理员修改权限后再次操作!");
			}
		} else {
			jsondata.put(KeyEnum.STATUS, StatusEnum.failed);
			jsondata.put(KeyEnum.REASON, "您还不是商户不能上传商品");
		}
		jsonViewIE(jsondata);
		Utils.senchaview(jsondata);
		return null;
	}

	public String deleteLock() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		lockService.txDel(oper, idlist);
		jsondata.put(KeyEnum.STATUS, StatusEnum.success);
		jsonViewIE(jsondata);
		return null;
	}

	public String editLock() throws IOException
	{
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		Map jsondata = new HashMap();
		StatusEnum status = StatusEnum.success;
		String reason = null;
			if (!lockService.txUpdate(oper, lock, id))
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
	 * 得到所有锁的id和name(团购html)
	 * @throws IOException 
	 */
	@SuppressWarnings("rawtypes")
	public void getAllLocksIdAndName() throws IOException {
		Map session = getSession();
		Operator oper = (Operator) session.get(KeyEnum.OPERATOR);
		jsonViewIE(lockService.getAllLocksIdAndName(oper));
	}

	public void setLockService(ILockService lockService)
	{
		this.lockService = lockService;
	}


	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	/*
	 * public String[] getIdlist() { return idlist; }
	 * 
	 * public void setIdlist(String[] idlist) { this.idlist = idlist; }
	 */


	public String getId()
	{
		return id;
	}

	public Locks getLock()
	{
		return lock;
	}

	public void setLock(Locks lock)
	{
		this.lock = lock;
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

	public String getRoleId()
	{
		return roleId;
	}

	public void setRoleId(String roleId)
	{
		this.roleId = roleId;
	}

	/*public File getFile()
	{
		return file;
	}

	public void setFile(File file)
	{
		this.file = file;
	}

	public String getFileFileName()
	{
		return fileFileName;
	}

	public void setFileFileName(String fileFileName)
	{
		this.fileFileName = fileFileName;
	}

	public String getFileContentType()
	{
		return fileContentType;
	}

	public void setFileContentType(String fileContentType)
	{
		this.fileContentType = fileContentType;
	}*/

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getBusinessId()
	{
		return businessId;
	}

	public void setBusinessId(String businessId)
	{
		this.businessId = businessId;
	}

	public String getOrigin()
	{
		return origin;
	}

	public void setOrigin(String origin)
	{
		this.origin = origin;
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

	public String[] getIdlist() {
		return idlist;
	}

	public void setIdlist(String[] idlist) {
		this.idlist = idlist;
	}

	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}

	public ILockService getLockService() {
		return lockService;
	}
  
}
