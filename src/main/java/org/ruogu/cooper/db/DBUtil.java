package org.ruogu.cooper.db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * DBUtil
 * 
 * @author xueyintao 2014年6月21日 下午2:43:59
 * @since 1.0
 */
public class DBUtil {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static Connection getLead0Conn() {
		Connection conn = null;
		String url = "jdbc:mysql://localhost:3306/lead0?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&autoReconnectForPools=true&zeroDateTimeBehavior=convertToNull";
		String user = "lead";
		String pw = "lead";
		try {
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
