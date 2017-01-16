package fr.lteconsulting.servlet.vue;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.Plateau;
import fr.lteconsulting.doa.PartieDao;

public abstract class VueServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PartieDao partieDao;

	/**
	 * Genere le code HTML  de la vue 'WEB-INF/jeu.jsp'
	 *  @param plateau Le plateau à afficher
	 *  @param message Le message à afficher
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	
	protected void vueJeu(Plateau plateau, String message,
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
		request.setAttribute("plateau", plateau);
		request.setAttribute("message", message);
		
		callJsp("Page de jeu (ne sert pas)", false, "jeu", request, response);
	}

	/**
	 * Genere le code HTML  de la vue 'WEB-INF/login.jsp'
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	
	protected void vueLogin(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
		System.out.println("dans vueLogin");
		callJsp("page de connection", false, "login", request, response);
	}
	
	/**
	 * Genere le code HTML  de la vue 'WEB-INF/login.jsp'
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	
	protected void vueAccueil(HttpServletRequest request, HttpServletResponse response, 
			List<Partie> parties, Joueur joueurConnecte)
					throws ServletException, IOException{
		request.setAttribute("parties", parties);
		request.setAttribute("joueurConnecte", joueurConnecte);
		System.out.println("dans vueAccueil");
		callJsp("Page d'accueil", false, "accueil", request, response);
	}
	
		
	
	/**
	 * Genere le code HTML  de la vue 'WEB-INF/creationCompte.jsp'
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	
	protected void vueCreationCompte(HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
		System.out.println("dans vueCreationCompte");
		callJsp("Creation de compte", false, "creationCompte", request, response);
	}
	
	protected void vueMAJCompte(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("dans vueMAJCompte");
		callJsp("Mise à jour du compte", false, "majCompte", request, response);
}
	
	protected void vueCreationPartie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		System.out.println("dans vueCreationPartie");
		callJsp("Creation de partie", false, "creationPartie", request, response);
}
	
	/**
	 * Genere le code HTML  de la vue 'WEB-INF/vueRalliementPartie.jsp'
	 * @throws IOException 
	 * @throws ServletException 
	 * 
	 */
	
	
	protected void vuePartieAttente(HttpServletRequest request, HttpServletResponse response,
			Partie partie) throws ServletException, IOException{
		System.out.println("dans vuePartieAttente");
		request.setAttribute("partie", partie);
		callJsp("Partie "+partie.getName()+" en attente", true, "partieAttente", request, response);
	}
	
	protected void vuePartie(Plateau plateau, Partie partie, Joueur joueurConnecte, 
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
		System.out.println("dans vuePartie");
		
		boolean doitRaffraichirPage = false;
	
		Partie partieEnCours = partieDao.findById(partie.getId());
		System.out.println("Partie en cours " + partieEnCours.getName());
	//	System.out.println("JoueurCourant " + partieEnCours.joueurCourant().getLogin());
		
		request.setAttribute("plateau", plateau);
		request.setAttribute("partie", partieEnCours);
		request.setAttribute("joueurConnecte", joueurConnecte);
		
		
		if ( partieEnCours.joueurCourant() != null ){
		 doitRaffraichirPage = (!joueurConnecte.getLogin().equals(partieEnCours.joueurCourant().getLogin()));
		}
		callJsp("Page de la partie "+partieEnCours.getName(), doitRaffraichirPage, "partie", request, response);
	}
	
	protected void vueScores(List<Joueur> joueurs, 
			HttpServletRequest request, HttpServletResponse response)
					throws ServletException, IOException{
		System.out.println("dans vueScore");
		request.setAttribute("joueurs", joueurs);
		
		callJsp("Page des scores", false, "scores", request, response);
	}
	
	
	
	/**
	 * 
	 * @param Delegue le traitement de la requete HTTP à une Servlet JSP 
	 * (qui doit se trouver dans le repertoire '/WEB-INF/')
	 * @param request La requete HTTP en cours
	 * @param response La reponse HTTP à générer
	 * @throws IOException 
	 * @throws ServletException 
	 */
	
	/*private void callJsp(String name, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		getServletContext().getRequestDispatcher("/WEB-INF/"+name+".jsp")
		.forward(request,  response);
	}
	*/
	
	private void callJsp( String pageTitle, boolean autoReload, String name,
			HttpServletRequest request, HttpServletResponse response )
			throws ServletException, IOException
	{
		request.setAttribute( "pageTitle", pageTitle );
		request.setAttribute( "pageReload", autoReload );
		request.setAttribute( "pageContentJsp", name + ".jsp" );
		request.setAttribute( "pageContentCss", name + ".css" );
		System.out.println("dans callJsp");
		getServletContext()
				.getRequestDispatcher( "/WEB-INF/gabarit.jsp" )
				.forward( request, response );
	}
}
