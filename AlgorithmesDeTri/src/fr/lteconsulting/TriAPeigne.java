package fr.lteconsulting;

public class TriAPeigne {

	public static void main(String[] args) {

		// Pour tester la methode recombiner seule (etape 1)
		int[] tab = { 2, 99, 9, 14,27,4,45,87,12,23,38,98, 4,45,87,12,23,38,98, 3, 1,3, 1, 0, 87, 12, 5, 4 };
		afficherTableau(tab);
		trierTableau(tab);
		afficherTableau(tab);
	}

	public static void trierTableau(int[] tab) {
		int intervalle = tab.length;
		boolean echange = false;
		while (intervalle > 1 || echange == true) {
			intervalle /= 1.3;
			if (intervalle < 1) {
				intervalle = 1;
			}

			int i = 0;
			echange = false;

			while (i < tab.length - intervalle) {
		//		System.out.println("i "+i+", intervalle "+intervalle);
				if (tab[i] > tab[i + intervalle]) {
					permuter(tab, i, i + intervalle);
					echange = true;
				}
				i += 1;
			}
		}
	}

	private static void permuter(int[] tab, int indice1, int indice2) {
		int temp = tab[indice1];
		tab[indice1] = tab[indice2];
		tab[indice2] = temp;
	}

	public static void afficherTableau(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");
		}
		System.out.println();
	}

}
