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
package fr.tp.bookmarkmanager.services.imp;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;

/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
 */
@Service
@Configurable  
public class HelloWorldServiceImpl implements HelloWorldServiceInt{	
	public String getHello() {
		return "Zzzzzzzzzzzz";
	}
	/**
	 * {@inheritDoc}
	 */
	
	public int fuck() {
		return 0;
	}

	
}

