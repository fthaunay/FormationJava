package fr.lteconsulting;


public class TriFusion {

	public static void main(String[] args) {
		
		
	// Pour tester la methode recombiner seule (etape 1)	
//		int[] tab1 = new int[]{2,4,8,10,12,12,15,17};
//		int[] tab2 = new int[]{1,3,4,5,9};
//		int[] tab1 = new int[]{2};
//		int[] tab2 = new int[]{1};
//		int[] tTrie = new int[tab1.length+tab2.length];
//		tTrie = recombiner(tab1, tab2 );
//		for(int i=0;i<tTrie.length;++i){
//			System.out.print(tTrie[i]+" ");
//		}
		

	// Pour tester les methodes premiereMoitie et deuxiemeMoitie
//		int[] tableau = new int[]{2,4,8,10,12,12,15};
//		int[] tab1 = premiereMoitie(tableau);
//		int[] tab2 = deuxiemeMoitie(tableau);
//		for(int i=0;i<tab1.length;++i){
//			System.out.print(tab1[i]+" ");
//		}
//		System.out.println();
//		for(int i=0;i<tab2.length;++i){
//			System.out.print(tab2[i]+" ");
//		}
		
		
	// Pour tester le programme entier	
		int[] t = new int[]{12,4,6,2,88,12,14,28,32,64,2,5,4,8};
		System.out.print("tableau non trie ");
		for(int i=0;i<t.length;++i){
			System.out.print(t[i]+" ");
		}
		System.out.println();
//		int[] t = new int[]{12,4};
		int[] tTrie = new int[t.length];
		tTrie = trierTableau(t);
		System.out.print("tableau trie ");
		for(int i=0;i<tTrie.length;++i){
			System.out.print(tTrie[i]+" ");
		}	
	}
	
	
// Trier un tableau : 
// - diviser le tableau principal en 2 sous-tableaux, puis refaire la m�me chose sur ces tableaux 
// jusqu'� ce que tous les tableaux soient de taille 1

	static int[] trierTableau(int[] tableau){
		if (tableau.length <=1){
			return tableau;
		} else {
			int[] tA;
			int[] tB;
			tA = trierTableau( premiereMoitie(tableau) );
			tB = trierTableau( deuxiemeMoitie(tableau) );
			return recombiner(tA, tB);
		}
	}
	
	static int[] premiereMoitie(int[] tableau){
		int[] tab1;
		if (tableau.length %2 ==0){
			 tab1 =  new int[tableau.length/2];
			 for (int i=0;i<tab1.length;++i){
				 tab1[i]=tableau[i];
			 }
		} else {
			tab1 =  new int[(tableau.length-1)/2];
			for (int i=0;i<tab1.length;++i){
				 tab1[i]=tableau[i];
			}
		}
		return tab1;
	}
	
	static int[] deuxiemeMoitie(int[] tableau){
		int[] tab2;
		if (tableau.length %2 ==0){
			tab2 =  new int[tableau.length/2];
			for (int i=0;i<tab2.length;++i){
				 tab2[i]=tableau[i+tab2.length];
			 }
		} else {
			tab2 =  new int[(tableau.length+1)/2];
			for (int i=0;i<tab2.length;++i){
				tab2[i]=tableau[i+tab2.length-1];
			 }
			
		}
		return tab2;
	}
	
	
	static int[] recombiner(int[] tab1, int[] tab2 ){
		
		// tableau resultat de la recombinaison
		int[] tableau =  new int[tab1.length + tab2.length];
		
		int indiceTab1=0;
		int indiceTab2=0;
		
		for (int i=0; i<tableau.length;++i){
			// d'abord le cas o� un des sous-tableaux est termin�
			if (indiceTab1==tab1.length){
				tableau[i] = tab2[indiceTab2];
				indiceTab2+=1;
			}else if (indiceTab2==tab2.length){
				tableau[i] = tab1[indiceTab1];
				indiceTab1+=1;
			// ensuite le cas g�n�ral
			}else{			
				if (tab1[indiceTab1]<=tab2[indiceTab2]){
					tableau[i] = tab1[indiceTab1];
					indiceTab1+=1;
				}else{
					tableau[i] = tab2[indiceTab2];
					indiceTab2+=1;
				}
			}
		}
		return tableau;
	}

}

