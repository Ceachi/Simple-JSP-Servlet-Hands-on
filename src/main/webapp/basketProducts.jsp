<h3>Your basket:</h3>

<!-- 
<c:forEach var="i" begin="0" end="${basketProducts.size() - 1}">

	<c:set var="basketProduct" scope="page" value="${basketProducts.get(i)}"/>  
	  
   	<p>
   		
   		Name: <b>${basketProduct.label }</b>
   		Description:<span>${basketProduct.description}</span> 
   	</p>
</c:forEach>  
-->


<c:forEach var="i" begin="0" end="${basketProducts.size() - 1}">

	<c:set var="basketProduct" scope="page" value="${basketProducts.get(i)}"/>  
	  <form action="basket" method="POST">
	  
	  		<p>
		   		
		   		Name: <b>${basketProduct.label }</b>
		   		Description:<span>${basketProduct.description}</span> 
		   	</p>
		   	<input type="hidden" name="id" value="${basketProduct.id}"/>
			<input type="hidden" name="label" value="${basketProduct.label}"/>
			<input type="hidden" name="description" value="${basketProduct.description}"/>
			<input type="hidden" name="delete_product" value="DeleteProduct"/>
		   	
		   	<input type="submit"  value="Delete" />
   		</form>
</c:forEach>  
