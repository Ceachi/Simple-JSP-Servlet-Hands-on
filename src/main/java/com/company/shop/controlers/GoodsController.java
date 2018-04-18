package com.company.shop.controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.company.shop.model.ProductDto;
import com.company.shop.model.UserDto;
import com.company.shop.services.ProductService;
import com.company.shop.services.UserService;

/**
 * Controller ce gestioneaza pagina mea de produse
 * Servlet implementation class Goods
 */
@WebServlet("/goods")
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String GOODS_VIEW = "goods.jsp";
	
	UserService userService = new UserService();	
	ProductService productService = new ProductService();
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Populate user data	
		UserDto user = userService.getCurrentLoggedInUser();
		request.setAttribute("user", user);
				
		// Populate products data
		List<ProductDto> availableProducts = productService.getListAvailableProducts();
		request.setAttribute("products", availableProducts);
		
//		for(ProductDto list : availableProducts) {
//			System.out.println(list.getId());
//		}
		
		// Forward to home page
		RequestDispatcher dispatcher = request.getRequestDispatcher(GOODS_VIEW);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("salutare");
	}

}
