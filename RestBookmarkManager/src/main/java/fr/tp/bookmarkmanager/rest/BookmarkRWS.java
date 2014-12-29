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
 * Cr�� le 1 d�c. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.rest;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.tp.bookmarkmanager.dao.FactoryDAO;
import fr.tp.bookmarkmanager.dao.imp.BookmarkDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;

/**
 * @author Housssam
 * @version 1 d�c. 2014
 * 
 *          L'attribut @component indique au container que ce composant doit
 *          �tre detect� par le scan des composants (i-e dans le fichier
 *          applicatonContext.xml, l'attribut component-scan doit pouvoir
 *          d�tecter cet objet)...
 * 
 */

@Path("/bookmarks")
public class BookmarkRWS {

	private BookmarkServiceInt bookmarkservice;
	
	public BookmarkRWS() {}

	/**
	 * add bookmark
	 * @return
	 */
	@GET
	@Path("/add")
	public Response addBookmark(){
		Bookmark bm=new Bookmark("Added_BM", "A", "Favorite A");
		bookmarkservice.saveBookmark(bm);
		return Response.ok(bm, MediaType.APPLICATION_JSON).build();
	}
	
	/**
	 * Creation d'un bookmark
	 * @param bookmark
	 * @return
	 */
	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	//@Transactional
	public Response createBookMark(Bookmark bookmark) {
		// il nous reste qu'� appler la m�thode create()
		// de l'objet FactoryDAO
	//	bookMarkDAO.create(bookmark);
		
		//vaut mieux utiliser un objet Response pour retourner 
		// le r�sultat car il permet de renvoyer une r�ponse bien structur�
		// avec les bons ent�tes, ainsi le client pourra identifier 
		// facilement l'aboutissement et le r�sutlat de sa requ�te
		
		return Response.status(200).entity("Un nouveau BookMark vient d'�tre cr��").build();
	}

	/**
	 * Creation d'un bookmark depuis le formulaire
	 * @param bookmark_name
	 * @param bookmark_type
	 * @return
	 */
	@POST
	@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
	@Produces({MediaType.TEXT_HTML})
	//@Transactional
	public Response createBookMarkFromFORM(	@FormParam("bm_name") String bookmark_name,
			@FormParam("bm_type") String bookmark_type, @FormParam("bm_description") String bookmark_desc){
		
		Bookmark bookmark=new Bookmark(bookmark_name, bookmark_type, bookmark_desc);
	//	bookMarkDAO.create(bookmark);
		return Response.status(200).entity("un nouveau bookmark vient d'�tre cr�� avec un id = "+bookmark.getId()).build();
	}
	
	
	/**
	 * Supprimer un bookmark
	 *
	 * @param bookmark
	 * @return
	 */
	@DELETE
	@Path("/delete/")
	@Produces({MediaType.TEXT_HTML})
//	@Transactional
	public Response deleteBookMark(Bookmark bookmark){
		//if(bookMarkDAO.delete(bookmark))
			//return Response.status(200).entity("Le bookmark dont l'id =" + bookmark.getId()+ " a �t� supprim�.").build();
		//else
			//return Response.status(400).entity("Le bookmark dont l'id = "+ bookmark.getId()+ " n'a pas �t� supprim�").build();
		return null;
	}
	
	
	/**
	 * Delete bookmark by id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.TEXT_HTML})
//	@Transactional
	public Response deleteBookMarkByID(@PathParam("id") Integer id){
		Bookmark bm=new Bookmark();
		bm.setId(id);
		
		/**if(bookMarkDAO.delete(bm))
			return Response.status(200).entity("Le bookmark dont l'id =" + bm.getId()+ " a �t� supprim�.").build();
		else
			return Response.status(400).entity("Le bookmark dont l'id = "+ bm.getId()+ " n'a pas �t� supprim�").build();		
		 */
		return null;
	}
	
	
	/**
	 * Suppression de tous les bookmarks
	 * @return
	 */
	@DELETE
	@Path("/delete/all")
	@Produces({MediaType.TEXT_HTML})
	public Response deleteAllBookMarks(){
		//bookMarkDAO.deleteAll(null);
		return Response.status(200).entity("tous les bookmarks ont �t� supprim�").build();
	}
	
	/** ----------- Beans Setters ------------ */
	/**
	 * @param bookmarkservice the bookmarkservice to set
	 */
	@Autowired
	public void setBookmarkservice(BookmarkServiceInt bookmarkservice) {
		this.bookmarkservice = bookmarkservice;
	}
}