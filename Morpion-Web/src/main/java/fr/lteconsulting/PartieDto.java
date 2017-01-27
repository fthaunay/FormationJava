package fr.lteconsulting;

// DTO veut dire Data Transfer Object et désigne des objets 
// dont le rôle est de transporter des données d’un endroit à un autre

// les objets serviront à être convertis en JSON pour représenter l’état d’une partie.
public class PartieDto {
	
	private boolean tour;
	// sera true si c’est au joueur qui a demandé l’état de la partie de jouer.

	private Character[][] plateau;
	// contiendra la représentation du plateau 
	//avec le caractère de la pièce s’il y en a, et null sinon.
	
	private int idJoueurCourant;

	private int idJoueurGagnant;
	
	public PartieDto(){}
	
	public PartieDto(int hauteur, int largeur){
		plateau = new Character[hauteur][largeur];
	}

	public boolean isTour() {
		return tour;
	}
	
	public void setTour(boolean tour) {
		this.tour = tour;
	}

	public void setPlateau(Character[][] plateau) {
		this.plateau = plateau;
	}

	public Character[][] getPlateau() {
		return plateau;
	}

	public int getIdJoueurCourant() {
		return idJoueurCourant;
	}

	public void setIdJoueurCourant(int idJoueurCourant) {
		this.idJoueurCourant = idJoueurCourant;
	}

	public int getIdJoueurGagnant() {
		return idJoueurGagnant;
	}

	public void setIdJoueurGagnant(int idJoueurGagnant) {
		this.idJoueurGagnant = idJoueurGagnant;
	}
}
