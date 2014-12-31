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
 * Créé le 25 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.services;

import java.util.List;

import fr.tp.bookmarkmanager.entities.Bookmark;

/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */
public interface BookmarkServiceInt {
	
	Integer createBookmark(final Bookmark instance);
	List<Bookmark> getAllBookmarks();
	Integer deleteAllBookmarks();
}

