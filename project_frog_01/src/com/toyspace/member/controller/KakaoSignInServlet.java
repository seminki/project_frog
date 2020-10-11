package com.toyspace.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;
import com.toyspace.member.model.vo.SNSLogin;

/**
 * Servlet implementation class KakaoSignInServlet
 */
@WebServlet("/member/kakaoSignIn")
public class KakaoSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoSignInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		gsonFlag의 용도: 응답페이지에 int로 플래그를 보내줌 
//		1:이미 가입된 사람인 경우
//		2:가입되어있지만 연동이 안되어있는 경우로 판단되는 경우
//		3:가입되어있지 않은 경우
		int gsonFlag = -1;
		
		
		HttpSession session = request.getSession();
		MemberService ms = new MemberService();
		Gson gson = new Gson();
		
		String msg ="";
		String loc ="";
		
		
		String id = request.getParameter("id");
		String accessToken = request.getParameter("access_token");
		String birthday = request.getParameter("birthday");
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String profileImageURL = request.getParameter("profile_image_url");
		
		//이 카카오 유니크 아이디가 벌써 등록되어있는지 체크
//		로그인 소스 1은 구글 2는 네이버 3은 카카오
		int loginSource =3;
		Member m = ms.checkMemberThroughSNSId(loginSource, id);
		
//		m이 존재하면 그 아이디로 멤버를 불러와 세션 어트리뷰트에 담는다.
//		서비스 통해 dao - > 서버로 가서 이미 있는 아이디인지 확인하고
//		있으면 멤버 불러 세션에 담아줌 (어차피 로그인 상태는 이 세션에 따라다니니까!)
		
		if(m!=null) {
			session.setAttribute("signedInMember", m);
			gsonFlag=1;
			gson.toJson(gsonFlag,response.getWriter());
			return;
		}
		
		SNSLogin sns = new SNSLogin();
		sns.setLoginSourceNo(3);
		sns.setAccessToken(accessToken);
		sns.setSnsId(id);
		sns.setSnsName(nickname);
		
		Member emailM=null; 
		if(email!=null) emailM= ms.checkMemberThroughSNSEmail(email);
		if(emailM!=null) {
			session.setAttribute("email-found-new-member", m);
			session.setAttribute("SNS-for-email-found-new-member", sns);
			gsonFlag=3;
			gson.toJson(gsonFlag,response.getWriter());
			return;
		}
		Member newM =new Member();
		newM.setUserEmail(email);
		newM.setUserName(nickname);
		newM.setUserNickname(nickname);
		newM.setUserBirthday(birthday);
		newM.setUserProfilePicUrl(profileImageURL);
		
//		멤버정보생성!
		Member signInMember = ms.signUpThroughSNS(newM, sns);
		
		session.setAttribute("signedInMember", signInMember);
		
		gsonFlag=2;
		gson.toJson(gsonFlag,response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
