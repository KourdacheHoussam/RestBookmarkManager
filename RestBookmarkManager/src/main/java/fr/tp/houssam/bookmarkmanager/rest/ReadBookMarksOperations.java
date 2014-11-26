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
 * Créé le 26 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.houssam.bookmarkmanager.rest;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import fr.tp.houssam.bookmarkmanager.contracts.BookMarksDAO;
import fr.tp.houssam.bookmarkmanager.models.BookMark;

/**
 *
 * @author Housssam
 * @version 26 nov. 2014
 */
@Path("/reading")
public class ReadBookMarksOperations {
	
	BookMarksDAO bookMarksDAO;	
	/**
	 * Lire un bookmark dont l'id est passe en param
	 */	
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response findBookMarkByID(@PathParam("id") Integer id){
		
		BookMark bm=bookMarksDAO.getBookmarkByID(id);
		
		if(bm !=null){
			return Response.status(200).entity(bm).build();
		}
		else{
			return Response.status(400).entity("The bookmark you are looking for doesn't exist").build();
		}		
	}
}	

