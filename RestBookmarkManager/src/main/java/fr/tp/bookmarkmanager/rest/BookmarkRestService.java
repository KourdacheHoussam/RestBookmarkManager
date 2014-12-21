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
 * Créé le 1 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.rest;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.tp.bookmanager.dao.FactoryDAO;
import fr.tp.bookmanager.dao.imp.BookmarkDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;

/**
 * @author Housssam
 * @version 1 déc. 2014
 * 
 *          L'attribut @component indique au container que ce composant doit
 *          être detecté par le scan des composants (i-e dans le fichier
 *          applicatonContext.xml, l'attribut component-scan doit pouvoir
 *          détecter cet objet)...
 * 
 */

@Component
@Path("/bookmarks")
public class BookmarkRestService {

	
	// Le bean bookMarkDAO doit être 
	// déclaré au sein du fichier de config : applicationContext.xml :)
	
	@Autowired
	private BookmarkDAO bookMarkDAO;

	
	/**
	 * constructeur 
	 */
	public BookmarkRestService() {
		bookMarkDAO=(BookmarkDAO) FactoryDAO.getBookMarkDAO();
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
	@Transactional
	public Response createBookMark(Bookmark bookmark) {
		// il nous reste qu'à appler la méthode create()
		// de l'objet FactoryDAO
		bookMarkDAO.create(bookmark);
		
		//vaut mieux utiliser un objet Response pour retourner 
		// le résultat car il permet de renvoyer une réponse bien structuré
		// avec les bons entêtes, ainsi le client pourra identifier 
		// facilement l'aboutissement et le résutlat de sa requête
		
		return Response.status(200).entity("Un nouveau BookMark vient d'être créé").build();
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
	@Transactional
	public Response createBookMarkFromFORM(	@FormParam("bm_name") String bookmark_name,
			@FormParam("bm_type") String bookmark_type){
		
		Bookmark bookmark=new Bookmark(bookmark_name, bookmark_type);
		bookMarkDAO.create(bookmark);
		return Response.status(200).entity("un nouveau bookmark vient d'être créé avec un id = "+bookmark.getId()).build();
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
	@Transactional
	public Response deleteBookMark(Bookmark bookmark){
		if(bookMarkDAO.delete(bookmark))
			return Response.status(200).entity("Le bookmark dont l'id =" + bookmark.getId()+ " a été supprimé.").build();
		else
			return Response.status(400).entity("Le bookmark dont l'id = "+ bookmark.getId()+ " n'a pas été supprimé").build();
	}
	
	
	/**
	 * Delete bookmark by id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response deleteBookMarkByID(@PathParam("id") Integer id){
		Bookmark bm=new Bookmark();
		bm.setId(id);
		
		if(bookMarkDAO.delete(bm))
			return Response.status(200).entity("Le bookmark dont l'id =" + bm.getId()+ " a été supprimé.").build();
		else
			return Response.status(400).entity("Le bookmark dont l'id = "+ bm.getId()+ " n'a pas été supprimé").build();		
	}
	
	
	/**
	 * Suppression de tous les bookmarks
	 * @return
	 */
	@DELETE
	@Path("/delete/all")
	@Produces({MediaType.TEXT_HTML})
	@Transactional
	public Response deleteAllBookMarks(){
		bookMarkDAO.deleteAll(null);
		return Response.status(200).entity("tous les bookmarks ont été supprimé").build();
	}
}
