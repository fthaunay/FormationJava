package fr.lteconsulting;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//@WebListener
// commenté pour ne plus être appelé à l'initialisation
public class ApplicationListener implements ServletContextListener  {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
/*		Partie partie1 = new Partie("premierePartie", 3);
		Partie partie2 = new Partie("deuxiemePartie", 5);
		Partie partie3 = new Partie("troisiemePartie", 3);
		Partie partie4 = new Partie("quatriemePartie", 5);
		Partie partie5 = new Partie("cinquiemePartie", 3);
		Partie partie6 = new Partie("sixiemePartie", 5);
		Partie partie7 = new Partie("septiemePartie", 3);
		Partie partie8 = new Partie("huitiemePartie", 5);
		Joueur joueur1 = new Joueur("toto", "toto", "passtoto", "X");
		Joueur joueur2 = new Joueur("tata", "tata", "passtata", "O");
		Joueur joueur3 = new Joueur("titi", "titi", "passtiti", "H");
		Joueur joueur4 = new Joueur("tutu", "tutu", "passtutu", "N");
		
		DonneesScope.getJoueursApplication(sce.getServletContext()).add(joueur1);
		DonneesScope.getJoueursApplication(sce.getServletContext()).add(joueur2);
		DonneesScope.getJoueursApplication(sce.getServletContext()).add(joueur3);
		DonneesScope.getJoueursApplication(sce.getServletContext()).add(joueur4);
		
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie1);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie2);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie3);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie4);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie5);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie6);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie7);
		DonneesScope.getPartiesApplication(sce.getServletContext()).add(partie8);
		
		partie1.addJoueur(joueur1);
		partie1.addJoueur(joueur2);
		partie2.addJoueur(joueur1);
		partie3.addJoueur(joueur1);
		partie4.addJoueur(joueur3);
		partie5.addJoueur(joueur3);
		partie5.addJoueur(joueur4);
		partie6.addJoueur(joueur4);
		partie7.addJoueur(joueur4);
		partie8.addJoueur(joueur1);
*/
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
