package com.toyspace.product.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.comment.model.service.CommentService;
import com.toyspace.product.comment.model.vo.Comment;
import com.toyspace.product.model.service.ProductService;
import com.toyspace.product.model.vo.Product;

/**
 * Servlet implementation class ProductDetailServlet
 */
@WebServlet("/product/productDetail")
public class ProductDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productId=request.getParameter("productId");
		
		
		Product p=new ProductService().productInfo(productId);
		
		//제품에 연결되어 있는 댓글 가져오기
		List<Comment> commentList=new CommentService().loadProductComment(productId);
		request.setAttribute("product",p);
		request.setAttribute("commentList", commentList);
		
		request.getRequestDispatcher("/views/product/productDetail.jsp").forward(request, response);
	

	
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
