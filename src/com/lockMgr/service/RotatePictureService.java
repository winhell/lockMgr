package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.RotatePicture;

/**
 * 滚动图片实现类
 */

@SuppressWarnings("unchecked")
public class RotatePictureService extends BaseDao<RotatePicture> implements IRotatePictureService {
	private int statusN = 0;  //不可用状态
	private int statusY = 1;  //可用状态
	
	/**
	 * 增加滚动图片
	 */
	public void addRotatePicture(Operator o, String address, int type, String comment) {
		RotatePicture rp = new RotatePicture();
		rp.setCreatetime(Utils.getNow());
		rp.setAddress(address);
		rp.setType(type);
		rp.setStatus(statusY);
		if(comment != null && comment.length() != 0)
			rp.setComment(comment);
		save(rp);
		writeLog(o, "添加", "滚动图片", rp);
	}

	/**
	 * 分页查询滚动图片(首页(1)和论坛(2)图片)
	 */
	@SuppressWarnings({ "rawtypes" })
	public void findRotatePictureByPage(Map m, int page, int pageSize, String path, int[] typeArray, int type) {
		String hql = null;
		//这是滚动图片(首页和论坛滚动图片,typeArray中存两个int类型数据,1和2)
		if(typeArray != null && typeArray.length != 0 && type == 0) {
			hql = " from RotatePicture where status=" + statusY + " " +
					" and type in(" + typeArray[0] + "," + typeArray[1] + ")  order by type ";
		}
		else if(type != 0 && typeArray == null)
			hql = " from RotatePicture where status=" + statusY + " " +
					" and type=" + type + " order by type ";
		List<RotatePicture> allList = findByPage(hql, null, (page-1)*pageSize, pageSize);
		Long count = getCount(hql, null);
		if(allList != null && allList.size() != 0) {
			for(int i=0; i<allList.size(); i++) {
				RotatePicture rp = allList.get(i);
				rp.setAddress(path + rp.getAddress());
				if(rp.getType() == 1)
					rp.setTypeName("首页轮播图片");
				else if(rp.getType() == 2)
					rp.setTypeName("论坛轮播图片");
			}
		}
		m.put("total", count);
		m.put("rows", allList);
	}
	
	/**
	 * 删除滚动图片
	 */
	public void deleteRotatePicture(Operator o, String[] idlist) {
		if(idlist == null || idlist.length == 0)
			return ;
		for(int i=0; i<idlist.length; i++) {
			RotatePicture rp = findById(idlist[i]);
			rp.setStatus(statusN);
			saveOrUpdate(rp);
			writeLog(o, "删除", "滚动图片", rp);
		}
	}
	
	/**
	 * 修改滚动图片
	 */
	public void editRotatePicture(Operator o, String id, String address, int type) {
		if(id == null || id.length() == 0)
			return ;
		RotatePicture rp = findById(id);
		rp.setCreatetime(Utils.getNow());
		rp.setType(type);
		rp.setAddress(address);
		saveOrUpdate(rp);
		writeLog(o, "修改", "滚动图片", rp);
	}
	
	/**
	 * 前端查询滚动图片
	 */
	public List<RotatePicture> findRotatePictureToFront(int type) {
		String hql = " from RotatePicture where type=" + type + " and status = " + statusY + "order by createtime";
		List<RotatePicture> rpList = find(hql);
		if(rpList != null && rpList.size() != 0) {
			for(int i=0; i<rpList.size(); i++) {
				rpList.get(i).setAddress(Utils.getRotatePictureImgPath() + rpList.get(i).getAddress());
			}
		}
		return rpList;
	}

}
