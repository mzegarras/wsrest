package com.demo.entidades;

import org.json.JSONObject;

public class User {

	
	private int id;
	  private String username;
	  private String name;
		
	  public int getId() {
	    return id;
	  }
		
	  public void setId(int id) {
	    this.id = id;
	  }

	  public String getUsername() {
	    return username;
	  }
		
	  public void setUsername(String username) {
	    this.username = username;
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
	  try{
	   JSONObject jsonobj = new JSONObject();
	   jsonobj.put("id", this.id);
	   jsonobj.put("name", this.name);
	   return jsonobj;
	  }catch(Exception e){
	   return null;
	  }
	  }

	  /**
	   * Convert this object to a string for representation
	   */
	  public String toString() {
	   StringBuffer sb = new StringBuffer();
	   sb.append("id:");
	   sb.append(this.id);
	   sb.append(",name:");
	   sb.append(this.name);
	   return sb.toString();
	  }
}
