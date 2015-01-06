/**
 * <p>
 * Copyright © 2015 Houssam KOURDACHE, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propriété de Houssam kourdache, France,
 * il ne peut être ni reproduit, ni utilisé, ni communiqué, ni distribué
 * à des tiers sans son autorisation préalable.
 * </p>
 * <p>
 * Créé le 4 janv. 2015.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.rest;

import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;

import fr.tp.bookmarkmanager.entities.Tag;
import fr.tp.bookmarkmanager.services.TagServiceInt;

/**
 *
 * @author Housssam
 * @version 4 janv. 2015
 */
@Path("/tags")
public class TagRWS {

	private TagServiceInt tagServiceInt;

	public TagRWS() {
	}

	/**
	 * CREATE TAG FROM FORM
	 * 
	 * @param value
	 * @return
	 * @throws JSONException 
	 */
	//@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	
	@POST
	@Path("/add/{tag_val}")	
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createTagFromForm(@PathParam("tag_val") String tag_val){
		Tag tag=new Tag(tag_val);
		int id = tagServiceInt.createTag(tag);
		tag.setId(id);
		return Response.status(200).entity(tag)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "POST, DELETE, GET, PUT").build();
	}

	/**
	 * GET ALL TAGS
	 * 
	 * @return
	 * @throws SQLException
	 */
	@GET
	@Path("/getAll")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getAllTags() throws SQLException {
		List<Tag> tags = tagServiceInt.getAllTags();
		return Response.status(200).entity(tags)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET").build();
	}

	@GET
	@Path("/get/{id}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response getTagByID(@PathParam("id") Integer id) {
		Tag tg = tagServiceInt.getTagByID(id);
		return Response.status(200).entity(tg)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET").build();
	}

	/**
	 * DELETE TAG BY ID
	 * 
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response deleteTagByID(@PathParam("id") Integer id) {
		try {
			tagServiceInt.deleteByID(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Response.status(200).entity("Tag deleted.")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", " DELETE, PUT").build();
	}

	/**
	 * DELETE ALL TAGS
	 * 
	 * @return
	 */
	@DELETE
	@Path("/delete/all")
	@Produces({ MediaType.TEXT_PLAIN })
	public Response deleteAllTags() {
		int nb = tagServiceInt.deleteAllTags();
		return Response.status(200).entity(nb + " tags deleted").build();
	}

	/**
	 * ---------------------------------- Beans Setters
	 * -------------------------------
	 */
	/**
	 * @param tagServiceInt
	 *            the tagServiceInt to set
	 */
	@Autowired
	public void setTagServiceInt(TagServiceInt tagServiceInt) {
		this.tagServiceInt = tagServiceInt;
	}
}
