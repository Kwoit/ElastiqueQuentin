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
		//debug
		System.out.println("dans la commandFiltre");
		System.out.println(request.getParameterValues("Famille Elastique Loom") + "le test param");
		
		
		for (BlocFiltre currBlock: (List<BlocFiltre>) Service.getSessionBeanBrowser(request).getListBlocFiltre()) {
			
			System.out.println("looping BlocFiltre");
			
	    	for (Filtre currFiltre: (List<Filtre>) currBlock.getListFiltre()) {
	    		
	    		//debug
	    		System.out.println("looping Filtre");
	    		System.out.println(currBlock.getLibelleBlocFiltre() + " " + currFiltre.getLibelleFiltre());
	    		
	    		if(request.getParameterValues(currBlock.getLibelleBlocFiltre() + " " + currFiltre.getLibelleFiltre() )!=null) {
	    			currFiltre.setChecked(true);
	    		}else {	
	    			currFiltre.setChecked(false);
	    		}
	    	}    		
    	}	
		
		return "/WEB-INF/jsp/catalogue.jsp";	
		}

}
