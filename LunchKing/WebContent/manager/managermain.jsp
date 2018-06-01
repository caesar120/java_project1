<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" type="text/css" href="./css/m_common.css">
<link rel="stylesheet" type="text/css" href="./css/m_main.css">
</head>
<body>
<h1>관리자페이지</h1><hr>

<header>           <!-----상단 heder 시작 : 로고, 검색, top_menu, main_menu -------->
  <section id="top">				
  						<!-- section top 시작 -->
    <a id="logo" href="mainControl.do?action=main"><img src="../img/lunchking.gif"></a> 		<!-- 로고 -->
    
    <nav id="top_menu">											<!-- top_menu 시작 -->
      <ul>
        <li><a href="#">로그아웃</a></li>
        <li><a href="#">고객센터</a></li>
      </ul>
    </nav> 														<!-- top_menu 끝 ---->
    <div class="clear"></div>
  </section> 	
  <section id="main_menu">											<!-- section top 끝 -->
  <nav> 											<!-- main_menu 시작 -->
    <ul>
      <li><a href="#">회원관리 </a></li>
      <li><a href="../managerControl.do?action=productManage">메뉴관리</a></li>
      <li><a href="#">식단표관리</a></li>
      <li><a href="#">게시판관리</a></li>
    </ul>
  </nav>
  </section>														<!-- main_menu 끝 -->
</header>           <!----------------- 상단 header 끝 ----------------------------->


</body>
</html>