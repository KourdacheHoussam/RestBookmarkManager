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

import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Tag;
/**
 *
 * @author Housssam
 * @version 31 déc. 2014
 */
public class TagDAO extends InterfaceDAO<Tag>{

	/**
	 * CONSTRUCTOR
	 * @param connection
	 */
	public TagDAO(EntityManager em) {
		super(em);
	}

	/**
	 * CREATE TAG
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(Tag obj) {
		return null;
	}

	/**
	 * GET ALL TAGS
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Tag> getAll() {
		return null;
	}

	/**
	 * DELETE A TAG
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(Tag obj) {
		return false;
	}

	/**
	 * DELETA ALL TAGS
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer deleteAll() {
		return 0;
	}

	/**
	 * UPDATE TAG
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(Tag obj) {
		return false;
	}

	/**
	 * FIND A TAG WITH A GIVEN ID
	 * {@inheritDoc}
	 */
	
	@Override
	public Tag find(int id) {
		return null;
	}

}

