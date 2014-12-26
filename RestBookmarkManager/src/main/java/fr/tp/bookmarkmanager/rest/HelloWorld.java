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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.InjectParam;

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;


/**
 * Root resource (exposed at "services" path)
 */
@Path("/hello")
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
    
    @POST
    @Path("/helloOne")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello() {
      return "Hello Jersey";
    }
    
    // This method is called if XML is request
    @GET
    @Path("/helloTwo")
    @Produces(MediaType.TEXT_XML)
    public String sayXMLHello() {
      return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
    }
    
    // This method is called if HTML is request
    @GET
    @Path("/helloThree")
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
      return "<html> " + "<title>" + "Hello Jersey" + "</title>"
          + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
    }
    
    /**
     * Resource exposed at "helloworld" path
     * @return dummy text
     */
    @GET
    @Path("/")
    @Produces("text/html")
    public String getHtml() {
    	return this.helloWorldServiceInt.getHello("hey");
    }
}