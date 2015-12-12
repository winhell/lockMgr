package com.lockMgr.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Newstype;
import com.lockMgr.pojo.Operator;
import com.lockMgr.util.DBUtil;

/**
 * 论坛版块类型实现类
 * @author lzc
 *
 */
public class NewstypeService extends BaseDao<Newstype> implements INewstypeService {
	
	/**
	 * 查询论坛版块列表
	 */
	@Override
//	public List<Newstype> findNewsTypeList() {
//		String sql = "select * from newstype";
//		List list = findBySQL(sql);
//		List<Newstype> newstype = new ArrayList();
//		for(int i=0; i<list.size(); i++) {
//			Newstype n = (Newstype) list.get(i);
//			newstype.add(n);
//		}
//		return newstype;
//	}
	public List<Newstype> findNewsTypeList() {
		String sql = "select * from newstype";
		List<Newstype> list = new ArrayList<Newstype>();
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet rs = prep.executeQuery();
			if(rs.next()) {
				Newstype n = new Newstype();
				n.setId(rs.getString("id"));
				n.setName(rs.getString("name"));
				n.setComment(rs.getString("comment"));
				n.setCreatetime(rs.getTimestamp("createtime"));
				n.setType(rs.getInt("type"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)
				DBUtil.closeConnection();
		}
		return list;
	}

	/**
	 * 分页查询所有论坛版块
	 */
	public List<Newstype> findAllNewstype(int page, int pageSize) {
		String hql = " from Newstype where status=1 order by type";
		List<Newstype> list = new ArrayList<Newstype>();
		if(page==0 && pageSize==0) {
			list = findByPage(hql, null, 0, 20);
		} else {
			list = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		return list;
	}

	/**
	 * 遍历type字段,返回没使用过的整型
	 */
	public int checkingType() {
		String sql = "select type from newstype order by type";
		List list = findBySQL(sql);
		int type = (Integer) list.get(list.size()-1) + 1;
		return type;
	}
	
	/**
	 * 查看已停用论坛版块
	 */
	public List<Newstype> findNewstypeDisabled(int page, int pageSize) {
		String hql = " from Newstype where status=0 order by type";
		List<Newstype> list = new ArrayList<Newstype>();
		if(page==0 && pageSize==0) {
			list = findByPage(hql, null, 0, 20);
		} else {
			list = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		return list;
	}
	
	/**
	 * 查询论坛版块信息
	 */
	public void findNewsTypeByPage(Map map, int page, int pageSize, int status, String sortAttr) {
		String hql = " from Newstype where status=1 ";
		int paramNums = 0;
		List<Object> list = new ArrayList<Object>();
/*		if(status == 1) {
			hql += " where status=1 ";
			list.add(status);
			paramNums ++;
		} else if(status == 0) {
			hql += " where status=0 ";
			list.add(status);
			paramNums ++;
		}*/
		if (sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += " order by createtime desc";
		}
//		Object[] values = list.toArray(new Object[paramNums]);
		fillPagetoMap(map, hql, null, page, pageSize);
	}
	
	/**
	 * (删除)停用论坛版块类型
	 */
	public boolean txCancelNewstype(Operator oper, String[] idlist) {
		for(String id : idlist) {
			Newstype nt = findById(id);
			nt.setStatus(0);
			saveOrUpdate(nt);
			writeLog(oper, "删除", "论坛版块类型", nt);
		}
		return true;
	}
	
	/**
	 * 增加论坛版块类型
	 */
	public void txAddNewstype(Operator oper, Newstype nt) {
		//type字段设置
		int type = 0;
		int maxType = 0;
		List<Newstype> newstypeList = new ArrayList<Newstype>();
		String hql = " from Newstype order by type ";
		newstypeList = find(hql, null);
		for(int i=0; i<newstypeList.size(); i++) {
			type = newstypeList.get(i).getType();
			if(type > maxType) {
				maxType = type;
			}
		}
		maxType ++;
		nt.setType(maxType);
		nt.setStatus(1);
		save(nt);
		writeLog(oper, "添加", "论坛版块类型", nt);
	}
	
	/**
	 * 修改论坛版块类型
	 */
	public boolean txUpdateNewstype(Operator oper, Newstype nt ,String id) {
		nt.setId(id);
		nt.setStatus(1);
		saveOrUpdate(nt);
		writeLog(oper, "修改", "论坛版块类型", nt);
		return true;
	}
	
	/**
	 * 根据type(int)查询name(typename)
	 */
	public String findNameByType(int type) {
		String typeName = "";
		String hql = " from Newstype where type=? ";
		List<Newstype> list = find(hql, new Object[]{type});
		if(list != null && list.size() != 0){
			typeName = list.get(0).getName();
		}
		return typeName;
	}
	
}
