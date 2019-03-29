package bean;
/**
 * 
 * @author Quentin
 *
 */
public class Produit {

	private int idArticle;
	private String libelleArticle;
	private int stockArticle;
	private Famille famille;
	private SSFamille ssFamille;
	private Marque marque;
	
	public Produit() {
		super();
	}

	public Produit(int idArticle, String libelleArticle, int stockArticle, Famille famille, SSFamille ssFamille,
			Marque marque) {
		super();
		this.idArticle = idArticle;
		this.libelleArticle = libelleArticle;
		this.stockArticle = stockArticle;
		this.famille = famille;
		this.ssFamille = ssFamille;
		this.marque = marque;
	}

	public int getIdArticle() {
		return idArticle;
	}

	public String getLibelleArticle() {
		return libelleArticle;
	}

	public int getStockArticle() {
		return stockArticle;
	}

	public Famille getFamille() {
		return famille;
	}

	public SSFamille getSsFamille() {
		return ssFamille;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setIdArticle(int idArticle) {
		this.idArticle = idArticle;
	}

	public void setLibelleArticle(String libelleArticle) {
		this.libelleArticle = libelleArticle;
	}

	public void setStockArticle(int stockArticle) {
		this.stockArticle = stockArticle;
	}

	public void setFamille(Famille famille) {
		this.famille = famille;
	}

	public void setSsFamille(SSFamille ssFamille) {
		this.ssFamille = ssFamille;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}




}

