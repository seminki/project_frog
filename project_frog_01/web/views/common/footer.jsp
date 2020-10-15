<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/common/footerStyle.css" />
<footer>
	<div class="footer-first-cont">
		<div class="footer-logo-cont">
			<a href="/">
				<img src="<%=request.getContextPath()%>/image/common/blacklogo.png" alt="" />
			</a>
		</div>
		<div class="footer-social-icons">
			<i class="fab fa-facebook-square animate__animated"></i>
			<i class="fab fa-twitter-square animate__animated"></i>
			<i class="fab fa-instagram-square animate__animated"></i>
			<i class="fab fa-youtube animate__animated"></i>
		</div>
	</div>
	<div class="footer-second-cont">
		<div class="footer-menu-cont">
			<ul>
				<li><a href="">ACCOUNT</a></li>
				<li><a href="">계정</a></li>
				<li><a href="">구매 기록</a></li>
			</ul>
			<ul>
				<li><a href="">ASSISTANCE</a></li>
				<li><a href="<%=request.getContextPath()%>/return.do">반품 정책</a></li>
				<li><a href="<%=request.getContextPath()%>/substitute.do">교환 정책</a></li>
				<li><a href="<%=request.getContextPath()%>/cancellation.do">취소 정책</a></li>
			</ul>
		</div>
		<div class="footer-menu-cont">
			<ul>
				<li><a href="">ABOUT TOYSPACE</a></li>
				<li><a href="<%=request.getContextPath()%>/introduce.do">회사 소개</a></li>
				<li><a href="<%=request.getContextPath()%>/map.do">위치</a></li>
				<li><a href="<%=request.getContextPath()%>/job.do">직업을 찾으십니까?</a></li>
				<li><a href="">매장 현황</a></li>
			</ul>
			<ul>
				<li><a href="">CONNECT WITH US</a></li>
				<li><a href="">연락처</a></li>
				<li><a href="">Twitter</a></li>
				<li><a href="">Instagram</a></li>
				<li><a href="">Facebook</a></li>
				<li><a href="">Youtube</a></li>
			</ul>
		</div>
	</div>
	<div class="footer-third-cont">© ToySpace. All rights reserved.</div>
</footer>
<script src="<%=request.getContextPath()%>/js/common/footerScript.js"></script>
