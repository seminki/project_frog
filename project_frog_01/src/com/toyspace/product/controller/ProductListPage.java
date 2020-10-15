package com.toyspace.product.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

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
		String searchKeyword = request.getParameter("searchKeyword");
		String[] categoryNumbers=request.getParameterValues("category");
		
		int cPage=0;
		int numPerPage=6;
		int pageBarSize=5;
		ArrayList<Product> productsList=null;;
		int totalData=0;
		TreeMap<Integer, Integer> categoryQty =null;
		String loc="/productlist.do";
		Page page=null;
		String pageBar=null;
		
		
		try {
			cPage=Integer.parseInt(request.getParameter("cPage"));
		} catch (Exception e) {
			// TODO: handle exception
			cPage=1;
		}
		
		if(searchKeyword==null && categoryNumbers==null) {
//		서치키워드 x 카테고리 x
			productsList=ps.loadAllProductsWithMainPic(cPage,numPerPage);
			categoryQty = ps.loadCategoryQty();
			totalData=totalDataCalculation(categoryQty);
					
	
			page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc);
			
			pageBar=page.getPageBar();
			
		} else if (searchKeyword!=null && categoryNumbers==null){
//			서치키워드 o 카테고리 x
			productsList = ps.searchByKeyword(searchKeyword, cPage, numPerPage);
			categoryQty= ps.loadCategoryQty(searchKeyword);
			totalData = totalDataCalculation(categoryQty);
			
			page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc, searchKeyword);
			
			pageBar=page.getPageBar();
			
		} else if (searchKeyword==null && categoryNumbers!=null) {
//			서치키워드 x 카테고리 o
			productsList = ps.searchByCategoryAndKeyword(categoryNumbers,searchKeyword,cPage, numPerPage);
			categoryQty = ps.loadCategoryQty(categoryNumbers, searchKeyword);
			totalData = totalDataCalculation(categoryQty);
			
			page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc, "", categoryNumbers);
			
			pageBar=page.getPageBar();
		} else {
//			서치키워드 o 카테고리 o
			productsList = ps.searchByCategoryAndKeyword(categoryNumbers,searchKeyword,cPage, numPerPage);
			categoryQty = ps.loadCategoryQty(categoryNumbers, searchKeyword);
			totalData = totalDataCalculation(categoryQty);
			
			page = new Page(cPage, numPerPage, totalData, pageBarSize, request, loc, searchKeyword, categoryNumbers);
			
			pageBar=page.getPageBar();
			
		}
		
		request.setAttribute("totalData", totalData);
		request.setAttribute("productsList", productsList);
		request.setAttribute("categoryQty", categoryQty);
		request.setAttribute("searchKeyword", searchKeyword);
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
	
	private int totalDataCalculation(TreeMap<Integer, Integer> categoryQty) {
		int result =0;
		for(int category : categoryQty.keySet()) {
			result+=categoryQty.get(category);
		}
		return result;
	}
	
}
