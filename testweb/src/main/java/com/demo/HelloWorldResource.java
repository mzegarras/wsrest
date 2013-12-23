package com.demo;

import org.apache.log4j.Logger;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class HelloWorldResource extends ServerResource {
	
	static Logger logger = Logger.getLogger(HelloWorldResource.class);
	 
	 @Get
	    public String represent() {
		 	logger.debug("HelloWorldResource");
	        return "hello, world";
	    }
	 
	 @Get ("json")
	 public Representation sendResponse(){
	     User user = new User();
	     return new JacksonRepresentation<User>(user);
	 }
}
