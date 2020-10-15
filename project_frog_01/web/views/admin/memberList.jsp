<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.toyspace.member.model.vo.*"%>    
  <%
  	ArrayList<Member> memberList =(ArrayList<Member>)request.getAttribute("memberList");
  %>
    
<%@ include file="/views/common/admin_header.jsp"%>
<style type="text/css">
      section.memberList-container {
        text-align: center;
      }

      section.memberList-container table.tbl-member {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.memberList-container table.tbl-member th,
      table.tbl-member td {
        border: 1px solid gray;
        padding: 10px;
      }
      section.memberList-container {
        text-align: center;
      }

      section.memberList-container table.tbl-member {
        width: 100%;
        border: 1px solid gray;
        border-collapse: collapse;
      }
      section.memberList-container table.tbl-member th,
      table.tbl-member td {
        border: 1px solid gray;
        padding: 10px;
      }
      div.search-container {
        margin: 0 0 10px 0;
        padding: 3px;
        background-color: rgb(0, 0, 0);
        color: white;
      }
      div.search-userId {
        display: inline-block;
      }
      div.search-userName {
        display: none;
      }
      div.search-gender {
        display: none;
      }
      div.numPerPage-container {
        float: right;
      }
      form.numPerPageFrm {
        display: inline;
      }
    </style>

    <section class="memberList-container">
      <h2>회원관리</h2>
      <div class="search-container">
        회원조회:
        <select class="searchType">
          <option value="userId">아이디</option>
          <option value="userName">회원명</option>
          <option value="gender">성별</option>
        </select>
        <div class="search-userId">
          <form action>
            <input type="hidden" name="searchType" value="userId" />
            <input
              type="text"
              name="searchKeyword"
              placeholder="아이디검색"
              size="25"
              value=""
            />
            <button type="submit">검색</button>
          </form>
        </div>
      </div>
     
      <table class="tbl-member">
        <thead>
          <tr>
            <th>멤버키</th>
            <th>아이디</th>
            <th>이메일</th>
            <th>이름</th>
            <th>닉네임</th>
            <th>가입날짜</th>

          </tr>
        </thead>
        <tbody>
  
            <%if(memberList.isEmpty()) {%>
            <tr>
                <td colspan="9">조회되 회원이 없습니다!</td>
            </tr>
        <%}else{ 
            for(Member m : memberList){
        %>
            <tr>
            	<td><%=m.getMemberKey() %></td>
                <td><%=m.getUserId() %></td>
                <td><%=m.getUserEmail() %></td>
                <td><%=m.getUserName() %></td>               
                <td><%=m.getUserNickname() %></td>
                <td><%=m.getUserSignUpDate() %></td>


            </tr>
        <%} 
        }%>  
        </tbody>
      </table>
    </section>
  </body>
</html>

