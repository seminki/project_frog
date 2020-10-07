<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="http://code.jquery.com/jquery-3.5.1.min.js"></script> 
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/product/productListStyle.css" />
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
    <div>
        <div>
            <header class="productsheader"> 
                <div class="h1"></div>
                <div class="h2">
                    <div class="h3">
                        <div class="h2_1">
                            <div class="shop">SHOP</div>
                            <h1 class="allp">ALL PRODUCTS</h1>
                        </div>
                        <div class="himg" style="background-position: center ;  background-image: url('data:image/png;base64,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');"></div>
                    </div>
                </div>
            </header>
            <div class="filter_con">
                <div class="filter_box">
                    <!-- 왼쪽 필터 -->
                    <div>Filters</div>
                    <div>
                        <ul>
                            <li>
                                <label for="">Featured</label>
                                <div>
                                    <ul>
                                        <li>
                                            <label for=""><input type="checkbox" value="best sellers"></label>
                                            <span>best sellers (#)</span>
                                        </li>
                                        <li>
                                            <label for=""><input type="checkbox" value="new releases"></label>
                                            <span>new releases (#)</span>
                                        </li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="products">
                    <!-- 오른쪽 제품 -->
                    <div>
                        <!-- 제품목록 -->
                        <div class="products_header">
                            <!-- 제품목록header -->
                            <div>
                                <!-- 전체 제품 수량 -->
                                <strong>제품수(#)</strong>
                            </div>
                            <div>
                                <!-- 빈공간 -->
                            </div>
                            <div>
                                <!-- 제품목록 순서 -->
                                <label for="">
                                    <select class="">
                                        <option value="0">Name: A-Z</option><option value="1">Name: Z-A</option>
                                        <option value="2" selected="">Newest First</option><option value="3">Oldest First</option>
                                        <option value="4">Price Low to High</option><option value="5">Price High to Low</option>
                                    </select>
                                </label>
                            </div>
                        </div>
                        <div class="products_list">
                            <!-- 제품목록 db 에서 불러온 제품을 for문 으로 제한된 수량 배열-->
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="products-list-item">
                                <a class="" href="">
                                    <img class="" src="https://gdimg1.gmarket.co.kr/goods_image2/large_jpgimg/152/483/1524837101.jpg?ver=5466828048" alt="Yelena Belova - Black Widow" style="background-image: url(&quot;https://cdn.shopify.com/s/files/1/1052/2158/products/1436_3266_8d7775aaf077bea_46687_MARVEL_BlueBayou_Yelena_POP_GLAM-WEB_300x2000.png?v=1583735493&quot;);">
                                    <div class="">
                                        <div class="">
                                            <div class="">Pop!</div>
                                            <strong class="">Yelena Belova - Black Widow</strong>
                                            <div class="">US$11</div>
                                        </div>
                                        <div class="addtocart_div">
                                            <button class="addtocart">Add To Cart</button>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            
                        </div>
                    </div>
                    <div>
                        <!-- 페이징 -->
                        <div class="center">
                            <div class="pagination">
                                <button class="black  pageControl previous " disabled="" tabindex="0">
                                <span class="sr-only">Previous page of results</span>
                                <span class="hide-for-small" aria-hidden="true">PREV</span>
                                <span class="show-for-small" aria-hidden="true"><i class="fas fa-chevron-left"></i></span>
                                </button>
                                <span class="sr-only">Go to page</span>
                                <button class="page active" tabindex="0">1</button>
                                <button class="page white" tabindex="0">2</button>
                                <button class="page white" tabindex="0">3</button>
                                <button class="page white" tabindex="0">4</button>
                                <button class="page white" tabindex="0">5</button>
                                
                                <button class="black pageControl next" tabindex="0">
                                <span class="sr-only">Next page of results</span>
                                <span class="hide-for-small" aria-hidden="true">NEXT</span>
                                <span class="show-for-small" aria-hidden="true"><i class="fas fa-chevron-right"></i></span>
                                </button>
                            </div>
                            <select class="width-auto">
                                <option value="24" selected="">Show 24 per page</option>
                                <option value="48">Show 48 per page</option>
                                <option value="96">Show 96 per page</option>
                                <option value="192">Show 192 per page</option>
                            </select>
                            </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>
