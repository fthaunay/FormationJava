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
import fr.lteconsulting.Piece;
import fr.lteconsulting.doa.JoueurDao;
import fr.lteconsulting.doa.PartieDao;

/**
 * Servlet implementation class JouerCoup
 */
@WebServlet("/jouerCoup")
public class JouerCoupServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private JoueurDao joueurDao;

	@EJB
	private PartieDao partieDao;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String idPartie = request.getParameter("id");

		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
		Partie p = partieDao.findById(idPartie);

		if (x != null && !x.isEmpty() && y != null & !y.isEmpty()) {
			String caractere = joueurConnecte.getCaractere();
			p.getPlateau().placerPiece(new Piece(caractere.charAt(0)),
					Integer.parseInt(x), Integer.parseInt(y));

			partieDao.updatePartie(p);

			// Teste si la partie est terminée, et si oui, incrémente les scores
			// des joueurs

			// Teste si la partie est terminée (plateau plein ou joueur gagnant)
			Joueur joueurGagnant = partieDao.joueurGagnant(idPartie,
					joueurConnecte, Integer.valueOf(x), Integer.valueOf(y));

			if (p.getPlateau().casesVides() == 0 || joueurGagnant != null) {

				for (Joueur joueur : p.getJoueurs()) {
					joueurDao.updateScore(joueur, p);
				}
			}
			redirigerReferer(request, response);
		}
	}
}
