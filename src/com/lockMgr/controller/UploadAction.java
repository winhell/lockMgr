package com.lockMgr.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.lockMgr.util.KeyEnum;
import com.opensymphony.xwork2.ActionContext;

public class UploadAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6382684172085779788L;
	private File filedata;
	private String filename;
	private String contentType;
	private String filedataFileName, filedataContentType;
	private String type;
	private long imageMaxSize = 2048000;
	private long fileMaxSize = 1024*1024*1024;  //最大文件大小1G(第一个1024代表字节向K转换)
	private final static String IMG_EXT = "jpg|gif|png";
	private final static String LINK_EXT = "zip|rar|txt|doc|xls|ppt";
	private static String UPLOAD_PATH = "/uploadFiles/img";
	
	private String uploadImgType;

	// private File file;
	// private String fileFileName;
	// private String fileContentType;
	
	/**
	 * xheditor富文本上传图片
	 */
	public void uploadOfXheditor() throws IOException
	{
		String catalog = "";
		Map<String, String> json = new HashMap<String, String>();
		if ("link".equals(type))
		{
			catalog = "resource"; // 上传供下载资源
			UPLOAD_PATH="file/resource";
		}
		if ("img".equals(type))
		{
			catalog = "img";
			UPLOAD_PATH = "/file/img";
		}
			ServletContext context = (ServletContext) (ActionContext
					.getContext().get(ServletActionContext.SERVLET_CONTEXT));
			String path = context.getRealPath(UPLOAD_PATH);
			String newFileName = getRandomFilename(filedataFileName);
			File target = new File(path, newFileName);
			try
			{
				if (filedata.length() > fileMaxSize)
				{
					json.put(KeyEnum.STATUS.name(), "failed");
					json.put("err", "文件大小超过1G!");
					json.put("msg", "");
					json.put(KeyEnum.REASON.name(), "文件大小超过1G!");
					System.out.println(filedata.length()+","+fileMaxSize);  //File.length() 的单位是字节(B)
				}
				else
				{
					//Thumbnails.of(filedata).size(340, 200).toFile(target);
					FileUtils.copyFile(filedata, target);  //一步上传
					json.put(KeyEnum.STATUS.name(), "success");
					 json.put("err", "");
					json.put("msg", "!/lockMgr/file/" + catalog + "/"
							+ newFileName);
					System.out.println(filedata.length()+","+fileMaxSize);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
				json.put(KeyEnum.STATUS.name(), "failed");

				json.put("err", "文件上传失败！");
				json.put("msg", "");
				json.put(KeyEnum.REASON.name(), "文件上传失败!");
			}
		jsonViewIE(json);
	}

	public String upload() throws IOException
	{
		String extAllowed = null;
		String catalog = "";
		Map<String, String> json = new HashMap<String, String>();
		if ("link".equals(type))
		{
			extAllowed = LINK_EXT;
			catalog = "resource"; // 上传供下载资源
			UPLOAD_PATH="/file/resource";
		}
		if ("img".equals(type))
		{
			extAllowed = IMG_EXT;
			catalog = "img";
			UPLOAD_PATH = "/file/img";
		}
		//不需要判断文件类型
		/*if (!isExtAllow(filedataFileName, extAllowed))
		{
			json.put(KeyEnum.STATUS.name(), "failed");
			json.put("err", "文件类型错误!");
			json.put("msg", "");
			json.put(KeyEnum.REASON.name(), "文件类型错误!");
		}*/
			ServletContext context = (ServletContext) (ActionContext
					.getContext().get(ServletActionContext.SERVLET_CONTEXT));

			String path = context.getRealPath(UPLOAD_PATH);
			String newFileName = getRandomFilename(filedataFileName);
			File target = new File(path, newFileName);
			try
			{
				if (filedata.length() > fileMaxSize)
				{
					json.put(KeyEnum.STATUS.name(), "failed");
					json.put("err", "文件大小超过1G!");
					json.put("msg", "");
					json.put(KeyEnum.REASON.name(), "文件大小超过1G!");
					System.out.println(filedata.length()+","+fileMaxSize);  //File.length() 的单位是字节(B)
				}
				else
				{
					//Thumbnails.of(filedata).size(340, 200).toFile(target);
					FileUtils.copyFile(filedata, target);  //一步上传
					/**
					 * 现在需要分步实现查看下载进度功能
					 */
//					long M = 0;  //判断文件一共多少M
//					if(filedata.length() % 1024 == 0)
//						M = filedata.length() / 1024;
//					else
//						M = filedata.length() / 1024 + 1;
//					for(int i=0; i<filedata.length(); i++) {
//						FileUtils.copy
//					}
					json.put(KeyEnum.STATUS.name(), "success");
					 json.put("err", "");
					json.put("msg", "!/lockMgr/file/" + catalog + "/"
							+ newFileName);
					System.out.println(filedata.length()+","+fileMaxSize);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
				json.put(KeyEnum.STATUS.name(), "failed");

				json.put("err", "文件上传失败！");
				json.put("msg", "");
				json.put(KeyEnum.REASON.name(), "文件上传失败!");
			}
		/*
		 * getResponse().setContentType("text/html;charset=utf-8"); PrintWriter
		 * writer = ServletActionContext.getResponse().getWriter(); ObjectMapper
		 * mapper = new ObjectMapper(); SimpleDateFormat format = new
		 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 * mapper.getSerializationConfig().setDateFormat(format);
		 * mapper.writeValue(writer, json);
		 */

		jsonViewIE(json);
		return null;
	}

	public String uploadImg() throws IOException
	{
		if (!filedataContentType.contains("image"))
		{
			jsonViewIE("1");
			return null;
		}
		if (filedata.length() > imageMaxSize)
		{
			jsonViewIE("2");
			return null;
		}
		String newFileName = getRandomFilename(filedataFileName);
		String path = null;
		/**
		 * AjaxUpload 中data,scriptData都传不了参数过来,要改变目录存储目前只有写过个方法
		 */
		/*if(uploadImgType == "rotatePicture") //如果是"滚动图片(广告)"
			path = ServletActionContext.getServletContext().getRealPath("file/rotatePicture/");
		else	*/
			path = ServletActionContext.getServletContext().getRealPath("/file/img/");
		FileOutputStream out;
		try
		{
			out = new FileOutputStream(path + "/" + newFileName);
			FileInputStream in = new FileInputStream(filedata);
			byte[] buffer = new byte[200];
			filedata.length();
			int length = 0;
			while (-1 != (length = in.read(buffer, 0, 200)))
			{
				out.write(buffer);
			}
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			jsonViewIE("3");
			return null;
			// e.printStackTrace();
		}
		jsonViewIE(newFileName);
		return null;
	}
	
	//上传申请同行图片
	public String uploadImgOfVerifyBusiness() throws IOException
	{
		if (!filedataContentType.contains("image"))
		{
			jsonViewIE("1");
			return null;
		}
		if (filedata.length() > imageMaxSize)
		{
			jsonViewIE("2");
			return null;
		}
		String newFileName = getRandomFilename(filedataFileName);
		String path = ServletActionContext.getServletContext().getRealPath("/file/verify/");
		FileOutputStream out;
		try
		{
			out = new FileOutputStream(path + "/" + newFileName);
			FileInputStream in = new FileInputStream(filedata);
			byte[] buffer = new byte[200];
			filedata.length();
			int length = 0;
			while (-1 != (length = in.read(buffer, 0, 200)))
			{
				out.write(buffer);
			}
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			jsonViewIE("3");
			return null;
			// e.printStackTrace();
		}
		jsonViewIE(newFileName);
		return null;
	}
	
	//上传广告图片,滚动图片
	public String uploadImgOfAdvertisement() throws IOException
	{
		if (!filedataContentType.contains("image"))
		{
			jsonViewIE("1");
			return null;
		}
		if (filedata.length() > imageMaxSize)
		{
			jsonViewIE("2");
			return null;
		}
		String newFileName = getRandomFilename(filedataFileName);
		String path = ServletActionContext.getServletContext().getRealPath("/file/rotatePicture/");
		FileOutputStream out;
		try
		{
			out = new FileOutputStream(path + "/" + newFileName);
			FileInputStream in = new FileInputStream(filedata);
			byte[] buffer = new byte[200];
			filedata.length();
			int length = 0;
			while (-1 != (length = in.read(buffer, 0, 200)))
			{
				out.write(buffer);
			}
			out.close();
			in.close();
		}
		catch (Exception e)
		{
			jsonViewIE("3");
			return null;
			// e.printStackTrace();
		}
		jsonViewIE(newFileName);
		return null;
	}

	static public String getRandomFilename(String filename)
	{
		String extension = filename.substring(filename.lastIndexOf("."));
		DateFormat format = new SimpleDateFormat("yyMMddHHmmss");
		String nameHeader = format.format(new Date());
		return nameHeader + new Random().nextInt(100) + extension;
	}

	private Boolean isExtAllow(String filename, final String ext)
	{
		String extension = filename.substring(filename.lastIndexOf("."))
				.toLowerCase().substring(1);
		String[] exts = ext.split("\\|");
		for (String item : exts)
		{
			if (item.equals(extension))
				return true;
		}
		return false;
	}
	
	public void setFiledataFileName(String filedataFileName)
	{
		this.filedataFileName = filedataFileName;
	}

	public String getFiledataFileName()
	{
		return filedataFileName;
	}

	public void setFiledataContentType(String filedataContentType)
	{
		this.filedataContentType = filedataContentType;
	}

	public String getFiledataContentType()
	{
		return filedataContentType;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public String getType()
	{
		return type;
	}

	public void setFiledata(File filedata)
	{
		this.filedata = filedata;
	}

	public File getFiledata()
	{
		return filedata;
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	public String getContentType()
	{
		return contentType;
	}

	public void setContentType(String contentType)
	{
		this.contentType = contentType;
	}

	public String getUploadImgType() {
		return uploadImgType;
	}

	public void setUploadImgType(String uploadImgType) {
		this.uploadImgType = uploadImgType;
	}

	
	/*
	 * public File getFile() { return file; } public void setFile(File file) {
	 * this.file = file; } public String getFileFileName() { return
	 * fileFileName; } public void setFileFileName(String fileFileName) {
	 * this.fileFileName = fileFileName; } public String getFileContentType() {
	 * return fileContentType; } public void setFileContentType(String
	 * fileContentType) { this.fileContentType = fileContentType; }
	 */

}
