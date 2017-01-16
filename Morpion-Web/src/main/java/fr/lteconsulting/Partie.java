package fr.lteconsulting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Partie")
public class Partie {
	
//**************************************	
// Les variables 	
	
	@Id
	@GeneratedValue( generator = "system-uuid" )
	@GenericGenerator( name = "system-uuid", strategy = "uuid" )
	private String id;
	
	private String name;
	
	@Lob
	@Column(length=50)
	private Plateau plateau;
	
	/**
	 * Dans la relation @ManyToMany Partie/Joueur
	 * La partie est propriétaire, donc les persist 
	 * doivent être faits du côté Partie
	 */
	
	@ManyToMany(fetch=FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Joueur> joueurs; 
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Joueur joueurGagnant;
	
	@Column
	private int idJoueurGagnant;
	
	private Date creationDate;
	
	@Column
	private java.util.Date dateModification;
	
		
	
	//**************************************
	// Constructeurs		
	
	public Partie(String name, int taille){
		this.name = name;
		joueurs = new ArrayList<Joueur>();
		plateau = new Plateau(taille,taille);
		dateModification = new java.util.Date();
	}	
	
	public Partie( )
	{
		super();
	}
	
	//**************************************	
	// Getters et Setters
	
	public String getId(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Plateau getPlateau(){
		return plateau;
	}
	public void setPlateau(Plateau plateau) {
		this.plateau = plateau;
	}
	
	public  List<Joueur> getJoueurs(){
		return joueurs;
	}
	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}
	
	public Joueur getJoueurGagnant(){
		return joueurGagnant;
	}
	
	public int getIdJoueurGagnant() {
		if (joueurGagnant == null){
			idJoueurGagnant = 0;
		} else{
			idJoueurGagnant = joueurGagnant.getId();
		}
		return idJoueurGagnant;
	}
	public void setIdJoueurGagnant(int idJoueurGagnant) {
		this.idJoueurGagnant = idJoueurGagnant;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	public java.util.Date getDateModification() {
		return dateModification;
	}
	public void setDateModification(java.util.Date dateModification) {
		this.dateModification = dateModification;
	}

	//**************************************	
		// Methodes publiques
		
	public void addJoueur(Joueur joueur){
		joueurs.add(joueur);
	}
	
	public Joueur joueurCourant(){
		int nbCasesPleines = plateau.nbCases() - plateau.casesVides();
		
		Joueur joueurCourant = getJoueurs().get(nbCasesPleines % 2);
		if (joueurGagnant != null){
			joueurCourant = null;
		}
		return joueurCourant;
	}
	
	public Joueur joueurPrecedent(){
		int nbCasesPleines = plateau.nbCases() - plateau.casesVides();
		Joueur joueurPrecedent = getJoueurs().get((nbCasesPleines+1) % 2);
		return joueurPrecedent;
	}
	
	public String toString(){
		String nom = "Partie "+name;
		return nom;
	}
	
	public boolean peutRejoindre(Joueur joueur){
		return (joueurs.size()==1 && !joueur.getLogin().equals(getJoueurs().get(0).getLogin()));
	}
	
	public boolean peutContinuer(Joueur joueur){
		// La partie peut être continuée si elle n'est pas terminée ...
		if(getJoueurGagnant()!=null){
			return false;
		}
		// ... par un joueur inscrit.
		for(int i=0; i<joueurs.size();++i){
			if (joueur.getLogin().equals(getJoueurs().get(i).getLogin())){
				return true;
			}
		}
		return false;
	}
	
	public boolean peutObserver(Joueur joueur){
		for(int i=0; i<joueurs.size();++i){
			if (joueur.getLogin().equals(getJoueurs().get(i).getLogin())){
				return false;
			}
		}
		return true;
	}
	
	//TODO Les règles du morpion pourraient être exportées dans les outils
	// Par exemple, on rajouterait un attribut de type "ReglesJeuPlateau " à la partie 
	// (qui pourrait être une classe abstraite ou une interface, obigeant par
	// exemple de trouver le joueurGagnant)
	// et une classe ReglesMorpion
	
	public Joueur getGagnant(int x, int y, Joueur joueur) {
		// Hypotèse de départ : si on cherche le gagnant au tour courant,
		// c'est qu'il n'y en avait pas pas au tour precedent;

		// test pour le joueur courant
		
			// reussit une horizontale
			if (valideUneLigne(joueur, 0, y, 1, 0)) {
				joueurGagnant = joueur;
				idJoueurGagnant = joueur.getId();
			}
			// reussit une verticale
			if (valideUneLigne(joueur, x, 0, 0, 1)) {
				joueurGagnant = joueur;
				idJoueurGagnant = joueur.getId();
			}
			// reussit la diagonale 1
			if (valideUneLigne(joueur, 0, 0, 1, 1)) {
				joueurGagnant = joueur;
				idJoueurGagnant = joueur.getId();
			}
			// reussit la diagonale 2
			if (valideUneLigne(joueur, 0, plateau.getHauteur() - 1, 1, -1)) {
				joueurGagnant = joueur;
				idJoueurGagnant = joueur.getId();
			}
		return joueurGagnant;
	}

	//**************************************	
		// Methodes protected
			
	@PrePersist
	protected void initialiserDateCreation(){
		creationDate = new Date();
	}
	
	//**************************************	
			// Methodes private

	private boolean valideUneLigne(Joueur joueur, int x, int y, int i, int j) {
		// x, y = position de départ
		// i,j = vecteur
		int identiques = 0;
		while (x < plateau.getLargeur() && y < plateau.getHauteur() && !plateau.caseVide(x, y)
				&& identiques < plateau.getHauteur()) {
			if (plateau.getPiece(x, y).getDisplayChar() != joueur.getCaractere().charAt(0)) {
				return false;
			}
			x += i;
			y += j;
			identiques++;
		}
		if (identiques == plateau.getHauteur())
			return true;
		return false;
	}
}
