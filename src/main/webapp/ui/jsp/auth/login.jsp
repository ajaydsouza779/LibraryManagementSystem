<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
<!-- <title>W3.CSS</title> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css"> -->
<link rel="stylesheet" href="w3.css">
<body>

<div class="w3-container w3-card-4  " style="width:75%; margin-right: auto; margin-left: auto; margin-top: 20px;">
 
    <button class="w3-button w3-section w3-blue w3-ripple w3-right" > <a href="${contextPath}/registration">Registering for library?</a></button>
 

      <div class="w3-center"><br>
<!--         <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span> -->
        <img src="img_avatar4.png" alt="Avatar" style="width:20%; height: 20%" class="w3-circle w3-margin-top">
      </div>

		<div class="w3-center w3-pale-blue">    <span>${message}</span></div>

      <form method="POST" action="${contextPath}/login" class="w3-container" >
         <div class="w3-section">
          <label><b>Username</b></label>  <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="username" required autofocus="true">
          <label><b>Password</b></label>  <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
          
          <br>
          <span class="w3-red">${error}</span>
         
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <!-- <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me -->
          <%--  <span class="text-center"><a href="${contextPath}/registration">Registering for library?</a></span> --%>
         <!--  <span class="w3-right w3-margin-top w3-hide-small"><a href="#">Forgot password?</a></span> -->
        </div>
        
              
        
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
      </form>

<!--       <div class="w3-container w3-border-top w3-padding-16 w3-light-grey"> -->
<!--         <button onclick="document.getElementById('id_Login').style.display='none'" type="button" class="w3-button w3-red">Cancel</button> -->
<!--         <span class="w3-right w3-padding w3-hide-small"><a href="#">Forgot password?</a></span> -->
<!--       </div> -->

    </div>
  </div>



            
</body>
</html>
