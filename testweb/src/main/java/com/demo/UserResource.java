package com.demo;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;


public class UserResource extends ServerResource { 

	
	private UserService userService;
	

	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


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
		//inputChannel.send(new GenericMessage<String>("World"));
		//String msg =  outputChannel.receive().getPayload().toString();
		
		
		   String cfg = "/spring-config.xml";
		   
		   ApplicationContext context = new ClassPathXmlApplicationContext(cfg);
		    MessageChannel channel = context.getBean("names", MessageChannel.class);
		    Message<String> message = MessageBuilder.withPayload("World").build();
		    channel.send(message);
		    
		    
		if(userService!=null)
			return "Account of user \"" + this.userName + "\"" + userService.doMessge() ;
		else
			return "Account of user \"" + this.userName + "\"" + "NULO";
    }
	
	
	
}
