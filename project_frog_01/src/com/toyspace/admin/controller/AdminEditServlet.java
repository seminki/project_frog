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
 * Servlet implementation class AdminEditServlet
 */
@WebServlet("/admin/editAdmin")
public class AdminEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Admin a=new Admin();
		a.setAdminId(request.getParameter("adminId"));
		a.setAdminPassword(request.getParameter("adminPw"));
		a.setNickname(request.getParameter("adminNic"));
		a.setAdminName(request.getParameter("adminName"));
		a.setAdminLevel(Integer.parseInt(request.getParameter("adminLevel")));
		
		boolean result=new AdminService().editAdmin(a);
		
		String loc = request.getContextPath()+"/admin/adminList";
		String msg = "";
		
		if(!result) {
			msg="수정 실패";
		} else {
			msg = "수정 성공";
		}
		
		request.getRequestDispatcher("/msg?msg="+msg+"&loc="+loc).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
