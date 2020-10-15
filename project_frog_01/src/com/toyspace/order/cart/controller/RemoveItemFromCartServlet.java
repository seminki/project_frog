package com.toyspace.order.cart.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class RemoveItemFromCartServlet
 */
@WebServlet("/cart/removeItem")
public class RemoveItemFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemFromCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		HttpSession session = request.getSession();
		
		TreeMap<Integer, Integer> cartValues = (TreeMap<Integer, Integer>)session.getAttribute("cart");
		if(cartValues!=null) {
			cartValues.remove(productId);
		}
		
		int sum=0;
		for(int v :cartValues.keySet()) {
			sum+=cartValues.get(v);
		}
		
		session.setAttribute("cart", cartValues);
		
		Gson gson = new Gson();
		gson.toJson(sum, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
