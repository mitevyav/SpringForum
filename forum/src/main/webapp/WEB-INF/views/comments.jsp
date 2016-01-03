<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comments</title>

	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
	<link rel="stylesheet" href="<spring:url value="/resources/css/custom.css"/>" type="text/css"/>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resources/js/global.js"/>"></script>

</head>
<body>
<jsp:include page="../views/fragments/header.jsp"></jsp:include>
<div class="container">
	
	<div class="panel panel-primary">
  		<div class="panel-heading">
    		<h3 class="panel-title">${topic.subject}</h3>
  		</div>
 		 <div class="panel-body">
 		 	<p class="lead">${topic.description}</p>
 		 	<p class="text-right">${topic.user}</p>
    		<p class="text-right date">${topic.date}</p>
  		</div>
	</div>
	
	
	<c:forEach items="${comments}" var="comment">
		<div class="media">
			<img class="media-object pull-left" src="${pageContext.servletContext.contextPath}/resources/images/user.gif">
			<div class="media-body">
				<h4 class="media-heading">${comment.user}</h4>
				<p>${comment.content}</p>
				 <p class="text-right date">${comment.date}</p>
			</div><!-- end of "media-body" -->
		</div><!-- end of "media" -->
	</c:forEach>
	
	
	
	
		
		
		<nav>
			  <ul class="pagination">
			    <li>
			      <a href="#" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <li><a href="#">1</a></li>
			    <li><a href="#">2</a></li>
			    <li><a href="#">3</a></li>
			    <li><a href="#">4</a></li>
			    <li><a href="#">5</a></li>
			    <li>
			      <a href="#" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			
		<div class="row">
		
			<form class="col-md-8 col-md-offset-2" method="post">
			
				<div class="form-group">
					<label for="comment">Comment: </label>
					<textarea class="form-control" placeholder="Your comment here..." rows="5" name="content"></textarea>
				</div>
				
				<sec:csrfInput/>
				<button type="submit"  class="btn btn-lg btn-primary btn-block">Submit</button>
	
			</form>
			
			
			
		</div>
		
		
	</div>
</body>
</html>