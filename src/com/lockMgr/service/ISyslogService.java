package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Syslog;

public interface ISyslogService extends IBaseDao<Syslog> {
	public void getSyslogByCondition(Map map,String userId,String name,String comment,Timestamp startTime,Timestamp endTime,int pageSize,int pageNum);
}
