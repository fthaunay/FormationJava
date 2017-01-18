package fr.lteconsulting;

import fr.lteconsulting.commandes.RechercherParAnagramme;
import fr.lteconsulting.commandes.RechercherParCodeBarre;
import fr.lteconsulting.commandes.RechercherParNom;
import fr.lteconsulting.commandes.AjouterDisque;
import fr.lteconsulting.commandes.AfficherParCodeBarre;
import fr.lteconsulting.commandes.AfficherParNom;

class Utilisateur {
	private Bibliotheque bibliotheque;
	private Menu menu = new Menu();

	public Utilisateur(Bibliotheque b) {
		bibliotheque = b;
		menu.ajouterCommande(new RechercherParNom( bibliotheque ));
		menu.ajouterCommande(new RechercherParCodeBarre( bibliotheque ));
		menu.ajouterCommande(new RechercherParAnagramme( bibliotheque ));
		menu.ajouterCommande(new AjouterDisque( bibliotheque ));
		menu.ajouterCommande(new AfficherParCodeBarre( bibliotheque ));
		menu.ajouterCommande(new AfficherParNom( bibliotheque ));
		
	}
	
	public void executer()
		{
			while( true )
			{
				Commande commandeAExecuter = menu.saisirCommmande();

				commandeAExecuter.executer();
			}
		}
}


