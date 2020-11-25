
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Payment</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
	<link href="<c:url value="/static/css/restaurantReservation.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

	<div class="container">

        	
		<h2>Create Payment form</h2>

		<hr />
		<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
	
	

		
			<form:form action="${pageContext.request.contextPath}/confirmcreatePayment/"
			cssClass="form-horizontal" method="post" modelAttribute="payment">

	
			
			<div class="form-group">
				<label for="custEmail" class="col-md-3 controllabel">Email</label>
				<div class="col-md-9">
					<form:input path="custEmail" value="${payment.custEmail}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="date" class="col-md-3 controllabel">Date</label>
				<div class="col-md-9">
					<form:input path="date" value="${payment.date}" readonly ="true" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="amount" class="col-md-3 controllabel">Amount</label>
				<div class="col-md-9">
					<form:input path="amount" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group">
				<label for="taxrate" class="col-md-3 controllabel">Tax Rate</label>
			
					<div class="col-md-9">	
								<form:select path ="taxrate" name="taxrate">
    <form:option value=".12">12%</form:option>
   <form:option value=".10">10%</form:option>>
     
    </form:select>
		</div>
			</div>
			
			
			
			
			
		
			<div class="form-group">
				<label for="type" class="col-md-3 controllabel">Type</label>
			<div class="col-md-9">	
		<form:select path ="type" name="type">
    <form:option value="waiting">Waiting For Payment</form:option>
   <form:option value="paid">Payment Received</form:option>>
     
    </form:select>
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