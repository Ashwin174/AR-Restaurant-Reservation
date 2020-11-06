<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AR Restaurant</title>
<link href="<c:url value="/static/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/static/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/static/js/bootstrap.min.js" />"></script>
</head>
<body>
	<h2>AR Restaurant</h2>

	<c:if test="${ message !=null }">
		<div class="alert alert-success" role="alert">${message}</div>
	</c:if>
<h4>Welcome &nbsp;${currEmployee.name} </h4>
<h5>Employee Details</h5>
	<h7>${currEmployee.Displ()}</h7>

      <div style="display:inline;">
      
		<form:form action="${pageContext.request.contextPath}/editEmployee"
			cssClass="form-horizontal" method="post" modelAttribute="currEmployee">
	

				<div >
					<form:button cssClass="btn btnprimary">Edit the Profile</form:button>
				</div>
			
	
		</form:form>


		<form:form
			action="${pageContext.request.contextPath}/employeeReservation"
			cssClass="form-horizontal" method="post" modelAttribute="currEmployee">
	
		
	
				<div >
					<form:button cssClass="btn btnprimary">Reserve Your Seat</form:button>
				</div>
		
	
		</form:form>



	<form:form action="${pageContext.request.contextPath}/showCustomers"
		cssClass="form-horizontal" method="post" modelAttribute="currEmployee">


		<div class="form-group">

			<div class="col-md-offset-3 col-md-9">
				<form:button cssClass="btn btnprimary">Customer List</form:button>
			</div>
		</div>



	</form:form>

	<form:form action="${pageContext.request.contextPath}/logout"
		cssClass="form-horizontal" method="post" modelAttribute="currEmployee">





		<div class="form-group">

			<div class="col-md-offset-3 col-md-9">
				<form:button cssClass="btn btnprimary">Logout</form:button>
			</div>
		</div>



	</form:form>
	
	</div>

	<c:if test="${ error !=null }">
		<div class="alert alert-success" role="alert">${error}</div>
	</c:if>

</body>
</html>