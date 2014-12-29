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
 * Cr�� le 25 d�c. 2014.
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
 * @version 25 d�c. 2014
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

