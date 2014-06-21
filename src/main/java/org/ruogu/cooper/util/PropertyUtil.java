package org.ruogu.cooper.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	public static Properties loadDbPropertyFile(String fullFile) {
		String webRootPath = null;
		if (null == fullFile || fullFile.equals(""))
			throw new IllegalArgumentException("Properties file path can not be null : " + fullFile);
		webRootPath = PropertyUtil.class.getClassLoader().getResource("").getPath();
		webRootPath = new File(webRootPath).getParent();
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(webRootPath + File.separator + "classes" + File.separator
					+ "config" + File.separator + "db" + File.separator + fullFile));
			p = new Properties();
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: " + fullFile);
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + fullFile);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
	
	
	public static Properties loadPropertyFile(String fileName) {
		String webRootPath = null;
		if (null == fileName || fileName.equals(""))
			throw new IllegalArgumentException("Properties file path can not be null : " + fileName);
		webRootPath = PropertyUtil.class.getClassLoader().getResource("").getPath();
		webRootPath = new File(webRootPath).getParent();
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(webRootPath + File.separator + "classes" + File.separator
					+ "config" + File.separator + fileName));
			p = new Properties();
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: " + fileName);
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + fileName);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

	public static Properties loadProperty(String filePath) {
		if (null == filePath || filePath.equals(""))
			throw new IllegalArgumentException("Properties file path can not be null : " + filePath);
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(filePath));
			p = new Properties();
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: " + filePath);
		} catch (IOException e) {
			throw new IllegalArgumentException("Properties file can not be loading: " + filePath);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}
