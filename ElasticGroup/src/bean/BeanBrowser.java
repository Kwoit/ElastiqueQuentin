package bean;

import java.util.List;

import service.ServiceFiltre;

/**
 * 
 * @author Quentin
 *
 */
public class BeanBrowser {
	//User Bean
	private User client;
	//Filtre Bean
	private List<BlocFiltre> listBlocFiltre;
	
	private List<Article> listArticle;
	
	//Constructeur
	public BeanBrowser() {
		this.client = new User();
		this.listBlocFiltre = new ServiceFiltre().createFiltre();
	}
	
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}

	public List<BlocFiltre> getListBlocFiltre() {
		return listBlocFiltre;
	}

	public void setListBlocFiltre(List<BlocFiltre> listBlocFiltre) {
		this.listBlocFiltre = listBlocFiltre;
	}

	public List<Article> getListArticle() {
		return listArticle;
	}

	public void setListArticle(List<Article> listArticle) {
		this.listArticle = listArticle;
	}
	
}
