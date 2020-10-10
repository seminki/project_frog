<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/payment.css">
    <title>Document</title> 
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
    <section class="container">
        <div class="left">
            <div class="logo">
            <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="">
                <p>정보 > 배송 > 지불</p>
            </div>
            <div class="bottom">
                <fieldset>
                    <legend align="center">&nbspExpress checkout&nbsp</legend>
                    <p>결제 모듈 부분</p>
<!--                     <img src="" alt="">
                    <img src="" alt="">
                    <img src="" alt=""> -->
                </fieldset>
                <div class="hr-sect">또는</div>
                <div class="contact">
                    <div class="contact-information">
                        연락 정보
                    </div>
                    <div class="Already">
                        이미 계정이 있습니까? 
                        <button>로그인</button>
                    </div>
                </div>
                    <div class="email">
                        <input type="email" id="email" name="email" placeholder="이메일">
                    </div>
                    <div class="Keep">
                        <label><input type="checkbox">&nbspKeep me up to deate on news and exclusive offers</label>
                    </div>
                <div class="Shipping">
                    <p>배송지 주소</p>
                    <div class="name">
                        <input type="text" placeholder="이름">
                        <input type="text" placeholder="성">
                    </div>
                    <div class="mid">
                        <input type="text" placeholder="회사(선택 사항)"><br>
                        <input type="text" placeholder="주소"><br>
                        <input type="text" placeholder="아파트, 스위트 등(선택 사항)"><br>
                        <input type="text" placeholder="시티">
                    </div>
                    <div class="btm">
                        <input type="text" placeholder="국가/지역">
                        <input type="text" placeholder="상태">
                        <input type="text" placeholder="우편 번호">
                    </div>
                    <button>계속 배송</button>
                </div>
            </div>
        </div>
        <div class="right">
            <div class="tp">
                <label><img src="<%=request.getContextPath()%>/image/cart/bat2.png" alt=""></label>
                <h4>배트맨 As Scrooge</h4>
                <p>11.00 달러</p>
            </div>
            <hr>
            <div class="discount">
                <input type="text" placeholder="  할인 코드">
                <button>적용</button>
            </div>
            <hr>
            <div class="subtotal-shipping">
                <div class="Subtotal">
                    <p>소계</p>
                    <p>11.00 달러</p>
                </div>
                <div class="shipping">
                    <p>배송</p>
                    <p>다음 단계에서 계산</p>
                </div>
            </div>
            <hr>
            <div class="sub">
                <p>합계</p>
                <p>USD <b>$ 11.00</b></p>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>