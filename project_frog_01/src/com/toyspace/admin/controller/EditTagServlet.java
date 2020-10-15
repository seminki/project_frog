package com.toyspace.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.toyspace.product.model.service.TagService;
import com.toyspace.product.model.vo.Tags;

/**
 * Servlet implementation class EditTagServlet
 */
@WebServlet("/admin/editTag")
public class EditTagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Tags t=new Tags();
		t.setTagName(request.getParameter("tagName"));
		t.setTagNo(Integer.parseInt(request.getParameter("tagNo")));
		
		int result=new TagService().editTag(t);
		
		String msg;
		String loc=request.getContextPath()+"/admin/tagList";
		
		if(result>0) {
			msg="태그수정 성공";
	
		} else {
			msg="태그등록 실패";

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
