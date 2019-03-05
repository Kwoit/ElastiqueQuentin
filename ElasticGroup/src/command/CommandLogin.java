package command;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import service.Service;

public class CommandLogin implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		//recuperation du log et mp entré dans le formulaire
		Service.getSessionBeanBrowser(request).setClient(new User(request.getParameter("txtLogin"), request.getParameter("txtPassword")));
		
		//verification du login et redirection en fonction
		if (Service.getSessionBeanBrowser(request).getClient().validate()) {
			//log ok --> on envoi sur le catalogue
			return "/WEB-INF/jsp/catalogue.jsp";
		}else {
			//log pas ok --> retour login
			return "/WEB-INF/jsp/login.jsp";
		}
	}

}
