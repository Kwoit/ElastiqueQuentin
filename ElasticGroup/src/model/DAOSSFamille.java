package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.SSFamille;
/**
 * @author nico
 */
public class DAOSSFamille implements DAO<SSFamille> {

	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public SSFamille create(SSFamille obj) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public SSFamille delete(SSFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public SSFamille update(SSFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public SSFamille find(int id) {
		
		SSFamille ssFam = null;
		String requete = ("SELECT * FROM ssfamille WHERE ID_SSFAMILLE = " + id);
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	ssFam = new SSFamille(id, result.getString("NOM_SSFAMILLE"));
		    	System.out.println("SSfamille trouvée");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion ssFam ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return ssFam;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<SSFamille> findAll() {
		
		ArrayList <SSFamille> listeSousFam = new ArrayList<SSFamille>();
		
		String requete = "SELECT * FROM ssfamille ORDER BY ID_SSFAMILLE";
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeSousFam.add(new SSFamille(result.getInt("ID_SSFAMILLE"), result.getString("NOM_SSFAMILLE")));
				
			}
			System.out.println(listeSousFam.size() + " Sous Familles créées.");
			// puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeSousFam;
	}

	@Override
	public String getNomTable() {
		// TODO Auto-generated method stub
		return "Sous Famille";
	}

}
