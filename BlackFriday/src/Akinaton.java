
public class Akinaton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Pensez à un nombre entre 0 et 100");
		int minIntervalle = 0;
		int maxIntervalle = 100;
		boolean trouve = false;
		String reponse;
		
		while (!trouve){
			int prochainEssai = (maxIntervalle + minIntervalle)/2;
			reponse = Saisie.saisie( "Est-il strictement supérieur à " +prochainEssai+", oui = 'o' ou nom = 'n'" );

			if(reponse.equals("o")){
				minIntervalle = prochainEssai+1;
			}else if (reponse.equals("n")){
				maxIntervalle = prochainEssai;
			} else {
				continue;
			}
			
//			System.out.println(maxIntervalle+" "+minIntervalle);
			
			if (maxIntervalle == minIntervalle){
				trouve = true;
				System.out.println("Le nombre est"+maxIntervalle);
			}
		}
		
		
		
		
		
	}

}
