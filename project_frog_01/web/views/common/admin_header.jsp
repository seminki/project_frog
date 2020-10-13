<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.admin.model.vo.Admin"%>
<% 
session =request.getSession(false);
Admin admin = (Admin)session.getAttribute("loggedInAdmin");%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
    <title>TOYSPACE 관리페이지</title>
    <script>
    	<%
    	String msg = "";
    	String loc =request.getContextPath()+"/admin";
    	if(admin==null){
    		msg="관리자로 로그인 되어있지 않습니다.";
    		%>
    			location.href = '<%=request.getContextPath()%>/msg?msg=<%=msg%>&loc=<%=loc%>';
    		<%
    	}
    	%>
    
    </script>
    <style>
        header .admin-header {
          display: flex;
          justify-content: center;
          align-items: center;
          background-color:black;
        }
        header .title{
            color:white;
        }
        header nav > ul {
          display: flex;
          justify-content: space-around;
          list-style-type: none;
          background-color:black;
          margin:0;
          padding:10px;
          flex-wrap:wrap;
       
        }
        header nav ul > li{
        	min-width:8em
        }
        
        header nav ul > li > a:hover {
          color: yellow;
        }
  
        header nav ul > li > a {
          text-decoration: none;
          color: white;
          font-weight: bolder;
          font-size: 20px;
          margin:2em;
        }
     	
     	.admin-header-right-container, #logoutBtn{
     		position:absolute;
     		right:0;
     		top:2em;
     		margin:2em;
     	}
     	.admin-header-right-container>table>tr{
     		text-align: right;     	
     		}
     	.admin-header-right-container h3{
     		color:white;
     	}
     	
        </style>
</head>
<body>
    <header>
        <div class="admin-header">
          <div class="toyspace-logo">
            <img
              src="<%=request.getContextPath()%>/image/common/blacklogo.png"
              alt=""
              width="150px"
            />
          </div>
          <div class="title">
            <h1>관리자 페이지</h1>
          </div>
          <div class="admin-header-right-container">
 		<table>
          		<tr>
          			<%if(admin!=null){ %>
          			<h3><%=admin.getAdminName()%>(<%=admin.getAdminLevelDescription() %>)님</h3>
          			<%} %>
          		</tr>
          		<tr>
          			<td> <input type="button" id="logoutBtn" value="로그아웃">
          			</td>
          		</tr>
          	</table> 
          </div>
          
          </div>
       
        <nav>
          <ul>
            <li><a href="<%=request.getContextPath()%>/admin/mainPage">메인</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/manageMember">회원관리</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/manageOrder">주문관리</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/insertProduct">상품등록</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/productList">상품관리</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/sales">매출현황</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/tagList">태그등록</a></li>
            <li><a href="<%=request.getContextPath()%>/admin/manageChat">채팅관리</a></li>
            <% if(admin!=null&& admin.getAdminLevel()==0){ %>
            <li><a href="<%=request.getContextPath()%>/admin/adminList">관리자 계정</a></li>
            <%} %>
          </ul>
        </nav>
   </header>
   <script>
   	$("#logoutBtn").click(e=>{
		location.href = '<%=request.getContextPath()%>/admin/logout';
   	})
   </script>

