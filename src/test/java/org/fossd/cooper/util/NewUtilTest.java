package org.fossd.cooper.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.ruogu.cooper.util.NewUtil;

public class NewUtilTest {

	@Test
	public void testMap() {
		Map<String, String> map1 = NewUtil.map();
		map1.put("k1", "1234");
		Assert.assertEquals("1234", map1.get("k1"));
		
		Map<String, List<String>> map2 = NewUtil.map();
		List<String> list = new ArrayList<String>();
		list.add("5");
		map2.put("k1", list);
		Assert.assertEquals("5", map2.get("k1").get(0));
	}

	@Test
	public void testList() {
		
	}

	@Test
	public void testSet() {
		
	}

	@Test
	public void testLinkedList() {
		
	}

	@Test
	public void testQueue() {
		
	}

}
