<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<header>

	<!-- le logo de l’application
un rappel de l’utilisateur connecté
un lien vers la page d’accueil
un lien pour se déconnecter.-->

	<div id="titre">
		<h1>${pageTitle}</h1>

		<div id="bouton2">
			<c:if test="${joueurConnecte != null}"> 
				Bienvenue ${joueurConnecte.getLogin()}
			</c:if>
		</div>
	</div>

	<div class="entete">
		<div id="bouton2">
			<a href="index.html"> Accueil </a>
		</div>
		<div id="bouton2">
			<c:if test="${joueurConnecte != null}">
				<a href="logout"> Déconnexion </a>
			</c:if>
		</div>
		<div id="bouton2">
			<c:if test="${joueurConnecte != null}">
				<a href="majCompte.html"> Mon Compte </a>
			</c:if>
		</div>
	</div>
	<div id="image">
		<img src="../grattageMorpion.jpg"></img> <img src="../grattageMorpion.PNG"></img>
		<img
			src="https://poilsagratter.files.wordpress.com/2013/08/grattage_morpion.jpg?w=177&h=180"></img>
	</div>
</header>