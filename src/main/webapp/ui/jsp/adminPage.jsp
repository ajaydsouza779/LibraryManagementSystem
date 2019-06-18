<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<meta charset="ISO-8859-1">
<link rel="stylesheet" href="w3.css">
<style>

		body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
		.w3-bar-block .w3-bar-item {padding:20px}
		.menu {display: none}

</style>
<body>

		<div class="w3-top" style="background-color: greenyellow;">
	       
	      <div class="w3-button  w3-left" onclick="w3_open()">☰</div>
	      <div class="w3-center " style="font-size: 21pt;">Library Management</div>
			<%@ include file="headerLibrarian.jsp"%>
		</div>
	
	<div class="container w3-bar" style="margin-top: 50px;">
		<%-- <c:if test="${ page == 'registerLibrarian'}"> --%>
			<a href="/admin" class="w3-btn w3-button w3-light-green "> <h1>Home</h1></a>
		<%-- </c:if> --%>
		<a href="/registerLibrarian" class="w3-btn w3-button w3-light-green "> <h1>Register a librarian</h1></a>
		<a href="/addBook" class="w3-btn w3-button w3-light-green "> <h1>Add book</h1></a>
	</div>
	
	
		
	<c:if test="${ page == 'registerLibrarian'}">
			<%@ include file="registerLibrarian.jsp" %>
	</c:if>
		<c:if test="${ page == 'addBook'}">
			<%@ include file="addBook.jsp" %>
	</c:if>
</body>
</html>