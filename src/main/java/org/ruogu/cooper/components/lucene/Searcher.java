package org.ruogu.cooper.components.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * 搜索
 * 
 * @author xueyintao 2014年6月13日 下午3:03:08
 * @since 1.0
 */
public class Searcher {

	static String indexPath = "E:\\run\\index";
	
	/**
	 * main方法
	 * @author xueyintao 2014年6月13日 下午3:03:08
	 * @param args
	 */
	public static void main(String[] args) {
		search();
	}
	
	static void search() {
		String field = "userId";
		String line = "userId:2";
		
		try {
			IndexReader reader = DirectoryReader.open(FSDirectory.open(new File(indexPath)));
			IndexSearcher searcher = new IndexSearcher(reader);
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
			QueryParser parser = new QueryParser(Version.LUCENE_47, field, analyzer);
			Query query = parser.parse(line);
			System.out.println("Searching for: " + query.toString(field));
			
			Thread.sleep(10000);
			TopDocs results = searcher.search(query, null, 100);
			int totalHits = results.totalHits;
			ScoreDoc[] hits = results.scoreDocs;
			
			System.out.println("totalHits:" + totalHits);
			
			for (int i = 0; i < totalHits; i++) {
				Document doc = searcher.doc(hits[i].doc);
				
				String userId = doc.get("userId");
				String companyFullName = doc.get("companyFullName");
				String tel = doc.get("tel");
				
				System.out.println("userId:" + userId + ", companyFullName:" + companyFullName + ", tel:" + tel);
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
