package com.demo;

import org.apache.log4j.Logger;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloWorldResource extends ServerResource {
	
	
	
	static Logger logger = Logger.getLogger(HelloWorldResource.class);
	
	
	
	@Autowired
    private User user;
	
	@Override
    public void init(Context context, Request request, Response response) {
        super.init(context, request, response);
        // code originally in non-default constructor
        logger.debug("HelloWorldResource:init");
    }
	
	
	@Get  
	public String toString() {  
	    // Print the requested URI path  
	    return "Resource URI  : " + getReference() + '\n' + "Root URI      : "  
	            + getRootRef() + '\n' + "Routed part   : "  
	            + getReference().getBaseRef() + '\n' + "Remaining part: "  
	            + getReference().getRemainingPart();  
	} 
	
	 @Get("?flavor1")
	    public String represent() {
		 	logger.debug("HelloWorldResource");
	        return "hello, world";
	    }
	 
	 /*
	 @Get ("json")
	 public Representation sendResponse(){
	     User user = new User();
	     user.setId("1");
	     user.setName("mzegarras");
	     return new JacksonRepresentation<User>(user);
	 }*/
	 
	 
	
	 
	 
	 /*
	  * 
	  *  @Get("xml")
	 public Representation toXml(){
		 return null;
	 }
	 
	  @Post("xml")
    public Representation accept(Document entity) {
        // ...
        return null;
    }

    @Put("atom")
    public void storeAtom(Feed feed) {
        // ...
    }

    @Put("cust")
    public void storeXml(InputStream stream) {
        // ...
    }

    @Delete
    public void removeAll() {
        // ...
    } 
	  
	  * */
}
