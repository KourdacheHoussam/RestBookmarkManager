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

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;

/**
 *
 * @author Housssam
 * @version 25 d�c. 2014
 */
public class HelloWorldServiceImpl implements HelloWorldServiceInt{

	
	public String getHello(String s) {
		return "<html lang=\"en\"><body><h1>Hello world from injected service</h1></body></html>";
	}

	
}

