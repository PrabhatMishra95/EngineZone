<%@include file="navbar.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<link href="../resources/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<div class="container">

	<table align="center" class="table">
		<tr bgcolor='pink'>
			<td colspan='6'>
				<center>Your Cart</center>
			</td>
		</tr>
		<tr bgcolor='orange'>
			<td>Product Name</td>
			<td>Price</td>
			<td>Quantity</td>
			<td>SubTotal</td>
			<td></td>
			<td>Operation</td>
		</tr>

		<c:if test="${not empty listCartItems}">
			<c:forEach items="${listCartItems}" var="cartItem">
				<form
					action="<c:url value="/updateCartItem/${cartItem.cartItemId}"/>"
					method="get">
					<tr>
						<td>${cartItem.productName}</td>
						<td>${cartItem.price}</td>
						<td><input type="text" name="qty"
							value="${cartItem.quantity}" /></td>
						<td>${cartItem.price * cartItem.quantity}</td>
						<td><img
							src="<c:url value="/resources/images/${cartItem.productId}.jpg"/>"
							width="50" height="50" /></td>
						<td><a
							href="<c:url value="/deleteCartItem/${cartItem.cartItemId}"/>">Delete</a>
							<input type="submit" value="Update" /></td>
					</tr>
				</form>
			</c:forEach>
		</c:if>
		<c:if test="${empty listCartItems}">
			<tr>
				<td colspan="6"><center>You Have No Items in Cart</center></td>
			</tr>
		</c:if>
		<tr>
			<td colspan="3">Total Cost</td>
			<td>${totalCost}</td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="3"><a href="<c:url value="/productPage"/>"><b>Continue
						Shopping</b></a></td>
			<td colspan="3"><a href="<c:url value="/orderConfirm"/>"><b>Checkout</b></a></td>
		</tr>


	</table>

</div>


<%@include file="footer.jsp"%>