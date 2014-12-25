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
package fr.tp.bookmarkmanager.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import fr.tp.bookmarkmanager.commons.PersistentObjectInt;


/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
@Entity
@XmlRootElement
@Table(name="favoritebookmarks")
public class FavoriteBookmark implements PersistentObjectInt {
	
	// serial object version
	private static final long serialVersionUID = 1L;

	@Column(name="fbm_name", length=33, nullable=false)
	private String name;
	@Column(name="fbm_description", length=66, nullable=true)
	private String description;
	
	
	@Column(name="fbm_tags")
	private List<Tag> tags;
	/**
	 * 
	 */
	public FavoriteBookmark() {
		super();
	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param tags
	 */
	public FavoriteBookmark(Integer id, String name, String description, List<Tag> tags) {
		super();		
		this.name = name;
		this.description = description;
		this.tags = tags;
	}	
}

