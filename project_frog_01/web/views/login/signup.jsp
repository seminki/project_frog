<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/login/style.css">
<%@ include file="/views/common/favicon.jsp" %>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
 <section>
        <form action="<%=request.getContextPath()%>/signupEnd.do" method="post">
            <div class="logo-area1">
                <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="toyspace">
            </div>
            
            <div class="logo-area2">    
                <img src="<%=request.getContextPath()%>/image/login/pikachu.png" alt="funko">
            </div>

            <div class="si-area">
            	<h1>SIGN UP</h1>
                	<input type="text" id="userId" name="userId" autocomplete="off" placeholder="아이디를 입력해주세요" required><br>
                	<input type="password" id="userPassword" name="userPassword" autocomplete="off" placeholder="비밀번호를 입력해주세요" required><br>
                	<!-- <input type="password" id="re_pw" name="pw" autocomplete="off" placeholder="비밀번호를 다시 입력해주세요" required><br> -->
                	<input type="text" id="userName" name="userName" autocomplete="off" placeholder="아름를 입력해주세요" required><br>
                	<input type="text" id="userNickname" name="userNickname" autocomplete="off" placeholder="닉네임을 입력해주세요" required><br>
                	<input type="email" id="userEmail" name="userEmail" autocomplete="off" placeholder="이메일을 입력해주세요" required><br>
            </div>
            <div class="news">
                <input type="checkbox"><label>TOYSPACE의 최근 소식을 볼수 있습니다. <br> 
                    	최근 소식을 볼려면 체크해주세요.</label>
            </div>
            <div class="btn-area1">
                <button type="submit">가입하기</button>
            </div>
            <div class="last-area1">
                <label>계속하면 TOYSPACE에 동의하는것으로 간주합니다.<a href=""> 이용약관</a> 그리고 <a href="">개인정보정책</a></label><br>
                <label>이미 계정이 있으신가요? <a href="<%=request.getContextPath() %>/login.do">로그인</a></label>               
            </div>
        </form>
    </section>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>