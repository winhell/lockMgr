package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Car;
import com.lockMgr.pojo.Newstype;
import com.lockMgr.pojo.Operator;

/**
 * 论坛版块类型接口
 * @author lzc
 *
 */
public interface INewstypeService extends IBaseDao<Newstype> {
	/**
	 * 查询论坛版块列表
	 */
	public List<Newstype> findNewsTypeList();
	
	/**
	 * 分页查询所有论坛版块
	 */
	public List<Newstype> findAllNewstype(int page, int pageSize);
	
	/**
	 * 遍历type字段,返回没使用过的整型
	 */
	public int checkingType();
	
	/**
	 * 查看已停用论坛版块
	 */
	public List<Newstype> findNewstypeDisabled(int page, int pageSize);

	/**
	 * 查询论坛版块信息
	 */
	public void findNewsTypeByPage(Map map, int page, int pageSize, int status, String sortAttr);
	
	/**
	 * (删除)停用论坛版块类型
	 */
	public boolean txCancelNewstype(Operator oper, String[] idlist);
	
	/**
	 * 增加论坛版块类型
	 */
	public void txAddNewstype(Operator oper, Newstype nt);

	/**
	 * 修改论坛版块类型
	 */
	public boolean txUpdateNewstype(Operator oper, Newstype nt ,String id);
	
	/**
	 * 根据type(int)查询name(typename)
	 */
	public String findNameByType(int type);
}
