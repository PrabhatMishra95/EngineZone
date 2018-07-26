<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
body, html {
	height: 100%;
	margin: 0;
}

.bg {
	background-image: url("resources/images/signup.jpg");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
}
</style>

<body class="bg">

	<center>
		<h3>Welcome to EngineZone</h3>
		<h1>Sign Up</h1>
	</center>
	<table align="center">
		<form:form method="post" action="signupUser" modelAttribute="user">
			<tr>
				<td>Username</td>
				<td><form:input type="text" path="username" />
				<td><form:errors path="username" /></td>
			</tr>
			<tr>
				<td>Address</td>

				<td><form:input type="text" path="address" /></td>
				<td><form:errors path="address" /></td>
			</tr>
			<tr>
				<td>CustomerName</td>
				<td><form:input type="text" path="customerName" /></td>
				<td><form:errors path="customerName" /></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId" /></td>
				<td><form:errors path="emailId" /></td>
			</tr>
			<tr>
				<td>Mobile No.</td>
				<td><form:input type="text" path="mobileNo" /></td>
				<td><form:errors path="mobileNo" /></td>

			</tr>

			<tr>
				<td>Password</td>
				<td><form:input type="password" path="password" /></td>
				<td><form:errors path="password" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Sign Up" /></td>
			</tr>

		</form:form>
	</table>
</body>