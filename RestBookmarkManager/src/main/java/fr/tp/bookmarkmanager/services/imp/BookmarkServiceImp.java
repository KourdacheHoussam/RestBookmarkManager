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
import org.springframework.stereotype.Service;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;
/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */
@Service
public class BookmarkServiceImp implements BookmarkServiceInt{
	EntityManager em;
	EntityManagerFactory emf;
	/**
	 * Save new bookmark 
	 */
	public Bookmark saveBookmark(final Bookmark instanceBM) {
		emf=Persistence.createEntityManagerFactory("bookmarkpersistence");
		em=emf.createEntityManager();	
		em.getTransaction().begin();
		em.persist(instanceBM);
		em.flush(); // force transaction
		em.getTransaction().commit();
		em.close();
		emf.close();
		return instanceBM;
	}
}