<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/admin_header.jsp"%>
		
		<section>
			<h1>채팅 메뉴</h1>
			<div class="main-container">
				<div class="chat-list-container">
					<div class="chat-head">
						<table>
						<tr>
							<th>고객 아이디</th>
							<th>세션 아이디</th>
							<th>유입 시간</th>
						</tr>
					</table>
					</div>
					<div class="chat-list-div">
						<table class="chat-list">
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>
							<tr>
								<td>1</td>
								<td>1</td>
								<td>1</td>
							</tr>

						</table>
					</div>
					<div class="chat-list-button-container">

						<input type="button" value="삭제">
						<input type="button" value="입장">
					</div>
				</div>
				<div class="arrow-container">
					<h1> => </h1>
				</div>
				<div class="chat-container">
					<div class="chat-top-container">
						<span>고객 아이디 & 세션 아이디</span>
						<input type="button" value="종료">
					</div>
					<div class="chat-content-container">
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						<div class="customer-message-container">
							<span>안뇽 난 손님이야</span>
						</div>
						<div class="admin-message-container">
							<span>그럼 난 어드민!</span>
						</div>
						
					</div>
					<div class="chat-input-container">
						<input type="text" id="chat-input">
						<input type="button" value="전송" id="chat-send-button">
					</div>
				</div>
			</div>

		</section>
	</body>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/adminChat.css">
</html>
