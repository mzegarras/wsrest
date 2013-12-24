package com.demo;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;



public class OrdersResource extends  ServerResource { 

	String userName;
	String order;
	
	@Override
    public void init(Context context, Request request, Response response) {
        super.init(context, request, response);
        // code originally in non-default constructor
        this.userName = (String) getRequestAttributes().get("user");  
        this.order = (String) getRequestAttributes().get("order");  
    }
	
	
	@Get  
    public String toString() {  
		if(this.order!=null){
			return "Orders of user \"" + this.userName + "\":" + this.order;
		}else{
			return "Orders of user \"" + this.userName + "\":" + "nullo";
		}
    }
	
}
