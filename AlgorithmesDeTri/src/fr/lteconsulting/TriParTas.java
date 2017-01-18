package fr.lteconsulting;

public class TriParTas {
	public static void main(String[] args) {

		int[] tab = { 100, 80, 2, 99, 9, 8, 14, 15, 3, 1, 0, 87, 12, 5, 4, 1002, 3 };
		afficher(tab);
		triParTas(tab);
		afficher(tab);
	}
	

	private static void permuter(int[] tab, int indice1, int indice2) {
		int temp = tab[indice1];
		tab[indice1] = tab[indice2];
		tab[indice2] = temp;
		// afficher(tab);
	}

	private static void tamiser(int[] tab, int i, int j, int taille) {
//		System.out.println(i+" "+j+" "+taille );
		int iParent = (i - 1) / 2;
		int iEnfantGauche = 2 * i + 1;
		int iEnfantDroit = 2 * i + 2;
		// System.out.println("Gauche "+iEnfantGauche+", droite "+iEnfantDroit);
		int iEnfantMax;
		// System.out.println(tab.length+" "+iEnfantDroit);

		// Ne pas tamiser sur les feuilles

		if (taille <= (iEnfantGauche)) {
			
		//	 System.out.println("Feuille "+i);
			return;
		}
		
		// System.out.println("i"+i);
		if (taille < iEnfantDroit + 1 || tab[iEnfantGauche] > tab[iEnfantDroit]) { //
			iEnfantMax = iEnfantGauche;
			// System.out.println("iEnfantMax1 "+iEnfantMax);
		} else {
			iEnfantMax = iEnfantDroit;
			// System.out.println("iEnfantMax2 "+iEnfantMax);
		}

		// System.out.println("j"+j);
		if (tab[i] < tab[iEnfantMax]) {
			permuter(tab, i, iEnfantMax);
	//		System.out.println("permuter");
	//		afficher(tab);
		}
		if (i > 0) {
			tamiser(tab, iParent, j, taille);
			// afficher(tab);
		} else {
			if (j > 0) {
				tamiser(tab, j - 1, j - 1, taille);
				// afficher(tab);
			}
		}
	}

	public static void triParTas(int[] tab) {
		
		for(int taille = tab.length; taille >=1; taille--) {
		//	System.out.println("taille "+taille);
			for (int i = taille / 2; i >= 0; i--) {
				// System.out.println("i dans triParTas "+i);
				tamiser(tab, i, i, taille);	
			}
	//		afficher(tab);
			permuter(tab, 0, taille-1);
		//	afficher(tab);
		}
	}

	private static void afficher(int[] tab) {
		for (int i = 0; i < tab.length; ++i) {
			System.out.print(tab[i] + " ");

		}
		System.out.println();
	}

}
