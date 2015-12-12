package com.lockMgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lockMgr.core.BaseDao;
import com.lockMgr.pojo.Car;
import com.lockMgr.pojo.CarNameAndLogo;
import com.lockMgr.pojo.NameAndId;
import com.lockMgr.pojo.Operator;

/**
 * 车系资源实现类
 * 
 * @author lzc
 * 
 */
public class CarService extends BaseDao<Car> implements ICarService {

	/**
	 * 根据车系查询车种类
	 */
	public List findCarByCountry(int page, int pageSize, String carCountry) {
		// try {
		// carCountry = new String(carCountry.getBytes("utf-8"),"iso-8859-1");
		// } catch (UnsupportedEncodingException e) {
		// e.printStackTrace();
		// }
		List<Car> carList = new ArrayList<Car>();
		Car car = new Car();
		// Connection conn = DBUtil.getConnection();
		// String sql =
		// " select distinct carName,carLogo from car where carCountry=? and status=1 ";
		// try {
		// PreparedStatement ps = conn.prepareStatement(sql);
		// ps.setString(1, carCountry);
		// ResultSet rs = ps.executeQuery();
		// while(rs.next()) {
		// car.setCarName(rs.getString("carName"));
		// car.setCarLogo(rs.getString("carLogo"));
		// carList.add(car);
		// }
		// } catch (SQLException e) {
		// e.printStackTrace();
		// } finally {
		// if(conn != null) {
		// DBUtil.closeConnection();
		// }
		// }
		// String carName = "";
		// String hql0 = "select distinct carName from Car where carCountry=? and status=1 ";
		String hql = " select distinct carName,carLogo from Car where carCountry=? and status=1 ";
		// carList = find(hql, new Object[]{carCountry});
		List<CarNameAndLogo> listL = new ArrayList<CarNameAndLogo>();
		CarNameAndLogo carNameAndLogo = null;
		List<Object[]> result_list = publicFind(hql,new Object[]{carCountry});
		for (Object[] str : result_list) {
			carNameAndLogo = new CarNameAndLogo();
			carNameAndLogo.setCarLogo(str[1].toString());
			carNameAndLogo.setCarName(str[0].toString());
			listL.add(carNameAndLogo);
		}
		return listL;
	}

	/**
	 * 根据车类查询
	 */

	/**
	 * 查询所有车id和品牌
	 */
	public List<NameAndId> findAllCarsIdAndName(Operator oper) {
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Car> carList = null;
		String hql = "from Car where status=1 order by carName";
		carList = find(hql);
		nameAndId = new NameAndId();
		nameAndId.setId("");
		nameAndId.setName("所有车类  ");
		list.add(nameAndId);
		for (Car car : carList) {
			nameAndId = new NameAndId();
			nameAndId.setId(car.getId());
			nameAndId.setName(car.getCarName());
			list.add(nameAndId);
		}
		return list;
	}

	/**
	 * 根据车系查询车品牌和id(此处仅查询车名,去重)
	 */
	public List<NameAndId> findCarsIdAndNameByCarCountry(String carCountry,
			Operator oper) {
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Car> carList = null;
		String hql = " select distinct carName from Car where status=1 and carCountry=? order by carName ";
//		carList = find(hql, new Object[] { carCountry });
		List<String> carNameList = publicFind(hql, new Object[]{carCountry});
		nameAndId = new NameAndId();
		// nameAndId.setId("");
		// nameAndId.setName("所有车类  ");
		// list.add(nameAndId);
//		for (Car car : carList) {
//			nameAndId = new NameAndId();
////			nameAndId.setId(car.getId());
//			nameAndId.setName(car.getCarName());
//			list.add(nameAndId);
//		}
		if(carNameList != null && carNameList.size() != 0) {
			for(int i=0; i<carNameList.size(); i++) {
				nameAndId = new NameAndId();
				nameAndId.setName(carNameList.get(i));
				list.add(nameAndId);
			}
		}
		return list;
	}
	/**
	 * 根据车名查询车类别,去重
	 */
	@SuppressWarnings("unchecked")
	public List<NameAndId> findCarTypeByCarName(String carName, Operator oper) {
		List<NameAndId> list = new ArrayList<NameAndId>();
		String hql = " select distinct carType from Car where status=1 and carName=? ";
		List<String> carTypeList = publicFind(hql, new Object[]{carName});
		NameAndId nameAndId = new NameAndId();
		if(carTypeList != null && carTypeList.size() != 0) {
			for(int i=0; i<carTypeList.size(); i++) {
				nameAndId = new NameAndId();
				nameAndId.setName(carTypeList.get(i));
				list.add(nameAndId);
			}
		}
		return list;
	}

	/**
	 * 查询所有车类型和id
	 */
	public List<NameAndId> findAllCarsIdAndType(Operator oper) {
		List<NameAndId> list = new ArrayList<NameAndId>();
		NameAndId nameAndId = null;
		List<Car> carList = null;
		String hql = "from Car where status=1 order by carCountry";
		carList = find(hql);
		nameAndId = new NameAndId();
		nameAndId.setId("");
		nameAndId.setName("所有类型 ");
		list.add(nameAndId);
		for (Car car : carList) {
			nameAndId = new NameAndId();
			nameAndId.setId(car.getId());
			nameAndId.setName(car.getCarType());
			list.add(nameAndId);
		}
		return list;
	}

	/**
	 * 查询车类信息
	 */
	public void findCarByPage(Map map, int page, int pageSize,
			String carCountry, String carName, String carType, String sortAttr) {
		int paramNums = 0;
		List<Object> list = new ArrayList<Object>();
		String hql = " from Car where status=1 ";
		if (carCountry != null && carCountry.trim().length() != 0) {
			hql += " and carCountry=? ";
			list.add(carCountry);
			paramNums++;
		}
		if (carName != null && carName.trim().length() != 0
				&& !carName.trim().equals("所有车类")) {
			hql += " and carName=? ";
			list.add(carName);
			paramNums++;
		}
		if (carType != null && carType.trim().length() != 0
				&& !carType.trim().equals("所有类型")) {
			hql += " and carType=? ";
			list.add(carType);
			paramNums++;
		}
		if (sortAttr != null) {
			hql += " order by " + sortAttr;
		} else {
			hql += "  ORDER BY createtime desc";
		}
		Object[] values = list.toArray(new Object[paramNums]);
		fillPagetoMap(map, hql, values, page, pageSize);

	}

	/**
	 * 根据车系查询车品牌
	 */
	public List<String> findCarsByCarCountry(String carCountry, Operator oper) {
		List<String> list = new ArrayList<String>();
		List<Car> carList = new ArrayList<Car>();
		String hql = " from Car where status=1 and carCountry=? order by carName";
		carList = find(hql, new Object[] { carCountry });
		list.add("所有车类");
		for (int i = 0; i < carList.size(); i++) {
			list.add(carList.get(i).getCarName());
		}
		return list;
	}

	/**
	 * 增加车类
	 */
	public void txAddCar(Operator oper, Car car) {
		car.setStatus(1);
		save(car);
		writeLog(oper, "添加", "车类", car);
	}

	/**
	 * 修改车类
	 */
	public boolean txUpdateCar(Operator oper, Car car, String id) {
		car.setId(id);
		saveOrUpdate(car);
		writeLog(oper, "修改", "车类信息", car);
		return true;
	}

	/**
	 * (删除)取消车类
	 */
	public boolean txCancelCar(Operator oper, String[] idlist) {
		for (String id : idlist) {
			Car car = findById(id);
			car.setStatus(0);
			saveOrUpdate(car);
			writeLog(oper, "删除", "车类", car);
		}
		return true;
	}

}
