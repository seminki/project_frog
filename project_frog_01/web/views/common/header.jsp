<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.member.model.vo.Member"%>
<%String contextPath = request.getContextPath(); 
Member signedInMember=(Member)(session.getAttribute("signedInMember"));

%>
		<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
		<script
			src="https://kit.fontawesome.com/8f9d453cdc.js"
			crossorigin="anonymous"
		></script>
		<link rel="stylesheet" href="<%=contextPath%>/css/common/commonStyle.css" />
		<link rel="stylesheet" href="<%=contextPath%>/css/common/headerStyle.css" />
		<link
    rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css"
  />


		<header>
			<div class="header-container">
				<div class="header-logo">
					<a href="<%=contextPath%>">
						<img
							src="<%=contextPath%>/image/common/blacklogo.png"
							alt="logo"
							class="header-logo-image"
						/>
					</a>
				</div>
				<div class="header-middle-menu">
					<div class="header-product-container header-menu-container">
						<a href="<%=contextPath%>/productlist.do" class="header-menu-title">PRODUCTS</a>
						<ul class="uler">
							<div class="header-gray-bar"></div>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
							<li class="header-product-list">
								<div>
									<div class="header-product-img">
										<img
											src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png"
											class="header-menu-image"
											alt=""
										/>
									</div>
									<a href="">Heroes</a>
								</div>
							</li>
						</ul>
					</div>
					<div class="header-community-container header-menu-container">
						<a href="" class="header-menu-title">COMMUNITY</a>
					</div>
					<div class="header-about-container header-menu-container">
						<a href="" class="header-menu-title">ABOUT</a>
					</div>
				</div>
				<div class="header-icons">
					<ul class="icons">
						<li class="search-bar-li">
							<a href="#">
								<div class="search-bar animate__animated">
									<i class="fas fa-search big-search "></i>
									<span>검색....</span>
								</div>
							</a>
						</li>
						<li class="user-li">
							<% if(signedInMember==null){ %>
							<a href="<%=contextPath%>/login.do">
							<%} else { %>
							<a href="<%=contextPath%>/member/myPage">
							<%} %>
								<i class="fas fa-user-astronaut user"></i>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="fas fa-search small-search"></i>
							</a>
						</li>
						<li>
							<a href="<%=contextPath%>/cart.do">
								<i class="fas fa-shopping-cart"></i>
								<div id="cart-amount">0</div>
							</a>
						</li>
						<li>
							<a href="#">
								<i class="fas fa-bars"></i>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="gray-scale"></div>
			<div class="search-bar-input">
				<i class="fas fa-search search-input-icon"></i>
				<input type="text" id="search-input" />
				<a href="#"><i class="fas fa-times search-x"></i></a>
			</div>
			<div class="side-bar">
				<div class="side-bar-top-cont side-bar-margin">
					<% if(signedInMember==null){ %>
							<a href="<%=contextPath%>/login.do">
							<%} else { %>
							<a href="<%=contextPath%>/member/myPage">
							<%} %>
					<i class="fa fa-user-circle user2"></i></a>
					<a href="#"><i class="fas fa-times side-x"></i></a>
				</div>
						<style type="text/css">
		a-color:link { color: black; text-decoration: none;}
		a-color:visited { color: black; text-decoration: none;}
		a-color:hover { color: black; text-decoration: underline;}
		</style>
		<!-- a태그  눌렀을때 마우스 올렸을때  평상시 색상 블랙 으로 변경  -->
				<div class="side-bar-product side-bar-margin" >
				<a  class="a-color" href="<%=contextPath%>/productlist.do" >PRODUCTS</a>
				</div>
				<div class="side-bar-product-cont side-bar-margin">
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
          <div class="side-bar-product-category">
            <a href="#">
              <div class="side-bar-img-cont">
                <img src="<%=contextPath%>/image/product/Nav-BatmanDC2-e4d01c44fb9235de2b33f34c1c669141.png" alt="" class="side-bar-img">
              </div>
              <span>Heroes</span>
            </a>
            
          </div>
        </div>
        <div class="side-bar-margin"></div>
				<div class="side-bar-community side-bar-margin">COMMUNITY</div>
				<div class="side-bar-about side-bar-margin">ABOUT</div>
			</div>
			<div class="bottom-support-ui animate__animated animate__delay-1s">
				<i class="far fa-question-circle"></i> 지원
			</div>
			<div class="chatting-window animate__animated">
				<div class="chatting-top">
					<span>실시간 채팅 문의</span>  <i class="fas fa-minus-square chatting-x"></i>
				</div>
				<div class="chatting-content">
					채팅 표시 창!
				</div>
				<div class="chatting-send">
					<input type="text" id="chatting-input">
					<button id="chatting-send-button">전송</button>
				</div>
			</div>
		</header>
	<script src="<%=contextPath%>/js/common/headerScript.js"></script>
<script>

</script>

