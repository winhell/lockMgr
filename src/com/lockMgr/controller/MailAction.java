package com.lockMgr.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Checknum;
import com.lockMgr.pojo.User;
import com.lockMgr.service.ICheckNumService;
import com.lockMgr.service.IUserService;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;


public class MailAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7489115342168221052L;
	
	private String initPwd = "666666";  //属性：初始化密码
	
	private String email;
	private int checkNum;  //用户输入的校验码
	private String id;  //用户id
	private String password;
	
	private IUserService userService;
	private ICheckNumService checkNumService;
	
	/*
	 * 找回密码Action
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void retrievePassword() throws IOException {
		//判断用户输入邮箱是否存在
		User user = userService.findUserByEmail(email);
		Map m = new HashMap();
		if(user == null) {
			m.put("success", false);
			m.put("msg", "查询不到相应邮箱，请重新输入！");
		} else {
			//要判断用户预留邮箱服务器，再赋值
//			String userMail = findMailById(id);
			Properties props = new Properties();
//		    props.put("mail.smtp.host", "smtp.qq.com");  //SMTP服务器地址
			props.put("mail.smtp.host", checkMailType(email));
		    props.put("mail.smtp.auth", "true");  //验证
		    Session session = Session.getInstance(props, 
		    		//以匿名内部类的形式创建登录服务器的认证对象
		            new Authenticator()
		            {
		                public PasswordAuthentication getPasswordAuthentication()
		                {
		                	return new PasswordAuthentication("nextday123@qq.com","h2+o2=h2o");
		                }
		            });
		    try {
		        MimeMessage msg = new MimeMessage(session);
		        //设置发件人
		        msg.setFrom(new InternetAddress("nextday123@qq.com"));
		        //设置收件人
		        InternetAddress[] addresses = {new InternetAddress(email)};
		        msg.setRecipients(Message.RecipientType.TO, addresses);
		        //设置邮件主题
		        msg.setSubject(transferChinese("锁业邮件"));
		        //构造Multipart
		        Multipart mp = new MimeMultipart();
		        //向Multipart添加正文
		        MimeBodyPart mbpContent = new MimeBodyPart();
		        mbpContent.setText("您好!您修改密码的校验码为" + getCheckNum(user.getId()) + "，请在24小时内进行操作。" +
		        		"如非本人请忽略该邮件。系统邮件请勿回复！");
		        //将BodyPart添加到Multipart中
		        mp.addBodyPart(mbpContent);
		        //向Multipart添加MimeMessage
		        msg.setContent(mp);
		        //设置发送日期
		        msg.setSentDate(new Date());
		        //发送邮件
		        Transport.send(msg);
		        m.put("success", true);
		        m.put("user", user);
		    } catch (MessagingException mex) {
		        System.out.println("send failed, exception: " + mex);
		        m.put("success", false);
		        m.put("msg", "抱歉出现错误,请稍后访问!");
		    }
		}
//		jsonViewIE(m);
		Utils.senchaview(m);
	}
	
	/*
	 * 判断用户输入校验码Action
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void checkUserNum() throws IOException {
		Map m = new HashMap();
		boolean b = checkNumService.checkUserNum(id, checkNum);
		if(b == true) {
			//校验码正确就初始化密码(本来要修改密码,但为了方便就初始化)
			userService.updatePassword(id, initPwd);
			m.put("success", true);
			m.put("msg", "校验码输入正确!密码已初始化为" + initPwd);
		} else if(b == false) {
			m.put("success", false);
			m.put("msg", "校验码输入错误!");
		}
//		jsonViewIE(m);
		Utils.senchaview(m);
	}
	
	/*
	 * 修改密码Action
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void updatePassword() throws IOException {
		Map m = new HashMap();
		//修改密码
		userService.updatePassword(id, password);
		m.put("success", true);
		m.put("msg", "密码修改成功!");
//		jsonViewIE(m);
		Utils.senchaview(m);
	}
	
	//转换中文
	public String transferChinese(String content) {
		try {
			MimeUtility.encodeText(new String(content.getBytes(), "GB2312"), "GB2312", "B");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return content;
	}
	
	//根据用户id查询该用户邮箱
//	private String findMailById(String userId) {
//		String mail = null;
//		User user = userService.findById(userId);
//		if(user != null) {
//			mail = user.getEmail();
//		}
//		return mail;
//	}
	
	//生成随机校验码
	private int getCheckNum(String userId) {
		//生成6位整型随机码
		Random r = new Random();
		int checkNum = r.nextInt(1000000);
		//有效期为一天
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, +1);
		//Date(父类)不能转Timestamp(子类),借助String(Date->String->Timestamp)
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(c.getTime());
		Timestamp endDate = Timestamp.valueOf(date);
		//往checkNum表中存条记录
		Checknum cn = new Checknum();
		cn.setCreatetime(Utils.getNow());
		cn.setEndtime(endDate);
		cn.setUserId(userId);
		cn.setCheckNum(checkNum);
		checkNumService.save(cn);
//		cn.setEndtime(endtime);
		return checkNum;
	}
	
	//判断邮箱类型
	private String checkMailType(String userMail) {
		//liangzaichao@vip.qq.com
		//nextday123@qq.com
		String hostSMTP = null;
		userMail.split("@");
		String[] myMail = userMail.split("@");
		String[] mySecond = myMail[1].split(".com");
		if(mySecond[0].contains("vip.")){
			String[] myThree = mySecond[0].split("vip.");
			hostSMTP = myThree[1];
		} else {
			hostSMTP = mySecond[0];
		}
		return "smtp." + hostSMTP + ".com";
	}

	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ICheckNumService getCheckNumService() {
		return checkNumService;
	}

	public void setCheckNumService(ICheckNumService checkNumService) {
		this.checkNumService = checkNumService;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
