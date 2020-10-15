<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta charset="UTF-8">
<%@ include file="/views/common/favicon.jsp" %>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
</head>
<body style="text-align: center;">
    <img src="<%=request.getContextPath()%>/image/error/blacklogo-smal.png">
    <br>
    <br>
    <h1 style="color:red">500 ERROR</h1>
	<h2 style="color:rgb(62, 155, 231)">죄송합니다. 현재 찾을 수 없는 페이지를 요청 하였습니다.</h2>
    
    <h3>존재하지 않는 주소를 입력 하셨거나,</h3>
    <h3>요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.</h3>
    <h3>궁금한 점이 있으시면 언제든 고객센터를 통해 문의해 주시기 바랍니다.</h3>
    <h3><strong>감사합니다.</strong></h3>
    <div>
    
    <button onclick="main()"><strong>메인으로</strong></button>
    <button onclick="back()"><strong>뒤로가기</strong></button>
    </div>
    <script>
    function back() {
    	window.history.back();
	}
    function main() {
    	 window.location.replace("/project_frog_01/index.jsp");
	}
    </script>
    <hr>
    <style>
    	h3{
    	color: gray;
  	 	 }
  	 	strong{
  	 	color: black;
  	 	}
  	 	button{
  	 	 height: 40px;
         width: 110px;
         background-color: white;
         font-size: large;
  	 	}
  	 	body{
		background-image : url('<%=request.getContextPath()%>/image/error/error.gif');
		background-repeat : no-repeat;
		background-size : 800px;
		}
    </style>
    
    
</body>
</html>