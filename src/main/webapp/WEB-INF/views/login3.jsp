<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en"> 
<head>

	<!-- General Metas -->
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">	<!-- Force Latest IE rendering engine -->
	<title>Login Form</title>
	<meta name="description" content="">
	<meta name="author" content="">
        
	<!-- Stylesheets -->
        <link href="../../../resources/css/base.css" rel="stylesheet" type="text/css"/>
        <link href="../../../resources/css/layout.css" rel="stylesheet" type="text/css"/>
        <link href="../../../resources/css/skeleton.css" rel="stylesheet" type="text/css"/>
	
</head>
<body>

	<div class="notice">
	</div>

	<div class="container">
		
		<div class="form-bg">
                    <form method="post" action="<c:url value='j_spring_security_check' />">
				<h2>Login</h2>
				<p><input name="j_username" type="text" placeholder="Username"></p>
				<p><input type="password" name='j_password' placeholder="Password"></p>
				<label for="remember">
				  <input type="checkbox" id="remember" value="remember" />
				  <span>Remember me on this computer</span>
				</label>
				<button type="submit"></button>
			</form>
		</div>

	
		<p class="forgot">Forgot your password? <a href="">Click here to reset it.</a></p>


	</div><!-- container -->

	<!-- JS  -->
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.js"></script>
	<script>window.jQuery || document.write("<script src='js/jquery-1.5.1.min.js'>\x3C/script>")</script>
	<script src="js/app.js"></script>
	
<!-- End Document -->
</body>
</html>