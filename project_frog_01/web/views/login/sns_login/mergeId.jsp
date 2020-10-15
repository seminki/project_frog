<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.toyspace.member.model.vo.Member, com.toyspace.member.model.vo.SNSLogin"%>
    <% Member m = (Member)session.getAttribute("email-found-new-member");
     String id = m.getUserId();
     /* replacedId는 보안상의 이유로 id 뒷자리를 숨겨놓고 있는 것임 */
     System.out.println(m);
     String replacedId="";
     if(id!=null){
     	replacedId = id.substring(0, id.length()-3)+"***";
     }
    %>
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta charset="UTF-8">
<%@ include file="/views/common/favicon.jsp" %>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<script>
	<% if(session.getAttribute("signedInMember")!=null){%>
		alert("잘못된 접근입니다. 이미 로그인되어있습니다.");
		location.href=
	<%}%>

</script>
<section>
이미 그 이메일로 된거 있는데?
니 아이디는 이러하니까
그거 비밀번호 쳐봐
맞으면 연동시켜줄게
<form action="<%=contextPath%>/member/mergeIdEnd" method="post">
<div>니 아이디 : <%=replacedId%></div>
<input type="password" name="password">
<button type="submit">할거임</button>
<button type="reset">귀차나 안해 - 회원가입 취소</button>
</form>
</section>

<%@ include file="/views/common/footer.jsp" %>
</body>
</html>