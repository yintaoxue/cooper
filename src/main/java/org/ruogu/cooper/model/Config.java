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

public class Config extends HashMap<String, Object> {
	private static final long serialVersionUID = -2810949267139897466L;

	public String getString(String key) {
        if (get(key) != null) {
            return get(key).toString();
        }
        return null;
    }

    public Double getDouble(String key) {
        if (get(key) != null) {
            return Double.parseDouble(get(key).toString());
        }
        return null;
    }

    public Integer getInteger(String key) {
        if (get(key) != null) {
            return Integer.parseInt(get(key).toString());
        }
        return null;
    }

    public Long getLong(String key) {
        if (get(key) != null) {
            return Long.parseLong(get(key).toString());
        }
        return null;
    }
}
