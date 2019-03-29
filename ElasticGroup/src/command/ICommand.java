package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author Quentin
 *
 */

public interface ICommand {

	/**
	 * @param request
	 * @param response
	 * @return String contenant le nom de la commande ou de la jsp a appelée
	 * @throws ServletException
	 * @throws IOException
	 */
	String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
