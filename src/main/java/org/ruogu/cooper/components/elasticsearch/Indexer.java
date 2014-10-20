package org.ruogu.cooper.components.elasticsearch;

import java.io.IOException;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingRequest;
import org.elasticsearch.action.admin.indices.mapping.put.PutMappingResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.Requests;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class Indexer {
	public static void main(String[] args) throws ElasticsearchException, IOException {
		Settings settings = ImmutableSettings.settingsBuilder().put("cluster.name", "elasticsearch").put("node.name","node").put("client.transport.sniff", true).build();
		Client client = new TransportClient(settings).addTransportAddress(new InetSocketTransportAddress("192.168.1.3", 9300));
		
		FieldSchema fs = new FieldSchema();
		fs.addField("id", "long");
		fs.addField("name");
		fs.addField("url", "string", FieldSchema.INDEX_NO);
		
		PutMappingRequest mappingRequest = Requests.putMappingRequest("testindex").type("article").source(fs.toMapping());  
		PutMappingResponse response = client.admin().indices().putMapping(mappingRequest).actionGet(); 
		


		
//		
//		IndexResponse response = client.prepareIndex("testindex", "article")
//			    .setSource(fs.toMapping())
//			    .setTTL(8000)
//			    .execute().actionGet();

			System.out.println(response.toString());

	}
}
