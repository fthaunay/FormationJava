package fr.lteconsulting.servlet.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.lteconsulting.DonneesScope;


/**
 * Servlet implementation class Logout
 */

@WebServlet( "/logout" )
public class LogoutServlet extends ActionServlet
{
	private static final long serialVersionUID = 1L;

	protected void doGet( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{	
		DonneesScope.viderSession(request);
		redirigerReferer(request,response );
	}

	protected void doPost( HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		DonneesScope.viderSession(request);
		redirigerReferer(request,response );
		
	}
}
