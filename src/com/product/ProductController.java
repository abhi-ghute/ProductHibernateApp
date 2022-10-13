package com.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchProductController
 */
@WebServlet("/addProduct")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ProductEntity product = new ProductEntity();
	ProductDao dao = new ProductDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			product.setProductID(request.getParameter("productID"));
			product.setProductName(request.getParameter("prooductName"));
			product.setWeight(request.getParameter("weight"));
			product.setPrice(request.getParameter("price"));
			product.setMfgDate(request.getParameter("mfgDate"));
			product.setExpDate(request.getParameter("expDate"));
			product.setDiscount(request.getParameter("discount"));
			product.setDiscount(request.getParameter("discount"));
			product.setColor(request.getParameter("color"));
			product.setCategory(request.getParameter("category"));
			
			dao.saveProduct(product);
		
			request.setAttribute("product",product);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ShowProduct.jsp");
			dispatcher.forward(request, response);
		
	}


}
