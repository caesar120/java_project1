<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>런치킹</title>
<link rel="stylesheet" type="text/css" href="./css/common.css">
<link rel="stylesheet" type="text/css" href="./css/main.css">
</head>
<body>
<header>           <!-----상단 heder 시작 : 로고, 검색, top_menu, main_menu -------->
  <section id="top">				
  						<!-- section top 시작 -->
    <a id="logo" href="mainControl.do?action=main"><img src="../img/lunchking.gif"></a> 		<!-- 로고 -->
    
    <nav id="top_menu">											<!-- top_menu 시작 -->
      <ul>
        <li><a href="mainControl.do?action=login">로그인</a></li>
        <li><a href="mainControl.do?action=userRegist">회원가입</a></li>
        <li><a href="#">마이페이지</a></li>
        <li><a href="#">장바구니</a></li>
        <li><a href="#">고객센터</a></li>
        <li><a href="managerControl.do?action=manager">관리자홈</a></li>
      </ul>
    </nav> 														<!-- top_menu 끝 ---->
    <div class="clear"></div>
  </section> 	
  <section id="main_menu">											<!-- section top 끝 -->
  <nav> 											<!-- main_menu 시작 -->
    <ul>
      <li><a href="detail.html">주문하기 </a></li>
      <li><a href="mainControl.do?action=category">런치킹도시락</a></li>
      <li><a href="mainControl.do?action=table">식단표</a></li>
      <li><a href="managerControl.do?action=productManage">게시판</a></li>
    </ul>
  </nav>
  </section>														<!-- main_menu 끝 -->
</header>           <!----------------- 상단 header 끝 ----------------------------->



<section id="main"> <!----------------- section main 시작  ------------------------->
                		<!-- section cat1 : 카테고리 section 끝 -->

  <div class="clear"></div>

  <section id="special_shop"> 				<!-----section : 왼쪽에 special_shop 만들기 시작-------->
    <ul>
      <li><img src=""></li>
      <li><img src=""></li>
    </ul>
  </section> 								<!-----section : 왼쪽에 special_shop 만들기 끝-------->
  <section id="special_banner"> 			<!-----section : 오른쪽에 배너 3개 만들기 시작-------->
    <div id="banner1">
      <ul>
        <li><img src=""></li>
        <li><img src=""></li>
      </ul>
    </div>
    <div id="banner2">
      <ul>
        <li><img src=""></li>
        <li><img src=""></li>
      </ul>
    </div>
    <div id="banner3">
      <ul>
        <li><img src=""></li>
        <li><img src=""></li>
      </ul>
    </div>
  </section> 								<!-----section : 오른쪽에 배너 3개 만들기 끝-------->

  <div class="clear"></div>

  <section id="new"> 						<!-----section : 신규 상품 부분 만들기 시작-------->
    <h3><span>NEW MENU</span> 신규 메뉴 </h3>
    <div class="item">
      <ul>
        <li><img src="../img/menu.gif"></li>
        <li class="subject">맞춤제작(풍경)</li> <!-- 신규 상품의 제목, 설명, 가격 ------>
        <li class="comment">원하는 사이즈로 제작 가능</li>
        <li class="price">20,000원</li>
      </ul>
    </div>
    <div class="item">
      <ul>
        <li><img src="../img/menu.gif"></li>
        <li class="subject">맞춤제작(풍경)</li>
        <li class="comment">원하는 사이즈로 제작 가능</li>
        <li class="price">20,000원</li>
      </ul>
    </div>
    <div class="clear"></div>
    <div class="item">
      <ul>
        <li><img src="../img/menu.gif"></li>
        <li class="subject">맞춤제작(풍경)</li>
        <li class="comment">원하는 사이즈로 제작 가능</li>
        <li class="price">20,000원</li>
      </ul>
    </div>
    <div class="item">
      <ul>
        <li><img src="../img/menu.gif"></li>
        <li class="subject">맞춤제작(풍경)</li>
        <li class="comment">원하는 사이즈로 제작 가능</li>
        <li class="price">20,000원</li>
      </ul>
    </div>
  </section> 								<!-----section : 신규 상품 부분 만들기 끝-------->

  <div class="clear"></div>

</section> 						<!----------------- section main 끝  ------------------------->

<footer>						<!------------------하단 footer 시작-------------------------->
  <section id="footer_menu_box">
    <nav id="footer_menu">				<!-- footer_menu 시작 -->
      <ul>
        <li><a href="#">회사소개</a></li>
        <li><a href="#">이용안내</a></li>
        <li><a href="#">장바구니</a></li>
        <li><a href="#">주문조회</a></li>
        <li><a href="#">적립금</a></li>
        <li><a href="#">이용약관</a></li>
        <li><a href="#">개인정보보호정책</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </nav>								<!-- footer_menu 끝 -->
  </section> 
  <section id="footer_box">				<!-----section : footer_box -->
    <div id="footer_logo">   				<!-- 로고 -->
      <img src="../img/footer_logo.gif">
    </div>
    <div id="address">						<!-- 주소 및 연락처-->
      <img src="../img/address.gif">
    </div>
    <div id="footer_banner">				<!-- 배너 -->
      <img src="../img/footer_banner_01.gif">
    </div>
  </section> 					<!------------------하단 footer 끝-------------------------->
</footer>
</body>
</html>