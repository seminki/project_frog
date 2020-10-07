<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<%@ include file="/views/common/admin_header.jsp"%>
		<section>
			<div class="sales-container">
				<div class="top-button-container">
					<h1>매출관리</h1>
					<div class="scope-buttons">
						<select name="scope" id="scope">
							<option value="">**스코프 설정**</option>
							<option value="day" >일별</option>
							<option value="week" >주별</option>
							<option value="month" >월별</option>
							<option value="year">연도별</option> 
						</select>
						<select name="category" id="category">
							<option value="">**카테고리 설정**</option>
							<!-- 모든 카테고리를 불러와서 그대로 설정해주기 -->
						</select>
						<button class="submit">검색</button>
					</div>
				</div>
				<div class="sales-stat-container"></div>
			</div>
		</section>
	</body>
	<script src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="<%=request.getContextPath() %>/js/admin/sales.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/sales.css" />
</html>
