
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

		<h1>Reservation Details</h1>
		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		
       <form:form action="${pageContext.request.contextPath}/gottoCustMainPage"
			cssClass="form-horizontal" method="post" modelAttribute="customer">
				
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
			
				<td>PhoneNumber</td>
			 	<td>Time</td>
				<td>Reservation Date</td>
				<td>Number of People</td>
				<td>Status</td>
				
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
				 
				</tr>
			</c:forEach>
		</table>
		
		
		<form:form action="${pageContext.request.contextPath}/createReservation/"
			cssClass="form-horizontal" method="post" modelAttribute="reservation">

	
			
			<div class="form-group">
				<label for="name" class="col-md-3 controllabel">Name</label>
				<div class="col-md-9">
					<form:input path="name" value="${reservation.name}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="email" value="${reservation.email}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="phone_number" class="col-md-3 controllabel">PhoneNumber</label>
				<div class="col-md-9">
					<form:input path="phone_number" value="${reservation.phone_number}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			
			
			</div>
			<div class="form-group">
				<label for="time" class="col-md-3 controllabel">Time</label>
				<div class="col-md-9">
					<form:input path="time" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="resDate" class="col-md-3 controllabel">Reservation Date</label>
				<div class="col-md-9">
					<form:input path="resDate"  cssClass="form-control" type ="Date"/>
				</div>
			</div>
			
				<div class="form-group">
				<label for="peopleNumber" class="col-md-3 controllabel">Number of People</label>
				<div class="col-md-9">
					<form:input path="peopleNumber" cssClass="form-control" />
				</div>
			</div>
			
				<div class="form-group">
				<label for="status" class="col-md-3 controllabel">Status</label>
				<div class="col-md-9">
					<form:input path="status" value ="${reservation.status}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			
			<div class="form-group">
				<!-- Button -->
				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Reserve Here</form:button>
				</div>
			</div>
			
		</form:form>
		
	

	</div>
</body>
</html>