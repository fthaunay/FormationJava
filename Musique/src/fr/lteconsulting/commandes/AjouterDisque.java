package fr.lteconsulting.commandes;

import java.util.UUID;

import fr.lteconsulting.Bibliotheque;
import fr.lteconsulting.Commande;
import fr.lteconsulting.Disque;
import fr.lteconsulting.Chanson;
import fr.lteconsulting.Saisie;

public class AjouterDisque implements Commande{
	
	private Bibliotheque bibliotheque;

	public  AjouterDisque( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}
	

	@Override
	public String getNom() {
		return "Ajouter un disque";
	}

	@Override
	public void executer() {
		
		String nom = Saisie.saisie( "Nom du disque" );
		String codeBarre = Saisie.saisie( "Code barre (laisser vide pour g�n�ration al�atoire)" );
		if( codeBarre.isEmpty() )
			codeBarre = UUID.randomUUID().toString();

		Disque disque = new Disque( codeBarre, nom );

		while( true )
		{
			String titre = Saisie.saisie( "Nom de la chanson (laisser vide pour terminer)" );
			if( titre.isEmpty() )
				break;

			int duree = Saisie.saisieInt( "Dur�e de la chanson" );

			Chanson chanson = new Chanson( titre, duree );
			disque.addChanson( chanson );
		}

		bibliotheque.ajouterDisque( disque );
	}
}
