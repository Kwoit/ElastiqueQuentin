package bean;

public class Article extends Produit {

	private Couleur couleur;
	private float prixVente;
	private int stockArticle;
	private int quantity;
	
	public Article() {
		super();
	}

	public Article(Couleur couleur, float prixVente){
		super();
		this.couleur = couleur;
		this.prixVente = prixVente;
		this.quantity = 1;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public int getStockArticle() {
		return stockArticle;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public void setPrixVente(float prixVente) {
		this.prixVente = prixVente;
	}

	public void setStockArticle(int stockArticle) {
		this.stockArticle = stockArticle;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
