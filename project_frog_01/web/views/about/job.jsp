<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<style>
section *{
    margin:0;
    padding:0;
    box-sizing: border-box;
    font-family: 'Poppins', sans-serif;
}
/* 배경색 */
section
{
    display:flex;
    justify-content: center;
    align-items: center;
    background: white;
    min-height: 100vh;
    /* margin:0;
    padding:0;
    box-sizing: border-box; */
}
.container
{
    position: relative;
    width: 1000px;
    display: flex;
    justify-content: space-between;
    flex-wrap: wrap;
    margin: 20px;
}
 /* 내부 색 */
.container .card 
{
    position: relative;
    height: 250px;
    background: #222;
    display: flex;
    width: 45%;
    margin: 30px 0;
}
/* div 배경색 */
.container .card .imgBx{
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background:#333;
    z-index: 1;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    transition: 0.5s ease-in-out;
}
/* 줄였을때 배경색 */
.container .card:hover .imgBx{
    width: 150px;
    height: 150px;
    left: -75px;
    top: calc(50% - 75px);
    transition: 0.5s ease-in-out;
    background: #ff0057;
}
/* 글자 부분 */
.container .card .imgBx:before{
    content: attr(data-text);
    position: absoulte;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 100%;
    text-align: center;
    font-size: 4em;
    color: white;
    font-weight: 700; 
}
.container .card .imgBx img{
    max-width: 120px;
    transition: 0.5s ease-in-out;
    /* border-radius: 30px; */
}
.container .card:hover .imgBx img{
    max-width: 50px;
    /* border-radius: 30px; */
}
.container .card .content{
    position: absolute;
    right: 0;
    width: calc(100% - 75px);
    height: 100%;
    padding: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
}
/* div 내부 h3 색 */
.container .card .content h3{
    /* margin-bottom: 5px; */
    font-size: 24px;
    color: white;
}
.container .card .content p{
    color: white;
}
@media (max-width: 992px){
    .container
    {
        width: 100%;
        flex-direction: column;
        align-items: center;
    }
    .container .card
    {
        width: 400px;
    }
}
@media (max-width: 768px){
    .container .card
    {
        max-width: 300px;
        flex-direction: column;
        height: auto;
    }
    .container .card .imgBx
    {
        position: relative;
    }
    .container .card .imgBx,
    .container .card:hover .imgBx
    {
        width: 100%;
        height: 200px;
        left: 0;
    }
    .container .card .imgBx img,
    .container .card:hover .imgBx img
    {
        max-width: 100px;
    }
    .container .card .content
    {
        position: relative;
        width: 100%;
    }
}
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
<body>
    <section>
    <div class="container">
        <div class="card">
            <div class="imgBx" data-text="접수기간">
            	<img src="<%=request.getContextPath()%>/image/about/receipt.png">
            </div>
            <div class="content">
                <div>
                    <h3>접수기간</h3>
                    <p>2020.10.2(금) ~ 10.16(금)</p>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="imgBx" data-text="모집분야">
            	<img src="<%=request.getContextPath()%>/image/about/recruitment.png">
            </div>
            <div class="content">
                <div>
                    <h3>모집분야</h3><br>
                    <p>웹 디자이너<br>
                        웹 퍼블리셔<br>
                        프론트 엔드<br>
                        백 엔드<br>
                        DB 엔지니어
                    </p>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="imgBx" data-text="지원방법">
            	<img src="<%=request.getContextPath()%>/image/about/support.png">
            </div>
            <div class="content">
                <div>
                    <h3>지원방법</h3>
                    <p>토이스토리 공식 홈페이지<br>
                    접속 -> 지원 -> 실시간 채팅 문의를 통한 입사지원</p>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="imgBx" data-text="혜택">
            	<img src="<%=request.getContextPath()%>/image/about/profits.png">
            </div>
            <div class="content">
                <div>
                    <h3>혜택</h3>
                    <p>TOYSPACE 피규어 평생 무료!!<br>
                        7GRAM 아이스 아메리카노 1잔<br>
                        TOMN TOMS COFFE 아이스 아메리카노 1잔
                    </p>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>