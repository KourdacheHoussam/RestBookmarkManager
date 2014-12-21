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
package fr.tp.bookmanager.dao.imp;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;

import fr.tp.bookmanager.dao.GenericDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class BookmarkDAO extends GenericDAO<Bookmark> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * @param connection
	 */
	public BookmarkDAO(Connection connection) {
		super(connection);
	}

	/**
	 * dans cette fonction, on créera un nouveau
	 * bookMark que l'on stockera dans la BD
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(Bookmark bookmark) {
		// on utilisant l'entity manager définie ci-dessous
		// on pourra intéroger la BD pour y insérer le BookMark
		entityManager.persist(bookmark);
		// la methode flush de entity manager permet 
		// de forcer l'insertion pour recevoir un id;
		entityManager.flush();
		//on retourne l'id
		return bookmark.getId();	 
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(Bookmark bookmark) {
		Integer id=bookmark.getId();
		entityManager.remove(bookmark);		
		return entityManager.find(Bookmark.class, id) != null ? true: false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(Bookmark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Bookmark find(int id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean deleteAll(Bookmark obj) {
		Query query=(Query) entityManager.createNativeQuery("Truncate table bookmarks");
		query.executeUpdate();
		return true;
	}

}

