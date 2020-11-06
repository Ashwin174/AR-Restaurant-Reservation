<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome </title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>

<h2>Restaurant Reservation - Home Page</h2>


<c:if test="${ message !=null }">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		
		
		<h4>Welcome &nbsp;${currCustomer.name} </h4>
		
		<h5>Customer Details</h5>
		<h7>${currCustomer.Displ()}</h7><br>
	
		
		<form:form action="${pageContext.request.contextPath}/editCustomer"
			cssClass="form-horizontal" method="post" modelAttribute="currCustomer">
		
			
		
			
			
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Edit Profile</form:button>
				</div>
			</div>
			
			
			
		</form:form>
		
		
				<form:form action="${pageContext.request.contextPath}/customerReservation"
			cssClass="form-horizontal" method="post" modelAttribute="currCustomer">
		
			
		
			
			
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Make Reservation</form:button>
				</div>
			</div>
			
			
			
		</form:form>
		
		
				<form:form action="${pageContext.request.contextPath}/logout"
			cssClass="form-horizontal" method="post" modelAttribute="currCustomer">
		
			
		
			
			
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Log Out</form:button>
				</div>
			</div>
			
			
			
		</form:form>
		
		<c:if test="${ error !=null }">
			<div class="alert alert-success" role="alert">${error}</div>
		</c:if>

</body>
</html>