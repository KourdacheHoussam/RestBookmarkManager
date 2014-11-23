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

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Housssam
 * @version 23 nov. 2014
 */
@XmlRootElement
public class BookMark {
	private int id;
	private String name;
	private String type_repository;
}

