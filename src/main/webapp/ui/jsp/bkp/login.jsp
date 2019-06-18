<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<!-- <title>W3.CSS</title> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<link rel="stylesheet" href="w3.css">
<body>

<div class="w3-container" style="width:100%;/*max-height: 700px*/">
 

      <div class="w3-center"><br>
<!--         <span onclick="document.getElementById('id01').style.display='none'" class="w3-button w3-xlarge w3-transparent w3-display-topright" title="Close Modal">×</span> -->
        <img src="img_avatar4.png" alt="Avatar" style="width:20%; height: 20%" class="w3-circle w3-margin-top">
      </div>

      <form class="w3-container" ><!-- action="/action_page.php" -->
        <div class="w3-section">
          <label><b>Username</b></label>  <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="usrname" required>
          <label><b>Password</b></label>  <input class="w3-input w3-border" type="text" placeholder="Enter Password" name="psw" required>
          <button class="w3-button w3-block w3-green w3-section w3-padding" type="submit">Login</button>
          <input class="w3-check w3-margin-top" type="checkbox" checked="checked"> Remember me
          <span class="w3-right w3-margin-top w3-hide-small"><a href="#">Forgot password?</a></span>
        </div>
      </form>

<!--       <div class="w3-container w3-border-top w3-padding-16 w3-light-grey"> -->
<!--         <button onclick="document.getElementById('id_Login').style.display='none'" type="button" class="w3-button w3-red">Cancel</button> -->
<!--         <span class="w3-right w3-padding w3-hide-small"><a href="#">Forgot password?</a></span> -->
<!--       </div> -->

    </div>
  </div>

            
</body>
</html>
