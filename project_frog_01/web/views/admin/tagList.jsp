<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/views/common/admin_header.jsp"%>
    <style type="text/css">
      section.tagList-container {
        text-align: center;
      }

      section.tagList-container table.tbl-tag {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.tagList-container table.tbl-tag th,
      table.tbl-tag td {
        border: 1px solid gray;
        padding: 10px;
      }
      section.tagList-container {
        text-align: center;
      }

      section.tagList-container table.tbl-tag {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.tagList-container table.tbl-tag th,
      table.tbl-tag td {
        border: 1px solid gray;
        padding: 10px;
      }
      div.search-container {
        margin: 0 0 10px 0;
        padding: 3px;
        background-color: rgb(0, 0, 0);
        color: white;
      }
      div.search-itemId {
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
    <section class="tagList-container">
      <h2>태그관리</h2>
      <div class="search-container">
        태그 조회:
        <!--상품 ID에서 select로 나오게끔해서 조회하는게 더 나을 수도 ??   -->
        <select class="searchType">
          <option value="itemId">상품ID</option>
          <option value="tagName">태그명</option>
        </select>
        <div class="search-itemId">
          <form action>
            <input type="hidden" name="searchType" value="itemId" />
            <input
              type="text"
              name="searchKeyword"
              placeholder="상품ID"
              size="10"
              value=""
            />
            <button type="submit">검색</button>
          </form>
        </div>
      </div>
      <hr />
      <input type="button" onclick="fn_addTag();" value="태그추가" />
      <hr />

      <table class="tbl-tag">
        <thead>
          <tr>
            <th>상품ID</th>
            <th>태그No.</th>
            <th>태그명</th>
            <th>삭제하기</th>
          </tr>
        </thead>
        <tbody>
          DB에서 받아온 데이터출력할것

          <tr>
            <td>0001A</td>
            <td>1</td>
            <td>겨울</td>
            <td><input type="button" onclick="" value="삭제" /></td>
          </tr>
        </tbody>
      </table>
    </section>

    <script>
      function fn_addTag() {
    	  /* 팝업창 열리는 화면전환 서블릿 구현해야함 */
        const url = "<%=request.getContextPath()%>/views/admin/addTag.jsp";
        const status = "width=400px,height=250px,top=200px,left=500px";
        open(url, "", status);
      }
    </script>
  </body>
</html>
