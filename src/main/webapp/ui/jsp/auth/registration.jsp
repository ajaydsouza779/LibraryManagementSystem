<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="w3.css">
<link rel="stylesheet" href="font-awesome.min.css">
<body>


 
 
 
 
 <div class="w3-container" style="width:75%;max-height: 700px; margin-right: auto; margin-left: auto;">
 <button class="w3-button w3-section w3-green w3-ripple w3-right" > <a href="${contextPath}/login">Having Account? Login </a></button>
 
<form:form method="POST" modelAttribute="userForm" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
<h2 class="w3-center">Register Me!</h2>


 
 
<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="firstName" type="text" placeholder="First Name" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="lastName" type="text" placeholder="Last Name" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="username" type="email" placeholder="Email (to be used as username)" required>
      <%-- <form:input type="text" path="username" class="form-control" placeholder="Username"
                                autofocus="true"></form:input> --%>
       <form:errors path="username"></form:errors>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="phoneNumber" type="number" placeholder="Phone" required>
     <form:errors path="phoneNumber"></form:errors>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
    <div class="w3-rest">
    <input class="w3-input w3-border" name="password" type="password" placeholder="Password" required> 
    <form:errors path="password"></form:errors>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
    <div class="w3-rest">
    <input class="w3-input w3-border" name="passwordConfirm" type="password" placeholder="Retype Password" required> 
     <form:errors path="passwordConfirm"></form:errors>
    </div>
</div>

<p class="w3-center">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit"> Register </button>
</p>

<div class="w3-container w3-border w3-large">
  <div class="w3-left-align"><p>To complete the registration you need to deposit refundable Rs. 500 at the librarian. Once the deposit is complete please use Login button or right top to login with your email id and password.</p></div>
<!--   <div class="w3-right-align"><p>Right aligned text.</p></div> -->
</div>

 </form:form>


    <script src="jquery.min.js"></script>
  </div>
</body>
</html> 
