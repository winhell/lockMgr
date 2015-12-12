package com.lockMgr.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 文件下载servlet
 * @author lzc
 *
 */
public class FileDownServlet extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=GBK";
	public void init() throws ServletException {
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		response.setContentType(CONTENT_TYPE);
		String fileName = new String(request.getParameter("fileName").getBytes("iso-8859-1"), "gbk");
		File file = new File("http://localhost:8080/lockMgr/lockFile/"+fileName);
		response.setContentType("application/x-msdownload");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("gbk"),"iso-8859-1"));
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream buff = new BufferedInputStream(fis);
		byte[] b = new byte[1024];
		long k = 0;
		OutputStream out = response.getOutputStream();
		while(k < file.length()) {
			int j = buff.read(b,0,1024);
			k += j;
			out.write(b, 0, j);
		}
		out.flush();
		
		
		
	}

}
