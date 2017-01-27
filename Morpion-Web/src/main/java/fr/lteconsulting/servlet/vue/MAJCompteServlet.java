package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MAJCompteServlet
 */
@WebServlet("/majCompte.html")
public class MAJCompteServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		vueMAJCompte(request, response);
	}

}
