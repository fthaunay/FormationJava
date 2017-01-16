package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationCompteServlet
 */
@WebServlet("/creationCompte.html")
public class CreationCompteServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vueCreationCompte(request, response);
	}

}
