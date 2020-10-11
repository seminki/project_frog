package com.toyspace.member.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.toyspace.member.model.service.MemberService;
import com.toyspace.member.model.vo.Member;

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
		MemberService ms = new MemberService();
		
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
			
			Member m = ms.checkMemberThroughSNSId(1, id);
			
//			m이 존재하면 그 아이디로 멤버를 불러와 세션 어트리뷰트에 담는다.
			if(m!=null) {
				request.getSession().setAttribute("signedInMember", m);
				return;
			}
//			멤버 객체 만들기
			
//			서비스 통해 dao - > 서버로 가서 이미 있는 아이디인지 확인하고
			
//			있으면 멤버 불러 세션에 담아줌 (어차피 로그인 상태는 이 세션에 따라다니니까!)
			
//			없으면 세션 정보와 같은지 
			
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
