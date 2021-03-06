<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
	<%@ include file="views/common/favicon.jsp" %>
</head>
<body>
	<%@ include file="views/common/header.jsp" %>
<!-- section main pic-->
    <section class="section">
      <div class="main-container">
        <div class="text-main">
          <div class="text-container">
            <div>디즈니 Kingdom of Disney</div>
            <h1 class="text-title">디즈니와 함께 사랑에 빠져볼까요?</h1>
            <div class="text-shop">
              <p>
                	우리들의 친구 미키마우스! 미워할 수 없는 마녀 말레피센트까지<br>
               		 장난감들이 당신을 기다리고 있어요! 지금 입양하시면, 배송비는 무료입니다!<br>
               		 The Happiest Place on Earth는 문을 닫았지만<br>
               		 당신은 여전히 디즈니와 함께할 수 있어요!
              </p>
              <a class="shop1-btn" href="<%=contextPath%>/productlist.do?category=1&searchKeyword=">Shop Collection</a>
            </div>
          </div>
        </div>
        <div class="pic">
          <div class="img-container">
            <a href="<%=request.getContextPath() %>/product/productDetail?productId=63">
              <img src="<%=request.getContextPath()%>/image/product/mickey.png" alt="" />
            </a>
          </div>
        </div>
      </div>
      <!-- section main2 second -->
      <div class="main2">
        <div class="main2-1">
          <div class="main2-container">
            <div class="main2-text">
              <h1>마블 MARVEL</h1>
              <div class="main2-shop">
                <p>"I am INEVITABLE"</p>
                <a class="shop2-btn" href="<%=contextPath%>/productlist.do?category=5&searchKeyword=">SHOP COLLECTION</a>
              </div>
            </div>
          </div>
        </div>
        <div class="main2-2">
          <div class="main2-container">
            <div class="main2-text">
              <h1>스타워즈 STAR WARS</h1>
              <div class="main2-shop">
                <p>"May the Force be with you."</p>
                <a class="shop2-btn" href="<%=contextPath%>/productlist.do?category=2&searchKeyword=">SHOP COLLECTION</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- section main3 -->

      <div class="main3-container">
        <header>
          <h2 class="new-item">NEW NEW NEW HARRY POTTER!</h2>
        </header>
        <div class="main3-pic-text">
          <div class="item1">
            <a class="item-container" href="">
              <img src="pics/harry.JPG" alt="" />
              <div class="item-info">
                <div class="item-title">
                  <div clss="brand">POP!</div>
                  <strong class="model">Harry Potter</strong>
                  <div class="price">9900원</div>
                </div>
                <div class="item-add-cart">
                  <button class="item-cart-btn">Add To Cart</button>
                </div>
              </div>
            </a>
          </div>
          <div class="item2">
            <a class="item-container" href="">
              <img src="pics/hagrid.JPG" alt="" />
              <div class="item-info">
                <div class="item-title">
                  <div clss="brand">POP!</div>
                  <strong class="model">Harry Potter</strong>
                  <div class="price">9900원</div>
                </div>
                <div class="item-add-cart">
                  <button class="item-cart-btn">Add To Cart</button>
                </div>
              </div>
            </a>
          </div>
          <div class="item3">
            <a class="item-container" href="">
              <img src="pics/malfoy.JPG" alt="" />
              <div class="item-info">
                <div class="item-title">
                  <div clss="brand">POP!</div>
                  <strong class="model">Harry Potter</strong>
                  <div class="price">9900원</div>
                </div>
                <div class="item-add-cart">
                  <button class="item-cart-btn">Add To Cart</button>
                </div>
              </div>
            </a>
          </div>
          <div class="item4">
            <a class="item-container" href="">
              <img src="pics/ron.JPG" alt="" />
              <div class="item-info">
                <div class="item-title">
                  <div clss="brand">POP!</div>
                  <strong class="model">Harry Potter</strong>
                  <div class="price">9900원</div>
                </div>
                <div class="item-add-cart">
                  <button class="item-cart-btn">Add To Cart</button>
                </div>
              </div>
            </a>
          </div>
        </div>
      </div>
    </section>
	
	<%@ include file="views/common/footer.jsp" %>
	<script>
	
		$($(".bottom-support-ui")[0]).addClass("animate__bounceInUp");
	
	</script>
</body>
</html>