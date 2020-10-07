<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/admin_header.jsp"%>
<section>
<style type="text/css">
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
  </head>
  <body>
    <section class="itemList-container">
      <h2>재고관리</h2>
      <div class="search-container">
        상품 조회:
        <select class="searchType">
          <option value="itemName">상품명</option>
          <option value="itemCategory">카테고리</option>
        </select>
        <div class="search-itemName">
          <form action>
            <input type="hidden" name="searchType" value="itemName" />
            <input
              type="text"
              name="searchKeyword"
              placeholder="상품명"
              size="25"
              value=""
            />
            <button type="submit">검색</button>
          </form>
        </div>
      </div>
      <div class="numPerPage-container">
        페이지당 상품수 :
        <form class="numPerPageFrm" name="numPerPageFrm" action="">
          <select name="numPerPage" class="numPerPage">
            <option value="15">15</option>
            <option value="10">10</option>
            <option value="5">5</option>
          </select>
        </form>
      </div>
      <table class="tbl-item">
        <thead>
          <tr>
            <th>상품ID</th>
            <th>상품 카테고리</th>
            <th>상품명</th>
            <th>상품 가격</th>
            <th>상품 개수</th>
            <th>상품 TAG</th>
            <th>수정하기</th>
            <th>삭제하기</th>
          </tr>
        </thead>
        <tbody>
          DB에서 받아온 데이터출력할것

          <tr>
            <td>0001A</td>
            <td>디즈니</td>
            <td>겨울왕국-엘사</td>
            <td>9900원</td>
            <td><input type="number" /></td>
            <td>겨울,아렌델,여왕,눈</td>
            <td><input type="button" onclick="" value="수정" /></td>
            <td><input type="button" onclick="" value="삭제" /></td>
          </tr>
        </tbody>
      </table>
    </section>
  </body>
</html>