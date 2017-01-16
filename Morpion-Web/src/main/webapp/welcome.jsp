<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>accueil</title>
</head>
<body>

<% String nomUtilisateur = request.getParameter("nomUtilisateur");  %>
<% String surnomUtilisateur = request.getParameter("surnomUtilisateur");  %>
<% String civilite = request.getParameter("civilite");  %>
<% out.print( "Bonjour "+civilite+" "+nomUtilisateur+" "+surnomUtilisateur); %> <br/>
<% 
if (nomUtilisateur !=null && ! nomUtilisateur.isEmpty()){
	response.addCookie(new Cookie("nom", nomUtilisateur));
}
%>

<h2>Liste des cookies</h2> 
<% 
Cookie[] cookies = request.getCookies();
%>

<ul>
<% if(cookies!=null){
	for (Cookie cookie : cookies){ %>
		<li><%= cookie.getName() %> = <%= cookie.getValue() %> </li>
	<%}
}%>

</ul>

</body>
</html>