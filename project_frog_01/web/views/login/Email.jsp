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
<section>
	<div class="email-container">
        <div class="logo-img">
            <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png">
        </div>
            <h1>비밀번호 변경하기</h1>  
        <div class="pw-area">
            <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요" required>
        </div>
        <div class="pw-area">
            <input type="password" name="password" id="password" placeholder="비밀번호를 재입력해주세요" required>
        </div>
        <div class="btn-area">
            <button onclick="">비밀번호변경</button>
        </div>
    </div>    
    </section>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>