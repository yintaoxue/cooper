package org.ruogu.cooper.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.ruogu.cooper.util.PropertyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

public class ConnPool {
	private static final Logger LOG = LoggerFactory.getLogger(ConnPool.class);

	private static ConnPool connPool = null;
	private static DruidDataSource dds = null;
	private static String confile = "db_wis.properties";

	static {
		Properties properties = PropertyUtil.loadDbPropertyFile(confile);
		try {
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ConnPool() {
	}

	public static synchronized ConnPool getInstance() {
		if (null == connPool) {
			connPool = new ConnPool();
		}
		return connPool;
	}

	public synchronized Connection getConnection() throws SQLException {
		return dds.getConnection();
	}

	public synchronized void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				LOG.error("Could not close connection.", e);
			}
		}
	}
}
