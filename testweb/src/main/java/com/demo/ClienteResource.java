package com.demo;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;

public class ClienteResource extends ServerResource {
	static Logger logger = Logger.getLogger(ClienteResource.class);
	 
	
	
	@Post("?insert")
	public String insert(Representation representation){
		logger.debug("insert");
		
		if(representation!=null){
			try {
				logger.debug(representation.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("Representation null");
		}
		
		
		
		
		Gson gson = new Gson();
		return gson.toJson("OK");
	}
	
	
	@Post("?update")
	public String update(Representation representation){
		logger.debug("update");
		
		if(representation!=null){
			try {
				logger.debug(representation.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("Representation null");
		}
		
		Gson gson = new Gson();
		return gson.toJson("OK");
	}
	
	@Post("?delete")
	public String delete(Representation representation){
		logger.debug("delete");
		
		if(representation!=null){
			try {
				logger.debug(representation.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("Representation null");
		}
		
		Gson gson = new Gson();
		return gson.toJson("OK");
	}
	
	@Post("?getId")
	public String GetId(Representation representation){
		logger.debug("GetId");
		
		if(representation!=null){
			try {
				logger.debug(representation.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("Representation null");
		}
		
		
		Cliente c1= new Cliente();
		c1.setId(1);
		c1.setApellidos("Zegarra");
		c1.setNombres("Manuel");
		
		Gson gson = new Gson();
		return gson.toJson(c1);
	}
	
	@Post()
	public String List(Representation representation){
		
		
		logger.debug("List");
		
		if(representation!=null){
			try {
				logger.debug(representation.getText());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			logger.debug("Representation null");
		}
		
		java.util.List<Cliente> clientes = new ArrayList<Cliente>();
		
		
		
		Cliente c1= new Cliente();
		c1.setId(1);
		c1.setApellidos("Zegarra");
		c1.setNombres("Manuel");
		clientes.add(c1);
		
		
		Cliente c2= new Cliente();
		c2.setId(1);
		c2.setApellidos("Zegarra");
		c2.setNombres("Manuel");
		clientes.add(c2);
		
		Gson gson = new Gson();
		return gson.toJson(clientes);
	}
	
}
