package com.lockMgr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OpenfireDBHander
{
	//private static Connection conn = null;
	//private static Statement stmt = null;

	public OpenfireDBHander()
	{

	}

	static
	{
		try
		{
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			//Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Class.forName("com.mysql.jdbc.Driver");
		}

		catch (ClassNotFoundException e)
		{

			System.out.println("驱动加载错误");

		}
	}

	public static  Connection getConnection()
	{
		// String url = "jdbc:odbc:BookManageSystem";
		//String url = "jdbc:sqlserver://localhost:1433;databaseName=BookManageSystem";
            String url="jdbc:mysql://120.24.58.163/openfire?useUnicode=true&amp;characterEncoding=utf-8";
		String username = "root";

		String password = "config01";

		try

		{

		Connection	conn = DriverManager.getConnection(url, username, password);
		
		return conn;

			//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
			//		ResultSet.CONCUR_READ_ONLY);

		}
		catch (SQLException e)
		{

			System.out.println("connection error");

			e.printStackTrace();
			return null;
  
		}
		// DBHander hander=new DBHander();
		// hander.executeQuery("select * from tb_operator_admin");

	}

	

	
	public static void closeConnection(Connection conn)
	{
		if(null!=conn)
		{
			try
			{
				conn.close();
			}
			catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
public static void main(String[] args) throws SQLException
{
 Connection con=getConnection();
 System.out.println(con);
 closeConnection(con);
 System.out.println(con.isClosed());
}
}
