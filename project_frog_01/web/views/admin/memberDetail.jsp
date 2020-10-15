<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.toyspace.member.model.vo.Member, com.toyspace.order.history.model.vo.OrderHistory, java.util.ArrayList"%>
    <%
    Member m = (Member)request.getAttribute("memberInfo");
    ArrayList<OrderHistory> orderHistories = (ArrayList<OrderHistory>)request.getAttribute("orderHistories");
    %>
<%@ include file="/views/common/admin_header.jsp"%>
	<section>
	<table>
		<tr>
		<th>멤버 키</th>
		<td><%=m.getMemberKey() %></td>
		</tr>
		<tr>
		<th>유저 아이디</th>
		<td><%=m.getUserId() %></td>
		</tr>
		<tr>
		<th>유저 이메일</th>
		<td><%=m.getUserEmail() %></td>
		</tr>
		<tr>
		<th>유저 성별</th>
		<td><%=m.getUserGender() %></td>
		</tr>
		<tr>
		<th>유저 이름</th>
		<td><%=m.getUserName() %></td>
		</tr>
		<tr>
		<th>유저 별명</th>
		<td><%=m.getUserNickname() %></td>
		</tr>
		<tr>
		<th>나이</th>
		<td><%=m.getUserAge() %></td>
		</tr>
		<tr>
		<th>생일</th>
		<td><%=m.getUserBirthday() %></td>
		</tr>
		<tr>
		<th>주소</th>
		<td><%=m.getUserAddress() %></td>
		</tr>
		<tr>
		<th>전화번호</th>
		<td><%=m.getUserPhone() %></td>
		</tr>
		<tr>
		<th>가입날짜</th>
		<td><%=m.getUserSignUpDate() %></td>
		</tr>
		<tr>
		<th>프로필 사진</th>
		<td></td>
		</tr>
		<tr>
		<th>유저 마일리지</th>
		<td><%=m.getUserMileage() %></td>
		</tr>
		<tr>
		<th>레벨</th>
		<td><%=m.getMemberLevelDescription() %></td>
		</tr>
		<tr>
		<th>마지막 수정일</th>
		<td><%=m.getModifiedDate() %></td>
		</tr>
		<tr>
		<th>간편 로그인으로 불러온 사진</th>
		<td><%if(m.getUserProfilePicUrl()!=null){%> <img alt="" src="<%=m.getUserProfilePicUrl()%>"><%} %> </td>
		</tr>
		<tr>


	</table>
	<hr>
	<hr>
	<table>
	
		<tr>
			<th>주문 번호</th>
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
	</style>
	
	</section>
	<script>
		function moveToOrderHistoryDetail(orderNo){
			location.href = '<%=request.getContextPath()%>/admin/orderDetail?orderNo='+orderNo;
		}
	</script>
</body>
</html>