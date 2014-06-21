package org.ruogu.cooper.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JdbcUtil {
	private static final Logger LOG = LoggerFactory.getLogger(JdbcUtil.class);

	public static void closeConnection(Connection conn) {
		if (conn == null)
			return;
		try {
			conn.close();
		} catch (SQLException ex) {
			LOG.debug("Could not close JDBC Connection", ex);
		} catch (Throwable ex) {
			LOG.debug("Unexpected exception on closing JDBC Connection", ex);
		}
	}
	
	/**
	 * 连续关闭一系列的SQL相关对象<br/>
	 * 这些对象必须按照顺序关闭，否则会出错。
	 * 
	 * @param objsToClose 需要关闭的对象
	 */
	public static void close(Object... objsToClose) {
		for (Object obj : objsToClose) {
			try {
				if (obj != null) {
					if (obj instanceof ResultSet) {
						((ResultSet) obj).close();
					} else if (obj instanceof Statement) {
						((Statement) obj).close();
					} else if (obj instanceof PreparedStatement) {
						((PreparedStatement) obj).close();
					} else if (obj instanceof Connection) {
						((Connection) obj).close();
					} else {
						LOG.warn("对象" + obj.getClass().getName() + "不是可关闭的类型");
					}
				}
			} catch (SQLException e) {
			}
		}
	}

	public static void closeStatement(Statement stmt) {
		if (stmt == null)
			return;
		try {
			stmt.close();
		} catch (SQLException ex) {
			LOG.trace("Could not close JDBC Statement", ex);
		} catch (Throwable ex) {
			LOG.trace("Unexpected exception on closing JDBC Statement", ex);
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs == null)
			return;
		try {
			rs.close();
		} catch (SQLException ex) {
			LOG.trace("Could not close JDBC ResultSet", ex);
		} catch (Throwable ex) {
			LOG.trace("Unexpected exception on closing JDBC ResultSet", ex);
		}
	}
}
