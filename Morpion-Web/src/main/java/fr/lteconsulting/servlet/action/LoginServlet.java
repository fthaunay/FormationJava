package fr.lteconsulting.servlet.action;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.doa.JoueurDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private JoueurDao joueurDao;
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// extraire les parametres de la requete
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// demander la liste des joueurs connus
		List<Joueur> joueurs = joueurDao.getJoueurs();
		
		// Verifier si le joueur est bien identifié
		
// inutile, la liste n'est jamais nulle, et ce n'est pas un problème si elle est vide		
//		if (joueurs != null && !joueurs.isEmpty()) {
			for (Joueur joueur : joueurs) {
				if (login.equals(joueur.getLogin())
						&& password.equals(joueur.getPassword())) {
					// Le connecter
					DonneesScope.setJoueurSession(joueur, request);
					break;
				}
			}
//		}
		redirigerReferer(request, response);
	}
	
	
}
