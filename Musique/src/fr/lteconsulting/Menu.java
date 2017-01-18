package fr.lteconsulting;
import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.outils.EnChiffresRomains;

	public class Menu
	{
		private List<Commande> commandes = new ArrayList<>();

		public void ajouterCommande( Commande commande )
		{
			commandes.add( commande );
		}

		public Commande saisirCommmande()
		{
			// afficher un menu,
			System.out.println( "MENU" );
			for( int i = 0; i < commandes.size(); i++ )
			{
				Commande commande = commandes.get( i );
				
				
	     		// en lettres
//				char indice = (char)((i+1)+ (int)'A'-1);
//				System.out.println( "- " + indice + ". " + commande.getNom() );
				
				// en chiffres
//				System.out.println( "- " + (i+1) + ". " + commande.getNom() );
				
				// en chiffres romains
				EnChiffresRomains cesar = new EnChiffresRomains();
				System.out.println( "- " + cesar.convertitEnRomains(i+1) + ". " + commande.getNom() );	
			}

			// TODO faire un récapitulatif des choix 
			// TODO gérer les erreurs de l'utilisateur
			int choix = Saisie.saisieInt( "Faites votre choix" );

			Commande commandeChoisie = commandes.get( choix - 1 );
			

			return commandeChoisie;
		}
		
	}



