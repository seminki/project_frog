package com.toyspace.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;

/**
 * Servlet implementation class MemberLoginOutServlet
 */
@WebServlet("/memberloginout.do")
public class MemberLoginOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId= request.getParameter("userId");
		String userPw= request.getParameter("userPw");
		
		Member member = new MemberService().loadMembers(userId,userPw);
		
		String msg;
		String loc;
		String path;
		
		if(member!=null) {
			request.getSession().setAttribute("loggedInMember", member);
			path="/views/index.jsp";
		} else {
			msg="로그인 실패";
			loc=request.getContextPath()+"/login.do";
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
