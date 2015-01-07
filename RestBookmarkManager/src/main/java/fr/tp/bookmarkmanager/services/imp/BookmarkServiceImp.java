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
package fr.tp.bookmarkmanager.services.imp;
import java.util.List;
import org.springframework.stereotype.Service;
import fr.tp.bookmarkmanager.dao.DAOFactory;
import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;
/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
 */
@Service
public class BookmarkServiceImp implements BookmarkServiceInt{
	InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
	/**
	 * CREATE BOOKMARK
	 * {@inheritDoc}
	 */	
	public Integer createBookmark(Bookmark instance) {		
		return bm_dao.create(instance);		
	}
	/**
	 * GET ALL BOOKMARKS
	 * {@inheritDoc}
	 */	
	public List<Bookmark> getAllBookmarks() {
		return bm_dao.getAll();
	}
	/**
	 * DELETE ALL BOOKMARKS
	 * {@inheritDoc}
	 * @return 
	 */	
	public Integer deleteAllBookmarks() {
		return bm_dao.deleteAll();
	}

	/**
	 * GET BOOKMARK BY ID
	 * {@inheritDoc}
	 */	
	public Bookmark getBookmarkByID(Integer id) {
		InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
		return bm_dao.findByID(id);
	}

	/**
	 * DELETE BY ID
	 * {@inheritDoc}
	 */
	
	public void deleteByID(Integer id) {
		InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
		bm_dao.deleteByID(id);
	}

	
}