package com.toyspace.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.common.model.vo.Page;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class ProductSearchServlet
 */
@WebServlet("/productSearch.do")
public class ProductSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService ps = new ProductService();
		String searchKeyword = request.getParameter("searchKeyword");
		int cPage;
		try {
			cPage = Integer.parseInt(request.getParameter("cPage"));
		} catch (Exception e) {
			// TODO: handle exception
			cPage=1;
		}
		int numPerPage = 4;
		int pageBarSize = 5;
		ArrayList<Product> productsList = ps.searchByKeyword(searchKeyword, cPage, numPerPage);
		int totalData = ps.selectProductCountByKeyword(searchKeyword);
		String loc = "/productSearch.do";
		Page page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc, searchKeyword);
		
		request.setAttribute("pageBar", page.getPageBar());
		request.setAttribute("productsList", productsList);
		request.setAttribute("searchKeyword", searchKeyword);
		request.setAttribute("totalData", totalData);
		request.getRequestDispatcher("/views/product/productList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
