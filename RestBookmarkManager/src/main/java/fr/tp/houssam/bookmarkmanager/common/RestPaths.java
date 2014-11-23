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
 * Créé le 23 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.houssam.bookmarkmanager.common;


/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
public class RestPaths {
	
	/** Lecture paths **/
	public static String hello="/";
	public static String get_bookmark_by_id="/bookmark/{id}";
	public static String get_tags_bookmark_by_id="/bookmark/{id}/tags";
	public static String get_all_bookmarks="/bookmark/all";
	public static String get_tag_by_id="/tag/{id}";
	public static String get_all_tags="/tag/all";
	
	/** ecriture paths  **/
	 
	public static String set_bookmark="/bookmark/";
	public static String set_tag_for_bookmark="/bookmark/tag/";
	public static String set_bookmark_id="/bookmark/{id}";
	public static String set_bookmark_tag_id= "/bookmark/tag/{id}";
	public static String set_tag_id="/tag/{id}";
	
}


