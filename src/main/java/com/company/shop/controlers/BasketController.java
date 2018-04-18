package com.company.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		PrintWriter out  = response.getWriter();
	    out.print("Salutare");    
	    System.out.println("Produsele tale sunt: ");
	    for(ProductDto obj : basketProducts) {
	    	System.out.println(obj.getId());
	    }
		request.setAttribute("basketProducts", basketProducts);
		
		// Forward to home page
		RequestDispatcher dispatcher = request.getRequestDispatcher(BASKET_VIEW);
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		basketProducts = this.getInstance();
		ProductDto newProduct = new ProductDto();
		
		// fetch data from request
		int id = Integer.parseInt(request.getParameter("id"));
		
		//construct your new product
		newProduct.setId(id);
		
		// add product to list
		basketProducts.add(newProduct);
		
		System.out.println("ai adaugat un produs" + newProduct.getId());
		
		
		
		response.sendRedirect("goods");
	}

}
