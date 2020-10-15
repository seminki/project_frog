<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<%@ include file="/views/common/favicon.jsp" %>
<meta charset="UTF-8">
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
</head>
<style>
<style>
section{
    
}
.container{
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100vw;
    height: 100vh;
}
.Sign-up{}
.sign-up-text{
    font-size: 3em;
}
#TOYSPACE{
    color:blue;
}

</style>
</style>
<body>
<%@ include file="/views/common/header.jsp" %>
<body>
    <section>
        <div class="container">
            <div class="Sign-up">
            	<img src="<%=request.getContextPath()%>/image/login/resume.png">
            </div>
            <div class="sign-up-text">
                <h3><span id="TOYSPACE">TOYSPACE</span> 홈페이지<br> 
                    회원가입이 완료 되었습니다.</h3>
            </div>
        </div>
    </section>
</body>
	   <%@ include file="/views/common/footer.jsp" %>
</body>
</html>