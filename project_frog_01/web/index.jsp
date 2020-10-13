<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Insert title here</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
</head>
<body>
	<%@ include file="views/common/header.jsp" %>
<!-- section main pic-->
    <section class="section">
      <div class="main-container">
        <div class="text-main">
          <div class="text-container">
            <div>TOY SPACE</div>
            <h1 class="fall">Where All Toys' Dream Comes True</h1>
            <div class="text-shop">
              <p>
                장난감들이 당신을 기다리고 있어요! 30% 할인 기간 동안 입양하시면, 배송비는 무료입니다!
              </p>
              <a class="shop1-btn" href="">Shop Collection</a>
            </div>
          </div>
        </div>
        <div class="pic">
          <div class="img-container">
            <a href="">
              <img src="<%=request.getContextPath()%>/image/product/wetmore.JPG" alt="" />
            </a>
          </div>
        </div>
      </div>
      <!-- section main2 second -->
      <div class="main2">
        <div class="main2-1">
          <div class="main2-container">
            <div class="main2-text">
              <h1>DISNEY COLLECTION</h1>
              <div class="main2-shop">
                <p>훌륭한 디덕이라면 놓칠 수 없죠!</p>
                <a class="shop2-btn" href="">SHOP COLLECTION</a>
              </div>
            </div>
          </div>
        </div>
        <div class="main2-2">
          <div class="main2-container">
            <div class="main2-text">
              <h1>THE GAME OF THRONES</h1>
              <div class="main2-shop">
                <p>왕좌의 게임 팬이라구요? 결말이 마음에 안들었나요? 새로운 결말을 만들어보세요!</p>
                <a class="shop2-btn" href="">SHOP COLLECTION</a>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- section main3 -->

      <div class="main3-container">
        <header>
          <h2 class="new-item">NEW NEW NEW STAR WARS!</h2>
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