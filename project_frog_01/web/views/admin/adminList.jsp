<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<%@ page import="com.toyspace.admin.model.vo.*, java.util.ArrayList" %>
<%
	ArrayList<Admin> adminList=(ArrayList<Admin>)request.getAttribute("adminList");
%>

<%@ include file="/views/common/admin_header.jsp"%> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
</head>
<body>
<% if(admin!=null&& admin.getAdminLevel()!=0){ %>
<div style="text-align:center;">
            <h1 style="margin-top:100px ">권한이 없습니다.</h1>
</div>            
<%} %>

<!-- 페이지에 권한부여 필요 (마스터 관리자만 이용가능) url 직접 입력시 접근가능 
추가 v , 삭제, 수정 버튼에 기능 추가 해야됨 -->
<!-- 비밀번호 암호화 필요 --> 

<% if(admin!=null&& admin.getAdminLevel()==0){ %>

<body style="text-align: center;">
<h2>:관리자 계정 관리:</h2>
<fieldset style="text-align: center;">
    <legend><strong>관리자 회원 목록</strong></legend>
    <form action="">
    <table border="3" style="margin: auto;">
        <thead>
            <tr>
                <th></th>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>NICKNAME</th>
                <th>이름</th>
                <th>LEVLE</th>
                <th>수정 / 삭제</th>
            </tr>
        </thead>
        <tbody>
        <%if(adminList!=null&&adminList.size()!=0){
        for(Admin a: adminList){%>
        <tr>
            <form action="">
                <td><input type="checkbox" name="" id=""></td>
                <td><input type="text" name="" id="" value="<%=a.getAdminId()%>"> </td>
                <td><input type="password" name="" id="" value="<%=a.getAdminPassword()%>"> </td>
                <td><input type="text" name="" id="" value="<%=a.getNickname()%>"> </td>
                <td><input type="text" name="" id="" value="<%=a.getAdminName()%>"> </td>
                <td><input type="text" name="" id="" value="<%=a.getAdminLevel()%>"> </td>
                <td><input type="button" name="" id="" value="수정">ㅣ<input type="button" name="" id="" value="삭제"></td>
            </form>
         </tr>
         <%}} %>
        </tbody>
    </table>
    <br>
    <button style="width:5%;"><strong>선택 삭제</strong></button>
    <br>
    </form>
</fieldset>
<hr>
<fieldset style="text-align: center;">
    <legend><strong>관리자 계정 생성</strong></legend>
    <table border="3" style="margin: auto;">
        <thead>
            <tr>
                <th>아이디</th>
                <th>비밀번호</th>
                <th>NICKNAME</th>
                <th>이름</th>
                <th>LEVEL</th>
            </tr>
        </thead>
        <tbody>
            <form action="<%=request.getContextPath()%>/admin/insertAdmin" method="post">
                <td><input type="text" name="adminId" id=""></td>
                <td><input type="password" name="adminPw" id=""></td>
                <td><input type="text" name="adminNic" id=""></td>
                <td><input type="text" name="adminName" id=""></td>
                <td><input type="number" name="adminLevel" id=""></td>
                <td><button type="submit">추가</button></td>
            </form>
        </tbody>
    </table>
</fieldset>




    
</body>
<%} %>
</body>
</html>