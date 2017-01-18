package fr.lteconsulting.commandes;

import fr.lteconsulting.Bibliotheque;
import fr.lteconsulting.Commande;
import fr.lteconsulting.Disque;
import fr.lteconsulting.Saisie;

public class RechercherParCodeBarre implements Commande{
	
	private Bibliotheque bibliotheque;

	public RechercherParCodeBarre( Bibliotheque bibliotheque )
	{
		this.bibliotheque = bibliotheque;
	}

	@Override
	public String getNom() {
		return "Rechercher par code barre";
	}

	@Override
	public void executer() {
			String codeBarre = Saisie.saisie( "Saisissez le code barre" );

			Disque disque = bibliotheque.rechercherDisqueParCodeBarre( codeBarre );
			

			if( disque == null )
			{
				System.out.println( "Il n'y a aucun disque avec le code barre " + codeBarre );
			}
			else
			{
				System.out.println( "Un disque a été trouvé" );
				disque.afficher();
			}
	}
}
