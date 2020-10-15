<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>TOY SPACE - Where All Toys' Dream Comes True</title>
<style>
section{
    margin: 0;
    padding: 0;
    min-height: 100vh;
    background: #333;
    display: flex;
    justify-content: center;
    align-items: center;
    font-family: consolas;
}
.container{
    width: 1000px;
    position: relative;
    display:flex;
    justify-content: space-between;
}
.container .card
{
    position: relative;
    cursor: pointer;
}
.container .card .face
{
    width: 300px;
    height: 200px;
    transition: 0.5s;
}
.container .card .face.face1
{
    position: relative;
    background: #333; 
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 1;
    transform: translateY(100px);
}
.container .card:hover .face.face1
{
    /* background: #ff0057; */
    box-shadow: 0 20px 50px rgba(0,0,0,0.8);
    transform: translateY(0px);
}
.container .card .face.face2
{
    position: relative;
    background: gray;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 20px;
    box-sizing: border-box;
    box-shadow: 0 20px 50px rgba(0,0,0,0.8);
    transform: translateY(-100px);
}
.container .card:hover .face.face2
{
    transform: translateY(0px);
}
.container .card .face.face2 .content p
{
    margin: 0;
    padding: 0;
}
.container .card .face.face2 .content a
{
    margin: 25px88px 0;
    display: inline-block;
    text-decoration: none;
    font-weight: 900;
    color: #333;
    padding: 5px;
    border: 1px solid #333
}
.container .card .face.face2 .content a:hover
{
    background: #333;
    color: #fff;
}
.container .card .face.face1 .content
{
    opacity: 0.2;
    transition: 0.5s;
}
.container .card:hover .face.face1 .content
{
    opacity: 1;
}
.container .card .face.face1 .content img
{
    max-width: 100px;
}
.container .card .face.face1 .content h3
{
    margin: 10px 0 0;
    padding: 0;
    color: #fff;
    text-align: center;
    font-size: 1.5em;
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
    .container .card .content
    {
        position: relative;
    }
    .container .card .content,
    .container .card:hover .content
    {
        width: 100%;
        height: 130px;
        left: 0;
    }
    .container .card .content img,
    .container .card:hover .content img
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
            <div class="face face1">
                <div class="content">
                	<img src="<%=request.getContextPath()%>/image/about/frog.png">
                    <h3>Frog 탄생</h3>
                </div>
            </div>
            <div class="face face2">
                <div class="content">
                    <p>2020년 7월21일
                    Frog팀은 피규어<br> 
                    쇼핑물 웹사이트를 만들기로<br>
                    다짐한 사람들이 모여 만들어진<br>
                    조직이다.</p> 
                </div>
            </div>
        </div>
        <div class="card">
            <div class="face face1">
                <div class="content">
                	<img src="<%=request.getContextPath()%>/image/about/toyspace.png">
                    <h3>TOSPACE 탄생</h3>
                </div>
            </div>
            <div class="face face2">
                <div class="content">
                    <p>2020년 10월2일<br>
                    TOYSPACE는 Frog팀의 회사명이며 <br>
                    피규어를 다루는 쇼핑몰이다. <br>
                    피규어 종류로는
                    디즈니, 스타워즈, 왕좌의 게임, 포켓몬스터, 마블의 피규어들이 있다.
                </p>
                </div>
            </div>
        </div>
        <div class="card">
            <div class="face face1">
                <div class="content">
                	<img src="<%=request.getContextPath()%>/image/about/star.png">
                    <h3>서비스 종료</h3>
                </div>
            </div>
            <div class="face face2">
                <div class="content">
                    <p>우리의 TOYSPACE... 10월 2일에<br>
                        시작해 구매자들이 많을거라<br>
                        기대를 했지만 10월 16일부로<br>
                        서비스를 종료합니다.
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