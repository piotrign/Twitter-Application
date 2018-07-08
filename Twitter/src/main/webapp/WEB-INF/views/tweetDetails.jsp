<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweet title ${tweet.title}</title>
</head>
<body>

	<a href="${contextPath}/tweet/add"><button>Tweet!</button></a>
	<a href="${contextPath}/login"><button>Logout</button></a>
	<a href="${contextPath}/home"><button>Home</button></a>
	
	<table border="2">
		<thead>
			<tr>
				<td>ID</td>
				<td>Title</td>
				<td>Tweet Text</td>
				<td>Created</td>
				<td>Updated</td>
				<td>Action</td>
			</tr>
		</thead>
			<tr>
				<td>${tweet.id}</td>
				<td>${tweet.title}</td>
				<td>${tweet.textBox}</td>
				<td>${tweet.created}"</td>
				<td>${tweet.updated}"</td>
				<td><a href="${contextPath}/tweet/edit/${tweet.id}">Edit</a></td>
				<td><a href="${contextPath}/tweet/edit/${tweet.id}">Comment</a></td>
			</tr>
	</table>
	
	
</body>
</html>