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
package org.fossd.cooper;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.ruogu.cooper.Sort;
import org.ruogu.cooper.model.Entity;

public class TestSort {

	@Test
	public void testSort() {
		List<Entity> list = new ArrayList<Entity>();
		Entity e1 = new Entity();
		e1.put("name", "e1");
		e1.put("score", 5);
		Entity e2 = new Entity();
		e2.put("name", "e2");
		e2.put("score", 3);
		Entity e3 = new Entity();
		e3.put("name", "e3");
		e3.put("score", 4);
		list.add(e1);
		list.add(e2);
		list.add(e3);
		
		Sort sort = new Sort();
		sort.sort(list);
		
		System.out.println(list);
		
		assertSame("not e1", "e1", list.get(0).getString("name"));
		assertSame("not e3", "e3", list.get(1).getString("name"));
		assertSame("not e2", "e2", list.get(2).getString("name"));
		
//		fail("Not yet implemented");
	}

}
