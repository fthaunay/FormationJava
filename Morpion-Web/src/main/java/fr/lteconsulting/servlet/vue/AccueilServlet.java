package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.doa.PartieDao;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/index.html")
public class AccueilServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PartieDao partieDao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
				// Vérifie si un utilisateur est en session
				Joueur joueur = DonneesScope.getJoueurSession(request);
				List<Partie> parties = partieDao.getParties();
				// S'il l'est, afficher la vue ACCUEIL
				if (joueur != null) {
					vueAccueil(request, response, parties, joueur);
					
				} else {
					// sinon, affiche la vue LOGIN
					vueLogin(request, response);
				}
	}
}
