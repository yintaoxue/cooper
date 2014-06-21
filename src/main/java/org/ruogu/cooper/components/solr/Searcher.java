package org.ruogu.cooper.components.solr;

import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

/**
 * 搜索查询
 * 
 * @author xueyintao 2014年6月17日 下午4:59:07
 * @since 1.0
 */
public class Searcher<T> {

	/**
	 * 查询
	 * 
	 * @author xueyintao 2014年6月17日 下午8:51:49
	 * @param query
	 * @throws SolrServerException
	 */
	public static SolrDocumentList search(SolrQuery query) throws SolrServerException {
		HttpSolrServer server = SolrServer.getServer();

		QueryResponse response = server.query(query);
		
		SolrDocumentList results = response.getResults();
		return results;
	}
	
	public static List<OppoDoc> searchBeans(SolrQuery query) throws SolrServerException {
		HttpSolrServer server = SolrServer.getServer();

		QueryResponse response = server.query(query);
		List<OppoDoc> list = response.getBeans(OppoDoc.class);
		return list;
	}
}
