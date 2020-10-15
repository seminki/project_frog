<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<style>
.top{
background-color:gray;
display:flex;
justify-content: center;
align-items: center;
width:100%;
font-size: 2em;
font-weight: 900;
color:black;
}
img{
    width:60px;
    height: 60px;
}
.text{
    margin-left:10%;
    margin-right:10%;
    margin-bottom: 10%;
}
h1{
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
            <h1>취소 정책</h1>
            <p>모든 판매는 최종적이며 주문이 제출 된 후에는 취소 할 수 없습니다.<br><br>
                주문을 제출하기 전에 구매를 검토하여 청구 / 배송, 주문 수량이 올바른지 확인하십시오. 주문이 확인 된 후에는 수량을 업데이트하거나 항목을 추가 또는 제거하거나 배송지 주소를 업데이트 할 수 없습니다.<br><br>
                수량 제한<br>
                팬과 수집가에게 독점 또는 비 독점 품목을 구매할 수있는 최상의 기회를 제공하기 위해 또는 기타 이유로 당사는 수량을 제한 할 권리를 보유합니다.<br><br>
                품목에 대한 한도를 초과하는 것으로 확인 된 주문은 주문 후 취소 될 수 있습니다. 주문이 취소되면 명세서에 미결제 요금이 표시 될 수 있으며 영업일 기준 3 ~ 7 일 이내에 취소되지만 이 기간은 금융 기관에 따라 다를 수 있습니다.<br><br>
                여러 이메일 주소를 사용하거나, 배송 주소를 조작하거나, 동일한 제품을 여러 번 과도하게 주문하거나, 다른 방법으로 제품 제한을 우회하려는 경우 모든 주문이 취소되거나 향후 구매가 차단 될 수 있습니다.<br><br>
                대량 구매<br>
                TOYSPACE는 대량 구매에 적용되는 주문 및 구매 조건을 제한, 제한, 취소 또는 변경할 권리를 보유합니다. "대량 구매"라는 용어는 재판매 및 / 또는 동일한 품목을 6 개 이상 구매하기위한 구매로 정의됩니다.<br><br>
                대량 구매시 배송비가 적용될 수 있습니다.<br><br>
                주문에 대한 도움이 필요하면 실시간 채팅문의를 통해 TOYSPACE에 문의하십시오.</p>
        </div>
    </section>
</body>
</html>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>