package bean;
/**
 * 
 * @author Quentin
 *
 */
public class Filtre {

	private int idFiltre;
	private String libelleFiltre;
	private String colorFiltre;
	private boolean checked;
	
	public Filtre() {
		super();
		checked = false;
	}

	public Filtre(int idFiltre, String libelleFiltre) {
		super();
		this.idFiltre = idFiltre;
		this.libelleFiltre = libelleFiltre;
		this.checked = false;
		this.colorFiltre = null;
	}
	
	public Filtre(int idFiltre, String libelleFiltre, String colorFiltre) {
		super();
		this.idFiltre = idFiltre;
		this.libelleFiltre = libelleFiltre;
		this.checked = false;
		this.colorFiltre = colorFiltre;
	}

	public int getIdFiltre() {
		return idFiltre;
	}

	public String getLibelleFiltre() {
		return libelleFiltre;
	}

	public boolean isChecked() {
		return checked;
	}
	
	public String getChecked() {
		if (checked) {
			return "checked";
		}else {
			return "";
		}
	}

	public String getColorFiltre() {
		return colorFiltre;
	}
	
	public void setIdFiltre(int idFiltre) {
		this.idFiltre = idFiltre;
	}

	public void setLibelleFiltre(String libelleFiltre) {
		this.libelleFiltre = libelleFiltre;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	public String setcolorFiltre() {
		return colorFiltre;
	}
	
	
	
	
	
}
