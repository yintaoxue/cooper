/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ruogu.cooper.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class CollectionUtil {

	/**
	 * 将集合转换为不包含<code>null</code>的字符串数组；注意：如果数组元素有<code>null</code>存在，
	 * {@link Arrays#sort(Object[])}将会抛出{@link NullPointerException}
	 * 
	 * @param collection
	 *            要转换的集合
	 * @return 字符串数组
	 */
	public static String[] toNoNullStringArray(
			final Collection<String> collection) {
		if (collection == null) {
			return ArrayUtils.EMPTY_STRING_ARRAY;
		}
		return toNoNullStringArray(collection.toArray());
	}

	/**
	 * 返回新的不包含null元素的数组。注意：如果数组元素有<code>null</code>存在，
	 * 
	 * @param array
	 *            需要检查的数组
	 * @return 不包含null的数组.
	 */
	public static String[] toNoNullStringArray(final Object[] array) {
		final List<String> list = new ArrayList<String>(array.length);
		for (final Object e : array) {
			if (e != null) {
				list.add(e.toString());
			}
		}
		return list.toArray(ArrayUtils.EMPTY_STRING_ARRAY);
	}
}
