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
 * Servlet implementation class AdminInsert
 */
@WebServlet("/admin/insertAdmin")
public class AdminInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInsert() {
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
		String adminNic=request.getParameter("adminNic");
		String adminName=request.getParameter("adminName");
		String adminLevel=request.getParameter("adminLevel");
		
		Admin admin = new Admin(adminId,adminPw,adminNic,adminName,Integer.parseInt(adminLevel),null);
		boolean result=new AdminService().insertAdmin(admin);
		
		String loc = request.getContextPath()+"/admin/adminList";
		String msg = "";
		
		if(!result) {
			msg="관리자 추가에 실패했습니다.";
		} else {
			msg = "관리자 추가에 성공했습니다.";
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
