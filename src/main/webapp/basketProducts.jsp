<h3>Your basket:</h3>
<c:forEach var="i" begin="0" end="${basketProducts.size() - 1}">

	<c:set var="basketProduct" scope="page" value="${basketProducts.get(i)}"/>  
	  
   	<p>
   		
   		ID:<b>${basketProduct.id}</b><br/>
   		<span>${basketProduct.description}</span> 
   	</p>
   	
</c:forEach>  


