
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
<h2> &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome to AR Restaurant</h2>

<h2>Employee Login</h2>
<form:form action="${pageContext.request.contextPath}/empLogin"
			cssClass="form-horizontal" method="post" modelAttribute="login">
		
			<div class="form-group">
				<label for="email" class="col-md-3 controllabel">Email:</label>
			    <form:input path="email" cssClass="form-control" />

			</div>
			
			<div class="form-group">
				<label for="password" class="col-md-3 controllabel">  Password:</label>
					<form:input path="password" type="password" cssClass="form-control" />
				
			</div>
			
		
			
			
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Submit</form:button>
				</div>
			</div>
			
			
			
		</form:form>
		<form:form action="${pageContext.request.contextPath}/createEmployee"
			cssClass="form-horizontal" method="post" modelAttribute="login">
		
			
		
			
			
			<div class="form-group">

				<div class="col-md-offset-3 col-md-9">
					<form:button cssClass="btn btnprimary">Register</form:button>
				</div>
			</div>
			
			
			
		</form:form>
		
		
		<c:if test="${ error !=null }">
			<div class="alert alert-success" role="alert">${error}</div>
		</c:if>

</body>
</html>