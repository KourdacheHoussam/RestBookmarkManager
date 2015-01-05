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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;

import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.Tag;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;
/**
 * @author Housssam
 * @version 1 déc. 2014
 * 
 *          L'attribut @component indique au container que ce composant doit
 *          être detecté par le scan des composants (i-e dans le fichier
 *          applicatonContext.xml, l'attribut component-scan doit pouvoir
 *          détecter cet objet)... 
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
		Collection<Tag> tags=null;
		Bookmark bm=new Bookmark("Added_BM", "A", "Favorite A",tags);
		bookmarkservice.createBookmark(bm);			
		return Response.ok(bm, MediaType.APPLICATION_JSON).build();
	}
	/**
	 * Creation d'un bookmark
	 * @param bookmark
	 * @return
	 */
	@POST
	@Path("/add/{name}/{type}/{description}/{tags}")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response createBookMark(
			@PathParam("name")String name,
			@PathParam("type")String type,	
			@PathParam("description")String description,
			@PathParam("tags")String tags){
		System.out.println("name: "+name+" type: "+type+" desc:"+description);
		List<String> tags_col=Arrays.asList(tags.split("-"));
		ArrayList<Tag> tags_data =new ArrayList<Tag>();
		for(int i=0;i<tags_col.size(); i++){
			Tag t=new Tag();
			t.setId(i);
			t.setTag_value(tags_col.get(i));
			tags_data.add(t);
		}
		Bookmark bm=new Bookmark(name, type, description,tags_data);
		int id=bookmarkservice.createBookmark(bm);
		return Response.status(200).entity("Un nouveau BookMark vient d'être créé dont le id ="+id).build();
	}	
	@GET
	@Path("/getAll")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getAllBookmarks() throws IOException, ApplicationException{
		List<Bookmark> bms = bookmarkservice.getAllBookmarks();
		return Response.ok(bms)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.build();
	}	
		
	@GET
	@Path("/get/{id}")
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response getBookmarkByID(@PathParam("id")Integer id) {
		Bookmark bm=bookmarkservice.getBookmarkByID(id);
		return Response.status(200).entity(bm)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}		
	/**
	 * Delete BOOKMARK BY ID
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({MediaType.TEXT_PLAIN})
	public Response deleteBookMarkByID(@PathParam("id") Integer id){
		try{
			bookmarkservice.deleteByID(id);		
		}catch(Exception e){
			e.printStackTrace();			
		}
		return Response.status(200).entity("Bookmark deleted.")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", " DELETE, PUT").build();
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
