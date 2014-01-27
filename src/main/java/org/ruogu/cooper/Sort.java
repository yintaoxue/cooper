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
package org.ruogu.cooper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.ruogu.cooper.model.Entity;

public class Sort {

	public void sort(List<Entity> dataList) {
		if (dataList == null) {
			return;
		}
		// 升序排列
		Collections.sort(dataList, new Comparator<Entity>() {
			public int compare(Entity e1, Entity e2) {
				int s1 = e1.getInteger("score");
				int s2 = e2.getInteger("score");
				
				if (s1 > s2) {
					return 1;
				} else if (s1 == s2) {
					return 0;
				} else {
					return -1;
				}
			}
		});
		// 降序排列
		Collections.reverse(dataList);
	}

}
