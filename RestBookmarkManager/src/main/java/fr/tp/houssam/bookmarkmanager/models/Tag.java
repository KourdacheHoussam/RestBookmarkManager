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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */

@XmlRootElement
@Entity
@Table(name="tags")
public class Tag implements Serializable{

	private static final long serialVersionUID = -2L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="tag_id")
	private Integer id;
	@Column(name="tag_value")
	private String tag_value;
}	

