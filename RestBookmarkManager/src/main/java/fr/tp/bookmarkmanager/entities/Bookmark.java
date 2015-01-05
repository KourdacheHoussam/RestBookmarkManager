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
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
/**
 * @author Housssam
 * @version 23 nov. 2014
 */
/**
 * @Entity : i-e une entite jpa : jpa for hibernate config
 * @Entity permet a BookMark de se faire mapper
 **/

@Entity
@Table(name="BOOKMARKS")
public class Bookmark implements Serializable{	
	private static final long serialVersionUID = -1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bm_id")
	private Integer id;
	
	@Column(name="bm_name", nullable = false)
	@Size(max = 40)
	private String name;

	@Column(name="bm_type",nullable = false)
	@Size(max = 60)
	private String type;

	@Column(name="bm_description", nullable=true, length=66)
	private String description;
	
	@OneToMany
	private Collection<Tag> tags;
	
	/**
	 * Il est impératif que Les entités JPA se comporte comme les java beans i-e
	 * avoir un constructuer vide sans paramètre et des accesseurs/getters ainsi
	 * qu'un id pour identifier l'élement au sein de la table
	 */
	
	public Bookmark(){}

	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param description
	 */
	public Bookmark(String name, String type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param description
	 * @param tags
	 */
	public Bookmark(String name, String type, String description, Collection<Tag> tags) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
		this.tags = tags;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 * the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
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
