/**
 * <p>
 * Copyright � 2014 Houssam KOURDACHE, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propri�t� de Houssam kourdache, France,
 * il ne peut �tre ni reproduit, ni utilis�, ni communiqu�, ni distribu�
 * � des tiers sans son autorisation pr�alable.
 * </p>
 * <p>
 * Cr�� le 25 d�c. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.rest;
/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
 */
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;
/**
 * Root resource (exposed at "services" path)
 */
@Path("/essai")
public class HelloWorldRWS {
    @Context
    private UriInfo context;
    
    
    /**
     * Injected service
     */
    private HelloWorldServiceInt helloservice;    
 
    public HelloWorldRWS() {}    
    
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
    
    @GET
    @Path("/helloThree")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getHtml1() {
    	ArrayList<Bookmark> ar=new ArrayList<Bookmark>();
    	ar.add(new Bookmark("nomA", "TypeA", "films westerns" ));
    	ar.add(new Bookmark("nomB", "TypeA", "films comedie" ));
    	ar.add(new Bookmark("nomC", "TypeC", "films action" ));
    	ar.add(new Bookmark("nomD", "TypeD", "films romance" ));
    	
    	return Response.ok(ar, MediaType.APPLICATION_JSON).build();
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