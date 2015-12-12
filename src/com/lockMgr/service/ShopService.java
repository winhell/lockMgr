package com.lockMgr.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Busilocks;

public class ShopService extends BaseDao<Busilocks> implements IShopService {
	/**
	 * 首页查询(包含商品商户的6个信息)
	 * @return
	 */
	@Override
	public List<Busilocks> findHomePage(int page, int pageSize) {
		List l = new ArrayList();
		String hql = " select l.id,l.image,l.sales,l.price,l.oprice,b.company,b.address from Locks l, Business b " +
				" where l.businessId=b.id and l.status=1 order by l.rank desc ";
		if(page==0 && pageSize==0) {
			//如果page,pageSize都为0(最初请求可能为该情况),自动返回规定查询数据(此处为前20条记录).
			l = findByPage(hql, null, 0, 20);
		} else {
			l = findByPage(hql, null, (page-1)*pageSize, pageSize);
		}
		List<Busilocks> blList = new ArrayList<Busilocks>();
		for(int i=0; i<l.size(); i++) {
			Busilocks bl = new Busilocks();
			Object[] obj = (Object[]) l.get(i);
			try { 
				bl.setLocksId(obj[0].toString());
				bl.setImage(Utils.getimagepath() + obj[1].toString());
				bl.setSales(Integer.parseInt(obj[2].toString()));
				bl.setPrice(Double.parseDouble(obj[3].toString()));
				bl.setOprice(Double.parseDouble(obj[4].toString()));
				bl.setBusiName(obj[5].toString());
				bl.setBusiaddr(obj[6].toString());
				blList.add(bl);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return blList;
	}

}
