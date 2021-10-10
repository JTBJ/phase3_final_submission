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

<title>Update or add a Category</title>
</head>
<body>
	<div class="container">
		<h1>Update or add a Category</h1>
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>id</th>
					<th>category_name</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${shoeCategoryList}" var="category">
					<tr>
						<td>"${category.id}"</td>
						<td>"${category.categoryName}"</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<!-- <p th:text="${customers}"/> -->
		<h4>Choose a Category to Update</h4>
		<form:form
			action="${pageContext.request.contextPath}/category-updated"
			method="post">
			<b>To update, fill in the values.</b><br/>
			<p>
				Enter the Category Id to Update <input type="number" name="categoryId" required />
			</p>
			<p>
				Update Category Name <input type="text" name="updatedName" required />
			</p>

				<input type="submit" value="Change"
					style="background-color: lightblue; color: darkblue; margin-bottom: 20px;" />
		</form:form>
		
		<h4>Or Create a New Category</h4>
		<form:form
			action="${pageContext.request.contextPath}/category-updated"
			method="post">
			
			<p>
				Create Category Name <input type="text" name="newName" required />
			</p>

				<input type="submit" value="Add"
					style="background-color: lightblue; color: darkblue; margin-bottom: 20px;" />
		</form:form>
		
		<h4>Delete a Category from the Table</h4>
		<form:form
			action="${pageContext.request.contextPath}/category-deleted"
			method="post">
			<b>To delete a category, fill in the values.</b><br/>
			<p>
				Enter the <b>category Id</b> to delete<br/> 
				<input type="number" name="categoryId" required />
			</p>
			<input type="submit" value="Delete"
					style="background-color: lightblue; color: darkblue;" />
		</form:form>
	</div>

</body>
</html>