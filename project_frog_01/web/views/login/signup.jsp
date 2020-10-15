<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<%@ include file="/views/common/favicon.jsp" %>
</head>
<style>
*{
    margin: 0; padding: 0;
    
}
section{
	justify-content: center;
    display: flex;
    align-items: center;
}
.logo-area1,.logo-area2{
	text-align: center;
}
.si-area{
	text-align: center;
	font-weight: bold;
	
}
.si-area label{
	margin:10px;
 	width:100px;  
 	display: inline-block;
    text-align: center;
    font-size: 15px;
}

.si-area input{
	justify-content: center;
    display: flex;
    align-items: center;
 	width: 100%;
    padding: 10px 10px 10px;
    margin: 20px;
    font-size: 15px;
    border-radius: 5px;
    outline:none;
}


.news{
	 margin: 20px;
    -webkit-nbsp-mode: space;
    font-size: 15px;
}
.last-area1{  
    margin: 30px;
    text-align: center;
    text-decoration: none;
    
    
}
.btn-area1{
	justify-content: center;
    display: flex;
    align-items: center;

}
.btn-area1 button{
 	width: 20%;
    height: 40px;
    border-radius: 50px;
    background-color: white;
    border-style: dotted;
    outline: 0;
}
.last-area1 a{
    text-decoration: none;
    color: blue;
}
.regex{
    font-size: 15px;
    text-align: center;
}
.id-msg1{
	color : black;
	display: none;
}
.id-msg2{
	color : red;
	display: none;
}
</style>
<body>
	<%@ include file="/views/common/header.jsp" %>
 <section>
        <form action="<%=request.getContextPath()%>/signupEnd.do" method="post" id="signform">
            <div class="logo-area1">
                <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png" alt="toyspace">
            </div>
            
            <div class="logo-area2">    
                <img src="<%=request.getContextPath()%>/image/login/pikachu.png" alt="funko">
            </div>
			<div class="wrapper">
            <div class="si-area">
            	<h1>SIGN UP</h1>
                	<label for ="userId">아이디</label>
                	<input type="text" name="userId" id="userId" autocomplete="off" minlength="8" maxlength="11">
	                	<span class="id-msg1">
	                		사용가능한 아이디입니다.
	                	</span>
	                	<span class="id-msg2">
	                		사용중인 아이디입니다. 다시입력해주세요
	                	</span>
                	<label>비밀번호</label>
                	<input type="password" name="userPassword" id="userPassword" minlength="8" maxlength="11">
                	<div class="userPassword regex"></div>
                	
                	<label>비밀번호확인</label>
                	<input type="password" name="re_userPassword" id="re_userPassword" minlength="8" maxlength="11">
                	<div class="re_userPassword regex"></div>
                	
                	<label>이름</label>
                	<input type="text" name="userName" id="userName" autocomplete="off">
                	<div class="userName regex"></div>
                	
                	<label>별명</label>
                	<input type="text" name="userNickname" id="userNickname" autocomplete="off">
                	<div class="userNickname regex"></div>
                	
                	<label>이메일</label>
                	<input type="email" name="userEmail" id="userEmail" autocomplete="off">
                	<div class="userEmail regex"></div>
            </div>
            <div class="btn-area1">
                <button type="submit" id="submitbtn">가입하기</button>
            </div>
            <div class="last-area1">
                <label>계속하면 TOYSPACE에 동의하는것으로 간주합니다.<a href=""> 이용약관</a> 그리고 <a href="">개인정보정책</a></label><br>
                <label>이미 계정이 있으신가요? <a href="<%=request.getContextPath() %>/login.do">로그인</a></label>               
            </div>
           </div> 
        </form>
    </section>
    <script type="text/javascript">
    		$(function(){
    			$("#userId").blur(function(){
    				$.ajax(){
    					url:"checkIdDuplicate",
    					type:"post",
    					data:{"id":$("#userId").val()},
    					success : function(result){}
    					
    				};
    			});
    		});
    </script>
    <script>
    	//비밀번호 유효성검사
            $("#userPassword").on("input",function(){
                var regex = /^[A-Za-z\d]{8,12}$/;
                var result = regex.exec($("#userPassword").val())
                
                if(result != null){
                    $(".userPassword.regex").html("사용가능한 비밀번호입니다.");
                    $(".userPassword.regex").css("color","green")
                }else{
                    $(".userPassword.regex").html("영어대소문자,숫자 8-11자리");
                    $(".userPassword.regex").css("color","red")
                }
            });
            
           //비밀번호 확인    
               $("#re_userPassword").on("keyup",function(){
                    if($("#userPassword").val()==$("#re_userPassword").val()){
                       $(".re_userPassword.regex").html("비밀번호가 일치합니다");
                       $(".re_userPassword.regex").css("color","green"); 
                    }else{
                     $(".re_userPassword.regex").html("비밀번호가 일치하지않습니다");
                     $(".re_userPassword.regex").css("color","red");
                    }
               })
            
            //이름 유효성검사
                $("#userName").on("input",function(){
                    var regex = /[가-힣]{2,}/;
                    var result = regex.exec($("#userName").val());
                    
                    if(result != null){
                       $(".userName.regex").html("입력 되셨습니다.");  
                       $(".userName.regex").css("color","green")
                    }else{
                        $(".userName.regex").html("한글만 입력 가능합니다.");
                        $(".userName.regex").css("color","red")
                    }
                    
                })
             //닉네임 유효성검사
                $("#userNickname").on("input",function(){
                    var regex = /[가-힣]{2,}/;
                    var result = regex.exec($("#userNickname").val());
                    
                    if(result != null){
                       $(".userNickname.regex").html("입력 되셨습니다.");
                       $(".userNickname.regex").css("color","green")
                    }else{
                        $(".userNickname.regex").html("한글만 입력 가능합니다.");
                        $(".userNickname.regex").css("color","red")
                    }
                    
                })
		     //email유효성 검사
                $("#userEmail").on("input",function(){
                     var regex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
                     var result = regex.exec($("#userEmail").val());
                    
                    if(result != null){
                    	$(".userEmail.regex").html("입력 되셨습니다.");
                        $(".userEmail.regex").css("color","green") 
                    }else{
                        $(".userEmail.regex").html("올바른 이메일이 아닙니다");
                        $(".userEmail.regex").css("color","red")
                    }
                })
          //회원가입 버튼 눌렀을 때, 빈칸 있으면 다시 유효성 검사진행    
           $("#submitbtn").on("click",function(){
        	   var pw = $("#userPassword").val();
        	   var name = $("#userName").val();
        	   var nickname = $("#userNickname").val();
        	   var email = $("#userEmail").val();
        	   
        	  
        	   var pwregex = /^[A-Za-z\d]{8,12}$/;
        	   var nameregex = /[가-힣]{2,}/;
        	   var nicknameregex = /[가-힣]{2,}/;
        	   var emailregex = /.+@[a-z]+(\.[a-z]+){1,2}$/;
        	   
        	  
        	   var pwregex = pwregex.exec(pw);
        	   if(pwregex == null){
        		   alert("비밀번호양식을 다시 확인해주세요");
        		   retrun;
        	   }
        	   var nameregex = nameregex.exec(name);
        	   if(nameregex == null){
        		   alert("이름양식을 다시 확인해주세요");
        		   retrun;
        	   }
        	   var nicknameregex = nicknameregex.exec(nickname);
        	   if(nicknameregex == null){
        		   alert("별명양식을 다시 확인해주세요");
        		   retrun;
        		}
        	   var emailregex = emailregex.exec(email);
        	   if(emailregex == null){
        		   alert("이메일양식을 다시 확인해주세요");
        		   retrun;
        	   }
        	   
             //빈칸 없을 때 제출.
        	   $("#signform").submit();
            	   
           
           })
        

        </script>
    <%@ include file="/views/common/footer.jsp" %>
</body>
</html>