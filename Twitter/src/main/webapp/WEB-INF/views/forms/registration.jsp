<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
</head>
<body>
	<a href="${contextPath}/home"><button>Home</button></a>
	<a href="${contextPath}/login"><button>Login</button></a>
	<a href="${contextPath}/tweet/add"><button>Send tweet</button></a>
	<br>
	<br>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	
	<h2>Registration form</h2>
	
	<c:if test="${errorMessage != null}">
		<div><h3>Error</h3>
			<p>${errorMessage}</p>
		</div>
	</c:if>
	
	<form:form method="POST" modelAttribute="user">
		Name: <form:input path="name"/><br>
		<form:errors path="name" cssClass="error" element="div"/>
		
		Last name: <form:input path="lastName"/><br>
		<form:errors path="lastName" cssClass="error" element="div"/>
		
		E-mail address: <form:input path="email"/><br>
		<form:errors path="email" cssClass="error" element="div"/>
			
		Password: <form:password path="password"/><br>
		<form:errors path="password" cssClass="error" element="div"/>
		
		<input type="submit" value="Register" />
		<input type="reset" value="Reset the form" />
	</form:form>
	<br>
</body>
</html>
</body>
</html>