package com.demo;

import org.apache.log4j.Logger;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ClienteResource extends ServerResource {
	static Logger logger = Logger.getLogger(ClienteResource.class);
	 
	
	 @Get
	    public String represent() {
		 	logger.error("ClienteResource");
	        return "cliente";
	    }
}
