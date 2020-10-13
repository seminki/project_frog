package com.toyspace.product.comment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.product.comment.model.service.CommentService;
import com.toyspace.product.comment.model.vo.Comment;

/**
 * Servlet implementation class CommentWriteServlet
 */
@WebServlet("/comment/commentWrite")
public class CommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Comment c=new Comment();
		c.setMemberKey(Integer.parseInt(request.getParameter("memberKey")));
		c.setProductId(Integer.parseInt(request.getParameter("productId")));
		c.setCommentContent(request.getParameter("commentContent"));
		System.out.println(c);
		int result=new CommentService().insertComment(c);
		
		String msg;
		String loc=request.getContextPath()+"/product/productDetail";
		
		if(result>0) {
			msg="댓글등록 성공";
	
		} else {
			msg="댓글등록 실패";

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
