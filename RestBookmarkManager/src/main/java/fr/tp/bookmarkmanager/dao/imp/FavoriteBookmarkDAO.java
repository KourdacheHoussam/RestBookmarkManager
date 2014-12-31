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
 * Cr�� le 31 d�c. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.dao.imp;
import java.util.List;

import javax.persistence.EntityManager;

import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.FavoriteBookmark;
/**
 *
 * @author Housssam
 * @version 31 d�c. 2014
 */
public class FavoriteBookmarkDAO extends InterfaceDAO<FavoriteBookmark> {

	/**
	 * CONSTRUCTOR
	 * @param connection
	 */
	public FavoriteBookmarkDAO(EntityManager em) {
		super(em);
	}

	/**
	 * CREATE FAVORITE BM
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(FavoriteBookmark obj) {
		return null;
	}

	/**
	 * GET ALL FAVORITE BOOKMARKS
	 * {@inheritDoc}
	 */
	
	@Override
	public List<FavoriteBookmark> getAll() {
		return null;
	}

	/**
	 * DELETE FAVORTIE BOOKMARK
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(FavoriteBookmark obj) {
		return false;
	}

	/**
	 * DELETE ALL FAVORITE BOOKMARKS
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer deleteAll() {
		return 0;
	}

	/**
	 * UPDATE FAVORITE BOOKMARK
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(FavoriteBookmark obj) {
		return false;
	}

	/**
	 * FIND A FAVORITE BOOKMARK WITH THE GIVEN ID
	 * {@inheritDoc}
	 */
	
	@Override
	public FavoriteBookmark find(int id) {
		return null;
	}

}

