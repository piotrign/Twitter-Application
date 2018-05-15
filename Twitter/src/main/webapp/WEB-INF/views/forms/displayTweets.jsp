<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweets</title>
</head>
<body>
<h1>List of tweets</h1>
 
 	<table border="1">
 		<thead>
 			<tr>
 				<td>Title</td>
 				<td>Tweet Text</td>
 				<td>Created</td>
 			</tr>
 		</thead>
 		<c:forEach items="${tweets}" var="tweet">
 			<tr>
 				<td><c:out value="${tweet.title}" /></td>
 				<td><c:out value="${tweet.tweetText}" /></td>
 				<td><c:out value="${tweet.created}" /></td>
 			</tr>
 		</c:forEach>
 	</table>
 	<a href="http://localhost:8080/cl.exam6/froms/home">Home page</a>
</body>
</html>