package com.toyspace.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class EditProductEndServlet
 */
@WebServlet("/admin/editProductEnd")
public class EditProductEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//int productId=(Integer.parseInt(request.getParameter("productId")));

		Product p=new Product();
	
		p.setProductId(Integer.parseInt(request.getParameter("productId")));
		p.setProductName(request.getParameter("item_name"));
		p.setCategoryNo(Integer.parseInt(request.getParameter("category")));
		System.out.println(request.getParameter("category"));
		p.setProductPrice(Double.parseDouble(request.getParameter("item_price")));
		p.setProductStock(Integer.parseInt(request.getParameter("item_qt")));
		p.setProductDescription(request.getParameter("product-description"));
		p.setManufacturedCountry(request.getParameter("manufactured-country"));
		p.setManufacturer(request.getParameter("manufacturer"));
		p.setRecommendedAge(Integer.parseInt(request.getParameter("recommended-age")));
		p.setCaution(request.getParameter("caution"));
		
		int result=new ProductService().updateProduct(p);
		String msg;
		String loc=request.getContextPath()+"/admin/productList";
		
		if(result>0) {
			msg="상품수정 성공";
			
	
		} else {
			msg="상품수정 실패";

		}
		request.setAttribute("msg", msg);
		request.setAttribute("loc", loc);
		request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
