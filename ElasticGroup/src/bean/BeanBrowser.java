package bean;

import java.util.ArrayList;
import java.util.List;

import model.DAOMarque;
import service.ServiceFiltre;

public class BeanBrowser {
	//User Bean
	private User client;
	//Filtre Bean
	private List<BlocFiltre> listBlocFiltre;
	
	private List<Article> listArticle;
	
	//Constructeur
	public BeanBrowser() {
		this.client = new User();
		this.listBlocFiltre = new ServiceFiltre().createFiltre();
	}
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}

	public List<BlocFiltre> getListBlocFiltre() {
		return listBlocFiltre;
	}

	public void setListBlocFiltre(List<BlocFiltre> listBlocFiltre) {
		this.listBlocFiltre = listBlocFiltre;
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	
	@SuppressWarnings("unchecked")
	public String getrequeteFiltre(List<BlocFiltre> listBlocFiltre) {
		
		String requete = "SELECT * FROM coloriser ";
		
		for (BlocFiltre indiceBlocFiltre : listBlocFiltre)
		{
		// si l'un des 4 est non null il faut un WHERE, 
		//	si l'un des 3 premieres est non null il faut un select produit, 
		//	si l'un des 3 premiers et le 4 sont non null il faut  un AND entre les deux
			String s = indiceBlocFiltre.getINSQL();
			String sWhere = "WHERE";
			String sRequeteProduit = " ID_PRODUIT IN (SELECT ID_PRODUIT FROM produit WHERE ";
			
			if (!s.equals(null)) {
				
				if (		indiceBlocFiltre.getIdBlocFiltre()== 1 
						||	indiceBlocFiltre.getIdBlocFiltre()== 2 
						||	indiceBlocFiltre.getIdBlocFiltre()== 3 )
				{
					requete += sWhere + sRequeteProduit ;
					sRequeteProduit = "";
					sWhere = "";
				}
				
				switch (	indiceBlocFiltre.getIdBlocFiltre()) {
	            
				case 0:		requete += "ID_FAMILLE " + s;
	                  		break;
				case 1:		requete += "ID_SSFAMILLE " + s;
              				break;
				case 2:		requete += "ID_FABRICANT " + s;
              				break;
				case 3:		if (sRequeteProduit.equals("")) {
								requete += " AND ";
							}
							requete += sWhere + "ID_COULEUR " + s;
							break;
				default:	break;
	            }
				s += " ;";
			}
		}

		return requete;
	}
}
