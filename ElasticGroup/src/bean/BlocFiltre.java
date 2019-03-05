package bean;

import java.util.ArrayList;
import java.util.List;


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

	public boolean isAllChecked() {
		int i = 0 ;
		for (Filtre indiceFiltre : this.listFiltre) {
			if (indiceFiltre.isChecked())
				i++;
			}
		
		if (i == this.listFiltre.size() ||  i == 0) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public String getINSQL(){
		String s ="";
		if (!this.isAllChecked()) {
			 for(Filtre indiceFiltre : this.listFiltre) {
				 if(indiceFiltre.isChecked()) {
					 if (!s.equals("")) {
						 s += ", ";
					 } 
					s += indiceFiltre.getIdFiltre();
				 }
			 }
			 s = ( "IN( " + s + ")" );
		} else { s = null; }
	return s;
}
	
	 
}
