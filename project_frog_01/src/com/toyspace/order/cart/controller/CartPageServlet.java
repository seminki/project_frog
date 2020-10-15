package com.toyspace.order.cart.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class CartPageServlet
 */
@WebServlet("/cart.do")
public class CartPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		TreeMap<Integer, Integer> cartValues = (TreeMap<Integer, Integer>)session.getAttribute("cart");
		
		if(cartValues!=null&&cartValues.size()!=0) {
			TreeMap<Integer, Product> productInCart = new ProductService().loadSelectedProductsWithMainPic(cartValues);
			request.setAttribute("productInCart", productInCart);
		}
		request.getRequestDispatcher("/views/cart/cart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
