package controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BeanBrowser;
import command.ICommand;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/frontcontroller")

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recuperation de la session active et création si elle n'existe pas
		HttpSession session = request.getSession(true);
		//si le bean browser n'existe pas deja on l'instancie
		if (session.getAttribute("beanBrowser") == null) {
			session.setAttribute("beanBrowser", new BeanBrowser());
		}		
		
		//recupération de l'url appelée
		String cmd = request.getParameter("cmd");
				
		String urlSuivante = null;
		System.out.println(1 + urlSuivante);
		if (cmd != null) {
			//Instantiation de la class correspondante a la commande dmde
			try {
				ICommand command = (ICommand) Class.forName("command." + cmd).newInstance();
				urlSuivante = command.execute(request, response);
			} 
			catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				urlSuivante = "/WEB-INF/jsp/unknowcmd.jsp";
			}

			//execution et récuperation de L'url a forwardé
		}else {
			urlSuivante = "/WEB-INF/jsp/login.jsp";
		}
		System.out.println(urlSuivante);
		//forward vers l'url donné par l'action
		request.getRequestDispatcher(urlSuivante).forward( request, response );
	}
	
	
}
