package com.demo;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.springframework.context.ApplicationContext;


//@Component("application")
public class FirstStepsApplication  extends Application {

	
	
    
    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a
        // new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/hello", HelloWorldResource.class);
        router.attach("/users/{user}", UserResource.class); 
        router.attach("/users/{user}/orders", OrdersResource.class);
        router.attach("/users/{user}/orders/{order}", OrdersResource.class);
        //router.attach("/cliente", ClienteResource.class);

        return router;
    }
    
    
    

}