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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
@Entity
@Table(name="FAVORITEBOOKMARKS")
public class FavoriteBookmark implements Serializable{ 
	
	private static final long serialVersionUID = -3L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="fbm_id")
	private Integer id;
	
	@Column(name="fbm_name", length=33, nullable=false)
	private String name;
	@Column(name="fbm_description", length=66, nullable=true)
	private String description;
		
	//@ManyToMany(cascade={CascadeType.ALL})
	//private List<Tag> tags;
	/**
	 * 
	 */
	public FavoriteBookmark() {	}
	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param tags
	 */
//	public FavoriteBookmark(Integer id, String name, String description, List<Tag> tags) {
//		super();		
//		this.name = name;
//		this.description = description;
//		this.tags = tags;
//	}	

	/**
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 *
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}	
}

