package com.lockMgr.util;

public class OpenfireEncrytionAndDecryption
{
	private static String passwordKey="rC8zs3s2815MiQ7"; //passwordKey,从openfire数据库中读取
	public static String getEncryPWD(String noEncryPWD) {
		String resultPWD = null;
		
		//String passWordKey = "rC8zs3s2815MiQ7"; //passwordKey,从openfire数据库中读取
		/*
		 * 	下面这段是从ofProperty表中查询得到passwordKey的值。
		OfProperty ofProperty = ofPropertyMapper.selectByPrimaryKey("passwordKey");
		if (ofProperty != null) {
			passWordKey = ofProperty.getPropvalue();
		} */
		
		
		Blowfish blowFish = new Blowfish(passwordKey); //根据加密key初始化
		resultPWD = blowFish.encryptString(noEncryPWD); //加密
		return resultPWD; //返回加密后的结果
	}
	
	public static String getDecryptPWD(String EncryPWD) {
		String resultPWD = null;
		//String passWordKey = "rC8zs3s2815MiQ7"; //passwordKey,从openfire数据库中读取
		/*
		 * 	下面这段是从ofProperty表中查询得到passwordKey的值。
		OfProperty ofProperty = ofPropertyMapper.selectByPrimaryKey("passwordKey");
		if (ofProperty != null) {
			passWordKey = ofProperty.getPropvalue();
		} */
		Blowfish blowFish = new Blowfish(passwordKey); //根据加密key初始化
		resultPWD = blowFish.decryptString(EncryPWD); //解密
		return resultPWD; //返回解密后的结果
	}
	public static void main(String[] args)
	{
		System.out.println(getEncryPWD("123"));
		System.out.println(getDecryptPWD("336870959f1bfb6f81318b5bca2c7c31f01153217d408f48156fad2287b6da5a23bed3575deb730a"));
		//System.out.println("4947eface5be0b8e1c12118e4e6c0398235b7616af7ffdcc".length());
	}
}
