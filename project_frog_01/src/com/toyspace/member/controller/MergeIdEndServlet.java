package com.toyspace.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;
import com.toyspace.member.model.vo.SNSLogin;

/**
 * Servlet implementation class MergeIdEndServlet
 */
@WebServlet("/member/mergeIdEnd")
public class MergeIdEndServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MergeIdEndServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		MemberService ms = new MemberService();
		Member m = (Member)session.getAttribute("email-found-new-member");
		SNSLogin sns = (SNSLogin)session.getAttribute("SNS-for-email-found-new-member");
		String password = request.getParameter("password");
		
		String msg="";
		String loc="";
		boolean result = ms.passwordCheck(m.getMemberKey(), password);
		if(!result) {
			msg = "비밀번호가 일치하지 않습니다.";
			loc = request.getContextPath()+"/member/mergeId";
			request.getRequestDispatcher("/msg?msg="+msg+"&loc="+loc).forward(request, response);
			return;
		}
		result = ms.insertSNSInfoToExistingMember(m, sns);
		if(!result) {
			msg = "SNS정보를 저장하던 중 에러가 발생했습니다.";
			loc = request.getContextPath()+"/member/mergeId";
			request.getRequestDispatcher("/msg?msg="+msg+"&loc="+loc).forward(request, response);
			return;
		}
		msg="SNS 정보를 "+m.getUserId()+"에 삽입 완료!";
		loc=request.getContextPath();
		
		session.setAttribute("signedInMember", m);
		session.removeAttribute("email-found-new-member");
		session.removeAttribute("SNS-for-email-found-new-member");
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
