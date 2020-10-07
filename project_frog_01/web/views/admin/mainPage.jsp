<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/views/common/admin_header.jsp"%>
		<section>
		<script src="https://www.gstatic.com/charts/loader.js"></script>
		<script src="<%=request.getContextPath() %>/js/admin/mainPage.js"></script>
			<div class="main-container">
				<div class="main-top-container">
					<div class="financial-stat-container">
						<div class="main-sub-titles">
							<h3>매출 현황</h3>
						</div>
						<div class="duration-button-container">
							<input type="button" value="이번 주" />
							<input type="button" value="이번 월" />
							<input type="button" value="이번 해" />
						</div>
						<div class="stat-container">
							<div class="financial-stat"></div>
							<div class="sum-container">
								<h4>Total :</h4>
								<h4 class="sum-value">123412원</h4>
							</div>
						</div>
					</div>
					<div class="popular-items-container">
						<div class="main-sub-titles">
							<h3>인기 제품 순위</h3>
						</div>
						<div class="duration-button-container">
							<input type="button" value="이번 주" />
							<input type="button" value="이번 월" />
							<input type="button" value="이번 해" />
						</div>
						<div class="popular-items-stat"></div>
					</div>
					<div class="popular-category-container">
						<div class="main-sub-titles">
							<h3>카테고리 별 인기 순위</h3>
						</div>
						<div class="duration-button-container">
							<input type="button" value="이번 주" />
							<input type="button" value="이번 월" />
							<input type="button" value="이번 해" />
						</div>

						<div class="popular-category-stat"></div>
					</div>
				</div>
				<div class="main-bottom-container">
					<div class="chat-menu-container">
						<div class="main-sub-titles">
							<h3>대기 중인 채팅</h3>
						</div>
						<div class="chat-panel">
							<div class="chat-count-container">
								<h4>대기중인 인원 수</h4>
								<h1>2명</h1>
							</div>
							<div class="chat-list">대기 중인 채팅방 목록 표시</div>
						</div>
					</div>
					<div class="notice-container">
						<div class="main-sub-titles">
							<h3>공지사항</h3>
						</div>
						<div class="notice-list"></div>
					</div>
				</div>
			</div>
		</section>
		<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/mainPage.css" />
	</body>
</html>
