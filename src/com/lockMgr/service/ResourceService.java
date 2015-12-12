package com.lockMgr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Locks;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Resource;
import com.lockMgr.util.StatusEnum;

public class ResourceService extends BaseDao<Resource> implements IResourceService
{

	@Override
	public void getResourceByPage(Map map, int page, int pageSize,
			String title, int type, int rank, String orderType, String sortAttr)
	{
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = "from Resource where status!=" + StatusEnum.disable.ordinal();
        Resource r = new Resource();
		if (null != title && title.trim().length() != 0) {
			hql += " and title like ?";
			al.add("%" + title + "%");
			paramNums++;
		}
		if (type!=-1) {
			hql += " and type =?";
			al.add(type);
			paramNums++;
		}
		if (rank!=-1) {
			hql += " and rank =?";
			al.add(rank);
			paramNums++;
		}
		if (orderType != null && sortAttr != null) {
			hql += " order by " + sortAttr + " " + orderType;
		} else {
			hql += "  ORDER BY createtime desc";
		}
		Object[] values = al.toArray(new Object[paramNums]);
        Long count = getCount(hql, values);
        List<Resource> list = findByPage(hql, values, (page-1)*pageSize, pageSize);
        if(list != null && list.size() != 0) {
            for(int i=0; i<list.size(); i++) {
                r = list.get(i);
                if(r.getResourceType() != null && r.getResourceType().length() != 0) {
                    r.setResourceAndDataType(r.getResourceType());
                    if(r.getDataType() != null && r.getDataType().length() != 0 && r.getResourceType().equals("数据介绍"))
                        r.setResourceAndDataType(r.getResourceType() + " - " + r.getDataType());
                }
            }
        }
        map.put("total", count);
        map.put("rows", list);
//		fillPagetoMap(map, hql, values, page, pageSize);
	}
	
	/**
	 * 查询软件下载资料
	 */
	@SuppressWarnings("unchecked")
	public void getResourceOfSoftwareByPage(Map m, int page, int pageSize, String title) {
		int paramNums = 0;
		ArrayList<Object> al = new ArrayList<Object>();
		String hql = " from Resource where status=1 and resourceType='软件下载' ";
        Resource r = new Resource();
		if (null != title && title.trim().length() != 0) {
			hql += " and title like ?";
			al.add("%" + title + "%");
			paramNums++;
		}
		Object[] values = al.toArray(new Object[paramNums]);
        Long count = getCount(hql, values);
        List<Resource> list = findByPage(hql, values, (page-1)*pageSize, pageSize);
        if(list != null && list.size() != 0) {
            for(int i=0; i<list.size(); i++) {
                r = list.get(i);
                r.setResourceAndDataType("软件下载");
            }
        }
        m.put("total", count);
        m.put("rows", list);
	}

	@Override
	public void txImportResource(Operator oper,Resource resource)
	{
		resource.setUploaderName(oper.getAccount());
		resource.setStatus(1);
		save(resource);
		writeLog(oper, "添加", "资源", resource);
	}

	@Override
	public void txDel(Operator operator, String[] idlist)
	{
	  Resource res = null;
		for (String id : idlist) {
			res = this.findById(id);
			delete(res);
			writeLog(operator, "删除", "资源",res);
		}
	}

	@Override
	public boolean txUpdate(Operator oper, int rank, int type, int score,
			String title, String describe, String id,String carName,String carType,String resourceType,String dataType)
	{
		Resource res=findById(id);
		if(res!=null)
		{
			res.setRank(rank);
			res.setTitle(title);
			res.setType(type);
			res.setScore(score);
			res.setResDescribe(describe);
			res.setCarName(carName);
			res.setCarType(carType);
			res.setResourceType(resourceType);
			res.setDataType(dataType);
			saveOrUpdate(res);
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * 根据车类查询相关资料
	 */
	public List<Resource> findResourceByCar(int page, int pageSize, String carIndex) {
		List<Resource> resourceList = new ArrayList<Resource>();
		String hql = "from Resource where status=1 and carIndex=?";
		if(page==0 && pageSize==0) {
			resourceList = findByPage(hql, new Object[]{carIndex}, 0, 20);
		} else {
			resourceList = findByPage(hql, new Object[]{carIndex}, (page-1)*pageSize, pageSize);
		}
		return resourceList;
	}
	
	/**
	 * 根据用户角色查询对应资料
	 */
	public List<Resource> findResourceByUserrole(int rank, int page, int pageSize) {
		String hql = "";
		List<Resource> list = new ArrayList<Resource>();
		if(rank == 0) {
			hql = " from Resource where rank=? ";
			if(page==0 && pageSize==0) {
				list = findByPage(hql, new Object[]{rank}, 0, 20);
			} else {
				list = findByPage(hql, new Object[]{rank}, (page-1)*pageSize, pageSize);
			}
		} else if(rank == 1) {
			hql = " from Resource ";
			if(page==0 && pageSize==0) {
				list = findByPage(hql, null, 0, 20);
			} else {
				list = findByPage(hql, null, (page-1)*pageSize, pageSize);
			}
		}
		return list;
	}
	
	/**
	 * 根据车类名查询所有对应资源
	 */
	public List<Resource> findAllResourceByCarName(int page, int pageSize, String carName) {
		String hql = " from Resource where carName=? and status=1 ";
		List<Resource> list = new ArrayList<Resource>();
		if(page==0 && pageSize==0) {
			list = findByPage(hql, new Object[]{carName}, 0, 20);
		} else {
			list = findByPage(hql, new Object[]{carName}, (page-1)*pageSize, pageSize);
		}
		return list;
	}
	
	/**
	 * 根据车类型查询所有对应资源(搜索框)
	 */
	public List<Resource> findAllResourceByCarType(int page, int pageSize, String resourceType,
			String dataType, String carName, String carType) {
		List<Resource> list = new ArrayList<Resource>();
		if(page==0 && pageSize==0) {
			if(dataType != null && dataType.length() != 0) {
				String hql = " from Resource where status=1 and resourceType=? and dataType=? and carName=? and carType like ? ";
				list = findByPage(hql, new Object[]{resourceType, dataType, carName, "%"+carType+"%"}, 0, 20);
			} else {
				String hql = " from Resource where status=1 and resourceType=? and carName=? and carType like ? ";
				list = findByPage(hql, new Object[]{resourceType, carName, "%"+carType+"%"}, 0, 20);
			}
		} else {
			if(dataType != null && dataType.length() != 0) {
				String hql = " from Resource where status=1 and resourceType=? and dataType=? and carName=? and carType like ? ";
				list = findByPage(hql, new Object[]{resourceType, dataType, carName, "%"+carType+"%"}, (page-1)*pageSize, pageSize);
			} else {
				String hql = " from Resource where status=1 and resourceType=? and carName=? and carType like ? ";
				list = findByPage(hql, new Object[]{resourceType, carName, "%"+carType+"%"}, (page-1)*pageSize, pageSize);
			}
		}
		return list;
	}
	
	/**
	 * 根据资源类型(resourceType),车型(carName)查询所有资源
	 */
	public List<Resource> findAllByResourceTypeAndCarName(int page, int pageSize, String resourceType, String carName) {
		String hql = " from Resource where resourceType=? and carName=? ";
		List<Resource> rList = new ArrayList<Resource>();
		if(page==0 && pageSize==0) {
			rList = findByPage(hql, new Object[]{resourceType, carName}, 0, 20);
		} else {
			rList = findByPage(hql, new Object[]{resourceType, carName}, (page-1)*pageSize, pageSize);
		}
		return rList;
	}
	
}
