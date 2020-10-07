package com.toyspace.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.admin.model.service.AdminService;
import com.toyspace.admin.model.vo.Admin;

/**
 * Servlet implementation class AdminLoginOutServlet
 */
@WebServlet("/admin/loginOut")
public class AdminLoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String adminId=request.getParameter("adminId");
		String adminPw=request.getParameter("adminPw");
		Admin admin= new AdminService().loadMember(adminId,adminPw);
		
		String msg;
		String loc;
		String path;
		
		if(admin!=null) {
			request.getSession().setAttribute("loggedInAdmin", admin);
			path="/views/admin/mainPage.jsp";
		} else {
			msg="로그인 실패";
			loc=request.getContextPath()+"/admin";
			request.setAttribute("msg", msg);
			request.setAttribute("loc", loc);
			path="/views/common/msg.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
