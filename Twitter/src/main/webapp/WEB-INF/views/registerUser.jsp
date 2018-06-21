<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>
	<a href="${contextPath}/home"><button>Home</button></a>
	<a href="${contextPath}/login"><button>Login</button></a>
	<a href="${contextPath}/tweet/add"><button>Send tweet</button></a>
	<br>
	<br>
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

		<form:form method="POST" modelAttribute="user">
			<div class="container">
				Username: <form:input path="userName" placeholder="Enter Username"/>
				<form:errors path="userName" cssClass="error" element="div"/>
	
				E-mail address: <form:input path="email" placeholder="Enter E-mail"/>
				<form:errors path="email" cssClass="error" element="div"/>
		
				Password: <form:password path="password" placeholder="Enter Password"/>
				<form:errors path="password" cssClass="error" element="div"/>

			</div>
			 <div class="container">
				<input class="btn btn-success" type="submit" value="Register" />
				<input class="btn btn-danger" type="reset" value="Reset the form" />
			</div>
		</form:form>
</body>
</html>
</body>
</html>