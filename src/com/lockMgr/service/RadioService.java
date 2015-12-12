package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Radio;

public class RadioService extends BaseDao<Radio> implements IRadioService {
	/**
	 * 添加一条广播
	 */
	public void addRadio(String word) {
		Radio r = new Radio();
		r.setWord(word);
		r.setCreatetime(Utils.getNow());
		save(r);
	}
	
	/**
	 * 删除一条广播
	 */
	public void deleteRadio(String[] idlist) {
		if(idlist == null || idlist.length == 0)
			return ;
		for(int i=0; i<idlist.length; i++) {
			Radio r = findById(idlist[i]);
			if(r != null)
				delete(r);
		}
	}
	
	/**
	 * 分页查询广播列表
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void findRadioByPage(Map m, int page, int pageSize) {
		String hql = " from Radio order by createtime ";
		List<Radio> rl = findByPage(hql, null, (page - 1) * pageSize, pageSize);
		Long count = getCount(hql, null);
		m.put("total", count);
		m.put("rows", rl);
	}
	
	/**
	 * 查询全部广播
	 */
	public List<Radio> findAllRadio() {
		return find(" from Radio ");
	}

}
