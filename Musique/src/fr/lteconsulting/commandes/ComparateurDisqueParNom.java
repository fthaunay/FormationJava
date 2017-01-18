package fr.lteconsulting.commandes;

import java.util.Comparator;

import fr.lteconsulting.Disque;

public class ComparateurDisqueParNom implements Comparator<Disque>
{
	@Override
	public int compare( Disque o1, Disque o2 )
	{
		return o1.getNom().compareTo( o2.getNom() );
	}
}