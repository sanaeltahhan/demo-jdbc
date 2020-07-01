/**
 * 
 */
package fr.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author eltahhansana
 *
 */
public class FournisseurDaoJdbc implements FournisseurDao {
    
	Statement statement = null;


	public int update(String ancienNom, String nouveauNom) {
		int nbligne = statement.executeUpdate("UPDATE FOURNISSEUR SET NOM='" + nouveauNom + "' WHERE NOM=" + ancienNom);
		return 0;
	}

	public List<Fournisseur> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		
	}

	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return false;
	}

}
