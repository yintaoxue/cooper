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
