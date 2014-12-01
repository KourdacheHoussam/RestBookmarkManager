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
package fr.tp.bookmanager.dao;

import fr.tp.bookmanager.dao.imp.BookMarkDAO;
import fr.tp.bookmanager.dao.imp.FavoriteBookMarkDAO;
import fr.tp.bookmanager.dao.imp.TagDAO;
import fr.tp.bookmarkmanager.entities.BookMark;
import fr.tp.bookmarkmanager.entities.FavoriteBookMark;
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
	public static GenericDAO<BookMark> getBookMarkDAO(){
		return new BookMarkDAO(null);
	}
	/**
	 * retourne un objet de la classe DAO de type TAG accédant à
	 * la base de données
	 * @return
	 */
	
	public static GenericDAO<Tag> getTagDAO(){
		return new TagDAO(null);
	}
	/**
	 * retourne un objet de la classe DAO de type FavoriteBookMark accédant à
	 * la base de données
	 * @return
	 */
	public static GenericDAO<FavoriteBookMark> getFavoriteBookmarkDAO(){
		return new FavoriteBookMarkDAO(null);
	}
	
}

