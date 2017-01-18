package fr.lteconsulting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShellSort2 {

		// tri d'un jeu de cartes
		public static void main(String[] args) {
			List<Integer> tab = new ArrayList<Integer>();
			Random r = new Random();
			for (int i=0;i<10000;++i){
				tab.add(r.nextInt(10000));
			}
			afficherTableau(tab);
			triShell(tab);
			afficherTableau(tab);
		}

		public static void triShell(List<Integer> tab) {
			int[] intervalles = { 6, 4, 3, 2, 1 };
		//	int[] intervalles = { 1 };
			for (int ngap = 0; ngap < intervalles.length; ngap++) {
					triParInsertion(tab, intervalles[ngap]);
			}
		}

	
		
		public static void triParInsertion(List<Integer> tab, int gap) {

			for (int k = 0; k < tab.size(); k+=gap) {
					int x = tab.get(k);  // memorise la place de la carte a trier
					for (int j = k - gap; j >= 0; j-=gap) {
						// deplace la carte sur la gauche tant que l'�l�ment pr�c�dent
						// est plus petit
						if (tab.get(j) > x) {
							tab.set(j+gap, tab.get(j) );
							tab.set(j, x);
						} else {
							tab.set(j+gap, x );
							break;
						}
					}
			}
		}
		
		
		
		
		
		
		

		public static void afficherTableau(List<Integer> tab) {
			for (int i = 0; i < tab.size(); ++i) {
				System.out.print(tab.get(i) + " ");
			}
		//	System.out.println();
		}
	}
