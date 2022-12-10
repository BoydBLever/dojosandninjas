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
    <title>New Ninja</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
  <form:form action="/ninjas/new" method="POST" modelAttribute="newNinja">
  <p>
        <form:label path="firstName">First Name:</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
       <p>
        <form:label path="lastName">Last Name:</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
     <p>
        <form:label path="age">Age: (18+)</form:label>
        <form:errors path="age"/>
        <form:input type="number" path="age"/>
    </p>
    <p>
    <form:label path="dojo">Dojo:</form:label>
    <!-- THE CODE BELOW WILL NOT BE HERE AFTER AUTH -->
    <form:select path="dojo">
    	<c:forEach var="eachDojo" items="${dojoList}">
    	<form:option value="${eachDojo.id}">${eachDojo.name}</form:option>
    	</c:forEach>
    </form:select>
    <form:errors path="dojo"/>
    </p>
    <button type="submit">Add new ninja</button>
</form:form>
</body>
</html>