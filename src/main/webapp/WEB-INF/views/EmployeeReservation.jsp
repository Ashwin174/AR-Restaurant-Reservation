
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
</head>
<body>
	<div class="container">

		<h1>Reservation Details</h1>
		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		
       <form:form action="${pageContext.request.contextPath}/ToEmployeeMain"
			cssClass="form-horizontal" method="post" modelAttribute="employee">
				
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button Class="btn btn-secondary">Return Main Page </form:button>
			</div>
			</div>
					
			
		</form:form>
		<h3>Please process the Reservations</h3>
		
		<table class="table table-striped table-bordered">

			<tr>
				<td>Name</td>
				<td>Email</td>
			
				<td>PhoneNumber</td>
			 	<td>Time</td>
				<td>Reservation Date</td>
				<td>Number of People</td>
				<td>Status</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach var="reservation" items="${unproceedList}">
				<tr>
					<td>${reservation.name}</td>
					<td>${reservation.email}</td>
					
					<td>${reservation.phone_number}</td>
					<td>${reservation.time}</td>
			        <td>${reservation.resDate}</td>
			        <td>${reservation.peopleNumber}</td>
			        <td>${reservation.status}</td>
				 	<td><A
						HREF="${pageContext.request.contextPath}/deleteCustomerReservationemp/?id=${reservation.id}">Delete</A></td> 
				<td><A
						HREF="${pageContext.request.contextPath}/editCustomerReservationemp/?id=${reservation.id}">Edit</A></td>
				</tr>
			</c:forEach>
		</table>
		 <h3>Confirmed Reservations</h3>
		<table class="table table-striped table-bordered">

			<tr>
				<td>Name</td>
				<td>Email</td>
			
				<td>PhoneNumber</td>
			 	<td>Time</td>
				<td>Reservation Date</td>
				<td>Number of People</td>
				<td>Status</td>
				<td>Delete</td>
				<td>Edit</td>
			</tr>
			<c:forEach var="reservation" items="${proceedList}">
				<tr>
					<td>${reservation.name}</td>
					<td>${reservation.email}</td>
					
					<td>${reservation.phone_number}</td>
					<td>${reservation.time}</td>
			        <td>${reservation.resDate}</td>
			        <td>${reservation.peopleNumber}</td>
			        <td>${reservation.status}</td>
				 	<td><A
						HREF="${pageContext.request.contextPath}/deleteCustomerReservationemp/?id=${reservation.id}">Delete</A></td> 
				<td><A
						HREF="${pageContext.request.contextPath}/editCustomerReservationemp/?id=${reservation.id}">Edit</A></td>
				</tr>
			</c:forEach>
		</table>
	
		
	

	</div>
</body>
</html>