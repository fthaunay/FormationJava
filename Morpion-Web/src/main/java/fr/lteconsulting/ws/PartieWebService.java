package fr.lteconsulting.ws;

import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import fr.lteconsulting.Coup;
import fr.lteconsulting.DonneesScope;
import fr.lteconsulting.Joueur;
import fr.lteconsulting.Partie;
import fr.lteconsulting.PartieDto;
import fr.lteconsulting.Piece;
import fr.lteconsulting.Plateau;
import fr.lteconsulting.doa.JoueurDao;
import fr.lteconsulting.doa.PartieDao;

// Cette classe recevra toutes les requêtes dont l’url commence par 'api/parties'.
@Path("parties")
public class PartieWebService {

	@EJB
	private JoueurDao joueurDao;

	@EJB
	private PartieDao partieDao;

	@POST
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void jouerCoup(Coup coup, @PathParam("id") String idPartie,
			@Context HttpServletRequest request) {

		int x = coup.getX();
		int y = coup.getY();

		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
		Partie p = partieDao.findById(idPartie);

		String caractere = joueurConnecte.getCaractere();
		p.getPlateau().placerPiece(new Piece(caractere.charAt(0)), x, y);

		partieDao.updatePartie(p);

		// Teste si la partie est terminée, et si oui, incrémente les scores
		// des joueurs

		// Teste si la partie est terminée (plateau plein ou joueur gagnant)
		Joueur joueurGagnant = partieDao.joueurGagnant(idPartie, joueurConnecte,
				x, y);

		if (p.getPlateau().casesVides() == 0 || joueurGagnant != null) {

			for (Joueur joueur : p.getJoueurs()) {
				joueurDao.updateScore(joueur, p);
			}
		}
	}

	@SuppressWarnings("null")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	// permet de récupérer la représentation JSON d’une partie.
	// L’url contient l’identifiant de la partie.

	public PartieDto getPartie(@PathParam("id") String id,
			@Context HttpServletRequest request) {
		System.out.println("dans getPartie");
		Partie partie = partieDao.findById(id);

		// récupérer le joueur connecté.
		Joueur joueurConnecte = DonneesScope.getJoueurSession(request);
		if (joueurConnecte == null) {
			return null;
		}

		PartieDto partieDto = new PartieDto(partie.getPlateau().getHauteur(),
				partie.getPlateau().getLargeur());

		if (partie.joueurCourant() != null) {
			partieDto.setTour(
					partie.joueurCourant().getId() == joueurConnecte.getId());
		} else {
			partieDto.setTour(false);
		}

		Character[][] plateauDto = partieDto.getPlateau();

		for (int j = 0; j < partie.getPlateau().getHauteur(); j++) {
			for (int i = 0; i < partie.getPlateau().getLargeur(); i++) {
				if (partie.getPlateau().getPiece(i, j) != null) {
					plateauDto[j][i] = partie.getPlateau().getPiece(i, j)
							.getDisplayChar();
				}
			}
		}
		partieDto.setPlateau(plateauDto);
		System.out.println("plateauDTO " + plateauDto);

		if (partie.joueurCourant() != null) {
			partieDto.setIdJoueurCourant(partie.joueurCourant().getId());
		} else {
			partieDto.setIdJoueurCourant(0);
		}

		if (partie.getJoueurGagnant() != null) {
			partieDto.setIdJoueurGagnant(partie.getJoueurGagnant().getId());
		} else {
			partieDto.setIdJoueurGagnant(0);
		}
		return partieDto;
	}

}
