package com.lockMgr.test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Test
{
	public static void main(String[] args) throws IOException
	{
/*OutputStream os = new FileOutputStream("c:\\out.txt");
		
		String str = "aaaab";
		
		byte[] buffer = str.getBytes();
		
		os.write(buffer);
		
		os.close();*/
		String str="!/sfds";
	 String s=	str.replaceAll("!/", "");
		System.out.println(str);
	}
}
