
package fr.lteconsulting;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
	    uniqueConstraints={
	        @UniqueConstraint(name="login", columnNames={"login"})
	    })
public class Joueur
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	
	private String pseudo;
	private String login;
	private String password;
	private String caractere;
	
	private int partiesJouees;
	private int partiesGagnees;
	
	@ManyToMany(mappedBy="joueurs", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Partie> parties;

	//**************************************
		// Constructeurs	

	public Joueur( String pseudo, String login, String password, String caractere)
	{
		super();
		this.pseudo = pseudo;
		this.login = login ;
		this.password = password;
		this.caractere = caractere;
	}
	
	public Joueur( String login, String password)
	{
		this("xxxxx", login, password, "O" );
	}
	
	public Joueur( )
	{
		super();
	}
	
	//**************************************	
		// Getters et Setters
	
	public Integer getId() {
		return id;
	}
	
	public String getLogin()
	{
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCaractere() {
		return caractere;
	}
	public void setCaractere(String caractere) {
		this.caractere = caractere;
	}
	
	public List<Partie> getParties() {
		return parties;
	}

	public void setParties(List<Partie> parties) {
		this.parties = parties;
	}

	public int getPartiesJouees()
	{
		return partiesJouees;
	}
	public void setPartiesJouees(int partiesJouees) {
		this.partiesJouees = partiesJouees;
	}

	public int getPartiesGagnees()
	{
		return partiesGagnees;
	}
	public void setPartiesGagnees(int partiesGagnees) {
		this.partiesGagnees = partiesGagnees;
	}

	//**************************************	
		// Methodes publiques
	
	public String toString(){
		return getPseudo();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public void addPartieJouee()
	{
		partiesJouees++;
	}
	
	public void addPartieGagnee()
	{
		partiesGagnees++;
	}
	
	
}

