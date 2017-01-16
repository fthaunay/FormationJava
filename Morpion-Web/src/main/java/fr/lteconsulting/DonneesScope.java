package fr.lteconsulting;

import javax.servlet.http.HttpServletRequest;

public class DonneesScope {

	private static final String PLATEAU_SESSION_ATTRIBUTE_NAME = "plateau";
	private static final String PARTIE_SESSION_ATTRIBUTE_NAME = "partie";
	
	public static Plateau getPlateauSession(HttpServletRequest request) {
		return (Plateau) request.getSession()
				.getAttribute(PLATEAU_SESSION_ATTRIBUTE_NAME);
	}

	public static void setPlateauSession(Plateau plateau,
			HttpServletRequest request) {
		request.getSession().setAttribute(PLATEAU_SESSION_ATTRIBUTE_NAME,
				plateau);
	}

	public static void viderSession(HttpServletRequest request) {
		request.getSession().invalidate();
	}

	/**
	 * Retuns the player registered in the session
	 * 
	 * @return
	 */
	public static Joueur getJoueurSession(HttpServletRequest request) {
		return (Joueur) request.getSession().getAttribute("joueurConnecte");
	}

	public static void setJoueurSession(Joueur joueur,
			HttpServletRequest request) {
		request.getSession().setAttribute("joueurConnecte", joueur);
	}

/*	public static List<Joueur> getJoueursApplication(ServletContext context) {

		// unchecked car arrive de la creation du compte
		@SuppressWarnings("unchecked")
		List<Joueur> joueurs = (List<Joueur>) context.getAttribute("joueurs");
		if (joueurs == null || joueurs.isEmpty()) {
			joueurs = new ArrayList<Joueur>();
			context.setAttribute("joueurs", joueurs);
		}
		return joueurs;
	}
*/	

	/**
	 * Retourne la liste des parties de l'application Si la liste est NULL, crée
	 * une liste vide
	 * 
	 * 
	 */

/*	public static List<Partie> getPartiesApplication(ServletContext context) {

		@SuppressWarnings("unchecked")
		List<Partie> parties = (List<Partie>) context
				.getAttribute(LISTE_PARTIES_APPLICATION_ATTRIBUTE_NAME);
		if (parties == null) {
			parties = new ArrayList<Partie>();
			setPartiesApplication(parties, context);
		}
		return parties;
	}
*/

/*	 public static void setPartiesApplication(List<Partie> parties,
			ServletContext context) {
		context.setAttribute(LISTE_PARTIES_APPLICATION_ATTRIBUTE_NAME, parties);
	}
*/

	public static void setPartieSession(Partie partie,
			HttpServletRequest request) {
		request.getSession().setAttribute(PARTIE_SESSION_ATTRIBUTE_NAME,
				partie);
	}

	/*public static Partie getPartie(PartieDao partieDao, String idPartie, ServletContext context){
		List<Partie> parties = partieDao.getParties();
		Partie partieEnCours = null;
		for (Partie partie : parties) {
			if (idPartie.equals(partie.getId())) {
				partieEnCours = partie;
			break;
			}
		}
		return partieEnCours;
	}
*/
}
