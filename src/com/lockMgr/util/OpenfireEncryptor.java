package com.lockMgr.util;



public interface OpenfireEncryptor
{
	public String encrypt(String value);

	public String decrypt(String value);

	public void setKey(String key);
}
