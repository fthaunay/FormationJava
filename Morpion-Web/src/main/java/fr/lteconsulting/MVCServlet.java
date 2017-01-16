package fr.lteconsulting;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MVCServlet
 * Pour initialiser au hasard
 * (Ne sert pas)
 */
@WebServlet("/mvc.html")
public class MVCServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Plateau plateau = new Plateau(250, 300);
	
	public MVCServlet() {
		plateau.initialiserHasard();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		// enregistrement du plateau dans le contexte JSP
		request.setAttribute("plateau", plateau);
		
		// délégation du traitement de la requète à la vue JSP
		getServletContext().getRequestDispatcher("/WEB-INF/mvc.jsp").forward(request, response);
	}
}
