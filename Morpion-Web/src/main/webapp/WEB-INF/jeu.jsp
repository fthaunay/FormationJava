<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="fr.lteconsulting.Piece"%>
<%@page import="fr.lteconsulting.Plateau"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<style>
* {
	box-sizing: border-box;
}

/* reset CSS ou feuille de style, à voir*/
body {
	position: absolute;
	margin: 0;
	padding: 0;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
	display: flex;
	flex-direction: column;
	flex-wrap: nowrap;
	border: 2px solid black;
}

#div1 {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	height: 100%;
	width: 100%;
	border: 2px solid grey;
	flex-grow: 1;
}

main {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	height: 100%;
	width: 80%;
	align-items: center;
	align-content: center;
	justify-content: center;
	border: 2px solid grey;
	text-align: center;
}

#plateau {
	height: 25em;
	width: 25em;
	display: flex;
	flex-direction: column;
	flex-wrap: nowrap;
	justify-content: space-around;
	align-items: center;
	background-color: black;
	display: flex;
}

.colonne {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	flex-grow: 1;
	height: 100%;
	width: 100%;
	justify-content: space-around;
	align-items: center;
	background-color: limegreen;
}

.case {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	flex-grow: 1;
	height: 80%;
	width: 80%;
	margin-left: 0.5em;
	margin-top: 0.5em;
	margin-right: 0.5em;
	margin-bottom: 0.5em;
	border: 1;
	border-color: blue;
	padding: 1em; background-color : lightgreen;
	background-color: lightgreen;
    line-height:1.3em;
    vertical-align:middle;
}
	
form {
display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	height: 100%;
	width: 100%;
	flex-grow: 1;
}

button{
	height: 100%;
	width: 100%;
	border:0;
	padding:0;
	}

#bouton {
	display: flex;
	flex-direction: row;
	flex-wrap: nowrap;
	flex-grow: 1;
	height: 100%;
	width: 100%;
	background-color: lightgreen;
	font-size: 2em;
}

aside {
	height: 100%;
	width: 20%;
	border: 2px solid grey;
}

.formulaire {
	width: 200px;
	height: 200px;
	background-color: darkgrey;
}

footer {
	height: 20%;
	width: 100%;
	background-color: lightgrey;
}
</style>

</head>

<body>
	<div id="div1">
		<main> <!-- plateau -->
		<div id="plateau">
			<c:forEach var="j" begin="0" end="${plateau.getHauteur() - 1}">
				<div class="colonne">
					<c:forEach var="i" begin="0" end="${plateau.getLargeur() - 1}">
						<div class="case">
							<c:if test="${plateau.getPiece( i, j ) == null}">
								<form action="jeu.html" method="post">
									<input type="hidden" name="x" value="${i}" /> <input
										type="hidden" name="y" value="${j}" />
									<button type="submit">
										<div id="bouton"></div>
									</button>
								</form>
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

		<aside>
			<!-- formulaire -->
			<div class="formulaire">
				<!--		<form action="jeu.jsp" method="post">
					x: <input type="text" name="x" /> <br> y: <input type="text"
						name="y" />
					<button type="submit">jouer</button>
				</form>   -->
			</div>
		</aside>
	</div>

	<footer> 
	   ${message} 
		

	</footer>

</body>



</html>


