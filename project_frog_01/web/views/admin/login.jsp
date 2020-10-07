<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<link rel="stylesheet" type="text/css" 
href="<%=request.getContextPath() %>/css/admin-login/style.css">
</head>
<body>
 <section>
        <div class=ad-login>
            <img src="<%=request.getContextPath() %>/image/admin/white-logo.png">
            <h1>TOYSPACE<br> 
                관리자페이지</h1>
        </div>
        <form method="post" action="<%=request.getContextPath()%>/admin/loginOut">
        <div class="in-area">
            <label for="id">아이디</label>
            <input type="text" name="adminId" id="id" autocomplete="off"  required>
        </div>
        <div class="in-area">    
            <label for="pw">비밀번호</label>
            <input type="password" name="adminPw" id="pw" autocomplete="off" required>
        </div>
        <div class="btn-area">
            <button onclick="">로그인</button> 
         </div>
         </form>
         <div class="last-area">
            <label>TEL : 관리자전화번호</label>
        </div>
    </section>

</body>
</html>