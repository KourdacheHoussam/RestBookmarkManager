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

import fr.tp.bookmanager.dao.GenericDAO;
import fr.tp.bookmarkmanager.models.BookMark;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class BookMarkDAO extends GenericDAO<BookMark> {

	/**
	 * @param connection
	 */
	public BookMarkDAO(Connection connection) {
		super(connection);
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean create(BookMark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(BookMark obj) {
		return false;
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

}

