package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.doa.JoueurDao;


@WebServlet("/scores.html")
public class ScoresServlet extends VueServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private JoueurDao joueurDao;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Joueur> joueurs = joueurDao.getJoueurs();
		vueScores(joueurs, request, response);
	}
}
