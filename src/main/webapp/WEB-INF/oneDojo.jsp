<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>One Dojo</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
   <div>
<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Dojo</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="eachDojo" items="${dojoList }">
			<tr>
				<td> <a href="/dojos/${eachDojo.id }">${eachDojo.name}</a></td>
				
				<td> <c:out value="${eachNinja.firstName }"/></td>
				<td> <c:out value="${eachNinja.lastName }"/></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>