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
package org.ruogu.cooper.model;

import java.util.HashMap;
import java.util.Map;

public class Params {
	private Map<String, String[]> params = new HashMap<String, String[]>();
	
	public Params() {}
	
	public Params(Map<String, String[]> params) {
		this.putAll(params);
	}
	
	public void put(String key, String value) {
		params.put(key, new String[]{value});
	}
	
	public void put(String key, String[] values) {
		params.put(key, values);
	}
	
	public void putAll(Map<String, String[]> params) {
		if (params == null)
			return;
		params.putAll(params);
	}
	
	public String get(String key) {
		String[] values = params.get(key);
		return values.length > 0 ? values[0] : null;
	}
	
	public String[] getArray(String key) {
		return params.get(key);
	}
}
