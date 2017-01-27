package fr.lteconsulting.doa;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;

@Stateless
public class JoueurDao {

	@EJB
	private PartieDao partieDao;

	/**
	 * 
	 * 
	 * Dans la relation @ManyToMany Partie/Joueur La partie est propriétaire,
	 * donc les persist doivent être faits du côté Partie
	 *
	 */

	@PersistenceContext(unitName = "Morpion")
	private EntityManager em;

	public Joueur creerJoueur(String pseudo, String login, String password,
			String caractere) {
		Joueur j = new Joueur(pseudo, login, password, caractere);
		em.persist(j);

		return j;
	}

	public Joueur modifierJoueur(String ancienLogin, String pseudo,
			String login, String password, String caractere) {

		Joueur j = findByLogin(ancienLogin);
		j.setPseudo(pseudo);
		j.setLogin(login);
		j.setCaractere(caractere);
		em.merge(j);
		return j;
	}

	public void removeJoueur(int id) {
		Joueur j = em.find(Joueur.class, id);
		em.remove(j);
	}

	public List<Joueur> getJoueurs() {

		TypedQuery<Joueur> query = em.createQuery("from Joueur", Joueur.class);
		List<Joueur> result = query.getResultList();
		return result;
	}

	public Joueur findByLogin(String login) {
		try {
			TypedQuery<Joueur> query = em.createQuery(
					"from Joueur j where j.login=:login", Joueur.class);

			query.setParameter("login", login);
			Joueur j = query.getSingleResult();
			return j;
		} catch (javax.persistence.NoResultException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void updateScore(Joueur joueur, Partie partie) {
		Joueur j = findByLogin(joueur.getLogin());
		Partie p = partieDao.findById(partie.getId());
		j.addPartieJouee();
		if (p.getJoueurGagnant() != null) {
			if (j.getLogin().equals(p.getJoueurGagnant().getLogin())) {
				j.addPartieGagnee();
			}
		}
		em.merge(j);
		em.merge(p);
	}

}
