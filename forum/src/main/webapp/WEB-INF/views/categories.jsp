<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>

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
	    <h3 class="panel-title">Movies</h3>
	  </div>
	  <table class="table table-bordered table-striped">
			  <tr>
			    <th>Category</th>
			    <th>Topics</th>
			    <th>Comments</th>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${Action.id}"></spring:url>'>Actions</a></td>
			    <td>${Action.topicsCount}</td>
			    <td>${Action.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${Fantasy.id}"></spring:url>'>Fantasy</a></td>
			    <td>${Fantasy.topicsCount}</td>
			    <td>${Fantasy.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${Adventure.id}"></spring:url>'>Adventure</a></td>
			    <td>${Adventure.topicsCount}</td>
			    <td>${Adventure.commentsCount}</td>
			  </tr>
			</table>
	</div>
	
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">Music</h3>
	  </div>
	  <table class="table table-bordered table-striped">
			  <tr>
			    <th>Category</th>
			    <th>Topics</th>
			    <th>Comments</th>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${RnB.id}"></spring:url>'>RnB</a></td>
			    <td>${RnB.topicsCount}</td>
			    <td>${RnB.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${HipHop.id}"></spring:url>'>Hip Hop</a></td>
			    <td>${HipHop.topicsCount}</td>
			    <td>${HipHop.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${Pop.id}"></spring:url>'>Pop</a></td>
			    <td>${Pop.topicsCount}</td>
			    <td>${Pop.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${Rock.id}"></spring:url>'>Rock</a></td>
			    <td>${Rock.topicsCount}</td>
			    <td>${Rock.commentsCount}</td>
			  </tr>
			   <tr>
			    <td><a href='<spring:url value="/topic/${Blues.id}"></spring:url>'>Blues</a></td>
			    <td>${Blues.topicsCount}</td>
			    <td>${Blues.commentsCount}</td>
			  </tr>
			   <tr>
			    <td><a href='<spring:url value="/topic/${Jazz.id}"></spring:url>'>Jazz</a></td>
			    <td>${Jazz.topicsCount}</td>
			    <td>${Jazz.commentsCount}</td>
			  </tr>
			</table>
	</div>
	
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">Football</h3>
	  </div>
	  <table class="table table-bordered table-striped">
			  <tr>
			    <th>Category</th>
			    <th>Topics</th>
			    <th>Comments</th>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${LaLiga.id}"></spring:url>'>La Liga</a></td>
			    <td>${LaLiga.topicsCount}</td>
			    <td>${LaLiga.commentsCount}</td>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${EPL.id}"></spring:url>'>EPL</a></td>
			    <td>${EPL.topicsCount}</td>
			    <td>${EPL.commentsCount}</td>
			  </tr>
			</table>
	</div>
	
	<div class="panel panel-primary">
	  <div class="panel-heading">
	    <h3 class="panel-title">MMA</h3>
	  </div>
	  <table class="table table-bordered table-striped">
			  <tr>
			    <th>Category</th>
			    <th>Topics</th>
			    <th>Comments</th>
			  </tr>
			  <tr>
			    <td><a href='<spring:url value="/topic/${UFC.id}"></spring:url>'>UFC</a></td>
			    <td>${UFC.topicsCount}</td>
			    <td>${UFC.commentsCount}</td>
			  </tr>
	</table>
	</div>
	
</div>



</body>
</html>