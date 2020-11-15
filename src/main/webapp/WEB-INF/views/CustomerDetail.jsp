
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Students</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">

		<h1>Customer List</h1>
		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		
       <form:form action="${pageContext.request.contextPath}/gottoCustMainPage"
			cssClass="form-horizontal" method="post" modelAttribute="currCustomer">
				
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Return Main Page </form:button>
				</div>
			</div>
					
			
		</form:form>
		
		
		<table class="table table-striped table-bordered">




			<tr>
				<td>Name</td>
				<td>Email</td>
				<td>Gender</td>
				<td>PhoneNumber</td>
			 	<td>Address</td>
				<td>Password</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.gender}</td>
					<td>${customer.phone_number}</td>
					<td>${customer.address}</td>
			        <td>${customer.password}</td>
				 	<td><A
						HREF="${pageContext.request.contextPath}/deleteCustomer/?id=${customer.id}">Delete</A></td> 
				<td><A
						HREF="${pageContext.request.contextPath}/editCustomeremp/?id=${customer.id}">Edit</A></td>
				</tr>
			</c:forEach>
		</table>
	

	</div>
</body>
</html>