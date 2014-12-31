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
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;
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
		bookmarkservice.createBookmark(bm);			
		return Response.ok(bm, MediaType.APPLICATION_JSON).build();
	}	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllBookmarks(){
		List<Bookmark> bms = bookmarkservice.getAllBookmarks();
		return Response.status(200).entity(bms).build();
	}	
	/**
	 * Creation d'un bookmark
	 * @param bookmark
	 * @return
	 */
	@POST
	@Path("/add/form")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_HTML })
	public Response createBookMark(Bookmark bookmark) {
		
		return Response.status(200).entity("Un nouveau BookMark vient d'être créé").build();
	}	
	/**
	 * DELETE BOOKMARK
	 *
	 * @param bookmark
	 * @return
	 */
	@DELETE
	@Path("/delete/")
	@Produces({MediaType.TEXT_HTML})
	public Response deleteBookMark(Bookmark bookmark){
		return null;
	}	
	/**
	 * Delete BOOKMARK BY ID
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.TEXT_HTML})
	public Response deleteBookMarkByID(@PathParam("id") Integer id){
		Bookmark bm=new Bookmark();
		bm.setId(id);		
		return null;
	}	
	/**
	 * DELETE ALL BOOKMARKS
	 * @return
	 */
	@DELETE
	@Path("/delete/all")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteAllBookMarks(){
		int nb_deleted=bookmarkservice.deleteAllBookmarks();
		System.out.println("nb :"+nb_deleted);
		return Response.ok(nb_deleted + " bookmarks deleted. ").build();
	}
	
	/** ---------------------------------- Beans Setters ------------------------------- */
	/**
	 * @param bookmarkservice the bookmarkservice to set
	 */
	@Autowired
	public void setBookmarkservice(BookmarkServiceInt bookmarkservice) {
		this.bookmarkservice = bookmarkservice;
	}
}
