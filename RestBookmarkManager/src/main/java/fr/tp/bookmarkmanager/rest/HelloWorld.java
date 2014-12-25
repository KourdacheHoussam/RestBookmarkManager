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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import com.sun.jersey.api.core.InjectParam;

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;


/**
 * Root resource (exposed at "services" path)
 */
@Path("/")
public class HelloWorld {
    @Context
    private UriInfo context;
    
    /**
     * Injected service
     */
    @InjectParam
    private HelloWorldServiceInt helloWorldServiceInt;    
 
    //Constructor
    public HelloWorld() {}
    
    /**
     * Resource exposed at "helloworld" path
     * @return dummy text
     */
    @GET
    @Path("/helloworld")
    @Produces("text/html")
    public String getHtml() {
    	return this.helloWorldServiceInt.getHello("hey");
    }
}