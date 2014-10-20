package org.ruogu.cooper.components.elasticsearch;

import org.json.JSONException;
import org.json.JSONObject;

public class FieldSchema {
	
	public static final String INDEX_ANALYZED = "analyzed";
	public static final String INDEX_NOT_ANALYZED = "not_analyzed";
	public static final String INDEX_NO = "no";
	
	private JSONObject field = new JSONObject();

	/**
	 * analyzed default true
	 * 
	 * @param fieldName
	 * @param type
	 * @throws JSONException
	 */
	public void addField(String fieldName) throws JSONException {
		addField(fieldName, "string", true);
	}

	/**
	 * analyzed default true
	 * 
	 * @param fieldName
	 * @param type
	 * @throws JSONException
	 */
	public void addField(String fieldName, String type) throws JSONException {
		addField(fieldName, type, true);
	}

	public void addField(String fieldName, String type, boolean analyzed) throws JSONException {
		JSONObject mapping = new JSONObject();
		mapping.put("type", type);
		if (!analyzed) {
			mapping.put("index", "not_analyzed");
		}
		field.put(fieldName, mapping);
	}
	
	public void addField(String fieldName, String type, String analyzed) throws JSONException {
		JSONObject mapping = new JSONObject();
		mapping.put("type", type);
		if (analyzed.equals(INDEX_ANALYZED)) {
			mapping.put("index", INDEX_ANALYZED);
		} else if (analyzed.equals(INDEX_NOT_ANALYZED)) {
			mapping.put("index", INDEX_NOT_ANALYZED);
		} else if (analyzed.equals(INDEX_NO)) {
			mapping.put("index", INDEX_NO);
		} else {
			mapping.put("index", "INDEX_NOT_ANALYZED");
		}
		
		field.put(fieldName, mapping);	
	}

	public String toMapping() throws JSONException {
		JSONObject properties = new JSONObject();
		properties.put("properties", field);
		return properties.toString();
	}

	public static void main(String[] args) throws Exception {
		FieldSchema fs = new FieldSchema();
		fs.addField("field1");
		fs.addField("field2", "long");
		fs.addField("field3", "string", INDEX_ANALYZED);
		fs.addField("field3", "string", INDEX_NO);
		System.err.println(fs.toMapping());
	}

}
