<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign In</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/custom.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/js/global.js"/>"></script>

</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">
<c:url value="/sign/sign_in" var="signVar"/>
<form class="form-signin col-md-4 col-md-offset-4" method="POST" action="${signVar}">
        <h2 class="form-signin-heading">Please sign in</h2>
        <div class="form-group">
	        <label for="user" class="sr-only">Username</label>
	        <input type="text" id="user" class="form-control" placeholder="Username" name="username">
        </div>
        <div class="form-group">
	        <label for="inputPassword" class="sr-only">Password</label>
	        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password">
        </div>
        <div class="form-group">
          	<label for="remember"> Remember me </label>
            <input type="checkbox" id="remember" name="remember-me"> 
        </div>
        <sec:csrfInput/>
        <c:if test="${param.error != null}">
        	<p class="red">Invalid Username and Password</p>
        </c:if>
        <c:if test="${param.signout != null}">
        	<p class="red">You have successfully sign out!</p>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>
</div>
<div id="sign_up" class="container col-md-4 col-md-offset-5">
<p>New to forum? <a href="<spring:url value="/sign/sign_up"/>">Sign Up here!</a></p>
</div>
</body>
</html>