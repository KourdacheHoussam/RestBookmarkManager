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

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Entity;

import fr.tp.bookmarkmanager.commons.imp.PersistentObjectImp;
/**
 * @author Housssam
 * @version 23 nov. 2014
 */
/**
 * @Entity : i-e une entite jpa : jpa for hibernate config
 * @Entity permet a BookMark de se faire mapper
 **/

@Entity
@Table(name = "bookmarks",
		uniqueConstraints = @UniqueConstraint(columnNames = { "name", "type" }))
public class Bookmark extends PersistentObjectImp {
	
	// serial version of object
	private static final long serialVersionUID = 1;

	@Version
	private Integer version;

	@Column(name = "bm_name", nullable = false, length=34, unique=true)
	@Size(max = 40)
	private String name;

	@Column(name = "bm_type", nullable = false)
	@Size(max = 60)
	private String type;

	@Column(name="bm_description", nullable=true, length=66)
	private String description;
	
	@ManyToMany(cascade={CascadeType.ALL})
	private Set<Tag> tags;
	
	/**
	 * Il est impératif que Les entités JPA se comporte comme les java beans i-e
	 * avoir un constructuer vide sans paramètre et des accesseurs/getters ainsi
	 * qu'un id pour identifier l'élement au sein de la table
	 */

	public Bookmark() {
		super();
	}

	public Bookmark(final String name, final String type, final String description){
		super();
		this.name = name;
		this.type = type;
		this.description=description;
	}
	// constructeur
	public Bookmark(final String name, final String type, final String description, final Set<Tag> tags) {
		super();
		this.name = name;
		this.type = type;
		this.description=description;
		this.tags=tags;
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
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}



}
