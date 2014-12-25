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
package fr.tp.bookmanager.dao;

import java.sql.Connection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public abstract class GenericDAO<T> {

	protected Connection connection;	
	
	public GenericDAO(Connection connection){
		this.connection=connection;
	}
	
	// CRUD METHODS
	public abstract Integer create(T obj);
	public abstract boolean delete(T obj);
	public abstract boolean deleteAll(T obj);
	public abstract boolean update(T obj);
	public abstract T find(int id);
	
}

