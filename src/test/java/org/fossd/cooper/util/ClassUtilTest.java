package org.fossd.cooper.util;

import org.junit.Assert;
import org.junit.Test;
import org.ruogu.cooper.util.ClassUtil;

/**
 * 
 * @author xueyintao 2014年7月25日 下午9:24:54
 * @since 1.0
 */
public class ClassUtilTest {

	@Test
	public void getPackageName() {
		String rs = ClassUtil.getPackageName(ClassUtil.class);
		System.out.println("getPackageName:" + rs);
		Assert.assertEquals(rs, "org.ruogu.cooper.util");
	}

	@Test
	public void getFullName() {
		String rs = ClassUtil.getFullName(ClassUtil.class);
		System.out.println("getFullName:" + rs);
		Assert.assertEquals(rs, "org.ruogu.cooper.util.ClassUtil");
	}
	
	@Test
	public void getClassName() {
		String rs = ClassUtil.getClassName(ClassUtil.class);
		System.out.println("getClassName:" + rs);
		Assert.assertEquals(rs, "ClassUtil");
	}
}
