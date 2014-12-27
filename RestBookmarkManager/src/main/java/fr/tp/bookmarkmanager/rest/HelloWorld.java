/**
 * <p>
 * Copyright © 2014 Houssam KOURDACHE, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propriété de Houssam kourdache, France,
 * il ne peut être ni reproduit, ni utilisé, ni communiqué, ni distribué
 * à des tiers sans son autorisation préalable.
 * </p>
 * <p>
 * Créé le 25 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.rest;

/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sun.jersey.api.core.InjectParam;

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;
import fr.tp.bookmarkmanager.services.imp.HelloWorldServiceImp;
/**
 * Root resource (exposed at "services" path)
 */
@Path("/essai")
public class HelloWorld {
    @Context
    private UriInfo context;
    
    /**
     * Injected service
     */
    private HelloWorldServiceInt helloservice;    
 
    public HelloWorld() {
    	//instanciation obligatoire
    	helloservice=new HelloWorldServiceImp();
    }    
    
    @GET  
    @Path("/helloOne")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
    	if(helloservice==null)
    		return ("Hello Service is NULL");
    	else
    		return "Hello Jersey";
    }
    
    /**
     * Resource exposed at "helloworld" path
     * @return dummy text
     */
    @GET
    @Path("/helloTwo")
    @Produces({MediaType.TEXT_PLAIN})
    public Response getHtml() {
    	return Response.status(200).entity("Works  "+this.helloservice.getHello()).build();
    }

	/**
	 *
	 * @param helloservice the helloservice to set
	 */
	@Autowired
    public void setHelloservice(HelloWorldServiceInt helloservice) {
		this.helloservice = helloservice;
	}

    
}