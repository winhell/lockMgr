package com.lockMgr.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Encoding
{
public static String encoding(String context,String toType) throws IOException
{
	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	byte[] myvc = decoder.decodeBuffer(context);
	 try
	{
		return new String(myvc, toType);
	}
	catch (UnsupportedEncodingException e)
	{
		e.printStackTrace();
	}
	return null;
}
}
