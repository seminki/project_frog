<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.member.model.vo.Member, com.toyspace.product.model.vo.Product, java.util.TreeMap"%>
    <% Member m = (Member)session.getAttribute("signedInMember"); 
    
	@SuppressWarnings("unchecked")
	TreeMap<Product, Integer> buyingItems = (TreeMap<Product, Integer>)request.getAttribute("buyingItems");
    
    %>
     
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/payment.css">
    <title>TOY SPACE - Where All Toys' Dream Comes True</title> 
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<script>
<%if(m==null){ %>
	location.href = "<%=contextPath%>/msg?loc=<%=contextPath%>&msg=로그인 하지 않았습니다.로그인을 먼저 진행해 주세요.";
<%} %>
</script>
 <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
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
                        <label><input type="checkbox">&nbspKeep me up to date on news and exclusive offers</label>
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
                    <button id="checkout-btn" onclick="requestPay();">계속 배송</button>
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
<script>
	/* 아임포트 API 초기화-가맹점 식별코드 삽입*/
	const IMP = window.IMP;
	IMP.init("imp71956162");

	function requestPay(){
		IMP.request_pay({ // param
		    pg: "html5_inicis",
		    pay_method: "card",
		    merchant_uid: <%=m.getMemberKey()%>+new Date().getTime(),
		    name: "노르웨이 회전 의자 외 3",
		    amount: 1000,
		    buyer_email: "gildong@gmail.com",
		    buyer_name: "홍길동",
		    buyer_tel: "010-4242-4242",
		    buyer_addr: "서울특별시 강남구 신사동",
		    buyer_postcode: "01181",
		    
		  }, function (rsp) { // callback
		    if (rsp.success) {
		        console.log("성공");
		        <%	
		        TreeMap<Product, Integer> boughtItems = new TreeMap<Product, Integer>();
		        boughtItems.put(new Product(), 1);
		        	session.setAttribute("boughtItems", boughtItems); 
		        	
		        %>
		        $.ajax({
		        	url: 'http://mightymosses.hopto.org:9090/project_frog_01/order/process',
		        	type: "POST",
		        	data:{
		        		"imp_uid" : rsp.imp_uid,
		        		"merchant_uid" : rsp.merchant_uid,
		        		"member_key" : <%=m.getMemberKey()%>
		        	}
		        }).done(function (data) {
		        	/* 서버 결제 api성공시 로직! */
		        	const result = JSON.parse(data);
		        	switch(result){
		        	case 0 : alert("결제 위변조가 발생하였습니다. 서버관리자에게 보고됩니다."); location.href = "<%=contextPath%>"; break;
		        	case 1 : location.href = "<%=contextPath%>/order/complete"; break;
		        	}
		        })
		    } else {
		        console.log("실패");
		    }
		  })
	}

</script>
</body>
</html>