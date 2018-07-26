<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="container">
	<div class="row">

		<c:forEach items="${listProducts}" var="product">
			<form action="<c:url value="/updateProduct/${product.productId}"/>"
				method="get">
				<div class="col-sm-6 col-md-6">
					<img
						src="<c:url value="/resources/images/${product.productId}.jpg"/>"
						width="550" height="220" alt="Generic thumbnail">
					
					<h3>${product.productName}</h3>
					<input type="text" name="price" value="${product.price}" /> <a
						href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
					
				</div>
				<input type="submit" value="Update" />
			</form>
		</c:forEach>

	</div>
</div>