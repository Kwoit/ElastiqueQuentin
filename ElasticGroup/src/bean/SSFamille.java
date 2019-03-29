package bean;

/**
 * 
 * @author Quentin
 *
 */
public class SSFamille implements IFiltrable{

	private int idSSFamille;
	private String libelleSSFamille;
	
	public SSFamille() {
		super();
	}

	public SSFamille(int idSSFamille, String libelleSSFamille) {
		super();
		this.idSSFamille = idSSFamille;
		this.libelleSSFamille = libelleSSFamille;
	}

	public int getIdFamille() {
		return idSSFamille;
	}

	public String getLibelleFamille() {
		return libelleSSFamille;
	}

	public void setIdFamille(int idSSFamille) {
		this.idSSFamille = idSSFamille;
	}

	public void setLibelleFamille(String libelleSSFamille) {
		this.libelleSSFamille = libelleSSFamille;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return idSSFamille;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return libelleSSFamille;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
