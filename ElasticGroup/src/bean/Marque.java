package bean;

/**
 * 
 * @author Quentin
 *
 */
public class Marque implements IFiltrable{

	private int idMarque;
	private String libelleMarque;
	
	public Marque() {
		super();
	}

	public Marque(int idMarque, String libelleMarque) {
		super();
		this.idMarque = idMarque;
		this.libelleMarque = libelleMarque;
	}

	public int getIdFamille() {
		return idMarque;
	}

	public String getLibelleFamille() {
		return libelleMarque;
	}

	public void setIdFamille(int idMarque) {
		this.idMarque = idMarque;
	}

	public void setLibelleFamille(String libelleMarque) {
		this.libelleMarque = libelleMarque;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idMarque;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return libelleMarque;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
