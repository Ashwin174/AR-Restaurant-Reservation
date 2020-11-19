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
	<link href="<c:url value="/static/css/restaurantReservation.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
<%@ page isELIgnored="false"%>
</head>
<body>
	<div class="container">
		
			<h1>Edit Employee - ${currEmployee.name}</h1>
			<hr />

		<form:form action="${pageContext.request.contextPath}/confirmempEdit/"
			cssClass="form-horizontal" method="post" modelAttribute="currEmployee">
			
			<div class="form-group">
				
				<div class="col-md-9">
					<form:input path="id" value ="${currEmployee.id}" readonly="true" cssClass="form-control" />
				</div>
			</div>
			
			
			
			
			
			
			
			
			
			
			<div class="form-group">
				<label for="name" class="col-md-3 controllabel">Name</label>
				<div class="col-md-9">
					<form:input path="name" value ="${currEmployee.name}" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="email" value ="${currEmployee.email}"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="gender" class="col-md-3 controllabel">Gender</label>
				<div class="col-md-9">
					<form:input path="gender" value ="${currEmployee.gender}"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="phone_number" class="col-md-3 controllabel">PhoneNumber</label>
				<div class="col-md-9">
					<form:input path="phone_number" value ="${currEmployee.phone_number}"  cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="department" class="col-md-3 controllabel">Department</label>
				<div class="col-md-9">
					<form:input path="department" value ="${currEmployee.department}"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-md-3 controllabel">Address</label>
				<div class="col-md-9">
					<form:input path="address" value ="${currEmployee.address}"  cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-md-3 controllabel">Password</label>
				<div class="col-md-9">
					<form:input path="password" value ="${currEmployee.password}"  cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button Class="btn btn-secondary">Submit</form:button>
				</div>
			</div>
			
		</form:form>
			
		</div>
		


</body>
</html>
