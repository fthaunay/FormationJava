<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Plateau en APPLICATION : ${plateauApplication}, largeur: ${plateauApplication.getLargeur()} <br/>
Plateau en SESSION : ${plateauSession}, largeur: ${plateauSession.largeur} <br/>
Plateau en REQUEST : ${plateauRequest}, largeur: ${plateauRequest.getLargeur()} <br/>
</body>
</html>