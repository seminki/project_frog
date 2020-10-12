<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.product.model.vo.*"%>
<%
Product p=(Product)request.getAttribute("product");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
    <title>Document</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/product/productDetailStyle.css" />
    
    </head>
   <body>
<%@ include file="/views/common/header.jsp"%>
<section>
    <!-- slide img -->
    <div class="slideshow-container">
      <div class="mySlides fade">
        <div class="numbertext">1 / 2</div>
        <img src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(0) %>" style="width: 100%" />
      </div>

      <div class="mySlides fade">
        <div class="numbertext">2 / 2</div>
        <img src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(1) %>" style="width: 100%" />
      </div>

      <a class="prev" onclick="plusSlides(-1)">&#10094;</a>
      <a class="next" onclick="plusSlides(1)">&#10095;</a>
    </div>
    <br />
    <div style="text-align: center">
      <span class="dot" onclick="currentSlide(1)"></span>
      <span class="dot" onclick="currentSlide(2)"></span>
    </div>

        <div class="all-container">
        <div class="detail-header">
          <div class="detail-header-brand"><%=p.getCategoryName() %></div>
          <h2 class="detail-header-title"><%=p.getProductName() %></h2>
          <div class="detail-header-price">
            <p class="price"><span><%=p.getProductPrice() %></span> 원</p>
          </div>
          <div class="detail-header-info">
            <h3 class="item-content-title"></h3>
            <div class="item-content-description">
         	<%=p.getProductDescription() %>
            </div>
          </div>
          <div class="detail-header-btn">
            
        <div class="input-group">
            <form action="">
          <!--수량버튼 -->
        <input
          type="button"
          value="-"
          class="button-minus"
          data-field="quantity"
          onclick="decrementValue(event);"
        />
        <input
          type="number"
          step="1"
          max=""
          value="1"
          name="quantity"
          class="quantity-field"
        />
        <input
          type="button"
          value="+"
          class="button-plus"
          data-field="quantity"
          onclick="incrementValue(event);"
        />
        <button class="add-cart">장바구니 담기</button>
        </form>
        <!-- 찜 -->
        </div>
        <button class="heart" onclick="zzim();"><i class="fas fa-heart"></i></button> 
      </div>
      <hr />
      </div>
        <div class="item-detail">
          <h2>상품정보</h3>
          <ul>
            <li class="item-detais-info">상품번호:<%=p.getProductId() %></li>
            <li class="item-detais-info">상품명:<%=p.getProductName() %></li>
            <li class="item-detais-info">상품 카테고리:<%=p.getCategoryName() %></li>
            <li class="item-detais-info">사용연령:<%=p.getRecommendedAge() %>이상</li>
            <li class="item-detais-info">제조자:<%=p.getManufacturer() %></li>
            <li class="item-detais-info">제조국:<%=p.getManufacturedCountry() %></li>
            <li class="item-detais-info">사이즈: 약 10.8cm</li>
            <li class="item-detais-info">취급 시 주의사항
                <ol type="1">
                    <li><%=p.getCaution() %></li>
                    
                </ol>
            </li>
        </ul>
        <br>
        <hr>
        </div>
        <div class="review-container">
            <div class="review-title"><h2>리뷰</h2></div>
            <div class="review-content">
             	<div class="comment-box">
                	<form action="">
                		<input type="hidden" name="commentLevel" value="1"> 
						<input type="hidden" name="commentWriter" value="">
						<input type="hidden" name="CommentRef" value="0">
                	<textarea name="commentContent" id="" cols="120" rows="4" style="resize:none"></textarea>
            	 </div>   
            <button type="submit" class="review-btn">리뷰 남기기</button>
           		 </form>
            </div>
        </div>
        <hr>
        <div class="recommend-container">
            <div class="rec-container">
                <header>
                  <h2 class="recommend-item">이 상품은 어때요?</h2>
                </header>
                <div class="rec-pic-text">
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
        </div>
    </div>
        <script>
            // 이미지 슬라이드
          let slideIndex = 1;
          showSlides(slideIndex);
    
          function plusSlides(n) {
            showSlides((slideIndex += n));
          }
    
          function currentSlide(n) {
            showSlides((slideIndex = n));
          }
    
          function showSlides(n) {
            let i;
            let slides = document.getElementsByClassName("mySlides");
            let dots = document.getElementsByClassName("dot");
            if (n > slides.length) {
              slideIndex = 1;
            }
            if (n < 1) {
              slideIndex = slides.length;
            }
            for (i = 0; i < slides.length; i++) {
              slides[i].style.display = "none";
            }
            for (i = 0; i < dots.length; i++) {
              dots[i].className = dots[i].className.replace(" active", "");
            }
            slides[slideIndex - 1].style.display = "block";
            dots[slideIndex - 1].className += " active";
          }
      
          function incrementValue(e) {
            e.preventDefault();
            let fieldName = $(e.target).data("field");
            let parent = $(e.target).closest("div");
            let currentVal = parseInt(
              parent.find("input[name=" + fieldName + "]").val(),
              10
            );
    
            if (!isNaN(currentVal)) {
              parent.find("input[name=" + fieldName + "]").val(currentVal + 1);
            } else {
              parent.find("input[name=" + fieldName + "]").val(0);
            }
          }
        //수량버튼 
          function decrementValue(e) {
            e.preventDefault();
            let fieldName = $(e.target).data("field");
            let parent = $(e.target).closest("div");
            let currentVal = parseInt(
              parent.find("input[name=" + fieldName + "]").val(),
              10
            );
    
            if (!isNaN(currentVal) && currentVal > 0) {
              parent.find("input[name=" + fieldName + "]").val(currentVal - 1);
            } else {
              parent.find("input[name=" + fieldName + "]").val(0);
            }
          }
          //찜
          function zzim(){
              $('.fa-heart').toggleClass('color');
          }
        </script>

</section>
<%@ include file="/views/common/footer.jsp"%>
</body>
</html>