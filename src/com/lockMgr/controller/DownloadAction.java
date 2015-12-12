package com.lockMgr.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Resource;
import com.lockMgr.pojo.Resourceofsoftware;
import com.lockMgr.pojo.User;
import com.lockMgr.service.IResourceOfSoftwareService;
import com.lockMgr.service.IResourceService;
import com.lockMgr.service.IUserService;

public class DownloadAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private String resourceId;
	private String userId;
	private String isType; // Y：有类型(resource)，N：无类型(Resourceofsoftware)
	private String fileName;

	String path = ServletActionContext.getServletContext().getContextPath()
			+ "/";

	private IResourceService resourceService;
	private IResourceOfSoftwareService resourceOfSoftwareService;
	private IUserService userService;

	/**
	 * 下载现在分两类： 1.分车类的Resource 2.不分车类的"软件下载"Resourceofsoftware
	 */
	@SuppressWarnings({ "deprecation", "rawtypes", "unchecked" })
	public void downloadLock() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		String servpaths = getRequest().getRealPath("/"); // E:\apache-tomcat-7.0.54\webapps\lockMgr\
		Map json = new HashMap();
		String address = null; // 初始化资源地址
		int oCoins = 0; // 初始化资源下载金币数
		String chineseName; // 初始化文件名
		User user = userService.findById(userId);
		long userCoins = user.getCoins(); // 该用户金币数
		/**
		 * 首先判断资源是有类型的(Resource)还是无类型的(Resourceofsoftware)
		 */
		// 如果isType为Y即为有类型的资源(Resource)
		if (isType != null && isType.equals("Y")) {
			Resource resource = resourceService.findById(resourceId);
			oCoins = resource.getScore(); // 下载该资源所需金币数
			address = resource.getAddress();
			chineseName = resource.getTitle();
			/**
			 * 再判断用户角色(普通用户下载需扣除金币数，VIP直接下载)
			 */
			if (userService.isVIP(userId)) {
				download(resourceId, address, chineseName, response, servpaths);
				resource.setDownloadNum(resource.getDownloadNum() + 1);
				resourceService.saveOrUpdate(resource); // 下载次数+1
				json.put("success", true);
			} else {
				if (userCoins < oCoins) {
					json.put("success", false);
					json.put("msg", "您的金币数不够！！");
					Utils.senchaview(json);
				} else {
					download(resourceId, address, chineseName, response, servpaths);
					resource.setDownloadNum(resource.getDownloadNum() + 1);
					resourceService.saveOrUpdate(resource); // 下载次数+1
					user.setCoins(userCoins - oCoins);
					userService.saveOrUpdate(user); // 不是VIP要扣除相应金币数
					json.put("success", true);
				}
			}
		}
		// 否则isType为N即为无类型的软件下载资源(Resourceofsoftware)
		else if (isType != null && isType.equals("N")) {
			Resourceofsoftware rs = resourceOfSoftwareService.findById(resourceId);
			oCoins = rs.getScore();
			address = rs.getAddress();
			chineseName = rs.getTitle();
			/**
			 * 再判断用户角色(普通用户下载需扣除金币数，VIP直接下载)
			 */
			if (userService.isVIP(userId)) {
				download(resourceId, address, chineseName, response, servpaths);
				rs.setDownloadNum(rs.getDownloadNum() + 1);
				resourceOfSoftwareService.saveOrUpdate(rs);  // 下载次数+1
				json.put("success", true);
			} else {
				if (userCoins < oCoins) {
					json.put("success", false);
					json.put("msg", "您的金币数不够！！");
					Utils.senchaview(json);
				} else {
					download(resourceId, address, chineseName, response, servpaths);
					rs.setDownloadNum(rs.getDownloadNum() + 1);
					resourceOfSoftwareService.saveOrUpdate(rs);  // 下载次数+1
					user.setCoins(userCoins - oCoins);
					userService.saveOrUpdate(user); // 不是VIP要扣除相应金币数
					json.put("success", true);
				}
			}
		}

	}

	/**
	 * @param resourceId  资源id
	 * @param address  资源地址
	 * @param chineseName  资源名称
	 */
	private void download(String resourceId, String address, String chineseName,
			HttpServletResponse response, String serverPath) throws IOException {
		PrintWriter out = null;
		File f = null;
		FileInputStream fis = null;
		BufferedInputStream buff = null;
		OutputStream os = null;
		try {
			fileName = address; // !/lockMgr/file/resource/14080309254991.txt
			out = response.getWriter();
			// f = new File(servpaths + "/file/" + fileName);
			String[] fn = fileName.split(path);
			f = new File(serverPath + "/" + fn[1]);
			if (f.exists()) {
				response.reset();
				// this.fileName = new String(this.fileName.getBytes("iso-8859-1"), "iso-8859-1");
				this.fileName = new String(this.fileName.getBytes(),
						"iso-8859-1");
				response.setContentType("application/x-msdownload");
				response.setHeader("Content-disposition",
						"attachment; filename=\"" + chineseName + "\"");
				// response.setHeader( "Content-Disposition",
				// "attachment;filename="+new
				// String(filename.getBytes("gb2312"), "ISO8859-1" ) );
				// response.addHeader(" Content-Length ", "" + f.length());
				fis = new FileInputStream(f);
				buff = new BufferedInputStream(fis);
				byte[] b = new byte[1024];
				long k = 0;
				os = response.getOutputStream();
				while (k < f.length()) {
					int j = buff.read(b, 0, 1024);
					k += j;
					os.write(b, 0, j);
				}
			} else {
				System.err.println("文件不存在！");
				response.sendError(404, "File not found!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			if (os != null) {
				os.flush();
				os.close();
			}
			if (buff != null) {
				buff.close();
			}
			if (fis != null) {
				fis.close();
			}
			if (out != null) {
				out.flush();
				out.close();
			}
		}
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public IResourceService getResourceService() {
		return resourceService;
	}

	public void setResourceService(IResourceService resourceService) {
		this.resourceService = resourceService;
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getIsType() {
		return isType;
	}

	public void setIsType(String isType) {
		this.isType = isType;
	}

	public IResourceOfSoftwareService getResourceOfSoftwareService() {
		return resourceOfSoftwareService;
	}

	public void setResourceOfSoftwareService(
			IResourceOfSoftwareService resourceOfSoftwareService) {
		this.resourceOfSoftwareService = resourceOfSoftwareService;
	}

}
