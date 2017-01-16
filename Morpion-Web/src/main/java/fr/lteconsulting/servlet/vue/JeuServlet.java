package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import fr.lteconsulting.Coup;
import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Piece;
import fr.lteconsulting.Plateau;

@WebServlet("/jeu.html")
public class JeuServlet extends VueServlet {

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Le premier coup
		Plateau plateau = DonneesScope.getPlateauSession(request);
		if (plateau == null) {
			plateau = new Plateau(3, 3);
		}
		// associer le plateau à la clé "plateau"
		DonneesScope.setPlateauSession(plateau,request);
		traiterRequete(request, response, plateau);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doPost n'est utilisable qu'avec un formulaire
		Plateau plateau = DonneesScope.getPlateauSession(request);

		String x = request.getParameter("x");
		String y = request.getParameter("y");
		if (x != null && !x.isEmpty() && y != null & !y.isEmpty()) {
			plateau.placerPiece(new Piece('O'), Integer.parseInt(x), Integer.parseInt(y));

//			Coup coup = plateau.trouverMeilleurCoup('O', 'X');
//			if (coup != null){
//				plateau.placerPiece(new Piece('X'), coup.getX(), coup.getY());
			}
		}
//		traiterRequete(request, response, plateau);
//	}

	private void traiterRequete(HttpServletRequest request, HttpServletResponse response, Plateau plateau)
			throws ServletException, IOException {

		String x = request.getParameter("x");
		String y = request.getParameter("y");
		String message=null;

		if (x != null && !x.isEmpty() && y != null && !y.isEmpty()) {
			message = "Vous avez joué : " + x + ", " + y + " ";
			request.setAttribute("message", message);
		}
		// passer le traitement de la requète à la JSP
		 vueJeu(plateau, message, request,  response);
	}
}
