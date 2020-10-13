<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<script src='http://code.jquery.com/jquery-3.5.1.min.js'></script>
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<meta charset="UTF-8">
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
</head>
<body>
	<script src="https://static.nid.naver.com/js/naveridlogin_js_sdk_2.0.0.js" charset="utf-8"></script>
</body>
<script>

		const naverLogin = new naver.LoginWithNaverId(
			{
				clientId: "ZsYfto7388DFNUATk2ze",
				callbackUrl: "http://mightymosses.hopto.org:9090/project_frog_01/member/naverSignIn",
				isPopup: false,
				callbackHandle: true
			}
		);

		/* (3) 네아로 로그인 정보를 초기화하기 위하여 init을 호출 */
		naverLogin.init();

		/* (4) Callback의 처리. 정상적으로 Callback 처리가 완료될 경우 main page로 redirect(또는 Popup close) */
		window.addEventListener('load', function () {
			naverLogin.getLoginStatus(function (status) {
				if (status) {
					/* (5) 필수적으로 받아야하는 프로필 정보가 있다면 callback처리 시점에 체크 */
					let email = naverLogin.user.getEmail();
					if( email == undefined || email == null) {
						alert("이메일은 필수정보입니다. 정보제공을 동의해주세요.");
						/* (5-1) 사용자 정보 재동의를 위하여 다시 네아로 동의페이지로 이동함 */
						naverLogin.reprompt();
						return;
					}
				
					naverLogin.getLoginStatus(function (status) {
						if (status) {
							let uniqId = naverLogin.user.getId();
							let email = naverLogin.user.getEmail();
							let name = naverLogin.user.getNickName();
							let profileImage = naverLogin.user.getProfileImage();
							let birthday = naverLogin.user.getBirthday();			
							
							 $.ajax({
		                    	  url: '<%=request.getContextPath()%>/member/naverSignIn',
		                    	  data: {"id" : uniqId, "birthday" : birthday, "email": email,
		                    			 "nickname" :  name, "profile_image_url": profileImage
		                    	  },
		                    	  type: 'POST',
		                    	  success : (data)=>{
		                    		const result = JSON.parse(data);
		                      		switch(result){
		                      		case 3: alert("기존에 가입된 아이디를 발견하였습니다"); location.href = "<%=request.getContextPath()%>/member/mergeId"; break;
		                      		/* 간편가입시 '추가 정보 기입하시겠습니까?' 등을 물어보는 서블릿으로 이동 */
		                      		case 2: alert("기존에 가입된 이력이 없습니다. 간편 가입되었습니다."); location.href = "<%=request.getContextPath()%>/member/snsSignUp"; break;
		                      		case 1: alert("네이버를 통해 간편로그인을 하셨습니다."); location.href = "<%=request.getContextPath()%>"; break;
		                      		}
		                    	  }
		                      })
						} else {
							console.log("AccessToken이 올바르지 않습니다.");
						}
					});
					
				} else {
					console.log("callback 처리에 실패하였습니다.");
				}
			});
		});
	</script>
</html>