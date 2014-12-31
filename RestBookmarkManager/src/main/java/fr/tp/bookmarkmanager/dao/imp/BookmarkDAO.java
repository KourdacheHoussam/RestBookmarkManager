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
package fr.tp.bookmarkmanager.dao.imp;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import org.apache.commons.logging.Log;
import fr.tp.bookmarkmanager.entities.Bookmark;
/**
 * @author Housssam
 * @version 30 nov. 2014
 */
@Repository
public class BookmarkDAO extends InterfaceDAO<Bookmark> {
	
	/**
	 * CONSTRUCTOR
	 */
	public BookmarkDAO() {
		super(em);
	}
	/**
	 * CONSTRUCTOR
	 * @param em
	 */
	public BookmarkDAO(EntityManager em) {
		super(em);
		OpenTransaction();		
	}

	/**
	 * CREATE AND SAVE NEW BOOKMARK
	 * {@inheritDoc}
	 */	
	@Override
	public Integer create(Bookmark bookmark) {
		//User entitymanager to interact with DB
		em.persist(bookmark);
		//flush() method force the insertion
		em.flush();
		em.getTransaction().commit();
		//return the id of the inserted bookmark
		return bookmark.getId();	 
	}

	/**
	 * GET ALL BOOKMARKS
	 * {@inheritDoc}
	 */
	
	@Override
	public List<Bookmark> getAll() {
		// CREATE A QUERY CONTENT
		String query_str="select b from Bookmark as b";
		// TYPE THE RESULT QUERY
		TypedQuery<Bookmark> query=em.createQuery(query_str, Bookmark.class);
		// EXECUTE & return IT 
		List<Bookmark> res=query.getResultList();	
		em.getTransaction().commit();
		return res;
	}
	/**
	 * DELETE A GIVEN BOOKMARK
	 * {@inheritDoc}
	 */	
	@Override
	public boolean delete(Bookmark bookmark) {
		return false;
		/**Integer id=bookmark.getId();
		entityManager.remove(bookmark);		
		return entityManager.find(Bookmark.class, id) != null ? true: false;*/
	}

	/**
	 * UPDATE A GIVEN BOOKMARK
	 * {@inheritDoc}
	 */	
	@Override
	public boolean update(Bookmark obj) {
		return false;
	}

	/**
	 * FIND A BOOKMARK
	 * {@inheritDoc}
	 */	
	@Override
	public Bookmark find(int id) {
		return null;
	}

	/**
	 * DELETE ALL BOOKMARKS
	 * {@inheritDoc}
	 */	
	@Override
	public Integer deleteAll() {
		Query query=(Query) em.createNativeQuery("Truncate table BOOKMARKS");		
		int nb= query.executeUpdate();
		System.out.println(" NB delete: "+ nb);
		return nb;
	}
	/** Open and close entitymanager */
	public void OpenTransaction(){
		em.getTransaction().begin();		
	}
	public void CloseTransaction(){
		em.close();
	}
}

