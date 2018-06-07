<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="utf-8"/>
		<title>Enroll the program</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="offcanvas.css" rel="stylesheet">
	</head>
	
	<body>
		<jsp:include page="CustomerTemplate.html" />				
				<div class="col-sx-5 col-sm-5 col-md-offset-3">
			      <form class="form-signin" action="Enroll" method="GET">
			      	<br><br>
			        <h3 class="form-signin-heading">Please Fill out the information</h3><br><br>


			        <label for="inputEmail"">Email address</label>
			        <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Please enter your email address">
			        <br>
			        <label for="inputPassword">Address</label>
			        <input  name="address" id="inputAddress" class="form-control" placeholder="Please enter your address">
			        <br>
			        <label for="inputPhoneNumber">Phone Number</label>
			        <input name="phoneNumber" id="inputPhone" class="form-control" placeholder="Please enter your phone number">
			        <br>
			        <label for="inputPassword">First Name</label>
			        <input type="text" name="firstname" id="InputFisrtName" class="form-control" placeholder="Please enter your first name">
			        <br>
			        <label for="inputPassword">Last Name</label>
			        <input type="text" name="lastname" id="InputLastName" class="form-control" placeholder="Please enter your last name">
			        <br>
			        <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="enroll">click to confirm enrollment</button>
			        <br><br><br><br><br><br>
			      </form>    
				</div>
	</body>
</html>