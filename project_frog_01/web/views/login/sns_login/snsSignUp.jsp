<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<%@ include file="/views/common/favicon.jsp" %>
</head>
<style>
section{
    margin-top: 20em;
    margin-bottom : 20em;
}
section .container{
    display:flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 100vw;
    height: 100vh;
}
section .sign-up-text{
    text-align: center;
    font-size: 3em;
}
section #TOYSPACE{
    color:blue;
}
section .button-location{
    display: flex;
    justify-content: space-around;
    width: 30%;
}
section button{
    margin-top: 5%;
    width:13em;
    height: 3em;
    border-radius: 20px;
    border: 3px solid black;
    background-color: white;
    color: black;
    font-size: 1em;
}
</style>
<body>

<%@ include file="/views/common/header.jsp" %>

    <section>
        <div class="container">
            <div class="Sign-up">
                <img src="<%=request.getContextPath()%>/image/login/resume.png">
            </div>
            <div class="sign-up-text">
                <h3><span id="TOYSPACE">TOYSPACE</span> 홈페이지<br> 
                    간편로그인으로 회원가입이 완료 되었습니다.<br>
                </h3>
            </div>
            <h3>추가 정보를 입력하시겠습니까?</h3>
            <div class="button-location">
                <button>확인</button>
                <button>취소</button>
            </div>
        </div>
    </section>

<%@ include file="/views/common/footer.jsp" %>

</body>
</html>