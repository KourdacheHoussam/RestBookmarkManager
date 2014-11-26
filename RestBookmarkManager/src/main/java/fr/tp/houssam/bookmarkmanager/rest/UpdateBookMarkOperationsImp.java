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

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
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
@Path("/updating")
public class UpdateBookMarkOperationsImp {

	BookMarksDAO bookMarksDAO;
	
	@SuppressWarnings("unused")
	@PUT
	@Path("{id}")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_XML})
	@Transactional()
	
	public Response updateBookMarkByID(@PathParam("id") Integer id, BookMark bookMark){
		
		if(bookMark.getId()==null){
			bookMark.setId(id);
		}
			
		String name, type;
	
		
		if(true){
			Integer id_update=bookMarksDAO.updateBookMarkByID(id, bookMark);
			return Response.status(200).entity(id_update).build();
			
		}else{
			StringBuilder message=new StringBuilder();
			message.append("The update of the bookMark");
			message.append("Is failure");			
			return Response.status(400).entity(message).build();
		}
	}
	
	
}

