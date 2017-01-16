package fr.lteconsulting.jsf;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import fr.lteconsulting.Joueur;
import fr.lteconsulting.doa.JoueurDao;


@ManagedBean
@RequestScoped
public class InscrireBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Joueur joueur;
	private String pseudo;
	private String login;
	private String password;
	private String caractere;
	
	// Injection de notre EJB (Session Bean Stateless)
	@EJB
	private JoueurDao joueurDao;
	
	// Initialisation de l'entité utilisateur
    public InscrireBean() {
        joueur = new Joueur();
    }
	
 // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void inscrire() {
    	boolean inscriptionValide = validerInscription();
    	if (inscriptionValide){
    		
    	}
        joueurDao.creerJoueur(pseudo, login, password, caractere);
        FacesMessage message = new FacesMessage( "Succès de l'inscription !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }
    
    private boolean validerInscription() {
        Timestamp date = new Timestamp( System.currentTimeMillis() );
  //      joueur.setDateInscription( date );
        return false;
    }
	
	

}
