package fr.lteconsulting.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	
	protected void redirigerReferer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String redirection = request.getHeader( "referer" );
		if (!request.isRequestedSessionIdValid() ){
			redirection="index.html";
		}
		response.sendRedirect( redirection );
	}
	
	protected void redirectionParDefaut(HttpServletResponse response) throws ServletException, IOException{
				response.sendRedirect("index.html");
	}
	
	protected void redirigerVersPartie(HttpServletResponse response, String idPartie) throws ServletException, IOException{
		response.sendRedirect("partie.html?"+"id="+idPartie);
	}
	
	
	
}
