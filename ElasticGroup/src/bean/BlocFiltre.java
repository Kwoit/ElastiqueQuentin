package bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Quentin
 *
 */
public class BlocFiltre {

	private int idBlocFiltre;
	private String libelleBlocFiltre;
	private List<Filtre> listFiltre= new ArrayList<Filtre>();
	
	public BlocFiltre() {
		super();
	}

	public BlocFiltre(int idBlocFiltre, String libelleBlocFiltre) {
		super();
		this.idBlocFiltre = idBlocFiltre;
		this.libelleBlocFiltre = libelleBlocFiltre;
	}
	
	
	public BlocFiltre(int idBlocFiltre, String libelleBlocFiltre, List<Filtre> listFiltre) {
		super();
		this.idBlocFiltre = idBlocFiltre;
		this.libelleBlocFiltre = libelleBlocFiltre;
		this.listFiltre = listFiltre;
	}

	
	
	public int getIdBlocFiltre() {
		return idBlocFiltre;
	}

	public String getLibelleBlocFiltre() {
		return libelleBlocFiltre;
	}

	public List<Filtre> getListFiltre() {
		return listFiltre;
	}

	public void setIdBlocFiltre(int idBlocFiltre) {
		this.idBlocFiltre = idBlocFiltre;
	}

	public void setLibelleBlocFiltre(String libelleBlocFiltre) {
		this.libelleBlocFiltre = libelleBlocFiltre;
	}

	public void setListFiltre(List<Filtre> listFiltre) {
		this.listFiltre = listFiltre;
	}
	
	//Method veriffiant si tous les filtres sont cochée (ou décochés)
	public boolean isAllChecked() {
		
		int i = 0 ;// compteur de case cochées
		
		//on passe en revu tout les filtre et on incrémente le compteur si cochée
		for (Filtre indiceFiltre : this.listFiltre) {
			if (indiceFiltre.isChecked())
				i++;
			}
		
		//si tout les filtre de la liste OU aucun n'est coché on renvoie true sinon c'est false
		if (i == this.listFiltre.size() ||  i == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	//generation de la requete SQL en fonction des filtre selectionné
	public String getINSQL(){
		
		String s ="";//initialisation du resultat a renvoyer
		
		//Si il faut Filtrer
		if (!this.isAllChecked()) {
			
			//pour chaque Filtre Cochée, on le rajoute a la requete
			 for(Filtre indiceFiltre : this.listFiltre) {
				 if(indiceFiltre.isChecked()) {
					 if (!s.equals("")) {
						 s += ", ";
					 } 
					 
					s += indiceFiltre.getIdFiltre();
				 }
			 }
			 
			 //on fini la mise en forme de la requete
			 s = ( "IN( " + s + ")" );
		} else { 
			s = ""; 
		}
	return s;
}
	
	 
}
