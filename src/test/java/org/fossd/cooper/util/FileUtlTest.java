package org.fossd.cooper.util;

import java.util.List;

import org.ruogu.cooper.util.FileUtil;

/**
 * FileUtlTest
 *
 * @author xueyintao 2014年11月27日 下午7:46:59
 */
public class FileUtlTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> lines = FileUtil.readFile("C:\\Users\\Talin\\Desktop\\test.txt");
		
		System.out.println(lines);
		
		FileUtil.writeLine("C:\\Users\\Talin\\Desktop\\test2.txt", lines);
	}

}
