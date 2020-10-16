<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> 
<%@ page import="com.toyspace.product.model.vo.*, java.util.ArrayList" %>
<%
	ArrayList<Product> productsList=(ArrayList<Product>)request.getAttribute("productsList");
%>

<%@ include file="/views/common/admin_header.jsp"%> 
 <style>
      section.itemList-container {
        text-align: center;
      }

      section.itemList-container table.tbl-item {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.itemList-container table.tbl-item th,
      table.tbl-item td {
        border: 1px solid gray;
        padding: 10px;
      }
      section.itemList-container {
        text-align: center;
      }

      section.itemList-container table.tbl-item {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.itemList-container table.tbl-item th,
      table.tbl-item td {
        border: 1px solid gray;
        padding: 10px;
      }
      div.search-container {
        margin: 0 0 10px 0;
        padding: 3px;
        background-color: rgb(0, 0, 0);
        color: white;
      }
      div.search-itemName {
        display: inline-block;
      }
      div.search-itemCategory {
        display: none;
      }
      div.numPerPage-container {
        float: right;
      }
      form.numPerPageFrm {
        display: inline;
      }
    </style>
    <section class="itemList-container">
      <h2>상품관리</h2>
      <div class="search-container">
        상품 조회:
        <div class="search-itemId">
          <form action="<%=request.getContextPath() %>/admin/searchProduct" method="post">
            <input
              type="text"
              name="searchKeyword"
              placeholder="상품명을 입력해주세요"
              size="25"
              value=""
            />
            <button type="submit">검색</button>
          </form>
        </div>
      </div>
<form action="<%=request.getContextPath()%>/admin/removeProduct" method="post">
      <table class="tbl-item">
        <thead>
          <tr>
            <th>✔</th>
            <th>상품ID</th>
            <th>카테고리</th>
            <th>상품명</th>
            <th>상품가격</th>
            <th>재고</th>
            <th>수정</th>
          </tr>
        </thead>
        <tbody>
          <button type="submit" onclick="return confirmRemoving();">선택 삭제</button>
        <%if(productsList!=null&&productsList.size()!=0){
        	for(Product p : productsList){ %>
          <tr>
            <td><input type="checkbox" value="<%=p.getProductId()%>" name="productIds-removed"/></td>
            <td><%=p.getProductId() %></td>
            <td><%=p.getCategoryName() %></td>
            <td><%=p.getProductName() %></td>
            <td><%=p.getProductPrice() %>원</td>
            <td><%=p.getProductStock() %></td>
            <td>
              <input
                type="button"
                onclick="window.open('<%=request.getContextPath() %>/admin/editProduct?productId=<%=p.getProductId()%>','','width=900px,height=auto,top=200px,left=500px')"
                value="상품 수정하기"
              />
            </td>
          </tr>
          <%}} %>
        </tbody>
      </table>
      </form>
    </section>

    <script>
   
    function confirmRemoving(){
    	
    	return confirm("정말로 상품을 삭제하시겠습니까?");
    }
   
    </script>
