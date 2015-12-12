package com.lockMgr.service;

import java.util.List;
import java.util.Map;

import com.lockMgr.core.IBaseDao;
import com.lockMgr.pojo.Car;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;

/**
 * 车系资源接口
 * @author lzc
 *
 */
public interface ICarService extends IBaseDao<Car> {
	/**
	 * 根据车系查询车种类
	 */
	public List<Car> findCarByCountry(int page, int pageSize, String carCountry);
	
	/**
	 * 查询所有车品牌和id
	 */
	public List<NameAndId> findAllCarsIdAndName(Operator oper);
	
	/**
	 * 根据车系查询车品牌和id
	 */
	public List<NameAndId> findCarsIdAndNameByCarCountry(String carCountry, Operator oper);
	/**
	 * 根据车名查询车类别,去重
	 */
	public List<NameAndId> findCarTypeByCarName(String carName, Operator oper);
	
	/**
	 * 查询所有车类型和id
	 */
	public List<NameAndId> findAllCarsIdAndType(Operator oper);
	
	/**
	 * 查询车类信息
	 */
	public void findCarByPage(Map map, int page, int pageSize,
			String carCountry, String carName, String carType, String sortAttr);
	
	/**
	 * 根据车系查询车品牌
	 */
	public List<String> findCarsByCarCountry(String carCountry, Operator oper);
	
	/**
	 * 增加车类
	 */
	public void txAddCar(Operator oper, Car car);
	
	/**
	 * 修改车类
	 */
	public boolean txUpdateCar(Operator oper, Car car,String id);
	
	/**
	 * (删除)取消车类
	 */
	public boolean txCancelCar(Operator oper,String[] idlist);
 
}
