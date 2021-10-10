<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="ISO-8859-1">
<title>Sporty Shoes Login Plain</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Reference Bootstrap files -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script><%!%>
</head>
<body>
	<h1>Sporty Shoes Login Plain</h1>
	<div>
		<form:form
			action="${pageContext.request.contextPath}/authenticateTheUser"
			method="post">

			<c:if test="${param.error != null}">
				<div style="color: red; padding: 25px 25px 25px 25px;">Invalid
					login</div>
			</c:if>

			<c:if test="${param.logout != null}">
				<div>You have been logged out</div>
			</c:if>

			<input type="text" name="username" placeholder="username">
			<input type="password" name="password" placeholder="password">
			<input type="submit" value="Login">
		</form:form>
		
	</div>

	
</body>
</html>