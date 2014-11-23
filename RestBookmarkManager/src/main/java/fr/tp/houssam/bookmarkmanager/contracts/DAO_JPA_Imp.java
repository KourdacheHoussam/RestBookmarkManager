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
 * Créé le 23 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.houssam.bookmarkmanager.contracts;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.tp.houssam.bookmarkmanager.models.BookMark;
import fr.tp.houssam.bookmarkmanager.models.FavoriteBookmark;
import fr.tp.houssam.bookmarkmanager.models.Tag;

/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
public class DAO_JPA_Imp implements BookMarksDAO{

	/**The EntityManager API is used to access a database in a particular 
	 * unit of work. It is used to create and remove persistent entity instances, 
	 * to find entities by their primary key identity, and to query 
	 * over all entities. This interface is similar to the Session in Hibernate.
	 */
	
	@PersistenceContext
	private EntityManager entity_Manager;
	
	/**
	 * {@inheritDoc}
	 */
	public List<BookMark> getBookmarks() {
		String query_string="Select * FROM bookmarks";
		TypedQuery<BookMark> request=(TypedQuery<BookMark>) entity_Manager.createQuery(query_string);		
		return request.getResultList();
	}
	
	/**
	 * {@inheritDoc}
	 */	
	public BookMark getBookmarkByID(Integer ID) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public List<BookMark> getFavoriteBookmarks() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public List<Tag> getTags_of_favoriteBookMarks(Integer ID) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	public void addBookMark(BookMark bookMark) {
	}

	/**
	 * {@inheritDoc}
	 */
	
	public void addFavoriteBookmark(FavoriteBookmark favoriteBookmark) {
	}

	/**
	 * {@inheritDoc}
	 */
	
	public void addTag_To_FavoriteBookmark(Tag tag) {
	}

}

