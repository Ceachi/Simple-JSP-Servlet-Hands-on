package com.company.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.shop.model.ProductDto;

/**
 * Servlet implementation class BasketController
 */
@WebServlet("/basket")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String BASKET_VIEW= "basket.jsp";
	
	static List<ProductDto> basketProducts;
	
	List<ProductDto> getInstance() {
		if(basketProducts==null) {
			return new ArrayList<ProductDto>();		
		}
	return basketProducts;
	}
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		this.printBasket();// in console
		if(basketProducts.size() == 0) {
			 PrintWriter out  = response.getWriter();
			 out.print("No products");
		}else {
			request.setAttribute("basketProducts", basketProducts);
			// Forward to home page
			RequestDispatcher dispatcher = request.getRequestDispatcher(BASKET_VIEW);
			dispatcher.forward(request, response);
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		basketProducts = this.getInstance();
		ProductDto newProduct = new ProductDto();
		
		String delete = request.getParameter("delete_product");
		
		// if the parameter is to delete a product:
		if(delete != null && delete.equals("DeleteProduct")) {
			this.printBasket();
			int id = Integer.parseInt(request.getParameter("id"));
			for (Iterator<ProductDto> iter = basketProducts.iterator(); iter.hasNext(); ) {
				ProductDto product = iter.next();
			    if (product.getId() == id) {
			        iter.remove();
			    }
			}		
			this.printBasket();
			
			response.sendRedirect("goods");
		}else {// add a new product
		
			
			// fetch data from request
			int id = Integer.parseInt(request.getParameter("id"));
			String label = request.getParameter("label");
			String description = request.getParameter("description");
			
			
			//construct your new product
			newProduct.setId(id);
			newProduct.setLabel(label);
			newProduct.setDescription(description);
			
			// add product to list
			basketProducts.add(newProduct);
			
			System.out.println("ai adaugat un produs" + newProduct.toString());
			response.sendRedirect("goods");
		}
	}
	
	
	void printBasket() {
		System.out.println("Your basket is: ");
		for(ProductDto product:basketProducts) {
			System.out.println(product.toString());
		}
	}

}
