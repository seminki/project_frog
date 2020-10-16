package com.toyspace.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;
import com.toyspace.order.history.model.service.OrderHistoryService;
import com.toyspace.order.history.model.vo.OrderHistory;

/**
 * Servlet implementation class MemberDetailServlet
 */
@WebServlet("/admin/memberDetail")
public class MemberDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int memberKey = Integer.parseInt(request.getParameter("memberKey"));
		Member m = new MemberService().loadMemberDetail(memberKey);
		ArrayList<OrderHistory> orderHistories = new OrderHistoryService().loadMemberOrderHistory(memberKey);
		
		request.setAttribute("memberInfo", m);
		request.setAttribute("orderHistories", orderHistories);
		request.getRequestDispatcher("/views/admin/memberDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
