<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Topic</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/custom.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/js/global.js"/>"></script>

</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container create_user">
			<form class="col-md-4 col-md-offset-4" method="post">
				<h2>Sign Up!</h2>
				<div class="form-group">
					<label for="user">Username</label>
					<input id="user" type="text" 
							class="form-control" name="username"/>
				<c:if test="${param.exist != null}">
        			<p class="red">There is such user name</p>
       			 </c:if>
				</div>
				
				<div class="form-group">
					<label for="pass">Password</label>
					<input id="pass" type="password" 
							class="form-control" name="password"/>
				</div>
				
				<div class="form-group">
					<input id="pass2" type="password" 
							class="form-control" name="password2"/>
				</div>
				<div class="registrationFormAlert" id="divPasswordsMatch"></div>
			
				<sec:csrfInput/>
			
				<button id="signUpButton" type="submit" class="btn btn-lg btn-primary btn-block">Submit</button>
	
			</form>
			
</div>
</body>
</html>