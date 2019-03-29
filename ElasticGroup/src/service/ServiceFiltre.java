package service;

import java.util.ArrayList;
import java.util.List;

import bean.BlocFiltre;
import bean.Filtre;
import bean.IFiltrable;
import model.DAO;
import model.DAOCouleur;
import model.DAOFamille;
import model.DAOMarque;
import model.DAOSSFamille;

/**
 * 
 * @author Quentin
 *
 */

public class ServiceFiltre {

	
	/**
	 * @return Retourne une liste de "Bloc" filtre. 
	 */
	@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
	public List<BlocFiltre> createFiltre () {
	//créer des Blocs de Filtre pour chaque famille de filtre
				
	// Lister les DAO pour 
		List<DAO> listDAO =  new ArrayList<DAO>(){{
			add(new DAOFamille());
			add(new DAOSSFamille());
			add(new DAOMarque());
			add(new DAOCouleur());
		}};

		List<BlocFiltre> listBlocFiltre = new ArrayList<BlocFiltre>();
		
		
		// Pour chaque element du tableau des DAO
		for (DAO indiceDAO : listDAO)
		{ 
			// Préparation de la liste des filtres pour le constructeur des BlocFiltre
			List<Filtre> listFiltre = new ArrayList<Filtre>();
			
			// Utilisation d'une interface IFiltrable pour tout les differents types 
			// de class à filtrer ( création d'une liste (casting) variable )
			List<IFiltrable> listFiltrable = new ArrayList<IFiltrable>();
			listFiltrable = (List<IFiltrable>) indiceDAO.findAll();
			
			// Pour Chaque Filtre d'un bloc, l'ajouter à sa liste de Filtre
			for (IFiltrable indiceFiltre : listFiltrable )
			{ 
				listFiltre.add(new Filtre(indiceFiltre.getId(), indiceFiltre.getLibelle(), indiceFiltre.getColor()));
			}

			// Creation du BlocFiltre avec l'index de la DAO, le nom donné à la Table et la liste de Filtres 
			listBlocFiltre.add(new BlocFiltre(listDAO.indexOf(indiceDAO), indiceDAO.getNomTable(), listFiltre));
		}
	return listBlocFiltre;
	}
	
	
	public List<BlocFiltre> getCheckedFiltre (List<BlocFiltre> listBlocFiltre) {
		
		
		
		
		
		return listBlocFiltre;
	}
}
