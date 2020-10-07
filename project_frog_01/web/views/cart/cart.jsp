<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/cart/style.css">
    <title>Document</title> 
</head>
<body>
<%@ include file="/views/common/header.jsp" %>
    <section class="container">
        <div class="top">
            <div class="left">
                <h1>내 카트</h1>
                <div class="top1">
                    <div class="ITEM">ITEM</div>
                    <div class="QTY">수량</div>
                    <div class="PRICE">가격</div>
                </div>
                <hr>
                <!-- 상품 -->
                <div class="top2">
                    <div class="imgg">
                        <img src="<%=request.getContextPath()%>/image/cart/joker.png" alt="">
                    </div>
                    <div class="name">
                        <div class="name1">
                        <p>POP!<br>
                        <b>JOKER-BATMAN 1989</b>
                        </p>
                        </div>
                    </div>
                    <div class="trash">
                        <button class="white-icon">
                            <i class="fas fa-trash"></i>
                        </button>
                    </div>
                    <div class="plus2">
                        <div class="plus3">
                            <button class="minus">
                                <i class="fas fa-minus"></i>
                            </button>
                            <div class="int">1</div>
                            <button class="plus">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="money">
                        <p>11달러</p>
                    </div>
                </div>
                <hr>
                <div class="top2">
                    <div class="imgg">
                        <img src="<%=request.getContextPath()%>/image/cart/jok.png" alt="">
                    </div>
                    <div class="name">
                        <div class="name1">
                        <p>POP! <br>
                            <b>THE JOKER AS SANTA</b>
                        </p>
                        </div>
                    </div>
                    <div class="trash">
                        <button class="white-icon">
                            <i class="fas fa-trash"></i>
                        </button>
                    </div>
                    <div class="plus2">
                        <div class="plus3">
                            <button class="minus">
                                <i class="fas fa-minus"></i>
                            </button>
                            <div class="int">1</div>
                            <button class="plus">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="money">
                        <p>11달러</p>
                    </div>
                </div>
                <hr>
                <div class="top2">
                    <div class="imgg">
                        <img src="<%=request.getContextPath()%>/image/cart/bat.png" alt="">
                    </div>
                    <div class="name">
                        <div class="name1">
                        <p>POP! <br>
                        <b>BATMAN AS EBENEZER SCROOGE</b>
                        </p>
                        </div>
                    </div>
                    <div class="trash">
                        <button class="white-icon">
                            <i class="fas fa-trash"></i>
                        </button>
                    </div>
                    <div class="plus2">
                        <div class="plus3">
                            <button class="minus">
                                <i class="fas fa-minus"></i>
                            </button>
                            <div class="int">1</div>
                            <button class="plus">
                                <i class="fas fa-plus"></i>
                            </button>
                        </div>
                    </div>
                    <div class="money">
                        <p>11달러</p>
                    </div>
                </div>
            </div>
            <div class="right">
                <div class="summary">
                    <div class="summary-left">SUMMARY</div>
                    <div class="summary-right">
                        3
                        항목
                    </div>
                </div>
                <hr>
                <div class="mid">
                    <p>
                        체크 아웃을 클릭하면 이용 약관에 동의 하고
                        모든 판매가 최종적임을 이해합니다. 적용 가능한
                        모든 할인 또는 쿠폰은 결제 시 반영됩니다.
                    </p>
                </div>
                <hr>
                <div class="mid2">
                    <div class="SUBTOTAL-left">SUBTOTAL</div>
                    <div class="SUBTOTAL-right">33달러</div>
                </div>
                <div class="bottom">
                    <p class="SHIPPING">무료 배송</p>
                    <button><b>체크 아웃</b></button>
                </div>
            </div>
        </div>
        <div class="btm">
            <h3>권장 사항</h3>
            <div class="dc">
                <div class="first">
                    <img src="<%=request.getContextPath()%>/image/cart/CutJoker.png" alt="">
                    <p>
                    REGULAR PLUSH<br>
                    <b>THE JOKER AS SANTA</b><br>
                    10달라
                    </p>
                    <button>장바구니에 담기</button>
                </div>
                <div class="second">
                    <img src="<%=request.getContextPath()%>/image/cart/Holly.png" alt="">
                    <p>
                    REGULAR PLUSH<br>
                    <b>HARLEY QUINN WITH HOLY</b><br>
                    10달라
                    </p>
                    <button>장바구니에 담기</button>
                </div>
                <div class="third">
                    <img src="<%=request.getContextPath()%>/image/cart/bat2.png" alt="">
                    <p>
                    POP!<br>
                    <b>CLASSIC BATMAN</b><br>
                    11달라
                    </p>
                    <button>장바구니에 담기</button>
                </div>
                <div class="force">
                    <img src="<%=request.getContextPath()%>/image/cart/super.png" alt="">
                    <p>
                    POP!<br>
                    <b>SUPERMAN IN HOLIDAY SWEATER</b><br>
                    11달라
                    </p>
                    <button>장바구니에 담기</button>
                </div>
            </div>
        </div>
    </section>
<%@ include file="/views/common/footer.jsp" %>
</body>
</html>