package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.BlocFiltre;
import bean.Filtre;
import service.Service;

public class CommandFiltre implements ICommand {

	/**
	 * @see command.ICommand#execute(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		//on passe en revue tout les filtre de chaque BlockFiltre
		for (BlocFiltre currBlock: (List<BlocFiltre>) Service.getSessionBeanBrowser(request).getListBlocFiltre()) {
			
			
	    	for (Filtre currFiltre: (List<Filtre>) currBlock.getListFiltre()) {
	    		
	    		//si le filtre est cocher lors de l'envoie de la requete on passe son état sur coché dans le BeanBrowser
	    		//sinon on passe son état sur décocher
	    		if(request.getParameterValues(currBlock.getIdBlocFiltre() + " " + currFiltre.getIdFiltre() )!=null) {
	    			currFiltre.setChecked(true);
	    		}else {	
	    			currFiltre.setChecked(false);
	    		}
	    	}    		
    	}	
		
		//puis retour sur le catalogue
		
		//construction de la requetes SQL en fonction des Filtres cochés
		
		return "/WEB-INF/jsp/catalogue.jsp";	
		}

}
