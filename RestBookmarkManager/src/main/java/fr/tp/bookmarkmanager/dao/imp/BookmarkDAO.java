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

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.persistence.EntityManager;
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
	
	public BookmarkDAO(){
		super(null);
	}
	/**
	 * CONSTRUCTOR
	 * @param em
	 */
	public BookmarkDAO(EntityManager em) {
		super(em);
	}	

	/**
	 * CREATE AND SAVE NEW BOOKMARK {@inheritDoc}
	 */
	@Override
	public Integer create(Bookmark bookmark) {
		// User entitymanager to interact with DB
		em.persist(bookmark);
		// flush() method force the insertion
		em.flush();
		em.getTransaction().commit();
		// return the id of the inserted bookmark
		return bookmark.getId();
	}

	/**
	 * GET ALL BOOKMARKS {@inheritDoc}
	 */

	@Override
	public List<Bookmark> getAll() {
		List<Bookmark> res=null;
		Lock lock = new ReentrantLock();
		lock.lock();
		try {
			em.getTransaction().begin();
			// CREATE A QUERY CONTENT
			String query_str = "select b from Bookmark as b";
			// TYPE THE RESULT QUERY
			TypedQuery<Bookmark> query = em.createQuery(query_str, Bookmark.class);
			// EXECUTE & return IT
			res = query.getResultList();
			em.getTransaction().commit();
		} finally {
			lock.unlock();
		}
		return res;
	}

	/**
	 * DELETE A GIVEN BOOKMARK {@inheritDoc}
	 */
	@Override
	public boolean delete(Bookmark bookmark) {
		return false;
		/**
		 * Integer id=bookmark.getId(); entityManager.remove(bookmark); return
		 * entityManager.find(Bookmark.class, id) != null ? true: false;
		 */
	}

	/**
	 * UPDATE A GIVEN BOOKMARK {@inheritDoc}
	 */
	@Override
	public boolean update(Bookmark obj) {
		return false;
	}

	/**
	 * FIND A BOOKMARK {@inheritDoc}
	 */
	@Override
	public Bookmark find(int id) {
		return null;
	}

	/**
	 * DELETE ALL BOOKMARKS {@inheritDoc}
	 */
	@Override
	public Integer deleteAll() {
		String query_str = "select b from Bookmark as b";
		TypedQuery<Bookmark> query = em.createQuery(query_str, Bookmark.class);
		List<Bookmark> res = query.getResultList();
		int nb = 0;
		for (Bookmark bm : res) {
			em.remove(bm);
			nb++;
		}
		em.getTransaction().commit();
		return nb;
	}
}
