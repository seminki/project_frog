<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.toyspace.product.model.vo.*, java.util.ArrayList, java.util.TreeMap"%>
<%
	ArrayList<Product> productsList = (ArrayList<Product>) request.getAttribute("productsList");
	String searchKeyword =(String)request.getAttribute("searchKeyword");
	Object totalData=request.getAttribute("totalData");
	TreeMap<Integer, Integer> categoryQty = (TreeMap<Integer, Integer>)request.getAttribute("categoryQty");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="/views/common/favicon.jsp"%>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<%-- <link rel="stylesheet" href="<%=request.getContextPath()%>/css/product/productDetailStyle.css" /> --%>
<!-- ??? 왜 productDetailStyle.css 적용?? -->

</head>
<body>
	<%@ include file="/views/common/header.jsp"%>
	<style>
div {
	/* border: 1px black solid; */
	
}
</style>

	<section>
		<div style="margin: auto; margin-left: 100px; margin-right: 100px;">
			<div>
				<header class="productsheader" style="display: flex;">
					<div class="h1" style="width: 200px";></div>
					<div class="h2" style="width: 100%; display: flex; max-width: 85%;">
						<div class="h3" style="width: 100%;">
							<div class="shop">SHOP</div>
							<h1 class="allp">
								<strong> ALL PRODUCTS</strong>
							</h1>
						</div>
						<img class="section-logo" alt="" src="<%=contextPath %>/image/common/blacklogo.png">
				</header>

				<div class="filter_con" >
					<div class="filter_box" style="width: 200px;">
						<!-- 왼쪽 필터 -->
						<div style="font-size: 30;">
							<strong> Filters</strong>
						</div>
						<div>
							<form action=""></form>
							<input type="text" name="searchKeyword" id="" value="<%=searchKeyword!=null?searchKeyword:"" %>"
								style="text-align:center; border: 2px black solid; border-radius: 10px; width: 80%;"><br>
								<br>
							<style>
							.filter_con{
							
							display: flex;		
							}
							.filter_box{
							position: sticky;
							top:50px;
							
							}
							
.section-logo{
float:right;
width:100px
}
section ul li {
	list-style: none;
}
</style>
							<label for=""><input type="checkbox" name ="category" value="1"></label>
							<span>디즈니</span><span id="qty-disney">(<%=categoryQty.get(1) %>)</span><br> 
							<label for=""><input type="checkbox" name="category" value="2"></label> 
							<span>스타워즈</span><span id="qty-starwars">(<%=categoryQty.get(2) %>)</span> <br> 
							<label for=""><input type="checkbox" name="category" value="3"></label> 
							<span>왕좌의 게임</span><span id=qty-thrones>(<%=categoryQty.get(3) %>)</span> <br> 
							<label for=""><input type="checkbox" name="category" value="4"></label> 
							<span>포켓몬스터</span><span id="qty-pocket">(<%=categoryQty.get(4) %>)</span> <br> 
							<label for=""><input type="checkbox" name="category" value="5"></label> 
							<span>마블</span><span id="qty-marvel">(<%=categoryQty.get(5) %>)</span> <br> 
								<br><br>
								<button type="submit">검색</button>
							</form>
						</div>
					</div>
					<div class=""
						style="width: 100%; display: flex; flex-wrap: wrap; max-width: 85%;">
						<!-- 오른쪽 제품 -->
						<div class="products"
							style="width: 100%; background-color: rgb(245, 245, 245);">
							<!-- 제품목록 -->
							<div class="products_header" style="display: flex;">
								<!-- 제품목록header -->
								<style>
.width33 {
	width: 33%;
}
</style>
								<div class="width33">
									<!-- 전체 제품 수량 -->
									<strong>제품수(<%=totalData!=null?(int)totalData:"" %>)</strong>
								</div>
								<div class="width33">
									<!-- 빈공간 -->
								</div>
								<div class="width33">
									<!-- 제품목록 순서 -->
									<label for="" style="float: right;" id="selectBox"> <select
										class="">
											<option value="0">Name: A-Z</option>
											<option value="1">Name: Z-A</option>
											<option value="2">Newest First</option>
											<option value="3">Oldest First</option>
											<option value="4">Price Low to High</option>
											<option value="5">Price High to Low</option>
									</select>
										<button onclick="gogogo()"></button>
									</label>
								</div>
							</div>
							<div class="products_list"
								style="width: 100%; display: flex; flex-wrap: wrap;">
								<!-- 제품목록 db 에서 불러온 제품을 for문 으로 제한된 수량 배열-->
								<style type="text/css">
section a:link {
	color: black;
	text-decoration: none;
}

section a:visited {
	color: black;
	text-decoration: none;
}

section a:hover {
	color: black;
	text-decoration: underline;
}
</style>
								<style>
section .products-list-item-a {
	font-size: .9375rem;
	text-decoration: none;
	display: flex;
	flex-direction: column;
	height: 95%;
}

section .products-list-item {
	font-size: .9375rem;
	box-shadow: 3px 6px 9px 0 rgba(0, 0, 0, .1);
	margin-right: 12px;
	margin-left: 12px;
	margin-top: 10px;
	margin-bottom: 10px;
	background-color: white;
	text-align: center;
	max-width: 300px;
	min-width: 300px;
}

section .shopify-image {
	cursor: pointer;
	width: 100%;
	background-size: contain;
	
                                    
                                        max-width : 300px;
                                        max-height: 300px;
                                        object-fit: contain;
	/*background-image: url("https://cdn.shopify.com/s/files/1/1052/2158/products/2791-Wall-E-POPGlam-WEB_d9d2ed14-dc3c-4816-b091-7fa704b716b6_400x2000.png?v=1601411410"); */
}

section .addtocart {
	text-transform: uppercase;
	font-size: 1rem;
	font-family: "Open Sans Condensed", sans-serif;
	font-weight: 700;
	border: 0;
	line-height: 1;
	padding: .75rem 1.25em;
	border-radius: 2em;
	position: relative;
	margin: .33rem 0;
	cursor: pointer;
	/* margin-left: 16.8%; */
	margin: auto;
	display: block;
}

section .products-list-item {
	flex-grow: 1;
	padding: 0 .5rem 2rem;
}
</style>


								<%
									if (productsList != null && productsList.size() != 0) {
									for (Product p : productsList) {
								%>
								<div class="products-list-item" name="divItem">
									<a class="products-list-item-a"
										href="<%=contextPath%>/product/productDetail?productId=<%=p.getProductId()%>">
										<img class="shopify-image "
										src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(0)%>"
										alt="<%=p.getProductName()%>" style="">
										<div class="">
											<div class="">
												<p hidden><%=p.getProductId()%></p>
												<div class=""><%=p.getCategoryName()%></div>
												<strong class="getProuctName"><%=p.getProductName()%></strong>
												<div class=""><%=p.getProductPrice()%>원
												</div>
											</div>
										</div>
									</a>
									<div class="addtocart_div">



										<button class="addtocart"
											onclick="addToCart('<%=p.getProductId()%>','<%=contextPath%>');">Add
											To Cart</button>
									</div>
								</div>
								<%
									}
								}
								%>
								<script>
									function gogogo() {
										var txt = [$(".getProuctName").text("")];
										for (var i = 0; i < txt.length; i++) {
											
										console.log(txt[i]);
										}
									}
								</script>


							</div>
						</div>
						<div style="margin: auto;">
							<!-- 페이징 -->
							<div class="center">
								<div class="pagination">
								
		<div id="pageBar">
			<%=(String)request.getAttribute("pageBar") %>
		</div>

									
								</div>
							</div>
						</div>
						
					</div>
				</div>
			</div>
		</div>

	</section>
		<%@ include file="/views/common/footer.jsp" %>
</html>