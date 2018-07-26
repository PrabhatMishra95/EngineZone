<%@include file="navbar.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<head>
<link rel="stylesheet"
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
		<div id="product" class="tab-pane fade in active">
			<form:form method="post" action="InsertProduct"
				modelAttribute="product" enctype="multipart/form-data">
				<h3>Add new Product</h3>
				<div class="form-group">
					<table class="table table-hover ">
						<tbody>
							<tr>
								<td><form:label path="productName">Product Name</form:label></td>
								<td><form:input type="text" path="productName"
										 placeholder="Enter category id" />
							</tr>
							<tr>
								<td><form:label path="categoryId">Category</form:label></td>
								<td><form:select path="categoryId">
										<form:option value="0" label="select" />
										<form:options items="${categoryList}" />
									</form:select>
							</tr>
							<tr>
								<td><form:label path="supplierId">Supplier</form:label></td>
								<td><form:input path="supplierId" type="text"
										placeholder="Enter supplier id" />
							</tr>
							<tr>
								<td><form:label path="price">Price</form:label></td>
								<td><form:input path="price" type="text"
										placeholder="Enter price " />
							</tr>
							<tr>
								<td><form:label path="stock">Stock</form:label></td>
								<td><form:input path="stock" type="text"
										placeholder="Enter stock " />
							</tr>
							<tr>
								<td><form:label path="prodDesc">Product Description</form:label></td>
								<td><form:input path="prodDesc" type="text" placeholder="Enter Product description " />
							</tr>
							<tr>
								<td><form:label path="pimage">Product Image</form:label></td>
								<td><form:input path="pimage" type="file"/>
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