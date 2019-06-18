<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%--     pageEncoding="ISO-8859-1"%> --%>
    
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Management System</title>
<link rel="stylesheet" href="w3.css">

</head>
<body>
test1234<br>
<!--  ${listOfBooks} -->

<table border="1">
<c:forEach items="${listOfBooks}" var="temp">
<tr><td>${temp.id}</td><td>${temp.title}</td><td>${temp.author}</td>
<td><img src="${urlOfImg}/${temp.imageName}"></td></tr>
</c:forEach>

</table>
	<%@ include file="index.jsp"%>
</body>
</html>