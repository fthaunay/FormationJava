<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<main> <!-- plateau -->
	<div id="plateau">
		<c:forEach var="j" begin="0" end="${plateau.getHauteur() - 1}">
			<div class="colonne">
				<c:forEach var="i" begin="0" end="${plateau.getLargeur() - 1}">
					<div class="case">
						<c:if test="${plateau.getPiece( i, j ) == null}">
							<c:if
								test="${joueurConnecte.getLogin().equals(partie.joueurCourant().getLogin()) }">
								<form action="jouerCoup" method="post">
									<input type="hidden" name="x" value="${i}" /> <input
										type="hidden" name="y" value="${j}" /> <input type="hidden"
										name="id" value="${partie.getId()}" />
									<button type="submit">
										<div id="bouton"></div>
									</button>

								</form>
							</c:if>
						</c:if>
						<c:if test="${plateau.getPiece( i, j ) != null}">
							<c:out value="${plateau.getPiece( i, j ).getDisplayChar()}"></c:out>
						</c:if>

						<br />
					</div>
				</c:forEach>
			</div>
		</c:forEach>
	</div>
	</main>

</div>

<footer>
	<c:if test="${partie.joueurCourant()==null}">
		<c:if test="${partie.joueurGagnant!=null}">
		Partie terminee, le joueur ${partie.joueurGagnant} a gagné
		</c:if>
		<c:if test="${partie.joueurGagnant==null}">
		Partie terminee, match ex aequo
		</c:if>
	</c:if>
	<c:if test="${partie.joueurCourant()!=null}">
			C'est au ${partie.joueurCourant().getLogin()} de jouer
			 Vous etes le ${joueurConnecte.getLogin()}
		</c:if>
</footer>


