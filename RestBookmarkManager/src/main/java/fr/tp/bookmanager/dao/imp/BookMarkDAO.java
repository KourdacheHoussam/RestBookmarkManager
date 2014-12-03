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
 * Cr�� le 30 nov. 2014.
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
import fr.tp.bookmarkmanager.entities.BookMark;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class BookMarkDAO extends GenericDAO<BookMark> {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	/**
	 * @param connection
	 */
	public BookMarkDAO(Connection connection) {
		super(connection);
	}

	/**
	 * dans cette fonction, on cr�era un nouveau
	 * bookMark que l'on stockera dans la BD
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(BookMark bookmark) {
		// on utilisant l'entity manager d�finie ci-dessous
		// on pourra int�roger la BD pour y ins�rer le BookMark
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
	public boolean delete(BookMark bookmark) {
		Integer id=bookmark.getId();
		entityManager.remove(bookmark);		
		return entityManager.find(BookMark.class, id) != null ? true: false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(BookMark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public BookMark find(int id) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean deleteAll(BookMark obj) {
		Query query=(Query) entityManager.createNativeQuery("Truncate table bookmarks");
		query.executeUpdate();
		return true;
	}

}

