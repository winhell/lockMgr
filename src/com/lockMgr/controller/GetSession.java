package com.lockMgr.controller;

import java.io.IOException;
import java.util.Map;

import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.util.KeyEnum;


@SuppressWarnings("serial")
public class GetSession extends BaseAction
{
	//后端得到用户(操作员,其实都一样了)session
	public String getUserInfo() throws IOException{
		Operator oper=(Operator) getSession().get(KeyEnum.OPERATOR);
		jsonViewIE(oper);
		return null;
	}
	
	//前端得到用户session
	public void getUserSession() throws IOException {
		User user = (User) getSession().get(KeyEnum.USER);
		jsonViewIE(user);
	}
}
