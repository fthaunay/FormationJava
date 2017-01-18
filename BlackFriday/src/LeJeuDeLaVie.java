import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class LeJeuDeLaVie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Damier monJeu = new Damier(40, 40);
		BoardDisplay.displayBoard( monJeu );
//		int tab[][]={{5,4},{6,3},{6,4},{4,14},{5,14}, {6,14}, {3,15}, {7,15}, {2,16}, {8,16}, {2,17}, 
//		{8,17}, {5,27}, {9,27}, {4,28}, {5,28}, {9,28}, {10,28}, {6,30}, {7,30}, {8,30}, {6,31}, {7,31}, {8,31}, 
//		{7,32}, {8,38}, {7,39}, {8,39}};
		monJeu.initRandom();
//		monJeu.initPasRandom(tab);
		monJeu.afficher();
		int essais = 10;
		int i =0;
		while(--essais>0){
			i++;
			System.out.println("\n Essai n° "+ i);
			Scanner sc = new Scanner(System.in);
			sc.nextLine();
			monJeu.evolve();
			monJeu.afficher();
		}
	}
	
}

class Damier implements IConway {
	private int largeur;
	private int longueur;
	private boolean[] tableDuJeu;
	private boolean[] tableDuJeuNext;
		
	public Damier(int uneLargeur, int uneLongueur) {
		super();
		largeur = uneLargeur+2;
		longueur = uneLongueur+2;
		tableDuJeu = new boolean [(largeur)*(longueur)];
		tableDuJeuNext = new boolean [(largeur)*(longueur)];
	}

	public int getLargeur(){
		return largeur;
	}
	public int getLongueur(){
		return longueur;
	}
	
	public int getWidth()
	{
		return largeur;
	}

	public int getHeight()
	{
		return longueur;
	}
	
	public boolean getCell( int x, int y ){
		return tableDuJeu[x*largeur+y];
	}
	
	
	public void initRandom(){
		
		for (int i=0;i<largeur;++i){
			for (int j=0;j<longueur;++j){
				tableDuJeu[i*largeur+j] = false;
				tableDuJeuNext[i*largeur+j] = false;
			}
		}
			
		for (int i=1;i<largeur-1;++i){
			for (int j=1;j<longueur-1;++j){
				Random rand = new Random();
				boolean vivante = rand.nextBoolean();
				tableDuJeu[i*largeur+j] = vivante;
			}
		}
	}
	
	
	public void initPasRandom(int[][] tableau){
		
		for (int i=0;i<largeur;++i){
			for (int j=0;j<longueur;++j){
				tableDuJeu[i*largeur+j] = false;
				tableDuJeuNext[i*largeur+j] = false;
			}
		}
		for (int i=0;i<tableau.length;++i){
			for (int j=0;j<2;++j){
				int k = tableau[i][0];
				int l = tableau[i][1];
				tableDuJeu[k*largeur+l] = true;
			}
		}
		
//		tableDuJeu[5*largeur+4] = true;	
//		tableDuJeu[2*largeur+2] = true;
//		tableDuJeu[3*largeur+2] = true;
//		tableDuJeu[2*largeur+3] = true;
//		tableDuJeu[3*largeur+3] = true;
//		tableDuJeu[3*largeur+4] = true;
	}
	
	
	public void afficher(){
		for (int p=0; p<getLargeur();p++){
			System.out.print("---");
		}
		System.out.print("\n");
		for (int i=1;i<largeur-1;++i){
			System.out.println();
			for (int j=1;j<longueur-1;++j){
				if (tableDuJeu[i*largeur+j]){
					System.out.print(" X("+i+","+j+")");
//					System.out.print(" X ");
				}else{
					System.out.print("  ("+i+","+j+")");
//					System.out.print("   ");
				}
			}
		}
		System.out.println();
		for (int p=0; p<getLargeur();p++){
			System.out.print("---");
		}
	}
	
	public void evolve(){
		for (int i=1;i<largeur-1;++i){
			for (int j=1;j<longueur-1;++j){
				// cellule vivante
				if (tableDuJeu[i*largeur+j]){
//					System.out.println("Cellule vivante");
//					System.out.println("i"+i+" j"+j+" dans evoluer ");
					int voisinesVivantes = calculerVoisines(i, j);
					if ((voisinesVivantes-1) == 2 || (voisinesVivantes-1) == 3){
						tableDuJeuNext[i*largeur+j] = true;
					}
				// cellule morte
				} else {
//					System.out.println("Cellule morte");
//					System.out.println("i"+i+" j"+j+" dans evoluer ");
					int voisinesVivantes = calculerVoisines(i, j);
//					System.out.println("voisinesVivantes " + voisinesVivantes);
					if (voisinesVivantes == 3){
						tableDuJeuNext[i*largeur+j] = true;
					}
				}
			}
		}
		// recopie du tableau
		for (int i=0;i<largeur;++i){
			for (int j=0;j<longueur-1;++j){
				tableDuJeu[i*largeur+j]=tableDuJeuNext[i*largeur+j];
			}
		}
		// reinitialise le tableu Next
		for (int i=0;i<largeur;++i){
			for (int j=0;j<longueur;++j){
				tableDuJeuNext[i*largeur+j] = false;
			}
		}
	}
	
	private int calculerVoisines(int maLargeur, int maLongueur){
		int voisinesVivantes = 0;
		for (int i=maLargeur-1;i<=maLargeur+1;++i){
			for (int j=maLongueur-1;j<=maLongueur+1;++j){
//				System.out.println("i"+i+" j"+j+" dans calculerVoisine ");
				if (tableDuJeu[i*largeur+j]){
					voisinesVivantes +=1;
				}
			}
		}
//		System.out.println("voisinesVivantes "+voisinesVivantes+" dans calculerVoisine ");
		return voisinesVivantes ;
		
	}		
}
