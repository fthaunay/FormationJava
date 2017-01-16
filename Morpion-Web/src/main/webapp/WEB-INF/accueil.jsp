<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id=lien>
	<a href="scores.html"> Score de tous les joueurs </a>
</div>

<div id=lien>
	<form action="creationPartie.html" method='post'>
		<button type="submit">Nouvelle partie</button>
	</form>
</div>
<div id=tableau>
	<!-- On affichera un tableau récapitulatif de toutes les parties 
	avec un bouton pour chaque action possible (rejoindre ou continuer) -->

	<!-- Il faudra envoyer la liste des partie -->

	<c:if test="${parties.size() > 0}">

		<table border="1">
			<tr>
				<th>NOM</th>
				<th>Liste des Joueurs</th>
				<th>C'est au tour de</th>
				<th>Taille du plateau</th>
				<th colspan="3">Actions</th>
			</tr>

			<c:forEach var="j" begin="0" end="${parties.size() - 1}">
				<tr>
					<!-- Affiche le nom de la partie -->
					<td>${parties.get(j).toString()}${parties.size()}</td>

					<!--  Affiche la liste des joueurs -->
					<td><c:forEach items="${parties.get(j).getJoueurs()}"
							var="joueur">
							<c:out value="${joueur}" />
						</c:forEach></td>

					<!--  Affiche le joueur qui doit jouer -->
					<!--  où le message 'Partie terminée' -->
					<td><c:if test="${parties.get(j).joueurCourant()!=null}">
							<c:out value="${parties.get(j).joueurCourant()}" />
						</c:if> <c:if test="${parties.get(j).joueurGagnant!=null}">
						Partie terminée : le joueur <c:out
								value="${parties.get(j).joueurGagnant}" /> a gagné
					</c:if></td>
					<!-- Affiche la taille du plateau -->
					<td><c:out
							value="${parties.get(j).getPlateau().getHauteur()*
				parties.get(j).getPlateau().getLargeur()}" />
					</td>

					<td>
						<!-- Si la partie peut être continuée, afficher un bouton --> <c:if
							test="${parties.get(j).peutContinuer(joueurConnecte)}">
							<a href="partie.html?id=${parties.get(j).getId()}"> Continuer
							</a>
						</c:if>
					</td>

					<td>
						<!-- Si la partie peut être rejointe, afficher un bouton --> <c:if
							test="${parties.get(j).peutRejoindre(joueurConnecte)}">
							<form action="rejoindrePartie" method="post">
								<button type="submit">
									Rejoindre <input type="hidden" name="partie"
										value="${parties.get(j).getId()}" />
								</button>
							</form>
						</c:if>
					</td>

					<td>
					<!-- Si la partie peut être observée, afficher un bouton -->
					<c:if
							test="${parties.get(j).peutObserver(joueurConnecte)}">
							<a href="partie.html?id=${parties.get(j).getId()}"> Observer
							</a>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</div>
