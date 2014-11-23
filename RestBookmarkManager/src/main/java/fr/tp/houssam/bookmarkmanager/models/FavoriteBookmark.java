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
package fr.tp.houssam.bookmarkmanager.models;

import java.util.List;

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
@Entity
@XmlRootElement
@Table(name="favoritebookmarks")
public class FavoriteBookmark {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="favoritebookmark_id")
	private Integer id;
	@Column(name="favoritebookmark_name")
	private String name;
	@Column(name="favoritebookmark_description")
	private String description;
	@Column(name="favoritebookmark_tags")
	private List<Tag> tags;
}

