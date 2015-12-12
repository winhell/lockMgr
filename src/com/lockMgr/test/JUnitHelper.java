package com.lockMgr.test;


/*
 * Copyright (c) 2004 Your Corporation. All Rights Reserved.
 */
 
import javax.servlet.ServletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
 
public class JUnitHelper
{
    public static String[] Configuration_Location = new String[]{"src/applicationContext.xml"};
    private static XmlWebApplicationContext wac = null;
    private static FileSystemXmlApplicationContext fsxac = null;
 
    public static void setWebApplicationContext(ServletContext context)
    {
        if (context.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE) != null)
            return;
        if (wac == null)
        {
            wac = new XmlWebApplicationContext();
            wac.setServletContext(context);
            wac.setConfigLocations(Configuration_Location);
            wac.refresh();
        }
        context.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, wac);
    }
 
    public static ApplicationContext getApplicationContext()
    {
        if (fsxac == null)
        {
            fsxac = new FileSystemXmlApplicationContext(Configuration_Location);
        }
        return fsxac;
    }
}
/***********************************************************************/
 
    