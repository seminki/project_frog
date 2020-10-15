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
 * Servlet implementation class memberInfoChange
 */
@WebServlet("/memberInfoChange.do")
public class memberInfoChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberInfoChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memberKey=request.getParameter("memberkey");
		String userId=request.getParameter("userId");
		String email =request.getParameter("email");
		String pw=request.getParameter("pw");
		String gender =request.getParameter("gender");
		String userName=request.getParameter("userName");
		String nick=request.getParameter("nick");
		String age =request.getParameter("age");
		String birthday=request.getParameter("year"+"/"+"month"+"/"+"day");
		String phone =request.getParameter("phone");

	
		String loc = "";
		String msg = "";
		
		Member m = new Member(Integer.parseInt(memberKey), userId,email,pw,"X", userName, nick,Integer.parseInt(age),
				birthday, null, phone, null, null, 0, null, 0, null, null, null);
		
		int result = new MemberService().memberInfoChange(m);
		if(result!=1) {
			msg = "수정 실패.";
			loc =request.getContextPath();
		} else { 
			msg = "수정 성공";
			loc = request.getContextPath()+"/member/signUpCelebrate";
		}
		request.getRequestDispatcher("/msg?loc="+loc+"&msg="+msg).forward(request, response);
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
