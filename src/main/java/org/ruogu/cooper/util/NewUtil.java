package org.ruogu.cooper.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 集合生成器
 * 
 * @author Talin
 * @see Thinking in Java 4th, p362
 */
public class NewUtil {
	
	public static <K,V> Map<K,V> map() {
		return new HashMap<K,V>();
	}
	
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}
	
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}
	
	public static <T> LinkedList<T> linkedList() {
		return new LinkedList<T>();
	}
	
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
}
