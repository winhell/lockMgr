package com.lockMgr.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class OpenfireofuserHandle {
	public static void addOfuser(String name, String password) {
		Connection conn = OpenfireDBHander.getConnection();
		String encryPWD = OpenfireEncrytionAndDecryption.getEncryPWD(password);
		String sql = "insert into ofUser(username,encryptedPassword,creationDate,modificationDate) values('"
				+ name + "','" + encryPWD + "','0','0')";
		System.out.println(name);
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OpenfireDBHander.closeConnection(conn);
		}
	}
	
	/**
	 * openfire的ofUser表没有id字段，所以根据username定位用户
	 */
	public static void modifyPwd(String userName, String newPwd) {
		Connection conn = OpenfireDBHander.getConnection();
		String encryPwd = OpenfireEncrytionAndDecryption.getEncryPWD(newPwd);  //根据openfire加密算法加密密码
		String sql = " update ofUser set encryptedPassword='" + encryPwd + "' where username='" + userName + "' ";
		try {
			Statement s = conn.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OpenfireDBHander.closeConnection(conn);
		}
	}

	public static void delOfuser(String username) {
		Connection conn = OpenfireDBHander.getConnection();
		String sql = "delete from ofuser where username='" + username + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OpenfireDBHander.closeConnection(conn);
		}
	}

	public static void updateOfuser(String oldName, String name, String password) {
		Connection conn = OpenfireDBHander.getConnection();
		String encryPWD = OpenfireEncrytionAndDecryption.getEncryPWD(password);
		String sql = "update  ofuser set username='" + name
				+ "',encryptedPassword='" + encryPWD + "' where username='"
				+ oldName + "'";
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OpenfireDBHander.closeConnection(conn);
		}
	}

	public static void main(String[] args) {
		addOfuser("huang", "huang");
		delOfuser("huang");
		updateOfuser("h", "h2", "123");

	}
}
