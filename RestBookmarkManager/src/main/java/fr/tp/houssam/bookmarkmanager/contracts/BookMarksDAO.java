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
 * Cr�� le 23 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.houssam.bookmarkmanager.contracts;

import java.util.List;

import fr.tp.houssam.bookmarkmanager.models.BookMark;
import fr.tp.houssam.bookmarkmanager.models.FavoriteBookmark;
import fr.tp.houssam.bookmarkmanager.models.Tag;

/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */

/** contract interface between Rest service and data persistence layer **/
public interface BookMarksDAO {
	
	
	/** ------------  Retriever (read) data --------- **/
	
	/** get all bookmarks */
	public List<BookMark> getBookmarks();
	/**get bookmark by id */
	public BookMark getBookmarkByID(Integer ID);
	/**get favorite bookmarks */
	public List<BookMark> getFavoriteBookmarks();
	/**get tags of favorite Bookmarks */
	public List<Tag> getTags_of_favoriteBookMarks(Integer ID);
	
	/** ------------  write data --------------------- **/
	
	/**add bookmark */
	public Integer addBookMark(BookMark bookMark);
	/**add a favorite bookmark*/
	public void addFavoriteBookmark(FavoriteBookmark favoriteBookmark);
	/**add � tag to � favorite book*/
	public void addTag_To_FavoriteBookmark(Tag tag);
	
	/** --------------  UPDATE DATA -----------------**/
	
	/**update bookmark*/
	public int updateBookMark(BookMark bookMark);
	public int updateBookMarkByID(Integer id);
	
}

