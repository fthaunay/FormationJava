package fr.lteconsulting;
import java.util.Random;
import java.util.UUID;

public class Generateur {
	
	private String listeMots [] = {"L'origine", "de", "la", "mythologie", "grecque",
	      "La", "mythologie", "grecque", "serait", "apparue", "vers", "3000", 
	      "avant", "J-C", "sur", "l'�le", "de", "la", "mer", "Eg�e", "o�", 
	      "le", "peuple", "de", "Cr�te", "s'est", "install�", "Cette", "civilisation",
	      "croyait", "que", "tous", "les", "objets", "de", "la", "nature", "poss�daient",
	      "des", "esprits", "voir", "m�me", "des", "pouvoirs", "magiques", "Avec", "le", 
	      "temps", "ces", "croyances", "ont", "constitu�", "les", "l�gendes", "alimentant",
	      "la", "mythologie", "grecque", "dans", "laquelle", "les", "objets", "ont", "laiss�",
	      "la", "place", "�", "des", "dieux", "�", "apparence", "humaine", "La", "mythologie",
	      "grecque", "dans", "la", "litt�rature", "Les", "auteurs", "de", "la", "Gr�ce", "Antique",
	      "m�lent", "histoires", "et", "mythologie", "Certains", "textes", "comme", "l'Iliade",
	      "et", "l'Odyss�e", "sont", "consid�r�s", "comme", "historique", "mais", "d'autres",
	      "r�cits", "ont", "�t�", "d�form�s", "apportant", "une", "part", "d'invention", "d'intrigue",
	      "et", "de", "myst�re", "Ces", "d�formations", "nous", "fond", "perdre", "tout", "rep�re",
	      "et", "complexifie", "la", "g�n�alogie", "Dans", "les", "diff�rentes", "formes", "de", "la",
	      "mythologie", "grecque", "nous", "observons", "m�me", "des", "textes", "contradictoires",
	      "Cette", "complexit�", "est", "tr�s", "certainement", "due", "�", "la", "multiplicit�",
	      "des", "influences", "que", "ce", "soit", "babyloniennes", "ach�ennes", "minoennes",
	      "ou", "autochtones", "Nous", "allons", "nous", "int�resser", "aux", "dieux", "de",
	      "la", "Gr�ce", "antique", "en", "vivant", "leur", "�pop�e", "et", "en", "essayant",
	      "de", "percer", "le", "myst�re", "de", "la", "mythologie", "dont", "ils", "appartiennent",
	      "Les", "principaux", "Dieux", "Grecs", "du", "canon", "Olympien", "La", "tradition", "compte",
	      "douze", "divinit�s"};

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

