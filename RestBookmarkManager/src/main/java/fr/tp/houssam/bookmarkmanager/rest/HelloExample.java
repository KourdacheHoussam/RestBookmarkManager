package fr.tp.houssam.bookmarkmanager.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/** @path permet au dispatcher de détecter 
 * cet objet comme contrôleur
 * et ainsi aiguiller la requete vers cette classe*/

@Path("hello")
public class HelloExample {
	
	/** on utilise @context pour JEersey reconnaisse l'object*/
	@Context
	private UriInfo context;

	public HelloExample(){
		//le constructeur permet d'être certain que l'instation par 
		//réflexion sera possible
		//c'est jersey qui s'occupe de l'intanciation de l'objet
	}
	
	// This method is called if TEXT_PLAIN is request
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jersey";
	}

	// This method is called if XML is request
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
	}

	// This method is called if HTML is request
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello Jersey" + "</title>"
				+ "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	}
}
