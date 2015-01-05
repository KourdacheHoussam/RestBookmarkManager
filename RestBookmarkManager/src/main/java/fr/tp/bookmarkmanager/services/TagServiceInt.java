/**
 * <p>
 * Copyright � 2015 Houssam KOURDACHE, France. All rights reserved.
 * </p>
 * <p>
 * Ce document est la propri�t� de Houssam kourdache, France,
 * il ne peut �tre ni reproduit, ni utilis�, ni communiqu�, ni distribu�
 * � des tiers sans son autorisation pr�alable.
 * </p>
 * <p>
 * Cr�� le 4 janv. 2015.
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

