package org.ruogu.cooper.components.lucene;

import java.io.File;
import java.io.IOException;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/**
 * 索引服务
 * 
 * @author xueyintao 年月日 下午::
 * @since .
 */
public class Indexer {

	static String indexPath = "E:\\run\\index";

	/**
	 * main方法
	 * 
	 * @author xueyintao 年月日 下午::
	 * @param args
	 */
	public static void main(String[] args) {
		index();
	}

	public static void index() {
		try {
			System.out.println("Indexing to directory '" + indexPath + "'...");

			OppoDoc doc1 = new OppoDoc();
			doc1.setUserId("1");
			doc1.setCompanyFullName("58同城");
			doc1.setTel("5858");

			OppoDoc doc2 = new OppoDoc();
			doc2.setUserId("2");
			doc2.setCompanyFullName("百度");
			doc2.setTel("1001");
			
			OppoDoc doc3 = new OppoDoc();
			doc3.setUserId("3");
			doc3.setCompanyFullName("阿里");
			doc3.setTel("1003");

			Directory dir = FSDirectory.open(new File(indexPath));
			Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_47);
			IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_47, analyzer);
			iwc.setOpenMode(OpenMode.CREATE);
//			iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
			IndexWriter writer = new IndexWriter(dir, iwc);

//			Thread.sleep(60000);
			
			indexDocs(writer, doc1);
			
//			Thread.sleep(6000);
			
			indexDocs(writer, doc2);
			
			indexDocs(writer, doc3);

			writer.close();

			System.out.println("Index end...");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void indexDocs(IndexWriter writer, OppoDoc oppoDoc) throws IOException {

		Document doc = new Document();

		Field userIdFiled = new StringField("userId", oppoDoc.getUserId(), Field.Store.YES);
		doc.add(userIdFiled);

		doc.add(new StringField("companyFullName", oppoDoc.getCompanyFullName(), Field.Store.YES));
		doc.add(new StringField("tel", oppoDoc.getTel(), Field.Store.YES));

		writer.updateDocument(new Term("userId", oppoDoc.getUserId()), doc);

	}

}
