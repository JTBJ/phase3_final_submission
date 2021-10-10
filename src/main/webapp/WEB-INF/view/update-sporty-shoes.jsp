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

<title>Manage Shoes</title>
</head>
<body>
	<div class="container">
		<h1>Manage Shoes</h1>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>shoe_name</th>
					<th>category</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${shoeProductList}" var="shoe">
					<tr>
						<td>"${shoe.id}"</td>
						<td>"${shoe.name}"</td>
						<td>"${shoe.productCategory}"</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<!-- <p th:text="${customers}"/> -->
		<form:form
			action="${pageContext.request.contextPath}/shoe-updated"
			method="post">
			<h4>Update a Shoe in the Table</h4>
			<b>To update, fill in the values. If a field will have the same value
				key in that value before submitting.</b><br/>
			<p>
				Enter Shoe Id to Update <input type="number" name="shoeId" required />
			</p>
			<p>
				Update Shoe Name <input type="text" name="shoeName" required />
			</p>

			<p>				
				Enter Category Id to change to <input type="number" name="shoeCategoryId" required />
			</p>
				<input type="submit" value="Change"
					style="background-color: lightblue; color: darkblue;" />
		</form:form>
		
		<h4>Add a Shoe to the Table</h4>
		<form:form
			action="${pageContext.request.contextPath}/shoe-added"
			method="post">
			<b>To create a new shoe, fill in the values.</b><br/>
			<p>
				Enter the <b>category Id</b> from the table above to create a category name for the shoe<br/> 
				<input type="number" name="categoryId" required />
			</p>
			<p>
				Shoe Name <input type="text" name="shoeName" required />
			</p>

			<input type="submit" value="Create"
					style="background-color: lightblue; color: darkblue;" />
		</form:form>
		
		<h4>Delete a Shoe from the Table</h4>
		<form:form
			action="${pageContext.request.contextPath}/shoe-deleted"
			method="post">
			<b>To delete a shoe, fill in the values.</b><br/>
			<p>
				Enter the <b>shoe Id</b> to delete<br/> 
				<input type="number" name="shoeId" required />
			</p>
			<input type="submit" value="Delete"
					style="background-color: lightblue; color: darkblue;" />
		</form:form>
	</div>

</body>
</html>