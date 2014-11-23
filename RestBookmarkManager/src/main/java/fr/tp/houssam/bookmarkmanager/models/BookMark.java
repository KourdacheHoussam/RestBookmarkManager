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
package fr.tp.houssam.bookmarkmanager.models;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Entity;
import org.hibernate.annotations.Generated;
import javax.persistence.Column;
/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */


/**
 * @Entity : i-e une entite jpa : jpa for hibernate config
 * @Entity permet a BookMark de se faire mapper
 **/

@Entity 
@XmlRootElement
@Table(name="bookmarks")
public class BookMark implements Serializable {
	// serial version of object
	private static final long serialVersionUID = 12L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="bookmark_id")
	private Integer id;
	@Column(name="bookmark_name")
	private String name;
	@Column(name="bookmark_type")
	private String type;
	
	
	/** Il est imp�ratif que Les entit�s JPA
	 * se comporte comme les java beans
	 * i-e avoir un constructuer vide sans param�tre
	 * et des accesseurs/getters ainsi qu'un id pour identifier
	 * l'�lement au sein de la table */
	
	public BookMark(){}


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
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 *
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
}

