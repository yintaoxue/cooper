package org.ruogu.cooper.usecases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.ruogu.cooper.util.FileUtil;

/**
 * JsoupUsecase
 *
 * @author xueyintao 2015年6月3日 下午10:57:01
 */
public class JsoupUsecase {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String intput = "C:\\Users\\Talin\\Desktop\\test\\tt";
		String output = "C:\\Users\\Talin\\Desktop\\test.txt";
		
		for (int i = 0; i < 20; i++) {
			String in = intput;
			if (i < 10) {
				in += "0" + i + ".xls";
			} else {
				in += i + ".xls";
			}
			System.out.println(in);
			parse(in, output);
		}
		
		
		
		System.out.println("success");
	}
	
	public static void parse(String in, String out) throws IOException {
		List<String> list = new ArrayList<String>();
		Document doc =	Jsoup.parse(new File(in), "UTF-8");
		Elements trs = doc.getElementsByTag("tr");
		System.out.println("trs.size:" +trs.size());
		for (Element tr : trs) {
			Elements tds = tr.getElementsByTag("td");
			String line = "";
			int i = 0;
			for (Element td : tds) {
				String text = td.text();
				line += text + "\t";
				i++;
				if (i == 8) {
					break;
				}
			}
			if (line.endsWith("\t")) {
				line = line.substring(0, line.length() - 1);
			}
			list.add(line);
		}
		FileUtil.writeLine(out, list, true);
	}

}
