package com.toyspace.admin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.admin.model.service.AdminService;

/**
 * Servlet implementation class SelectedAdminRemoveServlet
 */
@WebServlet("/admin/selectedAdminRemove")
public class SelectedAdminRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedAdminRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] adminIds= request.getParameterValues("checkbox");
		
		boolean result = new AdminService().selectedAdminRemove(adminIds);
		
		String loc = request.getContextPath()+"/admin/adminList";
		String msg = "";
		
		if(!result) {
			msg="계정삭제 실패";
	
		} else {
			msg="계정을 삭제하였습니다.";

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
