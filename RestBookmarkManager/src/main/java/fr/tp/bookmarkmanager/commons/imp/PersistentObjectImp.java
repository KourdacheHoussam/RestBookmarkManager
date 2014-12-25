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
 * Cr�� le 25 d�c. 2014.
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
 * @version 25 d�c. 2014
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