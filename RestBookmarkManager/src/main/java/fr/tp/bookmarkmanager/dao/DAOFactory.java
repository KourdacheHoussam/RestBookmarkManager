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
 * @version 1 d�c. 2014
 * Mon usine cr�atrice d'objets DAO
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

