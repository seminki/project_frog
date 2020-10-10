<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String clientId = "1048798785374-009dlj5qh83q83l0kg2n7lg3d4bo3q3f.apps.googleusercontent.com"; %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/login/style.css">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<meta name="google-signin-client_id" content="<%=clientId%>">
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section class ="login-form">
           <div class="logo1-area">
                <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="">
            </div>
            <div class="logo2-area">
                <img src="<%=request.getContextPath()%>/image/login/pikachu.png" alt="fun" id="fun">
            </div>
                <h1>LOG IN</h1>
            <div class="in-area">
                <input type="text" name="id" id="id" autocomplete="off" placeholder="아이디를 입력해주세요."  required>
                <label for="id"></label>
            </div>
            <div class="in-area">    
                <input type="password" name="pw" id="pw" autocomplete="off" placeholder="비밀번호를 입력해주세요." required>
                <label for="pw"></label>
            </div>
            <div class="caption">
                <a href="<%=request.getContextPath() %>/searchpw.do">비밀번호를 잊으셨나요?</a>
            </div>
            <div class="btn-area">
                <button onclick="">로그인</button> 
             </div>
            <div class="last-area">
                <p>ToySpace는 처음이신가요?<a href="<%=request.getContextPath() %>/signup.do"> 지금 가입하기</a></p>
            </div>
            <div class="simple-login">
                <div class="sp-login" style="margin:50px ;">
                    <div id="naverIdLogin"></div>
                    <input type="image" id="kakao" name="kakao" src="<%=request.getContextPath() %>/image/login/kakao.png">
                    <div class="g-signin2" data-onsuccess="onSignIn"></div>
                </div>
            </div>
   </section>
   <%@ include file="/views/common/footer.jsp" %>
   
  	
   <script>
   const naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "ZsYfto7388DFNUATk2ze",
				callbackUrl: "http://mightymosses.hopto.org:9090/project_frog_01/",
				isPopup: false, /* 팝업을 통한 연동처리 여부 */
				loginButton: {color: "green", type: 3, height: 40} /* 로그인 버튼의 타입을 지정 */
			}
		);
		
		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
   
   
   function onSignIn(googleUser) {
	   let id_token = googleUser.getAuthResponse().id_token;
	   let xhr = new XMLHttpRequest();
	   xhr.open('POST', 'http://mightymosses.hopto.org:9090/project_frog_01/member/googleSignIn');
	   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	   xhr.send('id_token=' + id_token + "&client_id=<%=clientId%>");
	   
	 }
   	
   </script>
   
</body>
</html>