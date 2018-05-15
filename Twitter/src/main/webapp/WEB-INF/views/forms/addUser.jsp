<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>

	<h1>Welcome. Add user here:</h1>

	<form:form method="POST" modelAttribute="user">
		<h2>Input data:</h2>
		First name:<form:input path="firstName" />
		Last name:<form:input path="lastName" />
		Email:<form:input path="email" />
		<br>
		<input type="submit" value="save">
	</form:form>

	<a href="${contextPath}/home"><button>Home</button></a>

</body>
</html>