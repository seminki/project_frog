<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.toyspace.product.model.vo.Product,com.toyspace.order.history.model.vo.OrderHistory, java.util.TreeMap"%>
    
<% 
    OrderHistory oh = (OrderHistory)request.getAttribute("orderHistory");
TreeMap<Integer, Product> productInfo = (TreeMap<Integer, Product>)request.getAttribute("productInfo");
   
    %>

 <%@ include file="/views/common/admin_header.jsp"%>

<style>
	.memberKeyRow{
		cursor:pointer;
	}
</style>
<section>

<table>
	<tr>
		<th>
			주문 번호
		</th>
		<td>
			<%=oh.getOrderNo() %>
		</td>
	</tr>
	
	<tr class="memberKeyRow" onclick="moveToMemberDetail('<%=oh.getMemberKey() %>');">
		<th>
			주문 멤버키 
		</th>
		<td>
			<%=oh.getMemberKey() %>
		</td>
	</tr>
	<tr>
		<th>
			주문 날짜
		</th>
		<td>
		<%=oh.getOrderedDate() %>
		</td>
	</tr>
	<tr>
		<th>
			주문 방법
		</th>
		<td>
		<%=oh.getPaymentMethod() %>
		</td>
	</tr>
	<tr>
		<th>
			주문 상태
		</th>
		<td>
		<%=oh.getStatusDetail() %>
		</td>
	</tr>
	<tr>
		<th>
			인증 번호
		</th>
		<td>
		<%=oh.getApplyNum() %>
		</td>
	</tr>
	<tr>
		<th>
			주문 유니크 번호
		</th>
		<td>
		<%=oh.getMerchantUid() %>
		</td>
	</tr>
	<tr>
		<th>
			주문자 전화번호
		</th>
		<td>
		<%=oh.getBuyerTel() %>
		</td>
	</tr>
	<tr>
		<th>
			받는 사람 이름
		</th>
		<td>
		<%=oh.getReceiverName() %>
		</td>
	</tr>
	<tr>
		<th>
			받는 사람 전화번호
		</th>
		<td>
		<%=oh.getReceiverTel() %>
		</td>
	</tr>
	<tr>
		<th>
			우편번호
		</th>
		<td>
		<%=oh.getReceiverPostcode() %>
		</td>
	</tr>
	<tr>
		<th>
			주소
		</th>
		<td>
		<%=oh.getReceiverAddr() %>
		</td>
	</tr>
	<tr>
		<th>
			커멘트
		</th>
		<td>
		<%=oh.getReceiverComment() %>
		</td>
	</tr>
	<tr>
		<th>
			총 주문 금액
		</th>
		<td>
		<%=oh.getTotalAmount() %>
		</td>
	</tr>

</table>

<table>
	<tr>
		<th>상품 사진</th>
		<th>상품 아이디</th>
		<th>상품 카테고리</th>
		<th>상품 이름</th>
		<th>상품 가격</th>
		<th>구매 개수</th>
		<th>소계</th>
	</tr>
	
	<%for(int productId : productInfo.keySet()) {
		Product p = productInfo.get(productId);
	%>
		<tr>
			<td> <img alt="" src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(0)%>"> </td>
			<td><%=p.getProductId() %></td>
			<td><%=p.getCategoryName() %></td>
			<td><%=p.getProductName() %></td>
			<td><%=p.getProductPrice()%></td>
			<td><%=oh.getProductList().get(productId) %></td>
			<td><%=oh.getProductList().get(productId) * p.getProductPrice() %></td>
		</tr>
	<%} %>
	
</table>

</section>
<script>

	function moveToMemberDetail(memberKey){
		location.href = '<%=request.getContextPath()%>/admin/memberDetail?memberKey='+memberKey;
	}

</script>

</body>
</html>