package fr.lteconsulting;

public class TriParInsertion {
	// tri d'un jeu de cartes
	public static void main(String[] args) {

		int[] tab = { 2, 99, 9, 14, 15, 3, 1, 0, 87, 12, 5, 4 };
		afficherTableau(tab);
		trierTableau(tab);
		afficherTableau(tab);
	}

	public static void trierTableau(int[] tab) {

		for (int k = 0; k < tab.length; k++) {
				int x = tab[k];  // memorise la place de la carte a trier
				for (int j = k - 1; j >= 0; --j) {
					// deplace la carte sur la gauche tant que l'élément précédent
					// est plus petit
					if (tab[j] > x) {
						tab[j + 1] = tab[j];
						tab[j] = x;
					} else {
						tab[j + 1] = x;
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
