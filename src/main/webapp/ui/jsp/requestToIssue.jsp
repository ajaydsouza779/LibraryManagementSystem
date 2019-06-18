
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>Library Management System</title>

	<link rel="stylesheet" href="w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
	<style>
		body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
		.w3-bar-block .w3-bar-item {padding:20px}
	</style>
	
	<script>
		// Script to open and close sidebar
		function w3_open() {
		  document.getElementById("mySidebar").style.display = "block";
		}
		 
		function w3_close() {
		  document.getElementById("mySidebar").style.display = "none";
		}
	</script>

</head>
<body>

	 <%@ include file="leftNavigation.jsp"%>
<!-- Top menu -->
	<div class="w3-top" style="background-color: greenyellow;">
	       
	      <div class="w3-button  w3-left" onclick="w3_open()">☰</div>
	      <div class="w3-center " style="font-size: 21pt;">Open Book Requests</div>
		<%@ include file="header.jsp"%>
	</div>
	
	
<div class="w3-container w3-padding-16" style="margin-top: 50px">

<table class="w3-table w3-hoverable w3-table-all">
	
	<tr>
		<th>Book</th>
		<th>Isin</th>
		<th>Category</th>
		<th>Author</th>
		<th>Cancel</th>
	</tr>
	<c:if test="${requestedBooks != null}">
	<c:forEach items="${requestedBooks}" var="book">
	<tr>
		<td>${book.title}</td>
		<td>${book.isin}</td>
		<td>${book.category}</td>
		<td>${book.author}</td>
		<td><a href="${contextPath}/cancelBookRequest?bookId=${book.id}">Cancel</a></td>
	</tr>
	</c:forEach>
	</c:if>
</table>
<%-- 
<hr>
<table class="w3-table w3-hoverable w3-table-all w3-padding">
	<caption>Books Issued</caption>
	<tr>
		<th>Book</th>
		<th>Isin</th>
		<th>Category</th>
		<th>Author</th>
	</tr>
	<c:forEach items="${requestedBooks}" var="book">
	<tr>
		<td>${book.title}</td>
		<td>${book.isin}</td>
		<td>${book.category}</td>
		<td>${book.author}</td>
	</tr>
	</c:forEach>
</table> --%>
</div>

