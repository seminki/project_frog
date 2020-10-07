<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta charset="UTF-8">
<title>TOYSPACE MESSAGE</title>
</head>
<body>
	<script>
		alert('<%=(String)request.getAttribute("msg")%>');
		location.href='<%=(String)request.getAttribute("loc")%>';
	</script>
</body>
</html>