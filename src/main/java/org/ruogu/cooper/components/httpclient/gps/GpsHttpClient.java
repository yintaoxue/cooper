package org.ruogu.cooper.components.httpclient.gps;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * GpsHttpClient
 *
 * @author xueyintao 2014年11月2日 下午5:04:02
 */
public class GpsHttpClient {

	// 连接池
	private static PoolingHttpClientConnectionManager pool = null;

	private static int poolMaxTotal = 50;
	private static int poolMaxPerRoute = 50;

	public static void init() {
		pool = new PoolingHttpClientConnectionManager();
		// Max total connection
		pool.setMaxTotal(poolMaxTotal);
		// Default max connection per route
		pool.setDefaultMaxPerRoute(poolMaxPerRoute);

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(pool).build();
		
	}

}
