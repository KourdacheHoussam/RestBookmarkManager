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

import fr.tp.bookmarkmanager.dao.imp.BookmarkDAO;
import fr.tp.bookmarkmanager.dao.imp.FavoriteBookmarkDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.FavoriteBookmark;
import fr.tp.bookmarkmanager.entities.Tag;

/**
 *
 * @author Housssam
 * @version 1 déc. 2014
 */
public class FactoryDAO {
	
	//protected static final Connection connection=SdzConnection.getInstance();
	
	/**
	 * retourne un objet de la classe DAO de type BookMark accédant à
	 * la base de données
	 * @return
	 */
	public static GenericDAO<Bookmark> getBookMarkDAO(){
		return new BookmarkDAO(null);
	}
	/**
	 * retourne un objet de la classe DAO de type TAG accédant à
	 * la base de données
	 * @return
	 */
	
	public static GenericDAO<Tag> getTagDAO(){
		return null; //new GenericDAO<Tag>(null);
	}
	/**
	 * retourne un objet de la classe DAO de type FavoriteBookMark accédant à
	 * la base de données
	 * @return
	 */
	public static GenericDAO<FavoriteBookmark> getFavoriteBookmarkDAO(){
		return new FavoriteBookmarkDAO(null);
	}
	
}

