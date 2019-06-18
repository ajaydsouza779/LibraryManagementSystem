
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%-- 
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>

<!DOCTYPE html>
<html>
	<meta charset="ISO-8859-1">
<!-- <meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
 --><link rel="stylesheet" href="w3.css">
<!-- <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma"> -->
<style>

		body,h1,h2,h3,h4,h5,h6 {font-family: "Karma", sans-serif}
		.w3-bar-block .w3-bar-item {padding:20px}
.menu {display: none}
/* .bgimg {
  background-repeat: no-repeat;
  background-size: cover;
  /* background-image: url("/w3images/pizza.jpg"); */
  min-height: 90%;
} */
</style>
<body>

		<div class="w3-top" style="background-color: greenyellow;">
	       
	      <div class="w3-button  w3-left" onclick="w3_open()">☰</div>
	      <div class="w3-center " style="font-size: 21pt;">Library Management</div>
		<%@ include file="headerLibrarian.jsp"%>
		</div>

<!-- Menu Container -->
<div class="w3-container   w3-black w3-padding-64 w3-xxlarge" id="menu"> <!-- w3-black -->
  <div class="w3-content">
  
   <!--  <h1 class="w3-center w3-jumbo" style="margin-bottom:64px">THE MENU</h1> -->
    <div class="w3-row w3-center w3-border w3-border-dark-grey">
      <a href="javascript:void(0)" onclick="openMenu(event, 'approveBookRequest');" id="myLink">
        <div class="w3-col s4 tablink  w3-hover-red">Book Issue Request</div> <!-- w3-padding-large -->
      </a>
      <a href="javascript:void(0)" onclick="openMenu(event, 'bookReturned');">
        <div class="w3-col s4 tablink w3-hover-red">Return Request</div>
      </a>
      <a href="javascript:void(0)" onclick="openMenu(event, 'ApproveUser');">
        <div class="w3-col s4 tablink  w3-hover-red">Approve User</div>
      </a>
    </div>

    <div id="approveBookRequest" class="w3-container menu w3-padding-32 w3-white">
      
   <%--   bookIssueRequests == ${{bookIssueRequests} } --%>
	      
	<div class="w3-container w3-padding-16" style="margin-top: 10px">
	
	<table class="w3-table w3-hoverable w3-table-all" style="font-size: 14px;">
		
		<tr style="">
			<th>Book</th>
			<th>User</th>
			<th>Issue</th>
		</tr>
		<c:if test="${bookIssueRequests != null}">
		<c:forEach items="${bookIssueRequests}" var="reqBook">
		<tr>
			<td>${reqBook.title}</td>
			<td>${reqBook.user}</td>
			<td>
				<c:if test="${reqBook.isUserApproved ==true }">
					<a style="color:blue; " href="${contextPath}/approveBookRequest?bookId=${reqBook.bookId}&userId=${reqBook.userId}">Issue</a>	
				</c:if>
				<c:if test="${reqBook.isUserApproved == null ||  reqBook.isUserApproved == false}">
					<a style="color:blue; " onclick="openMenu(event, 'ApproveUser');" href="javascript:;">User Approval Pending</a>	
				</c:if>
			</td>
			
		</tr>
		</c:forEach>
		</c:if>
	</table>
	</div>
	</div>
    <div id="bookReturned" class="w3-container menu w3-padding-32 w3-white">
     	<div class="w3-container w3-padding-16" style="margin-top: 10px">
			<table class="w3-table w3-hoverable w3-table-all" style="font-size: 14px;">
				
				<tr style="">
					<th>Book</th>
					<th>User</th>
					<th>Issue</th>
				</tr>
				<%-- <c:if test="${bookReturnRequests == null || (bookReturnRequests !=null && bookReturnRequests.length>0)}">
					<tr><td colspan="3" class="w3-center"> ${bookReturnRequests.length} No books to collect</td></tr>
				</c:if> --%>
				<c:if test="${bookReturnRequests != null}">
				<c:forEach items="${bookReturnRequests}" var="retBook">
				<tr>
					<td>${retBook.title}</td>
					<td>${retBook.user}</td>
					<td><a style="color:blue; " href="${contextPath}/bookReturned?bookId=${retBook.bookId}&userId=${retBook.userId}">Book Collected</a></td>
					
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
    </div>
    <br>

    <div id="ApproveUser" class="w3-container menu w3-padding-32 w3-white">
     	<div class="w3-container w3-padding-16" style="margin-top: 10px">
			<table class="w3-table w3-hoverable w3-table-all" style="font-size: 14px;">
				
				<caption><h4><i>Verify the user and collect the refundable security deposit of Rs.500 from the user before approving.</i></h4></caption>
				
				<tr >
					<th>Username</th>
					<th>Full Name</th>
					<th>Approve</th>
				</tr>
				<c:if test="${usersToApprove == null}">
					<tr><td colspan="3" class="w3-center"> No users to approve</td></tr>
				</c:if>
				<c:if test="${usersToApprove != null}">
				<c:forEach items="${usersToApprove}" var="user">
				<tr>
					<td>${user.username}</td>
					<td>${user.firstName} ${user.lastName}</td>
					<td><a style="color:blue; " href="${contextPath}/approveUser?userId=${user.id}">Collect Rs. 500 and Approve</a></td>
					
				</tr>
				</c:forEach>
				</c:if>
			</table>
		</div>
    </div><br>

  </div>
</div>
<script type="text/javascript">
// Tabbed Menu
function openMenu(evt, menuName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("menu");
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
     tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(menuName).style.display = "block";
  evt.currentTarget.firstElementChild.className += " w3-red";
}
document.getElementById("myLink").click();

</script>

<div ><%-- 
-------------------------------------------<br>
${page} --%>
</div>
<c:if test="${page == 'approveBookRequest'}">
	<script type="text/javascript">openMenu(event, 'approveBookRequest');</script>
</c:if>
<c:if test="${page == 'bookReturned'}">
	<script type="text/javascript">openMenu(event, 'bookReturned');</script>
</c:if>
<c:if test="${page == 'ApproveUser'}">
	<script type="text/javascript">openMenu(event, 'ApproveUser');</script>
</c:if>



</body></html>