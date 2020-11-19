
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
		<table class="table table-striped table-bordered">

			<tr>
				<td>Name/td>
				<td>Email</td>
				<td>Gender</td>
				<td>PhoneNumber</td>
			  
				<td>Address</td>
				<td>Password</td>
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
						HREF="${pageContext.request.contextPath}/deleteCustomerbyEmp/?id=${customer.id}">Delete</A></td> 
				<td><A
						HREF="${pageContext.request.contextPath}/editCustomerbyEmp/?id=${customer.id}">Edit</A></td>
				</tr>
			</c:forEach>
		</table>
		<h3>Create Customer</h3>

		<form:form action="${pageContext.request.contextPath}/createCustmerbyEmp/"
			cssClass="form-horizontal" method="post" modelAttribute="customer">
			
			<div class="form-group">
				<label for="name" class="col-md-3 controllabel">Name</label>
				<div class="col-md-9">
					<form:input path="name" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="email" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="gender" class="col-md-3 controllabel">Gender</label>
				<div class="col-md-9">
					<form:input path="gender" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="phone_number" class="col-md-3 controllabel">PhoneNumber</label>
				<div class="col-md-9">
					<form:input path="phone_number" cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="address" class="col-md-3 controllabel">Address</label>
				<div class="col-md-9">
					<form:input path="address" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-md-3 controllabel">Password</label>
				<div class="col-md-9">
					<form:input path="password" cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Submit</form:button>
				</div>
			</div>
			
		</form:form>

	</div>
</body>
</html>