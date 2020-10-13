<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Insert title here</title>
<%@ include file="/views/common/favicon.jsp" %>
<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=syvma1ax3n"></script>
<style>
    .iw_inner{
        
   
    }
    #map{
        /* width: max-content; */
        /* position: absolute; */
    	border: 1px black solid;
        /* left: 1%; */
       
    }
/* 	div{
        border: 1px red solid;
    } */
    .div-center{
        text-align: center;
        display: block;
    }
    .center-img{
        /* width: max-content; */
        display: flex;
        width: 100%;
       	justify-content: space-around;
        
    }
    .center-img>*{
    width:30%;
    
    }
    .center-img>div>img{
    width:100%;
    height:35vw;
    
    }
</style>
</head>
<body>
<%@ include file="/views/common/header.jsp" %>


<div class="div-center">
    <h1>위치</h1>
    <div class="center-img">
    	<div class="section-img-container">
        <img src="<%=request.getContextPath()%>/image/map/bat.jpg" alt="">
    	</div>
        <div id="map" style="width:30%;height:35vw;"></div>
        <div class="section-img-container">
        <img src="<%=request.getContextPath()%>/image/map/joker.jpg" alt="">
        </div>
    </div>
    <h3>TOY SPACE</h3>
    <tr>
        <td>주소 : </td>
        <td>서울특별시 강남구 강남구 테헤란로14길</td>
    </tr>
    <br>
    <tr>
        <td>TEL : </td>
        <td>010-3043-1234</td>
    </tr>
    <br>
    <tr>
        <td>FAX : </td>
        <td>02-3143-1234</td>
    </tr>
</div>










<script>
var HOME_PATH = window.HOME_PATH || '.';
var cityhall = new naver.maps.LatLng(37.499299,127.0328057),
    map = new naver.maps.Map('map', {
        center: cityhall,
        zoom: 14
    }),
    marker = new naver.maps.Marker({
        map: map,
        position: cityhall
    });

var contentString = [
        '<div class="iw_inner">',
        '   <div style="background-color: black; width: 100% ;"><h2 style="color: white;">TOY SPACE</h2></div>',

        '   <p>서울특별시 강남구 강남구 테헤란로14길 6<br />',
        '       <a href="http://localhost:9090/project_frog_01" target="_blank">www.toyspace.go.kr/</a>',
        '   </p>',
        '</div>'
    ].join('');

var infowindow = new naver.maps.InfoWindow({
    content: contentString,
    maxWidth: 600,
    backgroundColor: "#eee",
    borderColor: "black",
    borderWidth: 1,
    anchorSize: new naver.maps.Size(30, 30),
    anchorSkew: true,
    anchorColor: "#eee",
    pixelOffset: new naver.maps.Point(20, -20)
});

naver.maps.Event.addListener(marker, "click", function(e) {
    if (infowindow.getMap()) {
        infowindow.close();
    } else {
        infowindow.open(map, marker);
    }
});
</script>



<%@ include file="/views/common/footer.jsp" %>
</body>
</html>