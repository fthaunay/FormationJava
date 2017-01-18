package fr.lteconsulting;

public class BibliothequeAudio {

	public static void main(String[] args) {

		Disque d = new Disque("EFTAHHET6", "La lune");
		d.addChanson(new Chanson("Titre", 34));
		d.addChanson(new Chanson("Titre2", 34));
		d.addChanson(new Chanson("Titre3", 42));

		Bibliotheque b = new Bibliotheque();
		b.ajouterDisque(d);
//		b.afficher();
		
		d = new Disque("trtT6", "Les etoiles");
		d.addChanson(new Chanson("Tgrre", 37));
		b.ajouterDisque(d);
		
		d = new Disque("trthrT6", "Le Soleil");
		d.addChanson(new Chanson("Tit8re", 32));
		d.addChanson(new Chanson("Ti8re", 38));
		d.addChanson(new Chanson("Ti83", 842));
		b.ajouterDisque(d);

		Generateur g = new Generateur();
		for (int i=0;i<10;++i){
			d = g.genererDisque();
			b.ajouterDisque(d);	
		}	
		
		
		b.afficher();
		
//		Utilisateur u = new Utilisateur(b);
//		u.executer();
	}
	
	
	
}


