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
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/creerCompte")
public class CreerCompteServlet extends ActionServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private JoueurDao joueurDao;
	
	
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// Récupérer les valeurs des champs du formulaire.
		String pseudo = request.getParameter("pseudo");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String caractere = request.getParameter("caractere");

		if (!password.equals(confirmPassword)|| joueurDao.findByLogin(login ) !=null) {
			redirigerReferer(request, response);
			return;
		}

		Joueur joueur = joueurDao.creerJoueur(pseudo, login, confirmPassword, caractere);
	
		// Enregistrer ce joueur en session.
		DonneesScope.setJoueurSession(joueur, request);

		redirectionParDefaut(response);
	}
}
