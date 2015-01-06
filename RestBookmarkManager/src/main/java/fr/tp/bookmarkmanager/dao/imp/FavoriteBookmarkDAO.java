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
 * Créé le 31 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.dao.imp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.PinnedBookmark;
import fr.tp.bookmarkmanager.entities.Tag;
/**
 *
 * @author Housssam
 * @version 31 déc. 2014
 */
public class FavoriteBookmarkDAO extends InterfaceDAO<PinnedBookmark> {
	
	EntityTransaction et = null;
	/**
	 * CONSTRUCTOR
	 * @param connection
	 */
	public FavoriteBookmarkDAO(EntityManager em) {
		super(em);
		et = em.getTransaction();
	}

	/**
	 * CREATE FAVORITE BM
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(PinnedBookmark obj) {
		return null;
	}

	/**
	 * GET ALL FAVORITE BOOKMARKS
	 * {@inheritDoc}
	 */
	
	@Override
	public List<PinnedBookmark> getAll() {
		return null;
	}

	/**
	 * DELETE FAVORTIE BOOKMARK
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(PinnedBookmark obj) {
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
	public PinnedBookmark update(PinnedBookmark obj) {
		try{
			em.merge(obj);
			et.commit();
		}catch(RuntimeException e){
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		}
		return em.find(PinnedBookmark.class, obj.getId());
	}
	/**
	 * GET FAVORITE BOOKMARK BY ID
	 * {@inheritDoc}
	 */	
	@Override
	public PinnedBookmark findByID(Integer id) {
		return null;
	}

	/**
	 * DELETE FAVORITE BOOKMARK BY ID
	 * {@inheritDoc}
	 */
	
	@Override
	public void deleteByID(Integer id) {
		PinnedBookmark fbm=em.find(PinnedBookmark.class, id);
		em.remove(fbm);
	}

}

