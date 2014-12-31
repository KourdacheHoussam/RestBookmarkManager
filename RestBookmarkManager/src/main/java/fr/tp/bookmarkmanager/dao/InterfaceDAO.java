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
package fr.tp.bookmarkmanager.dao;
import java.util.List;

import javax.persistence.EntityManager;
/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public abstract class InterfaceDAO<T> {

	protected static EntityManager em;
	
	public InterfaceDAO(EntityManager em){
		this.em=em;
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
	 * GET ALL obj
	 * @param obj
	 * @return
	 */	
	public abstract List<T> getAll();
	/**
	 * DELETE ALL
	 * @param obj
	 * @return
	 */
	public abstract Integer deleteAll();
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

