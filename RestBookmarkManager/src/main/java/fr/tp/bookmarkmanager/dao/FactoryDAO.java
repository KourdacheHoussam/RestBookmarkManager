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

import fr.tp.bookmarkmanager.dao.imp.BookmarkDAO;
import fr.tp.bookmarkmanager.dao.imp.FavoriteBookmarkDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.FavoriteBookmark;
import fr.tp.bookmarkmanager.entities.Tag;

/**
 *
 * @author Housssam
 * @version 1 d�c. 2014
 */
public class FactoryDAO {
	
	//protected static final Connection connection=SdzConnection.getInstance();
	
	/**
	 * retourne un objet de la classe DAO de type BookMark acc�dant �
	 * la base de donn�es
	 * @return
	 */
	public static GenericDAO<Bookmark> getBookMarkDAO(){
		return new BookmarkDAO(null);
	}
	/**
	 * retourne un objet de la classe DAO de type TAG acc�dant �
	 * la base de donn�es
	 * @return
	 */
	
	public static GenericDAO<Tag> getTagDAO(){
		return null; //new GenericDAO<Tag>(null);
	}
	/**
	 * retourne un objet de la classe DAO de type FavoriteBookMark acc�dant �
	 * la base de donn�es
	 * @return
	 */
	public static GenericDAO<FavoriteBookmark> getFavoriteBookmarkDAO(){
		return new FavoriteBookmarkDAO(null);
	}
	
}

