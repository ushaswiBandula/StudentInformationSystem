package com.sis.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBPropertyUtil {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "Mysql@123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
