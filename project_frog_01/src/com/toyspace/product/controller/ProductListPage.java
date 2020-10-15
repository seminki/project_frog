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
 * Servlet implementation class ProductList
 */
@WebServlet("/productlist.do")
public class ProductListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService ps = new ProductService();
		int cPage;
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		} catch (Exception e) {
			// TODO: handle exception
			cPage=1;
		}
		int numPerPage=6;
		
		ArrayList<Product> productsList=ps.loadAllProductsWithMainPic(cPage,numPerPage);
		int totalData=ps.selectProductCount();
		int pageBarSize=5;
		String loc = "/productlist.do";
		Page page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc);
		
		
		
		String pageBar=page.getPageBar();
		
		request.setAttribute("totalData", totalData);
		request.setAttribute("productsList", productsList);
		request.setAttribute("pageBar", pageBar);
		
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
