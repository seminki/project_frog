<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/login/style.css">
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
                <a href="">비밀번호를 잊으셨나요?</a>
            </div>
            <div class="btn-area">
                <button onclick="">로그인</button> 
             </div>
            <div class="last-area">
                <p>ToySpace는 처음이신가요?<a href=""> 지금 가입하기</a></p>
            </div>
            <div class="simple-login">
                <div class="sp-login" style="margin:50px ;">
                    <input type="image" id="naver" name="naver" src="<%=request.getContextPath() %>/image/login/naver.PNG">
                    <input type="image" id="kakao" name="kakao" src="<%=request.getContextPath() %>/image/login/kakao.png">
                    <input type="image" id="google" name="google" src="<%=request.getContextPath() %>/image/login/google.png">
                </div>
            </div>
   </section>
   <%@ include file="/views/common/footer.jsp" %>
</body>
</html>