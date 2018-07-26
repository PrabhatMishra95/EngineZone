<%@include file="navbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head><link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="main.js"></script>
<!-- <link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 -->
</head> 
<div class="container">
		<h2 align="center">Admin</h2>
		<ul class="nav nav-tabs nav-justified ">
			
		</ul>
<div class="tab-content">
			<!-- Category Tab -->
			<div id="category" class="tab-pane fade in active">
				<form:form action="saveCate"
					modelAttribute="category" method="post">
					<h3>Add new Category</h3>
					<div class="form-group">
						<table class="table table-hover ">
							<tbody>
								<tr>
									<td><form:label path="categoryId">Category ID</form:label></td>
									<td><form:input type="number" path="categoryId"
											class="form-control" id="cid" placeholder="Enter category id"
											name="cid" />
								</tr>
								<tr>
									<td><form:label path="categoryName">Category Name</form:label></td>
									<td><form:input path="categoryName" type="text"
											class="form-control" id="cname"
											placeholder="Enter category name " name="cname" />
								</tr>
								<tr>
									<td><form:label path="categoryDesc">Category Description</form:label></td>
									<td><form:input path="categoryDesc" type="text"
											class="form-control" id="cdesc"
											placeholder="Enter category description " name="cdesc" />
								</tr>
								<tr>
									<td>
										<button type="submit" class="btn btn-lg btn-primary ">Submit
										</button>
									</td>
									
								</tr>
							</tbody>
						</table>
					</div>
				</form:form>
			</div>