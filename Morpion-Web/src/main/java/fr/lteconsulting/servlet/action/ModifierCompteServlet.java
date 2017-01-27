package fr.lteconsulting.servlet.action;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.doa.JoueurDao;

/**
 * Servlet implementation class ModifierCompteServlet
 */
@WebServlet("/modifierCompte")
public class ModifierCompteServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private JoueurDao joueurDao;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// Récupérer les valeurs des champs du formulaire.
		String newPseudo = request.getParameter("pseudo");
		String newLogin = request.getParameter("login");
		String newPassword = request.getParameter("password");
		String newConfirmPassword = request.getParameter("confirmPassword");
		String newCaractere = request.getParameter("caractere");

		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);

		// TODO Changer les conditions car oblige a changer de login
		if (!newPassword.equals(newConfirmPassword)
				|| joueurDao.findByLogin(newLogin) != null) {
			redirigerReferer(request, response);
			return;
		}

		Joueur joueur = joueurDao.modifierJoueur(joueurConnecte.getLogin(),
				newPseudo, newLogin, newConfirmPassword, newCaractere);

		// Enregistrer ce joueur en session.
		DonneesScope.setJoueurSession(joueur, request);

		redirectionParDefaut(response);
	}
}
