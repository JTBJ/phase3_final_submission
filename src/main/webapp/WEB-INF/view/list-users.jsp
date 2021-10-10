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

<title>Customer List</title>
</head>
<body>
	<div class="container">
		<h1>Customer List</h1>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>username</th>
					<th>email</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${customerList}" var="customer">
					<tr>
						<td>"${customer.id}"</td>
						<td>"${customer.firstName}"</td>
						<td>"${customer.lastName}"</td>
						<td>"${customer.userName}"</td>
						<td>"${customer.email}"</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>Products Selected by Customer</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${customerList}" var="customer">
					<tr>
						<td>"${customer.userName}"</td>
						<td>"${customer.shoeProduct}"</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<!-- <p th:text="${customers}"/> -->
		
		<form:form
			action="${pageContext.request.contextPath}/select-customer-by-id"
			method="post">
			
			<p>
				Enter a customer id <input type="number" name="customerId" required />
			</p>

				<input type="submit" value="Select"
					style="background-color: lightblue; color: darkblue; margin-bottom: 20px;" />
		</form:form>
	</div>
</body>
</html>