package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreationPartieServlet
 */
@WebServlet("/creationPartie.html")
public class CreationPartieServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		vueCreationPartie(request, response);
	}

}
