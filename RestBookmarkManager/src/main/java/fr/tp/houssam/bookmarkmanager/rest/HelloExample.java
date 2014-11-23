package fr.tp.houssam.bookmarkmanager.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("hello")
public class HelloExample {
	
	@Context 
	private UriInfo context;

	/** Constructor */
	public HelloExample(){
		
	}
	
	@GET
	@Produces("text/html")
	public String getHtml(){
		return "<html lang=\"en\"><body><h1>Hello everybody</h1></body></html> ";
	}
	
}