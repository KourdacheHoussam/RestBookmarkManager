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
import org.springframework.stereotype.Service;
import fr.tp.bookmarkmanager.entities.Bookmark;
import fr.tp.bookmarkmanager.services.BookmarkServiceInt;
/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
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