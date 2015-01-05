/**
 * <p>
 * Copyright © 2015 Houssam KOURDACHE, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propriété de Houssam kourdache, France,
 * il ne peut être ni reproduit, ni utilisé, ni communiqué, ni distribué
 * à des tiers sans son autorisation préalable.
 * </p>
 * <p>
 * Créé le 4 janv. 2015.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.services;
import java.util.List;
import fr.tp.bookmarkmanager.entities.Tag;
/**
 *
 * @author Housssam
 * @version 4 janv. 2015
 */
public interface TagServiceInt {
	Integer createTag(final Tag instance);
	List<Tag> getAllTags();
	Integer deleteAllTags();
	Tag getTagByID(Integer id);
	void deleteByID(Integer id);
}

