package com.lockMgr.test;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.lockMgr.controller.BaseAction;
import com.lockMgr.core.Utils;

public class Lzctest extends BaseAction {
	public static void main(String[] args) throws NoSuchFieldException,
			SecurityException, IllegalArgumentException, IllegalAccessException {
		 System.out.println(Utils.getNewUUID());
		// System.out.println(Utils.getNow());
		// String str =
		// "222222222<img alt='微笑' src='/lockMgr/js/xheditor_emot/default/smile.gif' /><img src='/lockMgr/file/img/14050112193333.jpg' alt='' />sdfasdf";
		// String str1 =
		// "afd frw<img src='/lockMgr/file/img/14080809442537.jpg' alt='' />gewdfs<img alt='骂人' src='/lockMgr/js/xheditor_emot/default/curse.gif' />";
		// // String path =
		// ServletActionContext.getServletContext().getContextPath(); //
		// /lockMgr
		// // StringBuffer path1 =
		// ServletActionContext.getRequest().getRequestURL(); //
		// http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action
		// String path = "/lockMgr";
		// String path1 =
		// "http://localhost:8080/lockMgr/resa_getAllResourceByCarType.action";
		// String[] path2 = path1.toString().split(path); //path2[0] ->
		// http://localhost:8080
		// if(str1.contains(path)) {
		// str1 = str1.replaceAll(path, path2[0]+path);
		// }
		// System.out.println(str1);
		
//		System.out.println(isDecimal("1.0"));
		
//		String i = String.valueOf((float)3/2);
//		System.out.println(i);
//		System.out.println(isDecimal(i));
		
//		String date = Calendar.getInstance().getTime().toString();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		System.out.println(sdf.format(Utils.getNow()));
//		System.out.println(new SimpleDateFormat("yyyyMMdd").format(Utils.getNow()));
//		System.out.println(sdf.format(Calendar.getInstance().getTime()));
//		Date date = sdf.format(Calendar.getInstance().setTime(new Date()));
//		System.out.println(date.toString());
//		System.out.println(String.valueOf(System.currentTimeMillis()));
//		System.out.println(String.valueOf(System.currentTimeMillis()) + String.valueOf(new Random().nextInt(1000)));
		/*String my = "liangzaichao@vip.qq.com";
		String[] myMail = my.split("@");
		System.out.println(myMail[1]);
		String[] mySecond = myMail[1].split(".com");
		System.out.println(mySecond[0]);
		if(mySecond[0].contains("vip."));
		String[] myThree = mySecond[0].split("vip.");
		System.out.println(myThree[1]);*/
	}

	/*private static boolean isMatch(String regex, String orginal) {
		if (orginal == null || orginal.trim().equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher isNum = pattern.matcher(orginal);
		return isNum.matches();
	}

	public static boolean isDecimal(String orginal) {
		if(orginal.contains(".")){
			String[] o = orginal.split(".");
			if(o.length == 0) {
				orginal = o[0];
			}
		}
		return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
	}*/
	
}
