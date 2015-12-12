package com.lockMgr.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.StrutsStatics;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

public abstract class BaseAction extends ActionSupport {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	protected String forwardUrl;
	private String pageURL;
	private static final DateFormat format = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	private static final DateFormat formatShort = new SimpleDateFormat(
			"yyyy-MM-dd");
	private static ObjectMapper mapper = null;

	String path = ServletActionContext.getServletContext().getContextPath(); // /lockMgr
	StringBuffer path1 = ServletActionContext.getRequest().getRequestURL();  // http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action

	public final ObjectMapper getInitMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			return mapper;
		} else
			return mapper;
	}

	@SuppressWarnings("rawtypes")
	protected final Map getSession() {
		return ActionContext.getContext().getSession();
	}

	protected HttpServletRequest getRequest() {
		return (HttpServletRequest) ActionContext.getContext().get(
				StrutsStatics.HTTP_REQUEST);
	}

	protected HttpServletResponse getResponse() {
		return (HttpServletResponse) ActionContext.getContext().get(
				StrutsStatics.HTTP_RESPONSE);
	}

	public void setPageURL(String page) {
		this.pageURL = page;
	}

	public String getPageURL() {
		return pageURL;
	}

	public String goPage() {
		forwardUrl = pageURL;
		return "forwardURL";
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	protected final void jsonView(Object o, boolean isShort) throws IOException {
		getResponse().setContentType("application/json;charset=utf-8");
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		ObjectMapper mapper = getInitMapper();
		// mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
		// false);
		if (isShort)
			mapper.setDateFormat(formatShort);
		else
			mapper.setDateFormat(format);
		mapper.writeValue(writer, o);

	}

	protected final void jsonView(Object o) throws IOException {
		jsonView(o, false);
	}

	protected final void jsonViewIE(Object o) throws IOException {
		jsonViewIE(o, false);
	}

	protected void jsonViewIE(Object o, boolean isShort) throws IOException {
		getResponse().setContentType("text/html;charset=utf-8");
		PrintWriter writer = ServletActionContext.getResponse().getWriter();
		ObjectMapper mapper = getInitMapper();
		if (isShort)
			mapper.setDateFormat(formatShort);
		else
			mapper.setDateFormat(format);
		mapper.writeValue(writer, o);
	}

	protected final void returnResponseText(String text) throws IOException {
		HttpServletResponse response = getResponse();
		response.setHeader("pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		// response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(text);
		out.flush();
		out.close();
	}

	/* 设置时间格式 */
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 判断短信验证码是否失效及是否正确
	 * 
	 * @return
	 * @throws Exception
	 */

	/**
	 * 邮件内容
	 * 
	 * @param account
	 *            用户名
	 * @param id
	 *            用户id号
	 * @param passwd
	 *            用户重置密码
	 * @return
	 */
	public String getDataHandler(String account, String id, String passwd) {
		String dataHandler = null;// 收件内容
		String https = "https://www.btcjyzx.com";// 网址
		if (account != null && id != null) {// 账户激活
			dataHandler = "<body>"
					+ "<p><img src=\""
					+ https
					+ "/img/Logo2.png\"/></p>"
					+ "<p>欢迎来到&nbsp;&nbsp;比特币交易中心</p>"
					+ "<p>请妥善保管这封信件。您的帐户信息如下所示:</p>"
					+ "<p>用户名:"
					+ account
					+ "</p>"
					+ "<p>您的账号尚未激活,请点击下面的链接激活它:</p>"
					+ "<p><a href=\""
					+ https
					+ "/comfirmsuccess.html?id="
					+ id
					+ "\">www.btcjyzx.com/btc/comfirmsuccess?activtyUser#</a></p>"
					+ "<p>请注意避免密码遗失，因为数据库中保存的密码已被加密。如果您忘了密码,不用担心！您可以重置登录密码。</p>"
					+ "<p>感谢您的注册！</p>" + "<p>非常感谢, 比特币交易中心管理团队</p>" + "</body>";
		} else {// 重置登录密码
			dataHandler = "<html><head></head>" + "<body>" + "<p><img src=\""
					+ https + "/img/Logo2.png\"/></p>"
					+ "<p>比特币交易中心管理系统找回密码<p>" + "<p>您的新密码为:" + passwd + "</p>"
					+ "<p>比特币交易中心管理团队</p>" + "</body></html>";
		}
		return dataHandler;
	}

	/**
	 * 替换简介中图片路径
	 */
	public String replaceComment(String comment) {
		String[] path2 = path1.toString().split(path);
		if (comment != null && comment.length() != 0 && comment.contains(path)) {
			comment = comment.replaceAll(path, path2[0] + path);
		}
		return comment;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public StringBuffer getPath1() {
		return path1;
	}

	public void setPath1(StringBuffer path1) {
		this.path1 = path1;
	}

}
