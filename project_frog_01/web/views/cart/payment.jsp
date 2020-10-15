<%@page import="java.util.TreeMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.member.model.vo.Member, com.toyspace.product.model.vo.Product, java.util.TreeMap"%>
    <% Member m = (Member)session.getAttribute("signedInMember"); 
    
	
    String merchant_uid = (String)request.getAttribute("merchant_uid");
    @SuppressWarnings("unchecked")
    TreeMap<Integer, Product> productInfo = (TreeMap<Integer, Product>)request.getAttribute("productInfo");
    
    int firstProduct = productInfo.firstKey();
    double totalAmount = 0;
    %>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="kr">
<head>
    
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/payment.css">
    <title>TOY SPACE - Where All Toys' Dream Comes True</title>
    <script language="javascript">
// opener관련 오류가 발생하는 경우 아래 주석을 해지하고, 사용자의 도메인정보를 입력합니다. ("팝업API 호출 소스"도 동일하게 적용시켜야 합니다.)
//document.domain = "abc.go.kr";

function goPopup(){
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
    var pop = window.open("<%=request.getContextPath()%>/views/address/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes");  
    
	// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
}
/** API 서비스 제공항목 확대 (2017.02) **/
function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn
						, detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn, buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo){
	// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
	document.form.roadAddrPart1.value = roadAddrPart1;
	document.form.roadAddrPart2.value = roadAddrPart2;
	document.form.addrDetail.value = addrDetail;
	document.form.zipNo.value = zipNo;
}
</script> 
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
            <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="" style="object-fit:contain;">
                
            </div>
            <div class="bottom">
                

                    <div class="email">
                        <input type="email" id="email" name="email" placeholder="이메일" required>
                    </div>
                    
                <div class="Shipping">
                <form name="form" id="form" method="post">
                    <p>배송지 주소</p>
                    <div class="name">
                        <input type="text" id="firstName" placeholder="이름" required>
                        <input type="text" id="lastName"placeholder="성" required>
                        
                        
                    </div>
                    	<div class="phone-form">
	                    	<p>전화번호</p>
	                    	<input type="number" id="phone-first" size="3" required>-
	                    	<input type="number" id="phone-second" size="4" required>-
	                    	<input type="number" id="phone-third" size="4" required>
                    	</div>
                    <div class="btm">
                        <!-- <input type="text" placeholder="국가/지역"> -->
                        <!-- <input type="text" placeholder="상태"> -->
                        
                        <input type="hidden" id="confmKey" name="confmKey" value=""  >
                        <input type="text" id="zipNo" name="zipNo" readonly placeholder="우편 번호" required>
                    	<input type="button"  value="주소검색" onclick="goPopup();">
                    </div>
                    <div class="mid">
                        <input type="text" id="roadAddrPart1"  placeholder="주소" required>
                        <input type="text" id="addrDetail"  placeholder="상세주소" required>
						<input type="text" id="roadAddrPart2"placeholder="상세주소2" >
                        <!-- <input type="text" placeholder="시티"> -->
                    </div>
                    <button id="checkout-btn" onclick="requestPay(); return false;">결제</button>
                 </form>
                </div>
            </div>
        </div>
        <div class="right">
        <% 
        for(int productId : productInfo.keySet()){
        	Product p= productInfo.get(productId);
        	totalAmount+=p.getProductPrice() * cartValues.get(productId); 
         %>
            <div class="tp">
                <label><img src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(0) %>" alt=""></label>
                <h4><%=p.getProductName() %></h4>
                <p><%=p.getProductPrice()%> 원 X <%=cartValues.get(productId) %> 개</p>
            </div>
         
            <hr>
            <div class="subtotal-shipping">
                <div class="Subtotal">
                    <p>소계</p>
                    <p><%=p.getProductPrice() * cartValues.get(productId) %> 원</p>
                </div>
               
            </div>
            <hr>
            <%} %>
            <hr>
            <div class="sub">
                <p>합계</p>
                <p> <b><%=totalAmount %> 원</b></p>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>
<script>
	/* 아임포트 API 초기화-가맹점 식별코드 삽입*/
	const IMP = window.IMP;
	IMP.init("imp71956162");
	function requestPayButtonFunction(){
		requestPay();
		return false;
	}
	function requestPay(){
		IMP.request_pay({ // param
		    pg: "html5_inicis",
		    pay_method: "card",
		    merchant_uid: '<%=merchant_uid%>',
		    name: '<%=productInfo.get(firstProduct).getProductName()%> 외 <%=productInfo.size()-1%>',
		    amount: Number('<%=totalAmount%>'),
		    buyer_email: $("#email").val(),
		    buyer_name: $("#lastName").val()+" "+$("#firstName").val(),
		    buyer_tel: $("#phone-first").val()+"-"+$("#phone-second").val()+"-"+$("#phone-third").val(),
		    buyer_addr: $("#roadAddrPart1").val()+" "+$("#addrDetail").val()+ " "+ $("#roadAddrPart2").val(),
		    buyer_postcode: $("#zipNo").val()
		    
		  }, function (rsp) { // callback
		    if (rsp.success) {
		        console.log("성공");
		        
		        $.ajax({
		        	url: '<%=contextPath%>/order/process',
		        	type: "POST",
		        	data:{
		        		"imp_uid" : rsp.imp_uid,
		        		"merchant_uid" : rsp.merchant_uid,
		        		"member_key" : <% if(m!=null){%><%=m.getMemberKey()%><%}%>,
		        		
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
		        $.ajax({
					url: '<%=contextPath%>/order/moveFromPayment',
					type: "POST",
					data:{
						"merchant_uid" : '<%=merchant_uid%>'
					},
					success: (data)=>{
						<%System.out.println("성공");%>
					},
					fail: error=>{
						<%System.out.println("실패");%>
					}
				})
		    }
		  })
	}
	
	/* 결제하지 않고 창 이동 시! */
	<%-- /* window.onbeforeunload=function (){
		
		$.ajax({
			url: '<%=contextPath%>/order/moveFromPayment',
			type: "POST",
			data:{
				"merchant_uid" : '<%=merchant_uid%>'
			},
			success: (data)=>{
				<%System.out.println("성공");%>
			},
			fail: error=>{
				<%System.out.println("실패");%>
			}
		})
	} */ --%>
</script>
</body>
</html>