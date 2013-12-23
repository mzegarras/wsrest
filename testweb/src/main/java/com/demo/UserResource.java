package com.demo;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class UserResource extends ServerResource { 

	
	String userName;  
	Object user;
	
	@Override
	public void init(Context arg0, Request arg1, Response arg2) {
		// TODO Auto-generated method stub
		super.init(arg0, arg1, arg2);
		
		
		 this.userName = (String) getRequestAttributes().get("user");  
	     this.user = null; // Could be a lookup to a domain object.  
	        
	}
	
	
	@Get  
    public String toString() {  
        return "Account of user \"" + this.userName + "\"";  
    }
	
	
}
