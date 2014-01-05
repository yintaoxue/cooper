package org.ruogu.cooper.model;

import java.util.HashMap;

public class Entity extends HashMap<String, Object> {
	
	private static final long serialVersionUID = 7906965015024137958L;

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
