package com.lockMgr.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
		private static String user;
		private static String password;
		private static String url;
		private static String driver;
		//线程安全
		private static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
		
		//静态代码块,一次加载常驻内存,省得调用一遍就创建一个对象
		static{
			//创建一个Properties对象,导入util包
			Properties p = new Properties();
			try {
				//把db.properties文件读入
				p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
				//现在把读入对象p中的值全部赋值给上面定义的属性
				user = p.getProperty("user");
				password = p.getProperty("password");
				url = p.getProperty("url");
				driver = p.getProperty("driver");
				//注册驱动,编译时需要抛出一个ClassNotFoundException
				Class.forName(driver);
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("db.properties文件读入失败",e);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("注册驱动失败",e);
			}
		}
		
		public static Connection getConnection() {
			Connection conn = t1.get();
			try {
				conn = DriverManager.getConnection(url, user, password);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("获取数据库连接失败", e);
			}
			return conn;
		}
		public static void closeConnection() {
			Connection conn = t1.get();
			if(conn != null) {
				try {
					conn.close();
					t1.set(null);
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭连接失败", e);
				}
			}
		}
		
		//测试连接(与以前的DBUtil对比下)
		public static void main(String[] args) {
			System.out.println(getConnection());
			closeConnection();
		}
		
}
