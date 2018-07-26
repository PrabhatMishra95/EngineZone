<%@include file="navbar.jsp" %>

<div class="container">
<div class = "row">

<c:forEach items="${listProducts}" var="product">
		<div class = "col-sm-6 col-md-6">
			<a href="<c:url value="productDesc/${product.productId}"/>">
			<img src = "<c:url value="/resources/images/${product.productId}.jpg"/>" width="550" height="220" alt = "Generic thumbnail">
			</a>
 			<p>
      	 		<h3>${product.productName}</h3>
      	 		<h3>Rs ${product.price}</h3>
      		</p>
		</div>
</c:forEach>

</div>
</div>

<%@include file="footer.jsp"%>