/**
 * 
 */
package fr.diginamic.jdbc.dao;

/**
 * @author eltahhansana
 *
 */
public interface FournisseurDao {
	
		List<Fournisseur> extraire();
		void insert(Fournisseur fournisseur);
		int update(String ancienNom, String nouveauNom);
		boolean delete(Fournisseur fournisseur);

		
}
