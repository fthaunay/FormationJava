package fr.lteconsulting;
import java.util.ArrayList;
import java.util.Arrays;

public class TriPairImpair {
	public static void main(String[] args) {

		// Pour tester la methode recombiner seule (etape 1)
		int[] tab = {2, 99, 9, 14, 3, 1, 0, 87, 12, 5, 4};
		afficherTableau(tab);
		trierTableau(tab);
		afficherTableau(tab);
	}
	
	public static void trierTableau(int[] tab) {
		boolean trie = false;
		while(!trie){
			trie = true;
	  //comparaisons impaires-paires : 
			for (int i = 1; i < tab.length-1; i += 2){
				if(tab[i] > tab[i+1]){
					permuter(tab, i, i+1);
					trie = false;
				}
			}
	      
	  //comparaisons paires-impaires : 
			for(int i = 0; i < tab.length-1; i += 2){
				if( tab[i] > tab[i+1]){
					permuter(tab, i, i+1);
					trie = false;
				}
			}
		}
	}
	     
	private static void permuter(int[] tab, int indice1, int indice2) {
		int temp = tab[indice1];
		tab[indice1] = tab[indice2];
		tab[indice2] = temp;
	}
	
	public static void afficherTableau(int[] tab){
		for (int i=0;i<tab.length;++i){
			System.out.print(tab[i]+" ");
		}
		System.out.println();
	}
}
