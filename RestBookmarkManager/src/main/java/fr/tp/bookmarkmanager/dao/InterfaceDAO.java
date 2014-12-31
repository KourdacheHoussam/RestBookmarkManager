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
package fr.tp.bookmarkmanager.dao;

import java.sql.Connection;
/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public abstract class InterfaceDAO<T> {

	protected Connection connection=null;	
	
	public InterfaceDAO(Connection connection){
		this.connection=connection;
	}
	/**
	 * CREATE
	 * @param obj 
	 * @return
	 */
	public abstract Integer create(T obj);
	/**
	 * DELETE
	 * @param obj
	 * @return
	 */
	public abstract boolean delete(T obj);
	/**
	 * DELETE ALL
	 * @param obj
	 * @return
	 */
	public abstract boolean deleteAll(T obj);
	/**
	 * UPDATE
	 * @param obj
	 * @return
	 */
	public abstract boolean update(T obj);
	/**
	 * FIND
	 * @param id
	 * @return
	 */
	public abstract T find(int id);
	
}

