<!DOCTYPE html>
<html>
<!-- <title>W3.CSS</title> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<link rel="stylesheet" href="w3.css"> <!-- https://www.w3schools.com/w3css/4/ -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>

<form  class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin"> <!-- action="/action_page.php" -->
<h2 class="w3-center">Register Me!</h2> 
 
<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="first" type="text" placeholder="First Name" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="last" type="text" placeholder="Last Name" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-envelope-o"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="email" type="email" placeholder="Email" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-phone"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="phone" type="number" placeholder="Phone" required>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="message" type="password" placeholder="Password" required>
    </div>
</div>

<p class="w3-center">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit"> Register </button>
</p>

<div class="w3-container w3-border w3-large">
  <div class="w3-left-align"><p>To complete the registration you need to deposit refundable Rs. 500 at the office. Once the deposit is complete please use Login button or right top to login with your email id and password.</p></div>
<!--   <div class="w3-right-align"><p>Right aligned text.</p></div> -->
</div>

</form>

</body>
</html> 
