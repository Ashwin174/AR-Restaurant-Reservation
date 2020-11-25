
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

		<h1>Payment Management</h1>
		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		
       <form:form action="${pageContext.request.contextPath}/gottoEmpMainPage"
			cssClass="form-horizontal" method="post" modelAttribute="currEmployee">
				
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button Class="btn btn-secondary">Return Main Page </form:button>
				</div>
			</div>
					
			
		</form:form>
		
		
		<h3>Confirmed Reservation List</h3>
		<table class="table table-striped table-bordered">

			<tr>
				<td>Name</td>
				<td>Email</td>	
				<td>PhoneNumber</td>
			 	<td>Time</td>
				<td>Reservation Date</td>
				<td>Number of People</td>
				<td>Status</td>
				<td>Make Payment</td>
				
			</tr>
			<c:forEach var="reservation" items="${reservationList}">
				<tr>
				  <td>${reservation.name}</td>
					<td>${reservation.email}</td>
					<td>${reservation.phone_number}</td>
					<td>${reservation.time}</td>
			        <td>${reservation.resDate}</td>
			        <td>${reservation.peopleNumber}</td>
			        <td>${reservation.status}</td>
			     
			     	<td><A
						HREF="${pageContext.request.contextPath}/createPayment/?id=${reservation.id}">Make Payment</A></td>   
				 
				</tr>
			</c:forEach>
		</table>
		
	
	
	<h3>List of Payments Waiting for Pay</h3>
		<table class="table table-striped table-bordered">

			<tr>
				<td> ID</td>
				<td>Customer Email</td>	
				<td>Date</td>
			 	<td>Amount</td>
				<td>Tax rate</td>
				<td>Total</td>
				<td>Type</td>
				
				
			</tr>
			<c:forEach var="payment" items="${waitingPaymentList}">
				<tr>
				  <td>${payment.id}</td>
					<td>${payment.custEmail}</td>
					<td>${payment.date}</td>
					<td>${payment.amount}</td>
			        <td>${payment.taxrate}</td>
			        <td>${payment.total}</td>
			        <td>${payment.type}</td>
			     
			     	
				 
				</tr>
			</c:forEach>
		</table>
	
	
	<h3>List of Payment Received</h3>
		<table class="table table-striped table-bordered">

		<tr>
				<td> ID</td>
				<td>Customer Email</td>	
				<td>Date</td>
			 	<td>Amount</td>
				<td>Tax rate</td>
				<td>Total</td>
				<td>Type</td>
				
				
			</tr>
			<c:forEach var="payment" items="${receivedList}">
				<tr>
				  <td>${payment.id}</td>
					<td>${payment.custEmail}</td>
					<td>${payment.date}</td>
					<td>${payment.amount}</td>
			        <td>${payment.taxrate}</td>
			        <td>${payment.total}</td>
			        <td>${payment.type}</td>
			     
			     	
				 
				</tr>
			</c:forEach>
		</table>
	
		
	

	</div>
</body>
</html>