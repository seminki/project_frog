package com.toyspace.member.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gson.Gson;
import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;
import com.toyspace.member.model.vo.SNSLogin;

/**
 * Servlet implementation class GoogleSignInServlet
 */
@WebServlet("/member/googleSignIn")
public class GoogleSignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoogleSignInServlet() {
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
		
		
		MemberService ms = new MemberService();
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		
		String idTokenString = request.getParameter("id_token");
		String clientId = request.getParameter("client_id");
		
		GoogleIdTokenVerifier verifier =  new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new JacksonFactory())
				.setAudience(Collections.singletonList(clientId))
				.build();
		GoogleIdToken idToken=null;
		Payload payload =null;
		try {
			idToken = verifier.verify(idTokenString);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (idToken!=null) {
			payload = idToken.getPayload();
//			정보 받아오기!

			String id = payload.getSubject();
			
			//이 구글 유니크 아이디가 벌써 등록되어있는지 체크
//			로그인 소스 1은 구글 2는 네이버 3은 카카오
			int loginSource =1;
			Member m = ms.checkMemberThroughSNSId(loginSource, id);
			
//			m이 존재하면 그 아이디로 멤버를 불러와 세션 어트리뷰트에 담는다.
//			서비스 통해 dao - > 서버로 가서 이미 있는 아이디인지 확인하고
//			있으면 멤버 불러 세션에 담아줌 (어차피 로그인 상태는 이 세션에 따라다니니까!)
			if(m!=null) {
				session.setAttribute("signedInMember", m);
				gsonFlag=1;
				gson.toJson(gsonFlag,response.getWriter());
				return;
			}
//			구글 페이로드에서 더 많은 정보 받아오기
//			만약 해당 이메일로 이미 회원정보가 있으면 패스워드를 확인한 뒤 그걸로 가입하게만듬. 
//			(이메일은 유니크이므로 중복값을 없게하기 위함이기도 함) 
//			-만약 패스워드 잃어버렸으면 다시 찾아야함
			String email = payload.getEmail();
			String pictureURL = (String)payload.get("picture");
			String familyName = (String)payload.get("family_name");
			String givenName = (String)payload.get("given_name");
			String name = familyName+" "+givenName;
			
			SNSLogin sns= new SNSLogin();
			sns.setLoginSourceNo(loginSource);
			sns.setAccessToken(idTokenString);
			sns.setSnsId(id);
			sns.setSnsName(name);
			
			Member emailM=ms.checkMemberThroughSNSEmail(email);
			if(emailM!=null) {
				session.setAttribute("email-found-new-member", m);
				session.setAttribute("SNS-for-email-found-new-member", sns);
				gsonFlag=3;
				gson.toJson(gsonFlag,response.getWriter());
				return;
			}
			
			
//			멤버 객체 만들기
			Member newM= new Member();
			newM.setUserEmail(email);
			newM.setUserName(name);
			newM.setUserProfilePicUrl(pictureURL);
			
//			멤버 정보 생성!
			Member signInMember = ms.signUpThroughSNS(newM, sns);
			
			session.setAttribute("signedInMember", signInMember);
			
			gsonFlag=2;
			gson.toJson(gsonFlag,response.getWriter());
		} else {
			System.out.println("Invalid ID Token!!");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
