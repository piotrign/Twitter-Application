<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>

</head>

<body>
	<a href="${contextPath}/home"><button>Main page</button></a>
	<br> 
	To register use following link:
	<a href="${contextPath}/register-user"><button>Register</button></a>
	<br>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />


	<h2>Provide your credentials:</h2>

	<c:if test="${errorMessage != null}">
		<div>
			<h3>Error</h3>
			<p>${errorMessage}</p>
		</div>
	</c:if>

	<form method="POST" action="#">
		<table border=1>
			<tr>
				<th>Email:</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td colspan="1"><input type="submit" name="submitButton"
					value="Log in"></td>
			</tr>
		</table>
	</form>

</body>

</html>