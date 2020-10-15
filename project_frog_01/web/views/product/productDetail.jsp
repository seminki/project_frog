<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.product.model.vo.*,com.toyspace.product.comment.model.vo.*,java.util.List"%>

<%
Product p=(Product)request.getAttribute("product");

List<Comment> commentList=(List<Comment>)request.getAttribute("commentList"); 

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<%@ include file="/views/common/favicon.jsp" %>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
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
        <% if(p.getProductImageFilePaths().get(1)!=null){ %>
        <img src="<%=request.getContextPath()%>/upload/product/<%=p.getProductImageFilePaths().get(1) %>" style="width: 100%" />
        <%} %>
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
          min="1"
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
        <input type="button" class="add-cart" value="장바구니 담기" onclick="addToCart('<%=p.getProductId()%>','<%=contextPath%>');">       
        </form>
        </div>
       
      </div>
      <hr />
      </div>
        <div class="item-detail">
          <h2>상품정보</h3>
          <ul>
            <li class="item-detais-info">상품번호:<%=p.getProductId() %></li>
            <li class="item-detais-info">상품명:<%=p.getProductName() %></li>
            <li class="item-detais-info">상품 카테고리:<%=p.getCategoryName() %></li>
            <li class="item-detais-info">사용연령:<%=p.getRecommendedAge() %>세 이상</li>
            <li class="item-detais-info">제조자:<%=p.getManufacturer() %></li>
            <li class="item-detais-info">제조국:<%=p.getManufacturedCountry() %></li>
            <li class="item-detais-info">사이즈: 약 10.8cm</li>
            <li class="item-detais-info">취급 시 주의사항
                <ul type="">
                    <li><%=p.getCaution() %></li>
                    
                </ul>
            </li>
        </ul>
        <br>
        <hr>
        </div>
        <div class="review-container">
            <div class="review-title"><h2>리뷰</h2></div>
            <div class="review-content">
             	<div class="comment-box">
                	<form action="<%=request.getContextPath() %>/comment/commentWrite" method="get">
                		
						<input type="hidden" name="memberKey" value="<%=signedInMember!=null?signedInMember.getMemberKey():"" %>">
                		<input type="hidden" name="productId" value="<%=p.getProductId() %>"> 
                	<textarea name="commentContent" id="" cols="120" rows="4" style="resize:none"></textarea>
            	 </div>   
            <button type=submit class="review-btn" onclick="return fn_access();">리뷰 남기기</button>
           		 </form>
            </div>
        </div>
        <hr>
             <table class="tbl-comment">
    	<%for(Comment c: commentList) {	
    		if(c.getCommentRefNo()==0)%>	
		   			<tr class="reply-box">
		   				<td>
		   					<sub class="comment-nick"><b>"<%=c.getUserNickname() %>"</b></sub>
		   					<sub class="comment-writer">(<%=c.getUserId() %>)</sub> 
		   					<sub class="comment-date"><%=c.getCommentDate() %></sub>
		   					<br>
		   					<br>
							<%=c.getCommentContent() %>
		   				</td>
		   				
		   			</tr>
	<%} %> 
   		</table>  
	
	
        <hr>
 
    </div>
    

</section>
        <script>
        //리뷰
        function fn_access(){
        	if(<%=signedInMember==null%>){
        		alert("로그인 후 이용가능");
        		return false;
        	} else return true;
        }
       
        
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
        //수량버튼 
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

    

    
    </script>

<%@ include file="/views/common/footer.jsp"%>
</body>
</html>