package org.ruogu.cooper.util;

/**
 * 
 * @author xueyintao 2014年7月25日 下午9:23:50
 * @since 1.0
 */
public class ClassUtil {
	
	/**
	 * 包名
	 * org.ruogu.cooper.util
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getPackageName(Class<?> clazz) {
		return clazz.getPackage().getName();
	}

	/**
	 * 类的全路径名称(包名+类名)
	 * org.ruogu.cooper.util.ClassUtil
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getFullName(Class<?> clazz) {
		return clazz.getName();
	}
	
	/**
	 * 类名
	 * ClassUtil
	 * 
	 * @param clazz
	 * @return
	 */
	public static String getClassName(Class<?> clazz) {
		return clazz.getSimpleName();
	}
}
