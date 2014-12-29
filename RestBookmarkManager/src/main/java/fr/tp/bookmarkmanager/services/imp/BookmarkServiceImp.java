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
 * Créé le 25 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.services.imp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;

/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */
public class BookmarkServiceImp implements BookmarkServiceInt{

	public Bookmark saveBookmark(Bookmark instance) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("tp");
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(instance);
		em.flush();
		em.getTransaction().commit();
		em.close();
		emf.close();
		return instance;
	}

}

