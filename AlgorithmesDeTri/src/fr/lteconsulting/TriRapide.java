package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TriRapide {

	public static void main(String[] args) {

		// Pour tester la methode recombiner seule (etape 1)
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 5, 9, 14, 3, 1, 0, 87, 12, 99, 4));
		//  14, 3, 1, 0, 87, 12, 99, 4
		ArrayList<Integer> listeTriee = triParPivot(list);
		System.out.println(listeTriee);

	}
	
	/*La méthode consiste à placer un élément du tableau (appelé pivot) à sa place définitive, 
	 * en permutant tous les éléments de telle sorte que tous ceux qui sont inférieurs au pivot
	 *  soient à sa gauche et que tous ceux qui sont supérieurs au pivot soient à sa droite.

	Cette opération s'appelle le partitionnement. Pour chacun des sous-tableaux, on définit un nouveau pivot
	 et on répète l'opération de partitionnement. Ce processus est répété récursivement,
	  jusqu'à ce que l'ensemble des éléments soit trié.

	Concrètement, pour partitionner un sous-tableau :

	on place le pivot à la fin (arbitrairement), en l'échangeant avec le dernier élément du sous-tableau ;
	on place tous les éléments inférieurs au pivot en début du sous-tableau ;
	on place le pivot à la fin des éléments déplacés.
*/

	
	public static int[] positionnerPivot( int[] tab) {
	Random random = new Random();
	int indexPivot = random.nextInt(tab.length);
	// 1 - On place le pivot à la fin du tableau
	int temp = tab[tab.length-1];
	tab[tab.length-1]= tab[indexPivot];
	tab[indexPivot] = temp; 
	
	// Pour chaque élement du tableau, si T[i
	
	
	return null;
	
}	
	
	
	
/*	private static int[] partitionnement( int[] tab) {
		Random random = new Random();
		int indexPivot = random.nextInt(tab.length);
		// 1 - On place le pivot à la fin du tableau
		int temp = tab[tab.length-1];
		tab[tab.length-1]= tab[indexPivot];
		tab[indexPivot] = temp; 
		
		// Pour chaque élement du tableau, si T[i
		
		
		return null;
		
	}
	
*/
	/*  partitionner(tableau T, entier premier, entier dernier, pivot)
    échanger T[pivot] et T[dernier]  // échange le pivot avec le dernier du tableau , le pivot devient le dernier du tableau
    j := premier
    pour i de premier à dernier - 1 // la boucle se termine quand i = (dernier-1).
        si T[i] <= T[dernier] alors
            échanger T[i] et T[j]
            j := j + 1
    échanger T[dernier] et T[j]
    renvoyer j

tri_rapide(tableau T, entier premier, entier dernier)
    début
        si premier < dernier alors
            pivot := choix_pivot(T, premier, dernier)
            pivot := partitionner(T, premier, dernier, pivot)
            tri_rapide(T, premier, pivot-1)
            tri_rapide(T, pivot+1, dernier)
        fin si
    fin
	
		*/

	public static ArrayList<Integer> triParPivot(ArrayList<Integer> listeExt) {
		// le meilleur choix est un pivot aleatoire
//		Random random = new Random();
//		int indexPivot = random.nextInt(listeExt.size());
		
		// 1er test : pivot = prmier element
		int indexPivot=0;
		ArrayList<Integer> liste = new ArrayList<Integer>();
		ArrayList<Integer> sousListe = new ArrayList<Integer>();
		ArrayList<Integer> sousListe2 = new ArrayList<Integer>();
		sousListe.add(listeExt.get(indexPivot));
		for (int i = 1; i < listeExt.size(); ++i) {
			if (listeExt.get(i).compareTo(listeExt.get(indexPivot)) == -1) {
				System.out.println(listeExt.get(i)+ listeExt.get(indexPivot)+
						listeExt.get(i).compareTo(listeExt.get(indexPivot))  );
				sousListe.add(listeExt.get(i));
			} else {
				sousListe2.add(listeExt.get(i));
			}
		}
//		liste.addAll(sousListe);
//		liste.addAll(sousListe2);
		
		
		if(sousListe.size()>2){
			liste.addAll(triParPivot(sousListe));
		}else {
			liste.addAll(sousListe);
		}
		
		if(sousListe2.size()>2){
			liste.addAll(triParPivot(sousListe2));
		}else {
			liste.addAll(sousListe2);
		}
		System.out.println("sousListe "+sousListe);
		System.out.println("sousListe2 "+sousListe2);
		System.out.println("liste "+liste);
		
		return liste;
	}
}
