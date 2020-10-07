// 서치 바 관련 ui 애니메이션

let searchBarInput = $(".search-bar-input");
let grayScale = $(".gray-scale");
let sideBar = $(".side-bar");

$(".search-bar-li").click(() => {
	searchBarInput.css("display", "flex").animate({ height: "60px" }, "1s");
	grayScale.css({ display: "block", animation: "blur 1s ease" });
});
$(".small-search").click(() => {
	searchBarInput.css("display", "flex").animate({ height: "60px" }, "1s");
	grayScale.css({ display: "block", animation: "blur 1s ease" });
});
$(".fa-times").click(() => {
	searchBarInput.animate({ height: "0px" }, "1s");
	grayScale.css({ animation: "blurOut 0.4s ease" });
	animateRemoving();
});

$(".fa-bars").click(() => {
	sideBar.css("display", "inline-block").animate({ width: "320px" }, "1s");
	grayScale.css({ display: "block", animation: "blur 1s ease" });
});
$(".side-x").click(() => {
	sideBar.animate({ width: "0px" }, "1s");
	grayScale.css({ animation: "blurOut 0.4s ease" });
	animateRemoving();
});
grayScale.click(() => {
	sideBar.animate({ width: "0px" }, "1s");
	searchBarInput.animate({ height: "0px" }, "1s");
	grayScale.css({ animation: "blurOut 0.4s ease" });
	animateRemoving();
});

function animateRemoving() {
	setTimeout(() => {
		grayScale.css({ display: "none" });
		searchBarInput.css("display", "none");
		sideBar.css({ display: "none" });
	}, 400);
}
///////////////////////////////////////////////////
// 지원 클릭시
let bottomSupportUi = $(".bottom-support-ui");
let chattingWindow = $(".chatting-window");
bottomSupportUi.click((e) => {
	bottomSupportUi
		.removeClass("animate__delay-1s")
		.removeClass("animate__rotateInUpRight")
		.removeClass("animate__bounceInUp")
		.addClass("animate__rotateOutUpRight");
	chattingWindow
		.css({ display: "block" })
		.removeClass("animate__rotateOutUpRight")
		.addClass("animate__rotateInUpRight")
		.addClass("animate__delay-1s");
});
$(".chatting-x").click((e) => {
	chattingWindow
		.removeClass("animate__delay-1s")
		.removeClass("animate__rotateInUpRight")
		.addClass("animate__rotateOutUpRight");
	bottomSupportUi
		.removeClass("animate__rotateOutUpRight")
		.addClass("animate__rotateInUpRight")
		.addClass("animate__delay-1s");
});
///////////////////////////////////////////
// 아이콘 눌렀을 때 애니메이션
////////////////////////
let bigSearchIcon=$(".search-bar");
bigSearchIcon.hover((e)=>{
		// over
		bigSearchIcon.addClass("animate__pulse");
	},e=>{
		bigSearchIcon.removeClass("animate__pulse");
	});
bigSearchIcon.click(e=>{
	bigSearchIcon.removeClass("animate_jello");
	bigSearchIcon.addClass("animate_jello");
})








////////////////////////////////////////////
// 서치바 ui 검색시 실행
$(".search-bar-input").keydown((key) => {
	// 엔터이면 아래 실행
	if (key.keyCode == 13) {
		// 무엇을 실행할 것인지는 나중에 정한다
		
	}
});
//채팅바 전송 버튼 클릭 or 엔터 입력시 
$("#chatting-input").keydown((key) => {
	// 엔터이면 아래 실행
	if (key.keyCode == 13) {
		// 무엇을 실행할 것인지는 나중에 정한다
		
	}
});
$("#chatting-send-button").click((e)=>{
	
});
