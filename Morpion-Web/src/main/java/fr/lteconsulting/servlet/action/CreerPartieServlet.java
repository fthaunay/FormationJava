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

@WebServlet("/creerPartie")
public class CreerPartieServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;
   
	@EJB
	private PartieDao partieDao;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Récupérer les valeurs des champs du formulaire.
			String nomPartie = request.getParameter("nomPartie");
			int taillePlateau = Integer.parseInt(request.getParameter("taillePlateau"));
			Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
			Partie partie = partieDao.creerPartie(nomPartie, taillePlateau, joueurConnecte);
			
		//	partie.addJoueur(DonneesScope.getJoueurSession(request));
			
			// Rejoindre la page de la partie
			
			redirigerVersPartie(response, partie.getId());
	}
}
