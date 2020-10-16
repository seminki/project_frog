<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId=(String)request.getAttribute("result");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 중복확인</title>
</head>
<body>
	<div id="checkId-container">
			<%if(userId==null){ %>
				[<span><%=request.getParameter("userId") %></span>]는 사용가능합니다.
				<br><br>	
				<button type="button" onclick="fn_close();">닫기</button>
			<%}else{ %>
				[<span id="duplicated"><%=userId %></span>]는 사용중입니다.
				<br><br>
				<form action="<%=request.getContextPath() %>/checkIdDuplicate" method="post">
					<input type="text" name="userId" id="userId">
					<input type="submit" value="중복검사" onclick="return fn_validate();">
				</form>
			<%} %>
	</div>

<style>
	div#checkId-container{text-align:center;padding-top:50px;}
	span#duplicated{color:red;font-weight:bolder;}
</style>
	<script>
		function fn_close(){
			//1. 현재 아이디값을 부모에게 전달하기
			const id='<%=request.getParameter("userId")%>';
			opener.document.getElementById("userId_").value=id;
			opener.document.getElementById("password_").focus();
			close();
		}
		function fn_validate(){
			let userId=document.getElementById("userId").value;
			if(userId.trim().length<4){
				alert("아이디를 4글자 이상 입력하세요");
				document.getElementById("userId").value="";
				document.getElementById("userId").focus();
				return false;
			}
		}
	
	</script>

</body>
</html>









