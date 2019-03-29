package bean;

/**
 * 
 * @author Quentin
 *
 */
public class Famille implements IFiltrable{

	private int idFamille;
	private String libelleFamille;
	
	public Famille() {
		super();
	}

	public Famille(int idFamille, String libelleFamille) {
		super();
		this.idFamille = idFamille;
		this.libelleFamille = libelleFamille;
	}

	public int getIdFamille() {
		return idFamille;
	}

	public String getLibelleFamille() {
		return libelleFamille;
	}

	public void setIdFamille(int idFamille) {
		this.idFamille = idFamille;
	}

	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idFamille;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return libelleFamille;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
