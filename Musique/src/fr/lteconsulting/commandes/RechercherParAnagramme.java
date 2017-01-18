package fr.lteconsulting.commandes;


import java.util.List;

import fr.lteconsulting.Bibliotheque;
import fr.lteconsulting.Commande;
import fr.lteconsulting.Disque;
import fr.lteconsulting.Saisie;

public class RechercherParAnagramme implements Commande {

	private Bibliotheque bibliotheque;

	public RechercherParAnagramme( Bibliotheque bibliotheque ){
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom() {
		return "Rechercher par anagramme";
	}


	@Override
	public void executer()
	{
		String terme = Saisie.saisie( "Saisissez le terme de recherche" );

		List<Disque> disques = bibliotheque.rechercherDisqueParAnagramme( terme );

		if( disques == null || disques.isEmpty() )
		{
			System.out.println( "Aucun disque ne correspond au terme " + terme );
		}
		else
		{
			System.out.println( "Voici les disques trouvés" );
			for( Disque disque : disques )
				disque.afficher();
		}
	}

}
