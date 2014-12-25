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
 * Créé le 25 déc. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmarkmanager.commons.imp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */

@MappedSuperclass
public class PersistentObjectImp {
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	private Integer id;

	public PersistentObjectImp(){
		super();
	}
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
}