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
package fr.tp.bookmarkmanager.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import fr.tp.bookmarkmanager.dao.imp.BookmarkDAO;
import fr.tp.bookmarkmanager.dao.imp.FavoriteBookmarkDAO;
import fr.tp.bookmarkmanager.dao.imp.TagDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.PinnedBookmark;
import fr.tp.bookmarkmanager.entities.Tag;
/**
 *
 * @author Housssam
 * @version 1 déc. 2014
 * Mon usine créatrice d'objets DAO
 */
public class DAOFactory {
	
	protected static EntityManagerFactory emf=Persistence.createEntityManagerFactory("bookmarkpersistence");
	protected static EntityManager em=emf.createEntityManager();	

	/**
	 * CONSTRUCTOR
	 */
	public DAOFactory() {}
	/**
	 * MANUFACTORING BOOKMARK DAO
	 * @return
	 */
	public static InterfaceDAO<Bookmark> getBookMarkDAO(){
		return new BookmarkDAO(em);
	}
	/**
	 * MANUFACTORING TAG DAO
	 * @return
	 */
	
	public static InterfaceDAO<Tag> getTagDAO(){
		return new TagDAO(em);
	}
	/**
	 * MANUFACTORING FAVORITE BOOKMARK DAO
	 * @return
	 */
	public static InterfaceDAO<PinnedBookmark> getFavoriteBookmarkDAO(){
		return new FavoriteBookmarkDAO(em);
	}
	
}

