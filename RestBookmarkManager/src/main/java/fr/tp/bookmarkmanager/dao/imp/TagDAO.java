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
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.entities.Tag;

/**
 * @author Housssam
 * @version 31 déc. 2014
 */
public class TagDAO extends InterfaceDAO<Tag> {
	EntityTransaction et = null;
	/**
	 * CONSTRUCTOR
	 * @param connection
	 */
	public TagDAO(EntityManager em) {
		super(em);
		et = em.getTransaction();
	}
	/**
	 * CREATE TAG {@inheritDoc}
	 */
	@Override
	public Integer create(Tag obj) {
		try {
			et.begin();
			em.persist(obj);// User entitymanager to interact with DB
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		}
		return null;
	}
	/**
	 * GET ALL TAGS {@inheritDoc}
	 */
	@Override
	public List<Tag> getAll() {
		List<Tag> res = null;
		try {
			et.begin();
			String query_str = "select t from Tag as t";
			TypedQuery<Tag> query = em.createQuery(query_str, Tag.class);
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
	 * GET TAG BY ID {@inheritDoc}
	 */
	@Override
	public Tag findByID(Integer id) {
		Tag res = null;
		try {
			String query_str = "SELECT b FROM Tag as b where b.id=" + id;
			TypedQuery<Tag> query = em.createQuery(query_str, Tag.class);
			res = query.getSingleResult();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return res;
	}
	/**
	 * UPDATE TAG {@inheritDoc}
	 */
	@Override
	public Tag update(Tag tag) {
		try {
			em.merge(tag);
			et.commit();
		} catch (RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		}
		return em.find(Tag.class, tag.getId());
	}
	/**
	 * DELETE TAG BY ID {@inheritDoc}
	 */
	@Override
	public void deleteByID(Integer id) {
		try{
			Tag tag=em.find(Tag.class, id);
			em.remove(tag);
			et.commit();
		}catch(RuntimeException e) {
			if (et != null && et.isActive()) {
				et.rollback();
			}
			throw e;
		} finally {}
	}
	/**
	 * DELETE A TAG {@inheritDoc}
	 */
	@Override
	public boolean delete(Tag obj) {
		return false;
	}
	/**
	 * DELETA ALL TAGS {@inheritDoc}
	 */
	@Override
	public Integer deleteAll() {
		int nb = 0;
		try {
			et.begin();
			String query_str = "select b from Tag as b";
			TypedQuery<Tag> query = em.createQuery(query_str, Tag.class);
			List<Tag> res = query.getResultList();
			for (Tag tg : res) {
				em.remove(tg);				
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
}
