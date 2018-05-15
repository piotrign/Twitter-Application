<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Home Page</title>
</head>
<body>
	<h1>Welcome in Content Management System</h1>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
	<h2>Categories:</h2>
     <p>
         <c:forEach items="${categoryOptions}" var="category">
             <a href=""><c:out value="${category.name}"/></a> ||
         </c:forEach>
     </p>
	
	<h2>Latest articles</h2>
	<table border=1>
		<c:forEach begin="0" end="4" items="${articles}" var="article">
			<tr>
				<td><b>Title:</b> ${article.title} <b>added:</b>
					${article.created}</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<c:set var="shortDesc" value="${fn:substring(article.content, 0, 200)}" />
				<td>${shortDesc}</td>
			</tr>
			<br>
			<br>
		</c:forEach>
	</table>

</body>
</html>