package fr.lteconsulting;
import java.util.ArrayList;
import java.util.List;


public class Disque {
	private String codeBarre;
	private String nom;
	private List<Chanson> chansons = new ArrayList<Chanson>();

	public Disque(String codeBarre, String nom) {
		this.codeBarre = codeBarre;
		this.nom = nom;
	}

	public String getCodeBarre() {
		return codeBarre;
	}

	public void setCodeBarre(String codeBarre) {
		this.codeBarre = codeBarre;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void addChanson(Chanson chanson) {
		chansons.add(chanson);
	}

	public void afficher()
	{
		afficher( true );
	}

	public void afficher( boolean avecTitres )
	{
		System.out.println( "DISQUE [" + codeBarre + "] " + nom + ", durée: " + getDuree() );
		if( avecTitres )
		{
			for( Chanson chanson : chansons )
				chanson.afficher();
		}
	}

	public int getDuree() {
		int dureeAlbum = 0;
		for (Chanson chanson : chansons) {
			dureeAlbum += chanson.getDureeEnSecondes();
		}
		return dureeAlbum;
	}

	public String toString() {
		return nom;
	}
}

