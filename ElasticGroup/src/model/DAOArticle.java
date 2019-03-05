package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Article;
import bean.BlocFiltre;
import bean.Filtre;

/**
 * @author nico
 */
public class DAOArticle implements DAO<Article> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#create(java.lang.Object)
	 */
	@Override
	public Article create(Article obj) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#delete(java.lang.Object)
	 */
	@Override
	public Article delete(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#update(java.lang.Object)
	 */
	@Override
	public Article update(Article obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#find(int)
	 */
	@Override
	public Article find(int id) {

		Article fam = null;
		
		//requete 
		String requete = ("SELECT * FROM famille WHERE ID_FAMILLE = " + id);

		try {
			
			//connexion à la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
			if (result.first()) {
				//fam = new Article(id, result.getString("NOM_FAMILLE"));
				System.out.println("Article trouvée");
			}
			// puis fermeture de la connexion

			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DAO#getListe()
	 */
	@Override
	public List<Article> findAll() {

		ArrayList<Article> listArt = new ArrayList<Article>();

		String requete = "SELECT ID_FAMILLE FROM famille ORDER BY ID_FAMILLE";

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que...
			while (result.next()) {
				listArt.add(this.find(result.getInt("ID_FAMILLE")));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listArt;
	}

	@Override
	public String getNomTable() {
		// TODO Auto-generated method stub
		return "Article";
	}

	
	public int getCountFiltre(List<BlocFiltre> listBlocFiltre) {
	
		// Construction de la requete
		String requete = "SELECT COUNT (*)";
		
		int nombreArticle = -1;
	
		//SELECT * FROM produit WHERE (id_/*NomPremiereTableFiltre*/ = '/*listFiltreFamille.first*/'  /*IfMoreThanOneFiltre OR*/ '/*listFiltreFamille.next*/' /*...*/ ) /*IfSecondeTableFiltre AND*/ (id_/*NomPremiereTableFiltre*/ = '/*listFiltreFamille.first*/'  /*IfMoreThanOneFiltre OR*/ '/*listFiltreFamille.next*/' /*...*/ ) /*...*/
		//"
		for (BlocFiltre indiceBlocFiltre : listBlocFiltre) {
			for (Filtre indiceFiltre : indiceBlocFiltre.getListFiltre() ) {
				
				
				
			}
		}
		
		
		
		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// recupere le nombre d'article
			nombreArticle = result.getInt("COUNT(*)");
			
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nombreArticle ;
	}
	
	public List<Article> FindSelectedFiltre(){
		
		ArrayList<Article> listArt = new ArrayList<Article>();
		
		return listArt;
	}
	

}

