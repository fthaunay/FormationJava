package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Arrays;

public class TriABulles {
	public static void main(String[] args) {

		// Pour tester la methode recombiner seule (etape 1)
		int[] tab = {2, 99, 9, 14, 3, 1, 0, 87, 12, 5, 4};
		afficherTableau(tab);
		trierTableau(tab);
		afficherTableau(tab);
	}
	
	public static void trierTableau(int[] tab) {
		int indiceMax = tab.length-1;
		for (int j=0;j<tab.length-1;++j){			
			for (int i=0;i<indiceMax;++i){
				if (tab[i]>tab[i+1]){
					permuter(tab, i, i+1);
				}
			}
			indiceMax--;
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
