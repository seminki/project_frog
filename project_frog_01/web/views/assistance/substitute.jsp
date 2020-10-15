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
            <h1>교환 정책</h1>
            <p>당사 사이트에서 구매 한 모든 상품은 타사 운송 업체에서 배송됩니다. 결과적으로,
                그러한 상품에 대한 소유권 및 손실 또는 손상 위험은 당사가 운송 업체에 배송하는 즉시
                귀하에게 이전됩니다. 모든 누락, 손상 및 잘못된 배송 또는 항목은 수령 후 15일 이내에 보고해야하며
                이메일 제출시 사진 문서를 포함해야합니다. 이러한 항목은 지원 담당자가 검토하며 해당되는 경우
                손상된 제품에 대해서만 교체가 발행되며 해당 제품의 포장을 덮거나 포함하지 않습니다. 포장 얼룩은
                손상된 품목의 일부로 간주되지 않습니다. 모든 교체는 고객 지원의 재량에 따릅니다. 다음 교체 제한 사항에
                유의하십시오.<br><br>
                우리는 사소한 제조 변형을 통제 할 수 없으며 사소한 페인트 결함이나 그림 위치를 포함하되 이에 국한되지 않는
                이러한 변형을 기반으로 항목을 교체 할 수 없습니다. 포장의 흠집은 손상된 그림의 일부로 간주되지 않습니다.<br><br>
                제품 포장<br>
                우리는 내부의 수집품을 보호하기 위해 포장을 설계하며, 바로 이러한 이유로 상자를 밀봉하지 않습니다.
                당신의 Pop! 피규어 및 기타 제품을 상자에서 꺼내서 즐기십시오! 상자에 그림을 보관하도록 선택하더라도
                포장을 교체 할 수 없습니다.<br><br>
                거부되거나 배송되지 않는 패키지<br>
                구매자 오류 또는 배송 거부로 인해 반품 패키지에는 구매가격의 최대 20% 까지 재입고 수수료가 부과됩니다.
                고객은 UPS에 연락하여 대체 배송을 준비 할 수 있습니다. TOYSPACE는 이 대체 배송과 관련된 수수료에 대해 책임을 지지 않습니다.<br><br>
                매진<br>
                보관 된 품목에 대한 교체 교체 재고를 항상 사용할 수 있는 것은 아니므로 매진되었거나 오래된 보관 된
                품목에 대한 교체 부품이 있을 것이라고 보장 할 수 없습니다. 허용되는 교체품이 발견 된 경우 교체 부품을 보내 드리기 위해
                배송비가 부과 될 수 있습니다.<br><br>
                주문에 대한 도움이 필요하면 ?지원 버튼을 눌러 실시간 채팅 문의로 TOYSPACE에 문의하십시오.
            </p>
        </div>
    </section>
</body>
</html>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>