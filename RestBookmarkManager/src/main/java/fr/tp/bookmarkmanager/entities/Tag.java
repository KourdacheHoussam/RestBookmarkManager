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
 * @author Housssam
 * @version 23 nov. 2014
 */

@Entity
@Table(name="TAGS")
public class Tag implements Serializable{

	private static final long serialVersionUID = -2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tag_id")
	private Integer id;
	
	@Column(name="tag_value")
	private String tag_value;
	
	public Tag(){}

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
	 * @return the tag_value
	 */
	public String getTag_value() {
		return tag_value;
	}

	/**
	 * @param tag_value the tag_value to set
	 */
	public void setTag_value(String tag_value) {
		this.tag_value = tag_value;
	}
}	

