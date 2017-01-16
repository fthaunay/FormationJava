<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		Plateau plateau = new Plateau( 3, 3 );
		plateau.placerPiece( new Piece( 'T' ), 2, 1 );
		plateau.placerPiece( new Piece( 'U' ), 1, 1 );
		plateau.placerPiece( new Piece( 'V' ), 0, 1 );
		
		// pour fournir à JSTL l'objet plateau sous le nom "plateau"
		pageContext.setAttribute( "plateau", plateau );
	%>

	<table border="1">
		<c:forEach var="j" begin="0" end="${plateau.getHauteur() - 1}">
			<tr>
				<c:forEach var="i" begin="0" end="${plateau.getLargeur() - 1}">
					<td>
						i: <c:out value="${i}"></c:out><br/>
						j: <c:out value="${j}"></c:out><br/>
						piece: <c:out value="${plateau.getPiece( i, j ).getDisplayChar()}">
						</c:out>
					</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>








	<ul>
		<c:forEach var="i" begin="1" end="10">
			<li><c:out value="${i}"></c:out></li>
		</c:forEach>
	</ul>

</body>
</html>