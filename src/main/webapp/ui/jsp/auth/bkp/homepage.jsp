
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

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
	
	<!-- Sidebar (hidden by default) -->
	<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
	  <a href="javascript:void(0)" onclick="w3_close()"
	  class="w3-bar-item w3-button">Close Menu</a>
	  <a href="#food" onclick="w3_close()" class="w3-bar-item w3-button">Food</a>
	  <a href="#about" onclick="w3_close()" class="w3-bar-item w3-button">About</a>
	</nav>
	
	<!-- Top menu -->
	<div class="w3-top" style="background-color: greenyellow;">
	  <div class="w3-white w3-xlarge" ><!-- style="max-width:1200px;margin:auto" -->
	    <div class="w3-button w3-padding-16 w3-left" onclick="w3_open()">☰</div>
	     
	      <c:if test="${pageContext.request.userPrincipal.name != null}">
	        <form id="logoutForm" method="POST" action="${contextPath}/logout">
	            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        </form>
	
	        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
	    
	    </c:if>
	     <c:if test="${pageContext.request.userPrincipal.name == null}">
	     Login
	    <%--   <div class="w3-right "><%@ include file="index.jsp"%></div> --%>
	     </c:if>
	    <div class="w3-center w3-padding-16" style="font-size: 21pt;">Library Book Shelf</div>
	  </div>
	</div>
	
<!-- class="container" -->
<!-- ------------------------------------------------- -->	
<div class="w3-container">
<div  class="w3-main w3-padding" style="width: 100%;/*max-width:1400px;margin-top:100px*/">
		<jsp:useBean id="pagedListHolder" scope="page" type="org.springframework.beans.support.PagedListHolder" />
		<jsp:useBean id="pagedListHolderByCategory" scope="page" type="org.springframework.beans.support.PagedListHolder" />

		<c:url value="/homepage" var="pagedLink"><c:param name="p" value="~" /></c:url>
		<c:url value="/homepage" var="pagedLinkByCategory"><c:param name="pageByCategory" value="~" /></c:url>
		
		<div class="w3-row-padding" id="latestArrival">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Latest Arrivals</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:if test="${pagedListHolder} != null">
		<c:forEach items="${pagedListHolder.pageList}" var="book">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a href="#"> <img src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${book.title}</p>
			  </div>
			</div>
		</c:forEach>
		</c:if>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}#latestArrival" />
		</div>
		
		<!-- ---------------------------------------------------------------------- -->
		<div class="w3-row-padding" id="comedy">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Comedy Literature</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:if test="${pagedListHolderByCategory} != null">
		<c:forEach items="${pagedListHolderByCategory.pageList}" var="book">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a href="#"> <img src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${book.title}</p>
			  </div>
			</div>
		</c:forEach>
		</c:if>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolderByCategory}" pagedLink="${pagedLinkByCategory}#comedy" />
		</div>
</div>
</div>
<!-- -------------------------------------------------------- -->
	
  <hr>
  
  <!-- Footer -->
  <footer class="w3-row-padding w3-padding-32">
    <div class="w3-third">
      <h3>FOOTER</h3>
      <p>Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.</p>
      <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
    </div>
  
    <div class="w3-third">
      <h3>BLOG POSTS</h3>
      <ul class="w3-ul w3-hoverable">
        <li class="w3-padding-16">
          <img src="/w3images/workshop.jpg" class="w3-left w3-margin-right" style="width:50px">
          <span class="w3-large">Lorem</span><br>
          <span>Sed mattis nunc</span>
        </li>
        <li class="w3-padding-16">
          <img src="/w3images/gondol.jpg" class="w3-left w3-margin-right" style="width:50px">
          <span class="w3-large">Ipsum</span><br>
          <span>Praes tinci sed</span>
        </li> 
      </ul>
    </div>

    <div class="w3-third w3-serif">
      <h3>POPULAR TAGS</h3>
      <p>
        <span class="w3-tag w3-black w3-margin-bottom">Travel</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">New York</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dinner</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Salmon</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">France</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Drinks</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Ideas</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Flavors</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Cuisine</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Chicken</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Dressing</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fried</span>
        <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Fish</span> <span class="w3-tag w3-dark-grey w3-small w3-margin-bottom">Duck</span>
      </p>
    </div>
  </footer>

<!-- End page content -->
</div>
    
</body>
</html>