<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.toyspace.product.model.vo.*, java.util.TreeSet" %>

<%
	TreeSet<Tags> tagsList= (TreeSet<Tags>)request.getAttribute("tagsList");
%>    
    
    
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
      .tag-no{
      border:none;
      outline:none;
      text-align:center;
      }
    </style>
  </head>
  <body>
    <section class="tagList-container">
      <h2>태그관리</h2>
      <div class="search-container">
        태그 조회:
        <div class="search-tagName">
      		<form action="<%=request.getContextPath() %>/admin/searchTag">
            <input
              type="text"
              name="keyword"
              placeholder="태그명을 입력해주세요"
              size="25"
            />
            <button type="submit">검색</button>
        	</form>
        </div>
      </div>
      <hr />
      <form action="<%=request.getContextPath() %>/admin/insertTag" method="post">
      <input type="text" class="tag-add" name="newTag" required />
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
          <% if(tagsList!=null&&tagsList.size()!=0){
        	  for(Tags t: tagsList){%>        
          <tr>
          	<form class="tagForm">
            <td><input type="text" class="tag-no" value="<%=t.getTagNo() %>" name="tagNo" readonly></td>
            <td><input type="text"  value="<%=t.getTagName() %>" name="tagName" required></input></td>
            <td><input type="button" onclick="location.href='<%=request.getContextPath()%>/admin/tagDelete?tagName=<%=t.getTagName()%>'" value="삭제" /></td>
            <td>
              <input type="button" onclick="fn_changeTag();" value="수정" />
            </td>
            </form>
          </tr>
             <%} } %>
        </tbody>
      </table>
	
    </section>

    <script>
	function fn_changeTag(){
		$(".tagForm").attr("action","<%=request.getContextPath()%>/admin/editTag").submit();
	}  

    </script>
  </body>
</html>
