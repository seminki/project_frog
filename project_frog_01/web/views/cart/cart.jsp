<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.product.model.vo.Product, java.util.TreeMap"%>
<%
TreeMap<Integer, Product> productInCart =null;
int totalAmount=0;

%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/newStyle.css">
	<%@ include file="/views/common/favicon.jsp" %>
     <title>TOY SPACE - Where All Toys' Dream Comes True</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<section>
      <div class="title section-title">
          MY CART
      </div>
      
      <!-- 카트에 들어간게 있을때와 없을때 -->
      <%if(cartValues!=null&& cartValues.size()!=0){ 
      	productInCart = (TreeMap<Integer, Product>)request.getAttribute("productInCart");
      	totalAmount = 0;
      	for(int productId : productInCart.keySet()){
      		totalAmount+=productInCart.get(productId).getProductPrice() * cartValues.get(productId);
      	}
      %>
      
      <div class="summary-container">
        <div class="summary-top medium-title">
          <span>총 갯수</span>
          <div>
          <span id="summary-qty"><%=cartQty %></span>
          <span> 개</span>
          </div>
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
         	<div>
          <span id="summary-amount"><%=(int)totalAmount %></span>
          <span> 원</span>
          </div>
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
          <%for(int productId : productInCart.keySet()) { 
        	  Product p =productInCart.get(productId);
          %>
         
          <tr>
            <td>
              <div class="product-table-img-cont">
                <img src="<%=contextPath%>/upload/product/<%=p.getProductImageFilePaths().get(0) %>" alt="11">
              </div>
            </td>
            <td>
              <div class="product-description-cont">
                <div>
                  <span class="cart-product-category small-title"><%=p.getCategoryName() %></span>
                </div>
                <div>
                  <b class="cart-product-name"><%=p.getProductName() %></b>
                </div>
              </div>
            </td>
            <td></td>
          </tr>
          <tr>
            <td class="trash-container">
                <button class="white-icon" onclick="removeItem(event, '<%=productId%>');">
                    <i class="fas fa-trash"></i>
                </button>
            </td>
            <td class="qty-btn-cont">
              <div class="plus2">
                <div class="plus3">
                    <button class="minus" onclick="deductQty(event, '<%=productId%>');">
                        <i class="fas fa-minus"></i>
                    </button>
                    <input type="number" class="int" id="qty-<%=productId%>" min="0" value="<%=cartValues.get(productId)%>">
                    
                    <button class="plus" onclick="addQty(event, '<%=productId%>');">
                        <i class="fas fa-plus"></i>
                    </button>
                </div>
           </div>
            </td>
            <td>
              <div class="money">
                <span class="sub-amount" name = "<%=p.getProductPrice()%>" id="sub-amount-<%=productId%>"><%=(int)(p.getProductPrice()*cartValues.get(productId)) %></span>
                <span> 원</span>
            </div>
            </td>
          </tr>
          <tr>
            <td colspan="3"><hr></td>
          </tr>
    
          <%} %>
<!-- 여기까지! -->
        </table>

      </div>

      <div class="bottom-checkout-container">
        <button id ="checkout-btn"><b>체크 아웃</b></button>
      </div>
	<%}else{ %>
		<div class="summary-container">
        <div class="summary-top medium-title">
          엇..... 아무것도 없는데요? 
          장난감들이 여러분을 기다리고 있는데 ㅠ
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
	
	function deductQty(e, productId){
    let qty = $("#qty-"+productId).val();
    if(qty!=0){
      $("#qty-"+productId).val(qty-1);
      $.ajax({
        url: "<%=contextPath%>/cart/addToCart",
        type:"POST",
        data:{
          "productId":productId,
          "value" : -1,
        },
        success: (data)=>{
          successRoutine(data);
          cartSuccessRoutine(data, productId, $("#qty-"+productId).val());
          
        },
        fail : error =>{
          console.log(error);
        }
      })
    }
  }
	
	function addQty(e, productId){
		let qty = $("#qty-"+productId).val();
		$("#qty-"+productId).val(Number(qty)+1);
	      $.ajax({
	        url: "<%=contextPath%>/cart/addToCart",
	        type:"POST",
	        data:{
	          "productId":productId,
	          "value" : 1,
	        },
	        success: (data)=>{
	          successRoutine(data);
	          cartSuccessRoutine(data, productId, $("#qty-"+productId).val());
	          
	        },
	        fail : error =>{
	          console.log(error);
	        }
	      })
	}
  function cartSuccessRoutine(data, productId, amount){
    $("#summary-qty").html(data);
    $("#sub-amount-"+productId).html(Number($("#qty-"+productId).val()) * Number($("#sub-amount-"+productId).attr("name")));
    let totalAmount = 0;
    $(".sub-amount").each((i,v)=>{
    	totalAmount+=Number($(v).html());
    })
    $("#summary-amount").html(totalAmount);
  }
  
  function removeItem(e, productId){
	  $.ajax({
		  url: "<%=contextPath%>/cart/removeItem",
		  type: "POST",
		  data: {
			  "productId" : productId
		  },
		  success: (data) =>{
			  successRoutine(data);
			  $("#summary-qty").html(data);
			   const targetCont = $(e.target).parent().parent().parent();
			    targetCont.prev().remove();
			    targetCont.next().remove();
			    targetCont.remove();
			  
			  let totalAmount = 0;
			    $(".sub-amount").each((i,v)=>{
			    	totalAmount+=Number($(v).html());
			    })
			    $("#summary-amount").html(totalAmount);
		  },
		  fail : error =>{
			  console.log(error);
		  }
		  
	  })
  }
  
  
</script>
</body>
</html>