<%@include file="navbar.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
body, html {
    height: 100%;
    margin: 0;
}

.bg {
    /* The image used */
    background-image: url("resources/images/login.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>

<body class="bg">
<br>
	<form action="perform_login" method="post">

		<div class="container">
			<div class="row">
				<form allign="left">
					<div class="col-md-offset-5 col-md-3">

						<div class="form-login">
							<h4><font color="white">Welcome</font></h4>
							<input type="text" name="username"
								class="form-control input-sm chat-input" placeholder="username">
							</br> <input type="password" name="password"
								class="form-control input-sm chat-input" placeholder="password">
							</br>
							<div class="wrapper">

								<input type="submit" class="btn btn-lg btn-info" value="Submit" />

							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
	</form>
	
</body>
</html>