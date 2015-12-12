package com.lockMgr.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Busilocks;
import com.lockMgr.pojo.Locks;
import com.lockMgr.service.ILockService;
import com.lockMgr.util.KeyEnum;
import com.lockMgr.util.StatusEnum;

public class LocksAction extends BaseAction {
	private ILockService lockService;
	private int start,limit;

//	public String gethotlocks() throws IOException{
//		Map json =new HashMap();
//		List<Busilocks> list =lockService.findBusilocks();
//		if(list.size()==0){
//			json.put(KeyEnum.REASON, "还没有任何商品和商铺信息!");
//		}else{
//			json.put(KeyEnum.REASON, "");
//		}
//		json.put(KeyEnum.RESULT, StatusEnum.success);
//		json.put("hotlocks", list);
//		jsonViewIE(json);
//		return null;
//}

	public String gethotlocks() throws IOException {
		Map json = new HashMap();
		List<Busilocks> list = lockService.findBusilocks(start,limit);
		if (list.size() == 0) {
			json.put("success", true);
			json.put("msg", "还没有任何商品和商铺信息!");
		} else {
			json.put("success", true);
			json.put("msg", "");
			json.put("hotlocks", list);
		}
		Utils.senchaview(json);
		return null;
	}
	public String getAlllocks() throws IOException{
		Map json =new HashMap();
		List<Locks> list =this.lockService.listAll();
		if(list.size()==0){
			json.put("success", false);
			json.put("msg", "暂无任何商品！");
		}else{
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setImage(Utils.getimagepath()+list.get(i).getImage());
			}
			json.put("success", true);
			json.put("msg", "");
			json.put("Locks", list);
		}
		Utils.senchaview(json);
		return null;
	}

	public ILockService getLockService() {
		return lockService;
	}

	public void setLockService(ILockService lockService) {
		this.lockService = lockService;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
