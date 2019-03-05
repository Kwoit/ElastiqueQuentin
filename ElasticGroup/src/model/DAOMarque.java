package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Marque;

/**
 * @author nico
 */
public class DAOMarque implements DAO<Marque> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#create(java.lang.Object)
	 */
	@Override
	public Marque create(Marque obj) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#delete(java.lang.Object)
	 */
	@Override
	public Marque delete(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#update(java.lang.Object)
	 */
	@Override
	public Marque update(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#find(int)
	 */
	@Override
	public Marque find(int id) {

		Marque mark = null;
		
		//requete 
		String requete = ("SELECT * FROM fabricant WHERE ID_FABRICANT = " + id);

		try {
			
			//connexion à la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
			if (result.first()) {
				mark = new Marque(id, result.getString("NOM_FABRICANT"));
				System.out.println("Marque trouvée");
			}
			// puis fermeture de la connexion

			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mark;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#getListe()
	 */
	@Override
	public List<Marque> findAll() {

		ArrayList<Marque> listeMark = new ArrayList<Marque>();

		String requete = "SELECT ID_FABRICANT FROM fabricant ORDER BY ID_FABRICANT";

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que...
			while (result.next()) {
				listeMark.add(this.find(result.getInt("ID_FABRICANT")));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeMark;
	}

	@Override
	public String getNomTable() {
		// TODO Auto-generated method stub
		return "Marque";
	}

}

