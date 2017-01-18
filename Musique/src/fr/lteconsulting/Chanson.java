package fr.lteconsulting;

public class Chanson {
	private String nom;
	private int dureeEnSecondes;

	public Chanson(String nom, int duree) {
		this.nom = nom;
		dureeEnSecondes = duree;
	}

	public Chanson() {
		nom = "";
		dureeEnSecondes = 0;
	}

	public int getDureeEnSecondes() {
		return dureeEnSecondes;
	}

	public void setDureeEnSecondes(int duree) {
		dureeEnSecondes = duree;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String mot) {
		nom = mot;
	}

	public void afficher() {
		System.out.println("La chanson " + getNom() + " dure " + getDureeEnSecondes() + " secondes.");
	}
}

