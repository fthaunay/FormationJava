<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<div id=tableau>
	<form action="login" method="post">
		Identifiant : <input type="text" name="login" /> <br /> 
		Mot de passe: <input type="password" name="password" /><br />
		<button type="submit">valider</button>
		<a href="creationCompte.html"> Creer un Compte <a/>
	</form>
</div>