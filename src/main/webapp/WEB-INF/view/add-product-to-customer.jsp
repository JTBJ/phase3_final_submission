<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- add spring security JSP Tag Library -->
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU"
	crossorigin="anonymous">

<title>Select a Shoe</title>
</head>
<body>
	<div class="container">
		<h1>Select a Shoe</h1>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>username</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>
				<tr>
						<td>"${customer.id}"</td>
						<td>"${customer.userName}"</td>
						<td>"${customer.firstName}"</td>
						<td>"${customer.lastName}"</td>
						<td>"${customer.email}"</td>
				</tr>
			</tbody>
		</table>
		
		<table>
			<thead>
				<tr>
					<td>product id</td>
					<td>product name</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${customer.shoeProduct}" var="customer">
						<td>"${customer.id}"</td>
						<td>"${customer.name}"</td>
						<td>"${customer.productCategory}"</td>
					</c:forEach>

				</tr>
			</tbody>
		</table>
		<!-- <p th:text="${customers}"/> -->
		<form:form
			action="${pageContext.request.contextPath}/add-product-to-customer"
			method="post">
			<p>
				Enter Product Id <input type="text" name="product_id" required />
			</p>
			
			<p>
				Enter Your Id <input type="text" name="customer_id" required />
			</p>
			<p>
				<input type="submit" value="Select"
					style="background-color: lightblue; color: darkblue;" />
		</form:form>
	</div>

</body>
</html>