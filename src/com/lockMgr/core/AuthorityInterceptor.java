package com.lockMgr.core;

import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.User;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;

public class AuthorityInterceptor
	extends AbstractInterceptor
{
	public String intercept(ActionInvocation invocation) throws Exception{
		ActionContext ctx = invocation.getInvocationContext();
		Map<String, Object> session = ctx.getSession();
		
		Map jsondata = new HashMap();
		Operator operator = (Operator)session.get(KeyEnum.OPERATOR);
		User user = (User) session.get(KeyEnum.USER);
		if (operator != null || user != null)
		{
			return invocation.invoke();
		}else{
			//ctx.put("tip", "系统使用超时，请重新登录...");
			jsondata.put(KeyEnum.STATUS, StatusEnum.timeout);
			//jsonView(jsondata);

			HttpServletResponse response = (HttpServletResponse) ctx.get(org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			response.setContentType("application/json;charset=utf-8");
			PrintWriter writer = response.getWriter();
			ObjectMapper mapper = new ObjectMapper();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//mapper.getSerializationConfig().with(format);
		mapper.getSerializationConfig().setDateFormat(format);
//			mapper.getSerializationConfig().setDateFormat(format);
			mapper.writeValue(writer, jsondata);
			return null;
		}
	}
	
	
}
