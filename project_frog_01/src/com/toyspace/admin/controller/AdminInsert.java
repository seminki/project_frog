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
		
		Admin admin = new Admin(adminId,adminPw,adminNic,adminName,Integer(adminLevel),null);
		int result=new AdminService().insertAdmin(admin);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	private int Integer(String adminLevel) {
		// TODO Auto-generated method stub
		return Integer(adminLevel);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
