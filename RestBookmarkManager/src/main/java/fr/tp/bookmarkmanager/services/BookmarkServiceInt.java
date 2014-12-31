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
 * Cr�� le 25 d�c. 2014.
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
 * @version 25 d�c. 2014
 */
public interface BookmarkServiceInt {
	
	Integer createBookmark(final Bookmark instance);
	List<Bookmark> getAllBookmarks();
	Integer deleteAllBookmarks();
}

