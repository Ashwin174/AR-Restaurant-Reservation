
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Rservation Details</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">


		<h2>Reservation Edit form</h2>

		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>




		<form:form
			action="${pageContext.request.contextPath}/confirmCustomerReservationemp/"
			cssClass="form-horizontal" method="post" modelAttribute="reservation">

			<div class="col-md-9">
				<form:input path="id" value="${reservation.id}" type="hidden"
					cssClass="form-control" />
			</div>
	</div>

	<div class="form-group">
		<label for="name" class="col-md-3 controllabel">Name</label>
		<div class="col-md-9">
			<form:input path="name" value="${reservation.name}" readonly="true"
				cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="email" class="col-md-3 controllabel">Email</label>
		<div class="col-md-9">
			<form:input path="email" value="${reservation.email}" readonly="true"
				cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="phone_number" class="col-md-3 controllabel">PhoneNumber</label>
		<div class="col-md-9">
			<form:input path="phone_number" value="${reservation.phone_number}"
				readonly="true" cssClass="form-control" />
		</div>
	</div>


	</div>
	<div class="form-group">
		<label for="time" class="col-md-3 controllabel">Time</label>
		<div class="col-md-9">
			<form:input path="time" value="${reservation.time}"
				cssClass="form-control" />
		</div>
	</div>
	<div class="form-group">
		<label for="resDate" class="col-md-3 controllabel">Reservation
			Date</label>
		<div class="col-md-9">
			<form:input path="resDate" value="${reservation.resDate}"
				cssClass="form-control" />
		</div>
	</div>

	<div class="form-group">
		<label for="peopleNumber" class="col-md-3 controllabel">Number
			of People</label>
		<div class="col-md-9">
			<form:input path="peopleNumber" value="${reservation.peopleNumber}"
				cssClass="form-control" />
		</div>
	</div>


	<div class="form-group">
		<label for="status" class="col-md-3 controllabel">Reservation
			status</label>
		<div class="col-md-9">
			<form:select path="status" name="status">

				<form:option value="waiting">Waiting for Confirmation</form:option>>
                <form:option value="confirm">Reservation Confirmed</form:option>>
    
             </form:select>
		</div>
	</div>


	<div class="form-group">
		<!-- Button -->
		<div class="col-md-offset-3 col-md-9">
			<form:button cssClass="btn btnprimary">Edit and Submit</form:button>
		</div>
	</div>

	</form:form>

	</div>
</body>
</html>