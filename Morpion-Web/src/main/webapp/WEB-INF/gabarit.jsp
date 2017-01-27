<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<c:if test="${pageReload}"> 
		<meta http-equiv="refresh" content="5">
	</c:if>

	<title>${pageTitle}</title> 

 	<link rel="stylesheet" href="entete.css">  
 	<link rel="stylesheet" href="${pageContentCss}"> 
 <!-- 	<link rel="stylesheet" href="milligram.min.css">  -->
 	
 	  
</head>

<body>
	
  	<jsp:include page="entete.jsp" />   

	<c:if test="${pageContentJsp!=null}">
		<jsp:include page="${pageContentJsp}" /> 
	</c:if>
</body>

</html>