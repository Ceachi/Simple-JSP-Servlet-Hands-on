<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page errorPage="error.jsp" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Available Products</title>
</head>
<body>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
		<h2> Select your goods</h2>
		
		
		<h3>Available offerings:</h3>

		<c:forEach var="i" begin="0" end="${products.size() - 1}">

			<c:set var="product" scope="page" value="${products.get(i)}"/>  
			
				 <form action="basket" method="POST"> 
				 	<input type="hidden" name="id" value="${product.id}"/>
				   	<p>
				   		<b>${product.label}</b><br/>
				   		<span>${product.description}</span> 
				   	</p>
				   	
				   	<input type="submit" value="Submit"/>
			   	
			   	</form>
   	
		</c:forEach>  
		<a href="<c:url value="/basket" />" >Show Basket</a>
		
		
		
</body>
</html>