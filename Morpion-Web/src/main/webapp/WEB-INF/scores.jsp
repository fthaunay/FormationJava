<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<div>
	<table border="1">
		<tr>
			<th>Joueur</th>
			<th>Parties jouées</th>
			<th>Parties gagnées</th>
		</tr>

		<!-- >Envoyer les joueurs de l'application -->

		<c:forEach items="${joueurs}" var="joueur">
			<tr>
				<!-- Afficher le nom de la partie -->
				<td>${joueur.toString()}</td>

				<td>${joueur.getPartiesJouees()}</td>

				<td>${joueur.getPartiesGagnees()}</td>
			</tr>
		</c:forEach>
	</table>
</div>