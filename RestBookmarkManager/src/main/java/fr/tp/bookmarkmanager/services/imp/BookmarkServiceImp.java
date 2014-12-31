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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.springframework.stereotype.Service;
import fr.tp.bookmarkmanager.dao.DAOFactory;
import fr.tp.bookmarkmanager.dao.InterfaceDAO;
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

	
//		emf=Persistence.createEntityManagerFactory("bookmarkpersistence");
//		em=emf.createEntityManager();	
//		em.getTransaction().begin();
//		em.persist(instanceBM);
//		em.flush(); // force transaction
//		em.getTransaction().commit();
//		em.close();
//		emf.close();
	
	/**
	 * CREATE BOOKMARK
	 * {@inheritDoc}
	 */	
	public Integer createBookmark(Bookmark instance) {
		InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
		return bm_dao.create(instance);		
	}

	/**
	 * GET ALL BOOKMARKS
	 * {@inheritDoc}
	 */
	
	public List<Bookmark> getAllBookmarks() {
		InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
		return bm_dao.getAll();
	}

	/**
	 * DELETE ALL BOOKMARKS
	 * {@inheritDoc}
	 * @return 
	 */	
	public Integer deleteAllBookmarks() {
		InterfaceDAO<Bookmark> bm_dao =DAOFactory.getBookMarkDAO();
		return bm_dao.deleteAll();
	}

	
	
}