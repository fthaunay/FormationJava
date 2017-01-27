package fr.lteconsulting.doa;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;


@Stateless
public class PartieDao {
	
	/**
	 * 
	 * 
	 * Dans la relation @ManyToMany Partie/Joueur
	 * La partie est propriétaire, donc les persist 
	 * doivent être faits du côté Partie
	 *
	 */
	
	@PersistenceContext(unitName = "Morpion")
	private EntityManager em;
	
	public Partie creerPartie(String name, int taille, Joueur joueurConnecte) {
		Partie p = new Partie(name, taille);
		Joueur j = em.find(Joueur.class, joueurConnecte.getId());
		p.addJoueur(j);
		actualiserDate(p);
		em.persist(p);
		return p;
	}
	
	public void rejoindrePartie(String id, Joueur joueurConnecte) {
		Partie p = findById(id);
		Joueur j = em.find(Joueur.class, joueurConnecte.getId());
		p.addJoueur(j);
		actualiserDate(p);
		em.merge(p);
	}
	
	public void removePartie(int id) {
		Partie p = em.find(Partie.class, id);
		em.remove(p);
	}
	
	public List<Partie> getParties() {
		TypedQuery<Partie> query = em.createQuery("from Partie", Partie.class);
		List<Partie> result = query.getResultList();
		return result;
	}
	
	public Partie findById(String id) {
		try {
			TypedQuery<Partie> query = em.createQuery(
					"from Partie p where p.id=:id", Partie.class);

			query.setParameter("id", id);
			Partie p = query.getSingleResult();
			return p;
		} catch (javax.persistence.NoResultException e) {
			e.printStackTrace();
			return null;
		}		
	}
	
	public List<Joueur> getJoueursPartie(String id) {
		Partie partie = findById(id);
		List<Joueur> joueursPartie = partie.getJoueurs();
		return joueursPartie;
	}

	public void updatePartie(Partie p) {
			actualiserDate(p);
			em.merge(p);
	}
	
	public Joueur joueurGagnant(String idPartie, Joueur joueurConnecte, int x, int y){
		Partie p = findById(idPartie);
		Joueur j = em.find(Joueur.class, joueurConnecte.getId());
		
		Joueur joueurGagnant = p.getGagnant(x, y, j);
		Joueur joueurGagnant2 = p.getJoueurGagnant();
		System.out.println("dans parrtie dao");
		System.out.println(joueurGagnant);
		System.out.println(joueurGagnant2);
		actualiserDate(p);
		em.merge(p);
		return joueurGagnant;
	}
	
	private static void actualiserDate(Partie p){
		Date dateModification = new java.util.Date();
		p.setDateModification(dateModification);
	}
	
	public void deleteOldEndedParties(){
		System.out.println("dans deletemachin");
		Calendar calendar = new GregorianCalendar();
		// retire 1 jour à la date courante
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		
		try {
			 em.createQuery(
				"delete from Partie p where p.joueurGagnant IS NOT null "
				+ "and p.creationDate < :dateEffacement ")
			 .setParameter("dateEffacement", calendar)
			 .executeUpdate();
			
		} catch (javax.persistence.NoResultException e) {
			e.printStackTrace();
		}		
	}
	
}
