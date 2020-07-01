package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestInsertion {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		
		// Lecture du fichier de propriétés
        ResourceBundle database = ResourceBundle.getBundle("database");
        
     // Etape 1 - Enregistrer le pilote
        // => indiquer à JDBC une possibilité de communiquer avec une base
        // DriverManager.registerDriver(new Driver());
        Class.forName(database.getString("database.driver"));
        
     // Etape 2 - Créer une connexion
        String url = database.getString("database.url"); // url JDBC d'accès à la base (machine, port, le nom de la base, le type de base...)
        String user = database.getString("database.user");
        String password =  database.getString("database.pass");
        Connection uneConnexion = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
        	 uneConnexion = DriverManager.getConnection(url, user, password);
        	
        	// Etape 3 - Créer un statement pour envoyer des requetes sql a la base
            statement = uneConnexion.createStatement();

            // Inserer une ligne 
            int nbLignesImpactees = statement.executeUpdate("insert into FOURNISSEUR(ID, NOM) values(4, 'La Maison de la Peinture')");
            System.out.println(nbLignesImpactees);
         
        } finally {
          uneConnexion.close();
        }
        
       
            

	}

}
