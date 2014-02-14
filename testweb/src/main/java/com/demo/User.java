package com.demo;

import org.json.JSONObject;

public class User {

	private String id = null;
	private String name = null;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Convert this object to a JSON object for representation
	 */
	public JSONObject toJSON() {
		try {
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("id", this.id);
			jsonobj.put("name", this.name);
			return jsonobj;
		} catch (Exception e) {
			return null;
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("id:");
		sb.append(this.id);
		sb.append(",name:");
		sb.append(this.name);
		return sb.toString();
	}

}
