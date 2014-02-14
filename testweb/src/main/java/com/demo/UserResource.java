

package com.demo;
//http://www.2048bits.com/2008/06/creating-simple-web-service-with.html
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.representation.Variant;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
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

	/*
	 * public boolean allowGet() { return true; }
	 */

	public boolean allowPut() {
		return true;
	}

	public boolean allowPost() {
		return true;
	}

	public boolean allowDelete() {
		return true;
	}

	public boolean setModifiable() {
		return true;
	}

	public boolean setReadable() {
		return true;
	}

	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	String userName;
	User user;

	@Override
	public void init(Context arg0, Request arg1, Response arg2) {
		// TODO Auto-generated method stub
		super.init(arg0, arg1, arg2);

		this.userName = (String) getRequestAttributes().get("user");
		getVariants().add(new Variant(MediaType.TEXT_PLAIN));
		getVariants().add(new Variant(MediaType.APPLICATION_JSON));

		System.out.println("ACÁ ESTOY");
	}

	@Get("json")
	public Representation toJson() {
		JsonRepresentation jr = new JsonRepresentation("respuesta");
		return jr;
	}

	@Post("json")
	public Representation toJson(JsonRepresentation  entity) {
		// JsonRepresentation jr=new JsonRepresentation("respuesta");
		// return jr;
		/*System.out.println("==============================");
		System.out.println(entity.getJsonObject());
		JsonRepresentation jr = new JsonRepresentation("respuesta_toJson");*/
		System.out.println("==============================");
		// getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
		
		
		JSONObject json = null;

	    try {
	        json = entity.getJsonObject();
	        // business logic and persistence

	    } catch (JSONException e) {
	        //setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
	        //return new JsonRepresentation("respuesta");
	    	
	    	ErrorMessage em = new ErrorMessage();
	    	   Representation rep = representError(MediaType.APPLICATION_JSON, em);
	    	   getResponse().setEntity(rep);
	    	   getResponse().setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
	    	   
	    	   
	    } 
	    
		return new JsonRepresentation("respuesta_toJson");
	}

	/*
	 * *
	 * Represent an error message in the requested format.
	 * 
	 * @param variant
	 * 
	 * @param em
	 * 
	 * @return
	 * 
	 * @throws ResourceException
	 */
	private Representation representError(Variant variant, ErrorMessage em)
			throws ResourceException {
		Representation result = null;
		if (variant.getMediaType().equals(MediaType.APPLICATION_JSON)) {
			result = new JsonRepresentation(em.toJSON());
		} else {
			result = new StringRepresentation(em.toString());
		}
		return result;
	}

	protected Representation representError(MediaType type, ErrorMessage em)
			throws ResourceException {
		Representation result = null;
		if (type.equals(MediaType.APPLICATION_JSON)) {
			result = new JsonRepresentation(em.toJSON());
		} else {
			result = new StringRepresentation(em.toString());
		}
		return result;
	}

}

/*
 * @Autowired UserDAO userDAO;
 * 
 * @Get("?d1") public String represent() throws ResourceException {
 * 
 * // greetings.send("MANUEL ZEGARRA"); return greetings.receive(); /
 * 
 * User d = new User(); d.setName("manuel zegarra"); d.setUsername("mzegarra");
 * 
 * userDAO.insertUser(d);
 * 
 * return "OK";
 * 
 * }
 * 
 * @Get public String toString() { // inputChannel.send(new
 * GenericMessage<String>("World")); // String msg =
 * outputChannel.receive().getPayload().toString();
 * 
 * String cfg = "/spring-config.xml";
 * 
 * AbstractApplicationContext context = new ClassPathXmlApplicationContext( cfg,
 * UserResource.class); MessageChannel inputChannel2 =
 * context.getBean("inputChannel", MessageChannel.class); PollableChannel
 * outputChannel = context.getBean("outputChannel", PollableChannel.class);
 * inputChannel2.send(new GenericMessage<String>("World"));
 * 
 * if (inputChannel2 != null) return "Account of user \"" + this.userName + "\""
 * + userService.doMessge() + outputChannel.receive(0).getPayload(); else return
 * "Account of user \"" + this.userName + "\"" + "NULO";
 * 
 * }
 */