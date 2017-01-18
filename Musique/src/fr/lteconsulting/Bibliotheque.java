package fr.lteconsulting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.lang.String;


public class Bibliotheque {
	private Map<String, Disque> disques = new HashMap<String, Disque>();
	
	/* La bibliotheque possède toutes les commandes implémentées précédemment
	 * mais ne conserve que la partie liée directement à la bibliothèque, 
	 * sans se préoccuper de l'interface (d'où vient le disque ? aléatoire, initialisation du main, 
	 * ou interface utilisateur ? Ce n'est pas ici que ça se règle. 
	 *  - ajouterDisque
	 *  - rechercherDisqueParNom(String mot)
	 *  - rechercherDisqueParNom(List<String> mots)
	 *  rechercherDisqueParCodeBarre
	 *  - rechercherDisqueParAnagramme
	 *  - afficher (affichage ordonné par code barre)
	 *  
	 */

	public void ajouterDisque(Disque disque) {
		disques.put(disque.getCodeBarre(), disque);
	}
	
	public List<Disque> getDisques()
	{
		return new ArrayList<>( disques.values() );
	}

	public void afficher()
	{
		System.out.println( "BIBLIOTHEQUE avec " + disques.size() + " disques" );
		for( Disque disque : disques.values() )
			disque.afficher();
	}

	public List<Disque> rechercherDisqueParNom(String mot) {
		List<Disque> disquesSelectionnes = new ArrayList<Disque>();
		for (Entry<String, Disque> entree : disques.entrySet()) {
			Disque disque = entree.getValue();
			if (entree.getValue().getNom().contains(mot)) {
				disquesSelectionnes.add(disque);
			}
		}
		return disquesSelectionnes;
	}
	
	
	public List<Disque> rechercherDisqueParNom(List<String> mots) {
		List<Disque> disquesSelectionnes = new ArrayList<Disque>();
		
		for (Disque disque : disques.values()){
			boolean estValide = true;
			for (String mot : mots){
				if (!disque.getNom().toLowerCase().contains(mot.toLowerCase())){
					estValide = false;
				}
			}
			
			if (estValide) {
				disquesSelectionnes.add(disque);
			}
		}
		return disquesSelectionnes;
	}
	
	
	public List<Disque> rechercherDisqueParAnagramme(String mot) {
		List<Disque> disquesSelectionnes = new ArrayList<Disque>();
		char[] anagramme = mot.toLowerCase().toCharArray();
		Arrays.sort(anagramme);
		String temp;
		for (Disque disque : disques.values()){
			boolean estValide= true;
			temp = disque.getNom().toLowerCase();
			char[] lettres = temp.toCharArray();
			Arrays.sort(lettres);
			if (lettres.length != anagramme.length){
				estValide = false;
			} else{
				for (int i=0;i<lettres.length;++i){
					if (lettres[i] != anagramme[i]){
						estValide = false;
					}
				}
			}
			
			if (estValide) {
				disquesSelectionnes.add(disque);
			}
		}
		return disquesSelectionnes;
	}
	
	public Disque rechercherDisqueParCodeBarre( String codeBarre )
	{
		return disques.get( codeBarre );
	}
}


