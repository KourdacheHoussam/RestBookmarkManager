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
package fr.tp.bookmanager.tests;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;


/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
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

