package bean;

public class Couleur implements IFiltrable{

	private int idColor;
	private String libelleColor;
	private String codeHexa;
	
	public Couleur() {
		super();
	}

	public Couleur(int idColor, String libelleColor, String codeHexa) {
		super();
		this.idColor = idColor;
		this.libelleColor = libelleColor;
		this.codeHexa = codeHexa;
	}

	public int getIdColor() {
		return idColor;
	}

	public void setIdColor(int idColor) {
		this.idColor = idColor;
	}

	public String getLibelleColor() {
		return libelleColor;
	}

	public void setLibelleColor(String libelleColor) {
		this.libelleColor = libelleColor;
	}

	public String getcodeHexa() {
		return codeHexa;
	}

	public void setcodeHexa(String codeHexa) {
		this.codeHexa = codeHexa;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.idColor;
	}

	@Override
	public String getLibelle() {
		// TODO Auto-generated method stub
		return this.libelleColor;
	}

	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return this.codeHexa;
	}

	
	
}
