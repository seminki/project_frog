package com.toyspace.order.cart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/cart/addToCart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(request.getParameter("productId"));
		int value = Integer.parseInt(request.getParameter("value"));
		HttpSession session = request.getSession();
		
		TreeMap<Integer, Integer> cartValues = (TreeMap<Integer, Integer>)session.getAttribute("cart");
		
		if(cartValues!=null&&cartValues.containsKey(productId)) cartValues.put(productId, cartValues.get(productId)+value);
		else if(cartValues!=null&&!cartValues.containsKey(productId)) cartValues.put(productId, value);
		else{
			cartValues= new TreeMap<Integer, Integer>();
			cartValues.put(productId, value);
			
		}
		
		int sum =0;
		ArrayList<Integer> removingKey = new ArrayList<Integer>();
		for(int v :cartValues.keySet()) {
			sum+=cartValues.get(v);
			if(cartValues.get(v)==0) {
				removingKey.add(v);
			}
		}
		for(int key : removingKey) {
			cartValues.remove(key);
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
