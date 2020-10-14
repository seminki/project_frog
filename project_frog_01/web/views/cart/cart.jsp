<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/newStyle.css">
    <title>df</title> 
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section>
      <div class="title section-title">
          MY CART
      </div>
      
      <!-- 카트에 들어간게 있을때와 없을때 -->
      <%if(cartValues!=null&& cartValues.size()!=0){ %>
      
      <div class="summary-container">
        <div class="summary-top medium-title">
          <span>총 갯수</span>
          <span id="summary-qty">0 개</span>
        </div>
        <hr>
        <div class="summary-middle">
          <b>체크 아웃을 클릭하면 이용 약관에 동의 하고
            모든 판매가 최종적임을 이해합니다. 적용 가능한
            모든 할인 또는 쿠폰은 결제 시 반영됩니다.</b>
        </div>
        <hr>
        <div class="summary-bottom medium-title">
          <span>총 금액</span>
          <span id="summary-amount">0 원</span>
        </div>
      </div>
      <div class="product-container">
        <table class="product-table">
          <tr>
            <th>상품</th>
            <th>개수</th>
            <th>가격</th>
          </tr>
          <tr class="table-bottom-line">
              <td colspan="3"> <hr> </td>
          </tr>
          <!-- 여기서부터 포문 돌리기 -->
          <tr>
            <td>
              <div class="product-table-img-cont">
                <img src="<%=contextPath%>/upload/product/Disney_Esmerelda.png" alt="11">
              </div>
            </td>
            <td>
              <div class="product-description-cont">
                <div>
                  <span class="cart-product-category small-title">CATEGORY</span>
                </div>
                <div>
                  <b class="cart-product-name">Esmeralda</b>
                </div>
              </div>
            </td>
            <td></td>
          </tr>
          <tr>
            <td class="trash-container">
                <button class="white-icon">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
            <td class="qty-btn-cont">
              <div class="plus2">
                <div class="plus3">
                    <button class="minus">
                        <i class="fas fa-minus"></i>
                    </button>
                    <input type="number" class="int" min="0">
                    <button class="plus">
                        <i class="fas fa-plus"></i>
                    </button>
                </div>
           </div>
            </td>
            <td>
              <div class="money">
                <span class="sub-amount">11원</span>
            </div>
            </td>
          </tr>
          <tr>
            <td colspan="3"><hr></td>
          </tr>
<!-- 여기까지! -->
        </table>

      </div>

      <div class="bottom-checkout-container">
        <button id ="checkout-btn"><b>체크 아웃</b></button>
      </div>
	<%}else{ %>
		<div class="summary-container">
        <div class="summary-top medium-title">
          엇..... 아무것도 없는데요? 장난감들이 여러분을 기다리고 있는데 ㅠ
        </div>
        
      </div>
		<div class="empty-space"></div>
	<%} %>
    </section>
<%@ include file="/views/common/footer.jsp" %>

<script>

	$("#checkout-btn").click((e)=>{
		/* 체크아웃 버튼 누를 때 수행할 로직*/
		location.href = "<%=contextPath%>/order/moveToPayment";
	})
	
	

</script>
</body>
</html>