<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta charset="utf-8"/>
		<title>Customer</title>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link href="offcanvas.css" rel="stylesheet">
	</head>
<body>
           <jsp:include page="CustomerTemplate.html" />	
			<div class="col-sx-10 col-sm-10 col-md-offset-2">
                <form method="POST" id="PostContent">
                <br>	
				 <table>
				 	<tr>
				 		<td>
				 			<textarea rows="20" cols="100"></textarea>
				 		</td>
				 	</tr>
			 			<td valign="bottom">
				 			<form action="/action_page.php" method="get">
								  <input type="checkbox" name="vehicle" value="enrollment"> I have read the above mentioned information
								  <br>
								  <br>
								  <button class="btn btn-lg btn-primary btn-block" type="button" onclick="{location.href=''}">click to agree on our enrollment program</button>
  							</form>
				 		</td>
				 </table>
				</form>		
				<br><br><br><br>
			</div>
</body>
</html>