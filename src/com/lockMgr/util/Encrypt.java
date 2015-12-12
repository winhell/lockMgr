package com.lockMgr.util;
public class Encrypt
{
	public static String encryptPassword(String password)
	{
		Md5 md5 = new Md5();
		md5.Md5(password);
		password = md5.compute(); // Md5加密
		DESPlus des;
		try
		{
			des = new DESPlus();
			password = des.encrypt(password);// DES加密
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return password;
	}

	public static String encryptOnlyDES(String password)
	{
		DESPlus des;
		try
		{
			des = new DESPlus();
			password=password.toLowerCase();
			password = des.encrypt(password);// DES加密
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return password;
	}

}
