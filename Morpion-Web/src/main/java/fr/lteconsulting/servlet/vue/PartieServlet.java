package fr.lteconsulting.servlet.vue;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.Plateau;
import fr.lteconsulting.doa.PartieDao;

@WebServlet("/partie.html")
public class PartieServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PartieDao partieDao;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
		String idPartie = request.getParameter("id");
		Partie partieEnCours = partieDao.findById(idPartie);
		Plateau plateau = partieEnCours.getPlateau();

		if (partieEnCours.getJoueurs().size() == 2){
			 vuePartie(plateau, partieEnCours, joueurConnecte, request,  response);
		} else {
			vuePartieAttente(request, response,	 partieEnCours);
		}
	}
}
