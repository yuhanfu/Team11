<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html lang="EN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<title>Auditor's page</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="offcanvas.css" rel="stylesheet">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>

<body>
    <nav class="navbar navbar-fixed-top navbar-inverse">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>

          <a class="navbar-brand" href="Auditor.html">Homepage &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> 
          <a class="navbar-brand" href="">History Record &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> 
          <a class="navbar-brand" href="">Setting &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a> 
          <a class="navbar-brand" href="">Profile &nbsp;&nbsp;</a>
        </div><!-- /.nav-collapse -->

      </div><!-- /.container -->
    </nav><!-- /.navbar -->

	<div class="container">
		<div class="row row-offcanvas row-offcanvas-right">
			<div class="col-xs-12 col-sm-12">
				<p class="pull-right visible-xs">
					<button type="button" class="btn btn-primary btn-xs"
						data-toggle="offcanvas">Toggle nav</button>
				</p>
				<div class="jumbotron">
					<br>
					<p><font size="6" face="Verdana"> Welcome, Auditor!</font></p>
					<p><font size="4" face="Verdana" color="gray">&nbsp;&nbsp; - Auditor's page. </font></p>
				</div>
			</div>
			<!--/.col-xs-12.col-sm-9-->

			<div class="col-xs-5 col-sm-5 sidebar-offcanvas" id="sidebar">
				<div class="list-group">
				</div>

<!-- 				<li class="dropdown"> -->
                  <a href="https://s3.amazonaws.com/team11-task15/deidentified.csv" download><font size="5">Download Cleaned User Data</font><span class="caret"></span></a>
                  <!-- <ul class="dropdown-menu">
                  	<font size="4">
                    <li style="line-height:50px"><a href="https://s3.amazonaws.com/team11-task15/deidentified.csv" download>&nbsp;Download Enrolled User Information</a></li>
                    <br>
                    <li style="line-height:50px"><a href="">&nbsp;Download Cleaned User Data</a></li>
                    </font>
                  </ul>
              </li> -->	
			</div>
			<!--/.sidebar-offcanvas-->
		</div>
		<!--/row-->
	</div>
	<br><br><br><br><br>

	<div class="col-sx-10 col-sm-10 col-md-offset-7">
	    <p><font size="5" face="Verdana" color="lightblue"> Recent Enrolled User</font></p>
		<br>
		<c:forEach var="user" items="${enrolledUsers}">
		    <p><font size="5" face="Verdana">${user.firstName}&nbsp;${user.lastName}&nbsp;(${user.email})</font></p>
		</c:forEach>
<!-- 		<p><font size="4" face="Verdana"> Yuhan Fu (user_id: 0000001)<span><font size="2"> -- <br> Enrolled time: 06/06/2018 1:45 pm </font></span></font></p> -->

		<br>
	</div>
	<!--/.container-->
</body>
</html>