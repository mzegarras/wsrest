package com.demo;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.message.GenericMessage;
import org.springframework.integration.support.MessageBuilder;

import com.demo.dao.UserDAO;
import com.demo.entidades.User;
import com.google.gson.annotations.Until;


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

	

	
	
	@Autowired
	UserDAO userDAO;
	
	@Get("?d1")
    public String demo1() {
        /*greetings.send("MANUEL ZEGARRA");
        return greetings.receive();*/
        
		User d = new User();
		d.setName("manuel zegarra");
		d.setUsername("mzegarra");
		
		
		userDAO.insertUser(d);
		
		return "OK";
		
	}
	@Get  
    public String toString() {  
		//inputChannel.send(new GenericMessage<String>("World"));
		//String msg =  outputChannel.receive().getPayload().toString();
		
		
		  String cfg = "/spring-config.xml";
		   
		   AbstractApplicationContext context = new ClassPathXmlApplicationContext(cfg, UserResource.class);
           MessageChannel inputChannel2 = context.getBean("inputChannel", MessageChannel.class);
           PollableChannel outputChannel = context.getBean("outputChannel", PollableChannel.class);
           inputChannel2.send(new GenericMessage<String>("World"));
		
           
		    
		if(inputChannel2!=null)
			return "Account of user \"" + this.userName + "\"" + userService.doMessge() + outputChannel.receive(0).getPayload();
		else
			return "Account of user \"" + this.userName + "\"" + "NULO";
	
    }
	
	
	
}
