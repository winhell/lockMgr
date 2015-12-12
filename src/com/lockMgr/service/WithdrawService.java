package com.lockMgr.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lockMgr.core.BaseDao;
import com.lockMgr.core.Utils;
import com.lockMgr.pojo.Operator;
import com.lockMgr.pojo.Withdraw;

@SuppressWarnings("unchecked")
public class WithdrawService extends BaseDao<Withdraw> implements IWithdrawService  {
	private int passedStatus = 2; //审核通过状态
	private int denyAuditStatus = -1; //拒绝审核状态
	private int waitStatus = 1;  //等待审核
	
	private IBusinessService businessService;
	
	/**
	 * 根据不同角色查询(商户和管理员)提现记录
	 */
	@SuppressWarnings("rawtypes")
	public List<Withdraw> findWithdrawByPage(Map map, int page, int pageSize, String sortAttr, 
			String operId, Timestamp beginDate, Timestamp endDate, int status) {
		int paramsNum = 0;
		List<Object> list = new ArrayList<Object>();
		String hql = " from Withdraw where 1=1 ";
		if(operId != null && operId.length() != 0) {
			hql += " and businessId=? ";
			list.add(operId);
			paramsNum ++;
		}
		if(beginDate != null && endDate != null) {
			hql += " and applyTime between ? and ? ";
			list.add(beginDate);
			list.add(endDate);
			paramsNum = paramsNum + 2;
		}
		if(status != 0) {
			hql += " and status=? ";
			list.add(status);
			paramsNum ++;
		}
		if (sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += " order by applyTime ";
		}
		Object[] values = list.toArray(new Object[paramsNum]);
//		fillPagetoMap(map, hql, values, page, pageSize);
		Long count = getCount(hql, values);
		List<Withdraw> wdList = findByPage(hql, values, (page-1)*pageSize, pageSize);
		Withdraw wd = new Withdraw();
		for(int i=0; i<wdList.size(); i++) {
			wd = wdList.get(i);
			if(wd.getBusinessId() != null && wd.getBusinessId().length() != 0) 
				wd.setBusinessName(businessService.findById(wd.getBusinessId()).getCompany());
		}
		map.put("total", count);
		map.put("rows", wdList);
		return null;
	}
	
	

	/**
	 * 最近一次商户提现成功日期
	 * 查询到：返回查询到的日期
	 * 查询不到：1.一次(上次)或多次(上上次...)申请的提现都未审核通过
	 * 			2.该商户至今未申请过提现
	 */
	@SuppressWarnings("rawtypes")
	public Date lastApplyTimeSuccess(String businessId) {
		Date lastDate = null;
		String hql = "select MAX(operationTime) from Withdraw where status=" + passedStatus + " and businessId=?";
		List l = find(hql, new Object[]{businessId});
		Date date = (Date) l.get(0);
		if(date != null) 
			lastDate = date;
		return lastDate;
	}
	
	/**
	 * 保存商户提现申请
	 */
	public void applySave(String businessId, double amount, String alipayAccount, String accountName) {
		Withdraw wd = new Withdraw();
		wd.setAmount(amount);
		wd.setAlipayAccount(alipayAccount);
		wd.setAccountName(accountName);
		wd.setBusinessId(businessId);
		wd.setApplyTime(Utils.getNow());
		wd.setStatus(waitStatus);
		save(wd);
	}
	
	/**
	 * 商户撤销提现申请
	 */
	public void cancelApply(String[] idList, Operator o) {
		for(String id : idList) {
			Withdraw wd = findById(id);
			delete(wd);
			writeLog(o, "撤销", "提现申请", wd);
		}
	}
	
	/**
	 * 商户撤销申请时检查状态该提现申请是否已通过管理员审核
	 * true：表示可以撤销(idList中的所有记录都未审核)
	 * false:表示不能撤销
	 */
	public boolean checkCancelApply(String[] idList) {
		for(String id : idList) {
			Withdraw wd = findById(id);
			if(wd.getStatus() == passedStatus) 
				return false;
		}
		return true;
	}
	
	/**
	 * 通过审核
	 */
	public void passed(String[] withdrawIdList) {
		Withdraw wd = null;
		for(String wdId : withdrawIdList) {
			if(wdId != null && wdId.length() != 0) {
				wd = findById(wdId);
				wd.setStatus(passedStatus);
				wd.setOperationTime(Utils.getNow());
				saveOrUpdate(wd);
			}
		}
	}
	
	/**
	 * 拒绝审核
	 */
	public void denyAudit(String[] withdrawIdList) {
		Withdraw wd = null;
		for(String wdId : withdrawIdList) {
			if(wdId != null && wdId.length() != 0) {
				wd = findById(wdId);
				wd.setStatus(denyAuditStatus);
				wd.setOperationTime(Utils.getNow());
				saveOrUpdate(wd);
			}
		}
	}
	
	/**
	 * 根据支付宝传递过来的参数组(批量付款id),修改审核状态
	 * success调用
	 */
	public void updateWithdraw(HttpServletRequest request, String[] idList, int status) {
		ApplicationContext ac = 
				WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		Withdraw w = null;
		for(int i=0; i<idList.length; i++) {
			 w = (Withdraw) session.get(Withdraw.class, idList[i]);
			 if(w != null) {
				 w.setStatus(passedStatus);
				 w.setOperationTime(Utils.getNow());
				 saveOrUpdate(w);
			 }
		}
		t.commit();
		session.close();
	}
	
	/**
	 * 根据idlist[] 查询各提现申请详情
	 */
	@SuppressWarnings("rawtypes")
	public Map findDetailsByIdlist(String[] idlist) {
		Map m = new HashMap();
		int count = 0;  //总笔数
		double allAmount = 0;  //总金额
		List alipayAccountList = new ArrayList();   //申请账号集合
		List accountNameList = new ArrayList();     //申请姓名集合
		List amountList = new ArrayList();          //申请金额集合
		Withdraw wd = new Withdraw();
		if(idlist.length == 0 || idlist == null) 
			return null;
		for(int i=0; i<idlist.length; i++) {
			wd = findById(idlist[i]);
			alipayAccountList.add(wd.getAlipayAccount());
			accountNameList.add(wd.getAccountName());
			amountList.add(wd.getAmount());
			allAmount += wd.getAmount();
		}
		count = alipayAccountList.size();
		m.put("alipayAccountList", alipayAccountList);
		m.put("accountNameList", accountNameList);
		m.put("amountList", amountList);
		m.put("count", count);
		m.put("allAmount", allAmount);
		return m;
	}
	
	public IBusinessService getBusinessService() {
		return businessService;
	}

	public void setBusinessService(IBusinessService businessService) {
		this.businessService = businessService;
	}
}
