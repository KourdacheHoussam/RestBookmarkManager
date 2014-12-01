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
import fr.tp.bookmarkmanager.entities.Tag;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class TagDAO extends GenericDAO<Tag>{

	/**
	 * @param connection
	 */
	public TagDAO(Connection connection) {
		super(connection);
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean create(Tag obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(Tag obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(Tag obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Tag find(int id) {
		return null;
	}

}

