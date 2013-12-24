package com.demo;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;



public class FirstStepsApplication  extends Application {

	
	private org.restlet.ext.spring.SpringRouter root;
	
	public org.restlet.ext.spring.SpringRouter getRoot() {
		return root;
	}


	public void setRoot(org.restlet.ext.spring.SpringRouter root) {
		this.root = root;
	}
    
    
    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
     //   Router router = new Router(getContext());

        // Defines only one route
    	//root.attach("/hello", HelloWorldResource.class);
      /*  router.attach("/users/{user}", UserResource.class); 
        router.attach("/users/{user}/orders", OrdersResource.class);
        router.attach("/users/{user}/orders/{order}", OrdersResource.class);*/
        //router.attach("/cliente", ClienteResource.class);

       return root;
    }


	
    
    /*
             ... 57 more
Caused by: java.lang.IllegalStateException: Cannot convert value of type [
org.restlet.ext.spring.SpringRouter] to required type 
org.restlet.ext.spring.SpringBeanRouter] for property 'root': no matching editors or conversion strategy found
        at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(Ty
peConverterDelegate.java:289)
        at org.springframework.beans.TypeConverterDelegate.convertIfNecessary(Ty
peConverterDelegate.java:154)
        at org.springframework.beans.BeanWrapperImpl.convertForProperty(BeanWrap
perImpl.java:452)
        ... 61 more
     * */

}