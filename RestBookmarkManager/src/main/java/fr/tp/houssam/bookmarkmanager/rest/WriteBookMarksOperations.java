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
 * Cr�� le 23 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.houssam.bookmarkmanager.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;

import fr.tp.houssam.bookmarkmanager.contracts.BookMarksDAO;
import fr.tp.houssam.bookmarkmanager.models.BookMark;

/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
@Path("/writing")
public class WriteBookMarksOperations {
	
	@Context
	private UriInfo context;
	@Autowired
	private BookMarksDAO bookMarksDAO;
	
	
	public WriteBookMarksOperations(){}
	
	/**
	 * MediaType.Application_JSON pour sp�cifier que cette 
	 * m�thode re�oit des donn�es en format jSON pour 
	 * cr�er un nouveau bookmark.
	 * @param bookMark
	 * @return
	 */
	
	@POST //means class ll send data with POST Request
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response addBookMark(BookMark bookMark){
		bookMarksDAO.addBookMark(bookMark);
		return Response.status(201).entity("A new BookMark is added").build();
	}
	
	
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_FORM_URLENCODED})
	@Transactional
	public Response addBookFromForm(@FormParam("name") String  name, @FormParam("type") String type){
		BookMark bm=new BookMark(name, type);
		Integer id=bookMarksDAO.addBookMark(bm);
		return Response.status(201).build();
	}
	
	
}

