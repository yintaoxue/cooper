package org.ruogu.cooper.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	public static List<String> readFile(String path) {
		List<String> result = new ArrayList<String>();
		String webRootPath = null;
		if (null == path || path.length() == 0) {
			System.out.println("File path can not be null : " + path);
			return result;
		}
		webRootPath = FileUtil.class.getClassLoader().getResource("").getPath();
		webRootPath = new File(webRootPath).getParent();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(webRootPath + File.separator + "classes" + File.separator
					+ path)));
			
			String line = null;
			while((line = br.readLine()) != null) {
				result.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void writeLine(String fullFile, String line) {
		String webRootPath = null;
		if (null == fullFile || fullFile.equals(""))
			throw new IllegalArgumentException("File path can not be null : " + fullFile);
		webRootPath = FileUtil.class.getClassLoader().getResource("").getPath();
		webRootPath = new File(webRootPath).getParent();
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(new File(webRootPath + File.separator + "classes" + File.separator
					+ "data" + File.separator + fullFile)));
			br.write(line);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
