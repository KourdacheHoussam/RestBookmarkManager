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
package fr.tp.bookmarkmanager.services.imp;
import java.util.List;
import fr.tp.bookmarkmanager.dao.DAOFactory;
import fr.tp.bookmarkmanager.dao.InterfaceDAO;
import fr.tp.bookmarkmanager.entities.Tag;
import fr.tp.bookmarkmanager.services.TagServiceInt;
/**
 *
 * @author Housssam
 * @version 4 janv. 2015
 */
public class TagServiceImp implements TagServiceInt {
	InterfaceDAO<Tag> tag_dao=DAOFactory.getTagDAO();
	/**
	 * CREATE TAG
	 * {@inheritDoc}
	 */	
	public Integer createTag(Tag instance) {		
		return tag_dao.create(instance);		
	}
	/**
	 * GET ALL TAGS
	 * {@inheritDoc}
	 */	
	public List<Tag> getAllTags() {
		return tag_dao.getAll();
	}
	/**
	 * DELETE ALL TAGS
	 * {@inheritDoc}
	 */	
	public Integer deleteAllTags() {
		return tag_dao.deleteAll();
	}
	/**
	 * GET TAG BY ID
	 * {@inheritDoc}
	 */	
	public Tag getTagByID(Integer id) {
		return tag_dao.findByID(id);
	}
	/**
	 * DELETE BY ID
	 * {@inheritDoc}
	 */	
	public void deleteByID(Integer id) {
		tag_dao.deleteByID(id);
	}
}

