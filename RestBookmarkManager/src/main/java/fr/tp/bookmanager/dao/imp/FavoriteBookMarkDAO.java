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
 * Créé le 30 nov. 2014.
 * </p>
 */
/**
 * 
 */
package fr.tp.bookmanager.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.tp.bookmanager.dao.GenericDAO;
import fr.tp.bookmarkmanager.models.FavoriteBookmark;
import fr.tp.bookmarkmanager.models.Tag;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class FavoriteBookMarkDAO extends GenericDAO<FavoriteBookmark>{

	/**
	 * @param connection
	 */
	public FavoriteBookMarkDAO(Connection connection) {
		super(connection);
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean create(FavoriteBookmark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean delete(FavoriteBookmark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean update(FavoriteBookmark obj) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@SuppressWarnings("unchecked")
	@Override
	public FavoriteBookmark find(int id) {
		FavoriteBookmark fmb=new FavoriteBookmark();
		try{
			ResultSet result=this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
						ResultSet.CONCUR_READ_ONLY).executeQuery("Select * from favoritebookmarks" +
								"where fmb="+id);
			if(result.first()){
				List<Tag> tags=(List<Tag>) this.connection.createStatement().executeQuery("select fbm_tags where" +
						"fbm_id="+id);
				
				fmb=new FavoriteBookmark(id, result.getString("fbm_name"), 
						result.getString("fbm_description"),tags);
			}
		}catch(SQLException e ){
			e.printStackTrace();	
		}
		return fmb;
	}

}

