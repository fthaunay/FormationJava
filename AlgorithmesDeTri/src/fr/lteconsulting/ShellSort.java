package fr.lteconsulting;

import java.util.Random;

public class ShellSort {

	// tri d'un jeu de cartes
	public static void main(String[] args) {

		Random r = new Random();
		int tab[] = new int [1000]; //= { 99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2, 99,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2,99, 9, 14, 15, 2, 99, 9, 14, 15, 3, 1, 15, 2, 3, 87, 12, 5, 4, 14, 15, 3, 1, 0, 87, };
		for (int i=0;i<1000;++i){
			tab[i]=r.nextInt(100);
		}
		afficherTableau(tab);
		triShell(tab);
		afficherTableau(tab);
	}

	public static void triShell(int[] tab) {
		int[] intervalles = { 6, 4, 3, 2, 1 };
	//	int[] intervalles = { 1 };
		for (int ngap = 0; ngap < intervalles.length; ngap++) {
				triParInsertion(tab, intervalles[ngap]);
		}
	}

	/*private static void triParInsertion(int[] tab, int gap, int debut) {

		int x;
		int j;
		for (int k = debut + gap; k < tab.length; k += gap) {
			x = tab[k]; // memorise la place de la carte a trier
			for (j = k; j >= gap; j -= gap) {
				// deplace la carte sur la gauche tant que l'élément précédent
				// est plus petit
				if (j >= gap && tab[j - gap] > x) {
					tab[j] = tab[j - gap];
					tab[j] = x;

				}
			}
			tab[j] = x;
		}
	}
	*/
	
	
	public static void triParInsertion(int[] tab, int gap) {

		for (int k = 0; k < tab.length; k+=gap) {
				int x = tab[k];  // memorise la place de la carte a trier
				for (int j = k - gap; j >= 0; j-=gap) {
					// deplace la carte sur la gauche tant que l'élément précédent
					// est plus petit
					if (tab[j] > x) {
						tab[j + gap] = tab[j];
						tab[j] = x;
					} else {
						tab[j + gap] = x;
						break;
					}
				}
		}
	}
	
	
	
	
	
	
	

	public static void afficherTableau(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}
}
