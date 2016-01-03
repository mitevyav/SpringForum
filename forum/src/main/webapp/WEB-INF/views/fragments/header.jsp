<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<div class="navbar-header">
	      			<a class="navbar-brand" href="#">Forum</a>
	    		</div>
	    		<ul class="nav navbar-nav">
	    			<li><a href="<spring:url value="/"/>">Home</a></li>
	    			<li><a href="<spring:url value="/categories"/>">Categories</a></li>
	    			<li><a href="<spring:url value="/about"/>">About</a></li>
	    		</ul>
	    		
	    		<ul class="nav navbar-nav navbar-right">
	    			<li class="dropdown">
	    				<a href="#" class="dropdown-toggle" data-toggle="dropdown">
	    					<span class="glyphicon glyphicon-user" aria-hidden="true"></span> Sign In <b class="caret"></b>
	    				</a>
	    				<ul class="dropdown-menu">
	    					<li>
	    						<a href="<spring:url value="/sign/sign_in"/>">Sign In</a>						
	    					<li/>
	    					<li>
	    						<a id="signout" href="#">Sign Out</a>	
	    						<form id="signout-form" action="<spring:url value="/sign/sign_out"/>" method="POST">
	    							<sec:csrfInput/>
	    						</form>    							
	    					<li/>
	    					<li>
	    						<a href="<spring:url value="/sign/sign_up"/>">Sign Up</a>					
	    					<li/>
	    				</ul>
	    			</li>			
	    		</ul>
	    		
	    	 		
    		</div>	
		</div>
</nav>
</div>