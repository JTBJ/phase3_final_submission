<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- add spring security JSP Tag Library -->
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Home Page</title>
</head>
<body>
	<h1>Sporty Shoes Home Page</h1>
	
	User: <security:authentication property="principal.username"/>
	
	<br/>
	
	Roles: <security:authentication property="principal.authorities"/>
	
	<br/>
	
	<hr/>
	
	<form:form
		action="${pageContext.request.contextPath}/logout"
		method="post">
		<input type="submit" value="Logout"
			style="background-color: lightblue; color: darkblue" />
	</form:form>
	
	<security:authorize access="hasRole('CUSTOMER')">
		<p><a href="${pageContext.request.contextPath}/list-sporty-shoes">List Items</a></p>
		<p><a href="${pageContext.request.contextPath}/select-sporty-shoes">Select and Purchase Items</a></p>
 	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<p><a href="${pageContext.request.contextPath}/update-sporty-shoes">Update Items</a></p>
		<p><a href="${pageContext.request.contextPath}/update-sporty-shoes-category">Update Category</a></p>
		<p><a href="${pageContext.request.contextPath}/list-users">List Users</a>
		<p><a href="${pageContext.request.contextPath}/filter-purchase-by-date">Filer Purchases by Date</a></p>
 		<p><a href="${pageContext.request.contextPath}/filter-purchase-by-Category">Filer Purchases by Category</a>
 		<p><a href="${pageContext.request.contextPath}/categorize-products">Categorize Products</a>
		<p><a href="${pageContext.request.contextPath}/init-products">Initialize Products</a>
		<p><a href="${pageContext.request.contextPath}/change-password">Change Password</a>
	</security:authorize>
	
</body>
</html>