<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>


<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">





<body>

	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="index">Engine Zone</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<c:if test="${!sessionScope.loggedIn}">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="index">
							<span class="glyphicon glyphicon-home"></span> Home
					</a></li>


					<li class="nav-item"><a class="nav-link" href="about">About
							Us</a></li>

					<li class="nav-item"><a class="nav-link" href="contact">Contact
							Us</a></li>
				</ul>


			</c:if>
			<ul class="navbar-nav navbar-right">
				<li class="nav-item"><a class="nav-link" href="signup"><span
						class="glyphicon glyphicon-user"></span>Sign Up</a></li>
				<li class="nav-item"><a class="nav-link" href="Login"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
			<c:if test="${sessionScope.loggedIn}">
				<c:if test="${sessionScope.role=='ADMIN'}">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="product">Insert
								Product</a></li>
						<li class="nav-item"><a class="nav-link" href="admin">Insert
								Category</a></li>
						<li class="nav-item"><a class="nav-link" href="proupdate">Update
								Product</a></li>
					</ul>
				</c:if>
				<c:if test="${sessionScope.role=='USER'}">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="/productPage"/>">Products</a></li>
					</ul>
				</c:if>
			</c:if>

		</div>


		<div class="nav nav-bar navbar-right">
			<c:if test="${sessionScope.loggedIn}">
				<a class="nav-link" href="<c:url value="/showCart"/>"> <span
					class="glyphicon glyphicon-shopping-cart"></span>
				</a>
				<font color="White" face="calibri">${CartItems}&nbsp;Welcome
					${sessionScope.username}</font>
				<a class="nav-link" href="perform_logout">LOGOUT</a>
			</c:if>
		</div>
	</div>
	</nav>
	<!-- Bootstrap core JavaScript -->
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.bundle.min.js"></script>

</body>
</html>