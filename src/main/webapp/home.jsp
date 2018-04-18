<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="error.jsp" %> 

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>My Online Shop</title>
	</head>
	
	<body>
	 <h2> For learning purpose: </h2>
	 
	 
	<form action="Add" method="POST">
		First Name: <input type="text" name="t1"><br>
		Last Name: <input type= "text" name="t2"><br>
		<input type="submit" value="Add">
	</form>
	
	
	
		<%@ include file="header.jsp" %>
		
	    <!--   <a href="goods.jsp" style="text-decoration:none">Buy Goods</a> -->
	    <a href="<c:url value="/goods" />" >Buy Goods</a>
	    
	    
	    <%@ include file="products.jsp" %>  
	    
	    
	</body>
</html>
