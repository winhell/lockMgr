package com.lockMgr.test;

import com.lockMgr.core.Utils;
import com.lockMgr.util.Encrypt;

public class FQtest {
	public static void main(String[] args) {
		System.out.println(Encrypt.encryptPassword("huanmhuanm"));
		System.out.println(Utils.getNewUUID());
		System.out.println(Utils.getNow());
		String str="<img src=\"lockMgr/file/1.jpg\"><img src=\"lockMgr/file/1.jpg\"><img src=\"lockMgr/file/1.jpg\"><img src=\"lockMgr/file/1.jpg\"><img src=\"lockMgr/file/1.jpg\">";
		System.out.println(str);
		if(str.contains("lockMgr")){
//			System.out.println(Utils.getimagepath());
//			str.replaceAll("lockMgr", Utils.getimagepath());
		}
	}
}
