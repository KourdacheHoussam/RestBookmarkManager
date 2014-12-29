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
package fr.tp.bookmarkmanager.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fr.tp.bookmarkmanager.dao.GenericDAO;
import fr.tp.bookmarkmanager.entities.FavoriteBookmark;
import fr.tp.bookmarkmanager.entities.Tag;

/**
 *
 * @author Housssam
 * @version 30 nov. 2014
 */
public class FavoriteBookmarkDAO extends GenericDAO<FavoriteBookmark>{

	/**
	 * @param connection
	 */
	public FavoriteBookmarkDAO(Connection connection) {
		super(connection);
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public Integer create(FavoriteBookmark obj) {
		return 1;
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
				
//				fmb=new FavoriteBookmark(id, result.getString("fbm_name"), 
//						result.getString("fbm_description"),tags);
			}
		}catch(SQLException e ){
			e.printStackTrace();	
		}
		return fmb;
	}

	/**
	 * {@inheritDoc}
	 */
	
	@Override
	public boolean deleteAll(FavoriteBookmark obj) {
		return false;
	}

}

