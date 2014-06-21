package org.ruogu.cooper.components.solr;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

/**
 * 索引
 * 
 * @author xueyintao 2014年6月17日 下午5:37:37
 * @since 1.0
 */
public class Indexer {

	public static void index(OppoDoc oppoDoc) throws SolrServerException, IOException {
		index(oppoDoc, true);
	}
	
	public static void index(OppoDoc oppoDoc, boolean isCommit) throws SolrServerException, IOException {
		HttpSolrServer server = SolrServer.getServer();
		server.addBean(oppoDoc);
		if (isCommit) {
			server.commit();
		}
	}

	public static void index(SolrInputDocument doc, boolean isCommit) throws SolrServerException, IOException {
		HttpSolrServer server = SolrServer.getServer();
		server.add(doc);
		if (isCommit) {
			server.commit();
		}
	}

	/**
	 * 给doc添加字段
	 * 
	 * @author xueyintao 2014年6月17日 下午8:33:46
	 * @param doc
	 * @param name
	 * @param value
	 */
	public static void addField(SolrInputDocument doc, String name, Object value) {
		if (value == null)
			return;
		if ((value instanceof String)) {
			String str = value.toString().trim();
			if (str.length() == 0) {
				return;
			}
			doc.addField(name, str);
			return;
		}
		doc.addField(name, value);
	}

	public static void index1() throws SolrServerException, IOException {
		HttpSolrServer server = SolrServer.getServer();

		SolrInputDocument doc = new SolrInputDocument();
		doc.addField("id", 2014);
		doc.addField("type", "book");
		doc.addField("name", "The Legend of the Hobbit part " + 2014);
		server.add(doc);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		server.commit();
	}

	public static void index() throws SolrServerException, IOException {
		HttpSolrServer server = SolrServer.getServer();
		for (int i = 0; i < 1000; ++i) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", i);
			doc.addField("type", "book");
			doc.addField("name", "The Legend of the Hobbit part " + i);
			server.add(doc);
			if (i % 100 == 0)
				server.commit(); // periodically flush
		}
		server.commit();
	}

	static void indexDocs(OppoDoc oppoDoc) throws IOException {

	}

}
