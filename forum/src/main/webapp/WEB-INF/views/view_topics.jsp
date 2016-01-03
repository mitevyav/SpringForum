<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib  uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Topics</title>

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
  <!-- Default panel contents -->
  <div class="panel-heading">Category Name</div>
 
	 	<table class="table table-bordered table-striped">
		  <tr>
		    <th>Topic Name</th>
		    <th>Author</th>
		    <th>Date</th>
		  </tr>
		  <c:forEach items="${topics}" var="topic">
		  <tr>
		    <td><a href='<spring:url value="/comments/${topic.id}"></spring:url>'>${topic.subject} </a><span class="badge">${topic.commentsCount}</span></td>
		    <td>${topic.user}</td>
		    <td><p class="text-right date">${topic.date}</p></td>
		  </tr>
		  </c:forEach>
		</table>
	</div>

 
 <div class="row">
		
			<form class="col-md-8 col-md-offset-2" method="post">
				
				<div class="form-group">
					<label for="comment">Topic Subject</label>
					<textarea class="form-control"  name="subject"></textarea>
				</div>
				
				<div class="form-group">
					<label for="comment">Description</label>
					<textarea class="form-control"  rows="4" name="description"></textarea>
				</div>
				
				<sec:csrfInput/>
				
				<button type="submit"  class="btn btn-lg btn-primary  btn-block">Submit</button>
	
			</form>
			
			
			
		</div>
</div>		
</body>
</html>