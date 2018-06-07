<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="utf-8"/>
		<title>Log In</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="offcanvas.css" rel="stylesheet">
	</head>
	
	<body onload="document.getElementById('email').focus()">
		<jsp:include page="CustomerTemplate.html" />				
				<div class="col-sx-5 col-sm-5 col-md-offset-3">
			    		<form class="form-signin" action="Login" method="GET">
				      	<br>
				        <h2 class="form-signin-heading">Please sign in</h2>
				        <label for="inputEmail" class="sr-only">Email address</label>
	
				        <input type="text" id="email" name="email" value="${form.email}" class="form-control" placeholder="Email address"/>
				        <br>
	
				        <label for="inputPassword" class="sr-only">Password</label>
	
				        <input type="password" name="password" class="form-control" placeholder="Password" />
				        <div class="checkbox">
				          <label>
				            <input type="checkbox" value="remember-me"> Remember me
				          </label>
				        </div>
				        <button class="btn btn-lg btn-primary btn-block" type="submit" name="button" value="Login">Sign in</button>
	        		 	</form>
			        <br><br><br><br><br><br>    
				</div>
	</body>
</html>