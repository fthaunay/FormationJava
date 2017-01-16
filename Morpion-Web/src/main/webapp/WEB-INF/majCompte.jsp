<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="modifierCompte" method="post">
	Pseudo : <input type="text" name="pseudo" /> <br /> 
		Login : <input type="text" name="login" /> <br /> 
		Mot de passe: <input type="password" name="password" /><br />
		Confirmer Mot de passe: <input type="password" name="confirmPassword" /><br />
		Caractère : <input type="text" name="caractere" /> <br /> 
		<button type="submit">OK</button>
</form>