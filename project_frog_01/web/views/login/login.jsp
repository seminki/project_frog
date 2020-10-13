<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <% String clientId = (String)request.getAttribute("client_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/login/style.css">
<%@ include file="/views/common/favicon.jsp" %>
<!-- 구글 로그인 api 로드 -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="<%=clientId%>">
<!-- 네이버 로그인 api 로드 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<!-- 카카오 로그인 api 로드 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<script>
	<% if(session.getAttribute("signedInMember")!=null){%>
		alert("잘못된 접근입니다. 이미 로그인되어있습니다.");
		window.history.go(-1);
	<%}%>

</script>
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
                    <div class="g-signin2" data-onsuccess="onSignIn"></div>
                    <div id="naverIdLogin"></div>
                    <div class="kakao-container">
                   </div>
                </div>
            </div>
           
   </section>
   <%@ include file="/views/common/footer.jsp" %>
   
  	
   <script>
   function onSignIn(googleUser) {
	   let id_token = googleUser.getAuthResponse().id_token;
	   let xhr = new XMLHttpRequest();
	   xhr.open('POST', 'http://mightymosses.hopto.org:9090/project_frog_01/member/googleSignIn');
	   xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	   xhr.send('id_token=' + id_token + "&client_id=<%=clientId%>");
		/* 어디로 보낼지 설정하기 */   
		/* 로그인 객체는 세션에 담아짐 */
		xhr.addEventListener('load', function(e){
    		const result = JSON.parse(e.target.response);
    		switch(result){
    		case 3: alert("기존에 가입된 아이디를 발견하였습니다"); location.href = "<%=request.getContextPath()%>/member/mergeId"; break;
    		/* 간편가입시 '추가 정보 기입하시겠습니까?' 등을 물어보는 서블릿으로 이동 */
    		case 2: alert("기존에 가입된 이력이 없습니다. 간편 가입되었습니다."); location.href = "<%=request.getContextPath()%>/member/snsSignUp"; break;
    		case 1: alert("구글을 통해 간편로그인을 하셨습니다."); 
    		location.href = "<%=request.getContextPath()%>";
    		break;
    		}
    		
		})
	 }
   
   
   const naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "ZsYfto7388DFNUATk2ze",
				callbackUrl: "http://mightymosses.hopto.org:9090/project_frog_01/views/login/sns_login/redirect/naverRedirect.jsp",
				isPopup: false, /* 팝업을 통한 연동처리 여부 */
				loginButton: {color: "green", type: 3, height: 36} /* 로그인 버튼의 타입을 지정 */
			}
		);
		
		/* 설정정보를 초기화하고 연동을 준비 */
		naverLogin.init();
   
		/* 카카오 인증 초기화 */
  	 	Kakao.init('9bf121caabaa1ff4de5c5d96dfa03136');
  	 	Kakao.Auth.createLoginButton({
            container: '.kakao-container',
            success: function (authObj) {
            	Kakao.API.request({
                    url: '/v2/user/me',
                    success: function(res) {
                    	
                      $.ajax({
                    	  url: '<%=request.getContextPath()%>/member/kakaoSignIn',
                    	  data: {"id" : res.id, "access_token": Kakao.Auth.getAccessToken(), "birthday" : res.kakao_account.birthday, "email": res.kakao_account.email,
                    			 "nickname" :  res.kakao_account.profile.nickname, "profile_image_url": res.kakao_account.profile.profile_image_url
                    	  },
                    	  type: 'POST',
                    	  success : (data)=>{
                    		const result = JSON.parse(data);
                      		switch(result){
                      		case 3: alert("기존에 가입된 아이디를 발견하였습니다"); location.href = "<%=request.getContextPath()%>/member/mergeId"; break;
                      		/* 간편가입시 '추가 정보 기입하시겠습니까?' 등을 물어보는 서블릿으로 이동 */
                      		case 2: alert("기존에 가입된 이력이 없습니다. 간편 가입되었습니다."); location.href = "<%=request.getContextPath()%>/member/snsSignUp"; break;
                      		case 1: alert("카카오를 통해 간편로그인을 하셨습니다."); 
                      		location.href = "<%=request.getContextPath()%>";
                      			break;
                      		}
                    	  }
                      })
                    },
                    fail: function(error) {
                      alert(
                        'login success, but failed to request user information: ' +
                          JSON.stringify(error)
                      )
                    },
                  })
            },
            fail: function (err) {
                alert(JSON.stringify(err));
            }
        });
  	 	

   </script>
   
</body>
</html>