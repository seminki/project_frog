<%@page import="sun.misc.Contended"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList,com.toyspace.member.model.vo.*"%>    
  <%
  	ArrayList<Member> memberList =(ArrayList<Member>)request.getAttribute("memberList");
	String type=request.getParameter("searchType");
	String key=request.getParameter("searchKeyword");
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
	 
	 section tr{
	 	cursor: pointer;
	 }
    </style>

    <section class="memberList-container">
      <h2>회원관리</h2>
      <div class="search-container">
        회원조회:
        <select class="searchType">
          <option value="userId" <%=type!=null&&type.equals("userId")?"selected":"" %>>아이디</option>
		<option value="userName" <%=type!=null&&type.equals("userName")?"selected":"" %>>회원명</option>
        </select>
        <div class="search-userId">
				<form action="<%=request.getContextPath() %>/admin/memberSearch">
					<input type="hidden" name="searchType" value="user_id">
					<input type="text" name="searchKeyword" placeholder="아이디검색" size="25"
					value="<%=key!=null&&type!=null&&type.equals("user_id")?key:""%>">
					<button type="submit">검색</button>
				</form>
			</div>
			<div class="search-userName">
				<form action="<%=request.getContextPath() %>/admin/memberSearch">
					<input type="hidden" name="searchType" value="user_name">
					<input type="text" name="searchKeyword" placeholder="이름검색" size="25"
					value="<%=key!=null&&type!=null&&type.equals("user_name")?key:""%>">
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
            <tr onclick="moveToMemberDetail('<%=m.getMemberKey()%>');">
       
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
      
      
 <script>
 $(function(){
		let userId=$(".search-userId");
		let userName=$(".search-userName");

		
		$(".searchType").change(e => {
			userId.css("display","none");
			userName.css("display","none");
			let v=$(e.target).val();
			$(".search-"+v).css("display","inline-block");
		});
		$(".searchType").change();
	});
 
 function moveToMemberDetail(memberKey){
	 location.href = '<%=request.getContextPath()%>/admin/memberDetail?memberKey='+memberKey;
 }
 </script>
    </section>
  </body>
</html>

