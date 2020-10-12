package com.toyspace.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;

/**
 * Servlet implementation class SignupEnd
 */
@WebServlet("/signupEnd.do")
public class SignupEnd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupEnd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //id pw name 닉네임 이메일
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userId=request.getParameter("userId");
		String userPassword =request.getParameter("userPassword");
		String userName =request.getParameter("userName");
		String userNickname =request.getParameter("userNickname");
		String userEmail = request.getParameter("userEmail");
	
		Member m = new Member(0, userId,userEmail,userPassword,null,userName, userNickname, 0, null, null, null, null, null, 0, null, 0, null, null, null);
		
		int result = new MemberService().insertMember(m);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
