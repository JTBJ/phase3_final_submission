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

<title>Shoe List</title>
</head>
<body>
	<div class="container">
		<h1>Shoe List</h1>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>shoe_name</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoeProductList}" var="shoe">
					<tr>
						<td>"${shoe.id}"</td>
						<td>"${shoe.name}"</td> 

					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>Complete Shoe Information</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${shoeProductList}" var="shoe">
					<tr>
						<td>"${shoe}"</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- <p th:text="${customers}"/> -->
	</div>
</body>
</html>