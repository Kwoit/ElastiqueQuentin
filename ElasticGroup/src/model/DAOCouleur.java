package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bean.Couleur;

/**
 * @author nico
 */
public class DAOCouleur implements DAO<Couleur> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#create(java.lang.Object)
	 */
	@Override
	public Couleur create(Couleur obj) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#delete(java.lang.Object)
	 */
	@Override
	public Couleur delete(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#update(java.lang.Object)
	 */
	@Override
	public Couleur update(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#find(int)
	 */
	@Override
	public Couleur find(int id) {

		Couleur color = null;
		
		//requete 
		String requete = ("SELECT * FROM couleur WHERE ID_COULEUR = " + id);

		try {
			
			//connexion à la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
			if (result.first()) {
				
				//Correction Code Hexa
				String HexaTotal = "#";
				List<String> listRVBHexa = Arrays.asList("HEXA_ROUGE", "HEXA_VERT", "HEXA_BLEU");
				for (String indiceString : listRVBHexa){
					String hexaX = result.getString(indiceString);
					if (hexaX.length() < 2) {
						hexaX="0"+hexaX;
					}
					HexaTotal += hexaX;
				}
				
				color = new Couleur(id, result.getString("INTITULE_COULEUR"),HexaTotal);
				System.out.println("couleur trouvée");
			}
			// puis fermeture de la connexion

			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return color;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#getListe()
	 */
	@Override
	public List<Couleur> findAll() {

		ArrayList<Couleur> listeColor = new ArrayList<Couleur>();

		String requete = "SELECT * FROM couleur ORDER BY ID_COULEUR";


		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			// tant que...
			while (result.next()) {
				
				//Correction Code Hexa
				String HexaTotal = "#";
				List<String> listRVBHexa = Arrays.asList("HEXA_ROUGE", "HEXA_VERT", "HEXA_BLEU");
				for (String indiceString : listRVBHexa){
					String hexaX = result.getString(indiceString);
					if (hexaX.length() < 2) {
						hexaX="0"+hexaX;
					}
					HexaTotal += hexaX;
				}
				
				listeColor.add(new Couleur(result.getInt("ID_COULEUR"), result.getString("INTITULE_COULEUR"),HexaTotal));

			}
			System.out.println(listeColor.size() + "Couleurs créées.");
			// puis fermeture de la connexion
			stmt.close();
			
			System.out.println("Fermeture statement ok");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectBDD.closeConnexion();
			System.out.println("Fermeture connect ok");
		}
		
		return listeColor;
	}

	@Override
	public String getNomTable() {
		// TODO Auto-generated method stub
		return "Couleur";
	}


}

