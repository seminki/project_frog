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
        <div class="search-itemId">
      
            <input
              type="text"
              name="tag"
              placeholder="태그명을 입력해주세요"
              size="25"
            />
            <button type="submit">검색</button>
        
        </div>
      </div>
      <hr />
      <form action="<%=request.getContextPath() %>/admin/insertTag" method="post">
      <input type="text" class="tag-add" name="tagName" required />
      <button type="submit">태그등록</button>
      </form>
      <hr />

      <table class="tbl-tag">
        <thead>
          <tr>
            <th>태그No.</th>
            <th>태그명</th>
            <th>삭제하기</th>
            <th>수정하기</th>
          </tr>
        </thead>
        <tbody>
          DB에서 받아온 데이터출력할것

          <tr>
            <td>1</td>
            <td>겨울</td>
            <td><input type="button" onclick="" value="삭제" /></td>
            <td>
              <input type="button" onclick="fn_changeTag();" value="수정" />
            </td>
          </tr>
        </tbody>
      </table>
    </section>

    <script>
      function fn_changeTag() {
        const url = "<%=request.getContextPath()%>/admin/adminTagList%>";
        const status = "width=400px,height=210px,top=200px,left=500px";
        open(url, "", status);
      }
    </script>
  </body>
</html>
