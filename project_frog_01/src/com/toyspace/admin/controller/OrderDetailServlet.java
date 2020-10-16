package com.toyspace.admin.controller;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.order.history.model.service.OrderHistoryService;
import com.toyspace.order.history.model.vo.OrderHistory;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class OrderDetailServlet
 */
@WebServlet("/admin/orderDetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int orderNo = Integer.parseInt(request.getParameter("orderNo"));
		
		OrderHistory oh = new OrderHistoryService().loadOrderHistory(orderNo);
		TreeMap<Integer, Product> productInfo = new ProductService().loadSelectedProductsWithMainPic(oh.getProductList());
		
		request.setAttribute("orderHistory", oh);
		request.setAttribute("productInfo", productInfo);
		
		request.getRequestDispatcher("/views/admin/orderDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
