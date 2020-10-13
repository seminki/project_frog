<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String clientId = (String)request.getAttribute("client_id"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<%@ include file="/views/common/favicon.jsp" %>
<!-- 구글 로그인 api 로드 -->
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="<%=clientId%>">
<!-- 네이버 로그인 api 로드 -->
<script type="text/javascript" src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
<!-- 카카오 로그인 api 로드 -->
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
</head>
<style>
.text_center{
    text-align: center;
    
}   
table{
    margin: auto;
}
.area-btn button{
    margin: 20px;
    width: 70px;
    height: 40px;
    border-radius: 50px;
    background-color: white;
    border-style: dotted;
    outline: 0;
}
.info {
    font-size: 12px;
    width: max-content;
    border-top: 1px solid black;
    border-collapse: collapse;
    }
.info th,td{
    border-bottom: 1px solid black;
    padding: 10px;
    }
.info td input:not([type=radio] ){
    font-size: 15px;
    border:none;
    border-bottom: gray 1px solid;
    width: 60%;
}
th{
    text-align: left;
}

.boy-girl{
    width: 50%;
    justify-content: space-around;
}

.inBorder{
    -moz-appearance: none;
    width: 50px; /* 원하는 너비설정 */ 
    padding: .3em .2em; /* 여백으로 높이 설정 */
}

.but1{
    display: flex;
    justify-content: center;
    
    max-width: 80%;
    
    
}
.btn2{
        
        float: left;
        height: 30em;
        z-index: 900;
}
.btn2 ul li{
    list-style: none;
    margin: 10px;
    margin-top: 50px;
}
.hide{
	display:none;
}
</style>
<body>
<%@ include file="/views/common/header.jsp" %>
    <section class="info-container">
    <div class="text_center" >
        <!-- 여기위 클래스로 text center css 줌 @@@@@@@@@@@@@@@@@@-->
        <img src="<%=request.getContextPath()%>/image/login/blacklogo-small.png">
    </div>
    <div class="btn2">
        <!-- 버튼 추가  -->
        <ul>
            <li><a href="">비밀번호 변경</a></li>
            <li><a href="">구매목록</a></li>
            <li><a href="">찜한목록</a></li>
        </ul>
    </div>
    <div class="but1">
        <div class="btn3"></div>
        <div class="list-container">
            <h2 class="text_center">개인 정보 수정</h2>
            <!-- 여기위 클래스로 text center css 줌 @@@@@@@@@@@@@@@@@@-->
            <table class="info"> 
                <tr>
                    <th>아이디</th> <!--회원아이디 불러오기 -->
                    <td>
                        <input type="text" name="userId" id="userId" value="" readonly>
                    </td>
                </tr>
                <tr>
                    <th>이름</th> <!--회원이름 불러오기-->
                    <td>
                        <input type="text" name="userName" id="userName" value="" autocomplete="off" required>
                    </td>
                </tr>
                <tr>
                    <th>생년월일</th>
                    <td>
                        <input type="text" style="width: 50px;" name="inyear" class="inBorder" maxlength=4 style="font-size: 10px;">년
                        <select class="inBorder">
                            <option value="1">1
                            <option value="2">2
                            <option value="3">3
                            <option value="4">4
                            <option value="5">5
                            <option value="6">6
                            <option value="7">7
                            <option value="8">8
                            <option value="9">9
                            <option value="10">10
                            <option value="11">11
                            <option value="12">12                            
                        </select> 월
                        <select class="inBorder">
                            <option value="1">1
                            <option value="2">2
                            <option value="3">3
                            <option value="4">4
                            <option value="5">5
                            <option value="6">6
                            <option value="7">7
                            <option value="8">8
                            <option value="9">9
                            <option value="10">10
                            <option value="11">11
                            <option value="12">12  
                            <option value="13">13
                            <option value="14">14
                            <option value="15">15
                            <option value="16">16
                            <option value="17">17
                            <option value="18">18
                            <option value="19">19
                            <option value="20">20
                            <option value="21">21
                            <option value="22">22
                            <option value="23">23
                            <option value="24">24
                            <option value="25">25
                            <option value="26">26
                            <option value="27">27
                            <option value="28">28
                            <option value="29">29
                            <option value="30">30
                            <option value="31">31
                        </select> 일
                    </td>
                </tr>
                <tr>
                    <th>나이</th>
                    <td>
                        <input type="text" name="age" id="age">
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <div class="boy-girl">                   
                            <label for="gender0">남</label>
                            <input type="radio" name="gender" size="5" id="gender0" value="M">                            
                            <label for="gender1">여</label>
                            <input type="radio" name="gender" size="5" id="gender1" value="F">
                        </div>
                    </td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>
                        <input type="email" name="email" id="email" value="">
                    </td>
                </tr>
                <tr>
                    <th>핸드폰</th>
                    <td>
                        <input type="text" name="phone" id="phone" value="">
                    </td>
                </tr>
                <tr>
                    <th>주소</th>
                    <td>
                        <input type="text" name="address" id="address" value="">
                    </td>
                </tr>
        </div>
    </div>
        </table>
            <div class="container-btn text_center">
                <!-- 여기위 클래스로 text center css 줌 @@@@@@@@@@@@@@@@@@-->
                <div class="area-btn">
                    <button onclick="" value="">수정</button>
                    <button onclick="" value="">뒤로</button>
                </div>
                
             <div class="g-signin2 hide" data-onsuccess="onSignIn"></div>  
            </div>
            
            <button id="logout-btn">로그아웃</button>
        </section>
<%@ include file="/views/common/footer.jsp" %>

<script>
	let googleFlag;
	function onSignIn(googleUser) {
		googleFlag = googleUser.isSignedIn();
		let id_token = googleUser.getAuthResponse().id_token;
	}
	
	$("#logout-btn").click((e)=>{
		if(googleFlag){
			gapi.auth2.getAuthInstance().signOut();
		}
			location.href = '<%=contextPath%>/member/logout';
	})


</script>
</body>
</html>