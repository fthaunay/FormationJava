package fr.lteconsulting;
import java.util.Random;
import java.util.UUID;

public class Generateur {
	
	private String listeMots [] = {"L'origine", "de", "la", "mythologie", "grecque",
	      "La", "mythologie", "grecque", "serait", "apparue", "vers", "3000", 
	      "avant", "J-C", "sur", "l'île", "de", "la", "mer", "Egée", "où", 
	      "le", "peuple", "de", "Crète", "s'est", "installé", "Cette", "civilisation",
	      "croyait", "que", "tous", "les", "objets", "de", "la", "nature", "possédaient",
	      "des", "esprits", "voir", "même", "des", "pouvoirs", "magiques", "Avec", "le", 
	      "temps", "ces", "croyances", "ont", "constitué", "les", "légendes", "alimentant",
	      "la", "mythologie", "grecque", "dans", "laquelle", "les", "objets", "ont", "laissé",
	      "la", "place", "à", "des", "dieux", "à", "apparence", "humaine", "La", "mythologie",
	      "grecque", "dans", "la", "littérature", "Les", "auteurs", "de", "la", "Grèce", "Antique",
	      "mêlent", "histoires", "et", "mythologie", "Certains", "textes", "comme", "l'Iliade",
	      "et", "l'Odyssée", "sont", "considérés", "comme", "historique", "mais", "d'autres",
	      "récits", "ont", "été", "déformés", "apportant", "une", "part", "d'invention", "d'intrigue",
	      "et", "de", "mystère", "Ces", "déformations", "nous", "fond", "perdre", "tout", "repère",
	      "et", "complexifie", "la", "généalogie", "Dans", "les", "différentes", "formes", "de", "la",
	      "mythologie", "grecque", "nous", "observons", "même", "des", "textes", "contradictoires",
	      "Cette", "complexité", "est", "très", "certainement", "due", "à", "la", "multiplicité",
	      "des", "influences", "que", "ce", "soit", "babyloniennes", "achéennes", "minoennes",
	      "ou", "autochtones", "Nous", "allons", "nous", "intéresser", "aux", "dieux", "de",
	      "la", "Grèce", "antique", "en", "vivant", "leur", "épopée", "et", "en", "essayant",
	      "de", "percer", "le", "mystère", "de", "la", "mythologie", "dont", "ils", "appartiennent",
	      "Les", "principaux", "Dieux", "Grecs", "du", "canon", "Olympien", "La", "tradition", "compte",
	      "douze", "divinités"};

	public String genererMot(){
		Random r = new Random();
		return listeMots[r.nextInt(listeMots.length)];
	}
	
	public String genererPhrase(){
		String phrase="";
		Random r = new Random();
		String mot = genererMot();
		String maj =  mot.substring(0,1);
		maj = maj.toUpperCase();
		String min = mot.substring(1,mot.length());
		phrase += maj;
		phrase += min;
		int nbMots = r.nextInt(10);
		for (int i=0; i<nbMots; ++i){
			phrase += " ";
			phrase += genererMot();
		}
		return phrase;
	}
	
	public String genererCodeBarre(){
		return UUID.randomUUID().toString();
	}	
	
	public Disque genererDisque(){
		String nom = genererPhrase();
		String codeBarre = genererCodeBarre();
		Disque d = new Disque(codeBarre,  nom);
		Random r = new Random();
		int nbChansons = r.nextInt(20);
		for (int i=0; i<nbChansons;++i){
			String nomChanson = genererPhrase();
			Random s = new Random();
			int duree = s.nextInt(15);
			Chanson c = new Chanson(nomChanson, duree+1);
			d.addChanson(c);
		}
		return d;
	}
}

