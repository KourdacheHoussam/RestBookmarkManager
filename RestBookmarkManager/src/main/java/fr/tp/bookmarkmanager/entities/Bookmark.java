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
 * Cr�� le 23 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.entities;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Entity;
import fr.tp.bookmarkmanager.commons.PersistentObjectInt;
import fr.tp.bookmarkmanager.commons.imp.PersistentObjectImp;

import javax.persistence.Column;

/**
 * @author Housssam
 * @version 23 nov. 2014
 */
/**
 * @Entity : i-e une entite jpa : jpa for hibernate config
 * @Entity permet a BookMark de se faire mapper
 **/

@Entity
@XmlRootElement
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
	
	/**
	 * Il est imp�ratif que Les entit�s JPA se comporte comme les java beans i-e
	 * avoir un constructuer vide sans param�tre et des accesseurs/getters ainsi
	 * qu'un id pour identifier l'�lement au sein de la table
	 */

	public Bookmark() {
		super();
	}

	// constructeur
	public Bookmark(String name, String type) {
		super();
		this.name = name;
		this.type = type;
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
