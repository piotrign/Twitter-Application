<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Comment tweet</title>
</head>
<body>

<a href="${contextPath}/home"><button>Return to main page</button></a>
<br>
<br>
<table border="2">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Tweet Text</td>
				<td>Created</td>
				<td>Updated</td>
			</tr>
		</thead>
			<tr>
				<td>${tweet.id}</td>
				<td>${tweet.title}</td>
				<td>${tweet.textBox}</td>
				<td>${tweet.created}"</td>
				<td>${tweet.updated}"</td>
			</tr>
	</table>
<br>
<h1>Comment:</h1>
<br>
	<form:form method="POST" modelAttribute="comment">
		Type comment here:<form:input path="commentText" />
		<br>
		<input type="submit" value="save">
	</form:form>
</body>
</html>