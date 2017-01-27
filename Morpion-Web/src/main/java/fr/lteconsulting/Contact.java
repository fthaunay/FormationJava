package fr.lteconsulting;

public class Contact {
	
	private int id;
	private String nom;
	private String prenom;
	private String telephone;

	public Contact(int id, String nom, String prenom, String telephone) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
	}
	public Contact(){}
	
	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getTelephone() {
		return telephone;
	}
	
	public void setId(int id){
		this.id = id;
	}
}
