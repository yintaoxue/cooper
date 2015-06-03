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

	public static List<String> readFile(String fileName) {
		List<String> result = new ArrayList<String>();
		if (null == fileName || fileName.length() == 0) {
			System.out.println("File path can not be null : " + fileName);
			return result;
		}
	
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File(fileName)));
			
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

	public static void writeLine(String fileName, List<String> lines) {
		if (null == fileName || fileName.equals(""))
			throw new IllegalArgumentException("File path can not be null : " + fileName);
		
		if (lines == null) {
			System.out.println("lines is null");
			return;
		}

		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(new File(fileName)));
			for (String line : lines) {
				br.write(line + "\n");
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
	}
	
	public static void writeLine(String fileName, List<String> lines, boolean append) {
		if (null == fileName || fileName.equals(""))
			throw new IllegalArgumentException("File path can not be null : " + fileName);
		
		if (lines == null) {
			System.out.println("lines is null");
			return;
		}

		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(new File(fileName), append));
			for (String line : lines) {
				br.write(line + "\n");
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
	}
}
