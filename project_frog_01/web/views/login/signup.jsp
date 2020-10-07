<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/login/style.css">
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
 <section>
        <form class="qwe">
            <div class="logo-area1">
                <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="toyspace">
            </div>
            
            <div class="logo-area2">    
                <img src="<%=request.getContextPath()%>/image/login/pikachu.png" alt="funko">
            </div>

            <div class="si-area">
            	<h1>SIGN UP</h1>
                	<input type="text" id="id" name="id" autocomplete="off" placeholder="아이디를 입력해주세요" required><br>
                	<input type="password" id="pw" name="pw" autocomplete="off" placeholder="비밀번호를 입력해주세요" required><br>
                	<input type="text" id="name" name="name" autocomplete="off" placeholder="아름를 입력해주세요" required><br>
                	<input type="text" id="nickname" name="nickname" autocomplete="off" placeholder="닉네임을 입력해주세요" required><br>
                	<input type="email" id="email" name="email" autocomplete="off" placeholder="이메일을 입력해주세요" required><br>
            </div>
            <div class="news">
                <input type="checkbox"><label>TOYSPACE의 최근 소식을 볼수 있습니다. <br> 
                    	최근 소식을 볼려면 체크해주세요.</label>
            </div>
            <div class="btn-area1">
                <button>가입하기</button>
            </div>
            <div class="last-area1">
                <label>계속하면 TOYSPACE에 동의하는것으로 간주합니다.<a href=""> 이용약관</a> 그리고 <a href="">개인정보정책</a></label><br>
                <label>이미 계정이 있으신가요? <a href="">로그인</a></label>               
            </div>
        </form>
    </section>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>