package com.toyspace.admin.controller;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.service.TagService;
import com.toyspace.product.model.vo.Product;
import com.toyspace.product.model.vo.Tags;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet("/admin/editProduct")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String productId=request.getParameter("productId");
		
		Product p=new ProductService().productInfo(productId);
		//System.out.println(p.getProductImageFilePaths().get(0));
		
		TreeSet<Tags> tagsList= new TagService().loadAllTags();
		
		request.setAttribute("product", p);
		request.setAttribute("tagsList", tagsList);
		
		request.getRequestDispatcher("/views/admin/productEdit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
