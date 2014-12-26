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
package fr.tp.bookmanager.tests;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */
public class EntitiesTests {
	
	/**
	@Test
	public void testNewBookmark(){
		EntityManager entityManager=Persistence.createEntityManagerFactory("bookmarkManager").createEntityManager();
		entityManager.getTransaction().begin();
		
		Bookmark bookmark=new Bookmark();
		bookmark.setName("MBookOne");
		bookmark.setType("Dev");
		
		entityManager.persist(bookmark);
		entityManager.getTransaction().commit();
		
		System.out.println("bookm name:"+bookmark.getName());
		
		Bookmark bm=entityManager.find(Bookmark.class, bookmark.getId());
		
		System.out.println("book mark found : "+bm.getName());
		assertEquals(bookmark.getName(), bm.getName());
		entityManager.close();
	}**/
}

