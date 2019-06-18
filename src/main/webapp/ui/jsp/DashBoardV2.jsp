
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- <div>
---------------------------------<br>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authorize access="hasRole('ROLE_ADMIN')">
This content will only be visible to users who have the "supervisor" authority in their list of <tt>GrantedAuthority</tt>s.
</sec:authorize>
<sec:authentication property="name" />
--------------------------------<br>

<c:out value="${pageContext.request.remoteUser}"/>


----------------------------<br/>
<c:out value="${username}"/> <c:out value="${userId}"/>
-------------------------------<br/>
</div> --%>

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
<!-- 	<nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:40%;min-width:300px" id="mySidebar">
	  <a href="javascript:void(0)" onclick="w3_close()"
	  class="w3-bar-item w3-button">Close Menu</a>
	  <a href="#latestArrival" onclick="w3_close()" class="w3-bar-item w3-button">Latest Arrivals</a>
	  <a href="#comedy" onclick="w3_close()" class="w3-bar-item w3-button">Comedy</a>
	</nav>
	 -->
	 <%@ include file="leftNavigation.jsp"%>
	 
	<!-- Top menu -->
		<div class="w3-top" style="background-color: greenyellow;">
	       
	      <div class="w3-button  w3-left" onclick="w3_open()">☰</div>
	      <div class="w3-center " style="font-size: 21pt;">Library Book Shelf</div>
		<%@ include file="header.jsp"%>
		</div>
	
<!-- class="container" -->
<!-- ------------------------------------------------- -->	
<div class="w3-container">
<div  class="w3-main w3-padding" style="width: 100%;/*max-width:1400px;margin-top:100px*/">
		<jsp:useBean id="pagedListHolder" scope="request" type="org.springframework.beans.support.PagedListHolder" />
	
		<c:url value="/dashboardV2" var="pagedLink"><c:param name="p" value="~" /></c:url>
		
		<div class="w3-row-padding" id="latestArrival">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Latest Arrivals</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:forEach items="${pagedListHolder.pageList}" var="book">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a  href="javascript:;"> <img  onclick="document.getElementById('book_${book.id}').style.display='block'" src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${book.title}</p>
			  </div>
			</div>
		</c:forEach>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolder}" pagedLink="${pagedLink}#latestArrival" />
		</div>
<!-- ---------------------------------------------------------------------- -->
	
		<jsp:useBean id="pagedListHolderByCategoryComedy" scope="request" type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/dashboardV2" var="pagedLinkByCategoryComedy"><c:param name="pageByCategoryComedy" value="~" /></c:url>
	
		<div class="w3-row-padding" id="comedy">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Comedy Literature</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:forEach items="${pagedListHolderByCategoryComedy.pageList}" var="book">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a href="javascript:;"> <img onclick="document.getElementById('book_${book.id}').style.display='block'" src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${book.title}</p>
			  </div>
			</div>
		</c:forEach>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolderByCategoryComedy}" pagedLink="${pagedLinkByCategoryComedy}#comedy" />
		</div>

<!-- -------------------------------------------------------- -->
<!-- ---------------------------------------------------------------------- -->
	
		<jsp:useBean id="pagedListHolderByCategoryFiction" scope="request" type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/dashboardV2" var="pagedLinkByCategoryFiction"><c:param name="pageByCategoryFiction" value="~" /></c:url>
	
		<div class="w3-row-padding" id="fiction">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Fiction Literature</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:forEach items="${pagedListHolderByCategoryFiction.pageList}" var="book">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a href="javascript:;"> <img onclick="document.getElementById('book_${book.id}').style.display='block'" src="${urlOfImg}/${book.imageName}" alt="${book.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${book.title}</p>
			  </div>
			</div>
		</c:forEach>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolderByCategoryFiction}" pagedLink="${pagedLinkByCategoryFiction}#fiction" />
		</div>

<!-- -------------------------------------------------------- -->

		<jsp:useBean id="pagedListHolderByCategoryNovel" scope="request" type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/dashboardV2" var="pagedLinkByCategoryNovel"><c:param name="pageByCategoryNovel" value="~" /></c:url>
	
		<div class="w3-row-padding" id="novel">
		    <div class="w3-center w3-padding-64">
		      <span class="w3-xlarge w3-bottombar w3-border-dark-grey w3-padding-16">Novels</span>
		    </div>
		</div>
		<div class="w3-panel w3-leftbar w3-sand w3-xxlarge w3-serif">
		<c:forEach items="${pagedListHolderByCategoryNovel.pageList}" var="bookN">
			<div class="w3-card-4 w3-quarter " style="/*max-height: 250px; overflow: hidden*/">
			  <a href="javascript:;"> <img onclick="document.getElementById('book_${bookN.id}').style.display='block'" src="${urlOfImg}/${bookN.imageName}" alt="${bookN.title}" style="width:100%;max-height: 250px; overflow: hidden"></a>
			  <div class="w3-container w3-center">
			    <p>${bookN.title}</p>
			  </div>
			</div>
		</c:forEach>
		</div>	
		<br/>	
		<div class="w3-center">
			<tg:paging pagedListHolder="${pagedListHolderByCategoryNovel}" pagedLink="${pagedLinkByCategoryNovel}#novel" />
		</div>

<!-- ----------------------------------------------------------- -->
</div>
</div>

	
	<%@ include file="BookInfo.jsp"%>
	<!-- ----------------------------- -->
  <hr>
  
<!-- Footer -->
<div class="w3-row w3-section">
  <div class="w3-third w3-container w3-black w3-large" style="height:250px">
    <h2>Library Address</h2>
    <p><i class="fa fa-map-marker" style="width:30px"></i> 547/1, R.V. Road, Near Vijaya College,IOC Petrol pump 2nd floor, Basavanagudi, 2nd Block, Jayanagar, Bengaluru, Karnataka 560004</p>
    <p><i class="fa fa-phone" style="width:30px"></i> Phone: 080 2656 4926</p>
    <p><i class="fa fa-envelope" style="width:30px"> </i> Web: annamalaiuniversity.ac.in</p>
  </div>
  <div class="w3-third w3-center w3-large w3-dark-grey w3-text-white" style="height:250px">
   </div>
  <div class="w3-third w3-center w3-large w3-grey w3-text-white" style="height:250px">

  </div>
</div>

<!-- End page content -->
</body>
</html>