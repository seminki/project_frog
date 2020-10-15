<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.toyspace.member.model.vo.Member, com.toyspace.order.history.model.vo.OrderHistory, java.util.ArrayList"%>
    <% 
    
    ArrayList<OrderHistory> orderHistories = (ArrayList<OrderHistory>)request.getAttribute("orderHistories");
    
  
    %>
    <%@ include file="/views/common/admin_header.jsp"%>
<section>

<table>
	
		<tr>
			<th>주문 번호</th>
			<th>주문 멤버키</th>
			<th>주문 날짜</th>
			<th>주문 방법</th>
			<th>주문 상태</th>
			<th>인증 번호</th>
		
			<th>주문 유니크 번호</th>
			<th>받는 사람</th>
			<th>주문 금액</th>
			
		</tr>
		<% for(OrderHistory oh : orderHistories){ %>
		<tr class="orderHistoryRow" onclick="moveToOrderHistoryDetail(<%=oh.getOrderNo()%>);">
			<td><%=oh.getOrderNo() %></td>
			<td><%=oh.getMemberKey() %></td>
			<td><%=oh.getOrderedDate() %></td>
			<td><%=oh.getPaymentMethod() %></td>
			<td><%=oh.getStatusDetail()%></td>
			<td><%=oh.getApplyNum()%></td>
			
			<td><%=oh.getMerchantUid() %></td>
			<td><%=oh.getReceiverName() %></td>
			<td><%=oh.getTotalAmount()%></td>
		</tr>
		<%} %>
	</table>
	
	<style>
	.orderHistoryRow{
		cursor:pointer;
	}
	/* 추가한 부분 */
	table{
        display:flex;
        justify-content: center;
        align-items: center;
    }
	table td{
    border : 1px solid black;
	}
	</style>
	
	


</section>
	<script>
		function moveToOrderHistoryDetail(orderNo){
			location.href = '<%=request.getContextPath()%>/admin/orderDetail?orderNo='+orderNo;
		}
	</script>
</body>
</html>