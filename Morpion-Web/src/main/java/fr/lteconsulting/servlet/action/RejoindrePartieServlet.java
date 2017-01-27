package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.doa.PartieDao;

@WebServlet("/rejoindrePartie")
public class RejoindrePartieServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PartieDao partieDao;
	
	/**
	 * 
	 * retrouvez la partie demandée,
	 *  ajouter le joueur à cette partie
	 *  redirigez vers l’URL d’accueil pour l’instant
	 *  
	 */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idPartie = request.getParameter("partie");
		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
		partieDao.rejoindrePartie(idPartie, joueurConnecte);
		Partie partie = partieDao.findById(idPartie);
		redirigerVersPartie(response, partie.getId());
	}
}
