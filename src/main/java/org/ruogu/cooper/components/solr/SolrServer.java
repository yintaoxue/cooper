package org.ruogu.cooper.components.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

/**
 * SolrServer
 * 
 * @author xueyintao 2014年6月17日 下午6:44:07
 * @since 1.0
 */
public class SolrServer {
	static String url = "http://localhost:8080/uq/core0";
	static HttpSolrServer server = null;

	static {
		init();
	}

	/**
	 * 初始化SolrServer
	 */
	static void init() {
		if (server != null) {
			server.shutdown();
			server = null;
		}
		server = new HttpSolrServer(url);

		server.setMaxRetries(1); // defaults to 0. > 1 not recommended.
		server.setConnectionTimeout(5000); // 5 seconds to establish TCP

		// 默认使用binary parser，需要兼容1.4.1之前和3.1之后版本时设置为XMLResponseParser
		// server.setParser(new XMLResponseParser()); // binary parser is used

		server.setSoTimeout(1000); // socket read timeout
		server.setDefaultMaxConnectionsPerHost(100);
		server.setMaxTotalConnections(100);
		server.setFollowRedirects(false); // defaults to false
		// allowCompression defaults to false.
		// Server side must support gzip or deflate for this to have any effect.
		server.setAllowCompression(true);
	}
	
	public static void commit() throws SolrServerException, IOException {
		if (server != null) {
			server.commit();
		}
	}
	
	public static HttpSolrServer getServer() {
		if (server == null) {
			init();
		}
		return server;
	}

}
