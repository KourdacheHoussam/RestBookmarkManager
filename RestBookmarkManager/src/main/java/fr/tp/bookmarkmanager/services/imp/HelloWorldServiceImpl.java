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
package fr.tp.bookmarkmanager.services.imp;

import fr.tp.bookmarkmanager.services.HelloWorldServiceInt;

/**
 *
 * @author Housssam
 * @version 25 déc. 2014
 */
public class HelloWorldServiceImpl implements HelloWorldServiceInt{

	
	public String getHello(String s) {
		return "<html lang=\"en\"><body><h1>Hello world from injected service</h1></body></html>";
	}

	
}

