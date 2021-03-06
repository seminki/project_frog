package com.toyspace.admin.controller;


import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.model.service.CategoryService;
import com.toyspace.product.model.service.TagService;
import com.toyspace.product.model.vo.Category;
import com.toyspace.product.model.vo.Tags;

/**
 * Servlet implementation class InsertProductServlet
 */
@WebServlet("/admin/insertProduct")
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		TreeSet<Tags> tagsList= new TagService().loadAllTags();
		TreeSet<Category> categoryList= new CategoryService().loadAllCategories();
		
		request.setAttribute("tagsList", tagsList);
		request.setAttribute("categoryList", categoryList);
		
		
		request.getRequestDispatcher("/views/admin/productEnroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
