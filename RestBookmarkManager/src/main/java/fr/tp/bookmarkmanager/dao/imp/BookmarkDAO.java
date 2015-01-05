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
 * Créé le 30 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.dao.imp;

import java.awt.print.Book;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;

/**
 * @author Housssam
 * @version 30 nov. 2014
 */
@Repository
public class BookmarkDAO extends InterfaceDAO<Bookmark> {
	EntityTransaction et = null;

	public BookmarkDAO() {
		super(null);
	}

	/**
	 * CONSTRUCTOR
	 * 
	 * @param em
	 */
	public BookmarkDAO(EntityManager em) {
		super(em);
		et = em.getTransaction();
	}

	/**
	 * CREATE AND SAVE NEW BOOKMARK {@inheritDoc}
	 */
	@Override
	public Integer create(Bookmark bookmark) {
		try {
			et.begin();
			em.persist(bookmark);// User entitymanager to interact with DB
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {
			// em.close();
		}
		return bookmark.getId();// return the id of the inserted bookmark
	}

	/**
	 * GET ALL BOOKMARKS {@inheritDoc}
	 */
	@Override
	public List<Bookmark> getAll() {
		List<Bookmark> res = null;
		try {
			et.begin();
			// CREATE A QUERY CONTENT
			String query_str = "select b from Bookmark as b";
			// TYPE THE RESULT QUERY
			TypedQuery<Bookmark> query = em.createQuery(query_str, Bookmark.class);
			// EXECUTE & return IT
			res = query.getResultList();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {
			// em.close();
		}
		return res;
	}

	/**
	 * GET BOOKMARK By ID {@inheritDoc}
	 */
	@Override
	public Bookmark findByID(Integer id) {
		Bookmark res = null;
		try {
			String query_str = "SELECT b FROM Bookmark as b where b.id=" + id;
			TypedQuery<Bookmark> query = em.createQuery(query_str, Bookmark.class);
			res = query.getSingleResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * UPDATE A GIVEN BOOKMARK {@inheritDoc}
	 */
	@Override
	public Bookmark update(Bookmark bm) {
		try {
			em.merge(bm);
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		}
		return em.find(Bookmark.class, bm.getId());
	}

	/**
	 * DELETE A GIVEN BOOKMARK {@inheritDoc}
	 */
	@Override
	public boolean delete(Bookmark bookmark) {
		Integer id = bookmark.getId();
		try {
			Bookmark bm = em.find(Bookmark.class, id);
			em.remove(bm);
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {
		}
		return em.find(Bookmark.class, id) != null ? true : false;
	}
	/**
	 * DELETE ALL BOOKMARKS {@inheritDoc}
	 */
	@Override
	public Integer deleteAll() {
		int nb = 0;
		try {
			et.begin();
			String query_str = "select b from Bookmark as b";
			TypedQuery<Bookmark> query = em.createQuery(query_str, Bookmark.class);
			List<Bookmark> res = query.getResultList();
			for (Bookmark bm : res) {
				em.remove(bm);
				nb++;
			}
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {}
		return nb;
	}

	/**
	 * DELETE BOOKMARK BY ID {@inheritDoc}
	 */
	@Override
	public void deleteByID(Integer id) {
		try {
			Bookmark bm = em.find(Bookmark.class, id);
			em.remove(bm);
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {
		}
	}
}
