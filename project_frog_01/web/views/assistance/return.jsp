<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<style>
section .top{
background-color:gray;
display:flex;
justify-content: center;
align-items: center;
width:100%;
font-size: 2em;
font-weight: 900;
color:black;
}
section img{
    width:60px;
    height: 60px;
}
section .text{
    margin-left:10%;
    margin-right:10%;
    margin-bottom: 10%;
}
section h1{
    font-size: 3em;
    font-weight: 900;
}
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<body>
    <section>
        <div class="top">
        	<img src="<%=request.getContextPath()%>/image/about/toyspace.png">
            <p>TOYSPACE OPEN !!</p>
        </div>
        <div class="text">
            <h1>반품 정책</h1>
            <p>TOYSPACE 구매를 반품하고 싶다면 저희가 도와 드리겠습니다! 주문을 받은 후 5 일 이내에 TOYSPACE 상품을
                반품 할 수 있으며 환불에서 배송비를 공제합니다. 원래의 상자와 포장에 있는 항목을 반환하십시오.<br><br>
                실시간 채팅 문의를 통해 반품 관련 글을 적으신 후 10일 이내에 상품을 반송해야합니다. 글을 적은 후 10일이 지난 상품을 보내면
                환불에서 20% 재입고 수수료가 공제됩니다. 환불은 원래 결제 방법으로 상품을 수령 한 후 영업일 기준 2일 이내에 처리됩니다.<br><br>
                다음은 위의 반품 정책에 대한 예외입니다.<br><br>
            </p>
            <ul>
                <li>상품에 대한 우발적 파손에 대하여 책임을 지지 않습니다.</li>
                <li>상품의 라벨 제거시</li>
            </ul>
        </div>
    </section>
</body>
</html>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>