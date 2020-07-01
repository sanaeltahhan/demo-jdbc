package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import fr.diginamic.jdbc.entites.Fournisseur;

public class TestSelect {

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
        ArrayList<Fournisseur> listFournisseur = new ArrayList <Fournisseur>();

        try {
        	 uneConnexion = DriverManager.getConnection(url, user, password);
        	
        	// Etape 3 - Créer un statement pour envoyer des requetes sql a la base
            statement = uneConnexion.createStatement();

            // Select 
            resultSet = statement.executeQuery("select * from FOURNISSEUR");

            // Etape 5 - Exploiter les résultats
            
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nom = resultSet.getString("nom");
                
                listFournisseur.add(new Fournisseur(id, nom));

            }
        } finally {
            // Etape 6 - fermer les resssources
            if(resultSet != null) {
                resultSet.close();
            }

            if(statement != null) {
               statement.close();
           }

           if(uneConnexion != null) {
               uneConnexion.close();
           }

           for (int i=0; i<listFournisseur.size(); i++) {
        	   System.out.println(listFournisseur.get(i));
           }
        }           

	}

}

