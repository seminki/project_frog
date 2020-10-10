<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> 
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
          <form action>
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

      <table class="tbl-item">
        <thead>
          <tr>
            <th><input type="checkbox" /> 전체선택</th>
            <th>상품ID</th>
            <th>카테고리</th>
            <th>상품명</th>
            <th>상품가격</th>
            <th>재고</th>
            <th>수정</th>
          </tr>
        </thead>
        <tbody>
          <input type="button" value="선택 삭제" />

          <tr>
            <td><input type="checkbox" /></td>
            <td>1</td>
            <td>디즈니</td>
            <td>인어공주</td>
            <td>9,900원</td>
            <td>100</td>
            <td>
              <input
                type="button"
                onclick="fn_changeTag();"
                value="상품 수정하기"
              />
            </td>
          </tr>
        </tbody>
      </table>
    </section>

    <script>
      function fn_changeTag() {
        const url = "<%=request.getContextPath() %>/admin/editProduct";
        const status = "width=900px,height=auto,top=200px,left=500px";
        open(url, "", status);
      }
    </script>
