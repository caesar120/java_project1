<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>메뉴 소개</title>
<style>
	.category {
		list-style: none;
	}
	.category li {
		float: left;
		margin: 20px;
	}
	.menu_path {
		list-style: none;
	}
	.menu_path li {
		float: left;
	}
	.menu {
		list-style: none;
		text-align: center;
	}
	.menu li {
		float: left;
		width: 220px;
		height: 170px;
		border: 1px solid black;
		padding: 10px;
		display: block;
	}
	.clear {
		clear: both;
	}
</style>
</head>
<body>
<div id="content">
  <section id="sub">		
	<div class="content_intro">
		<h3>메뉴소개</h3>
			<span class="">매일 집 앞까지 배달해주는 다이어트 도시락을 주문해보세요!</span>
	</div>

	<ul class="category">
	<c:forEach items="${categoryList}" var="categoryList">	
		<li class="">
			<a href="CategoryControl.do?action=intro&categoryId=${categoryList.categoryId}">
				<strong>${categoryList.categoryName}</strong>
			</a>
		</li>
	</c:forEach>
	</ul>
	
	<div class="clear">
		<h4>메뉴소개</h4>

		<div id="">
			<ul class="menu_path">
				<li><a>HOME</a></li>
				<li><span class="">></span><a>메뉴소개</a></li>
				<li><span class="">></span><a>메뉴소개</a></li>
			</ul>
		</div>
	</div>
	
	<div class="clear"></div>
	
	<img src="" />
	
	<div class="">
		<h4 class="">메뉴소개 메뉴 구성</h4>
		<span class="">매일매일 다른 메뉴로 제공되는 참살이 도시락!  20여 가지 식단제공!</span>
	</div>
	
	<div id=""></div>
	
	<ul class="menu">
<c:forEach items="${category.productList}" var="product" varStatus="st">
		<li>
			<a href="ProductControl.do?action=intro&prodId=${product.prodId}">
			<img src="../uploadedImg/${product.prodImage}" width="200" height="120" alt="${product.prodName}">
			<span class="tit">${product.prodName}</span>
			</a>
		</li>
	<c:if test="${st.count%5 == 0}">
		<div class="clear"></div>
	</c:if>
</c:forEach>	
	</ul>

	<div class="clear"></div>

	<div class="">
		<a href="../order/OrdersControl?action=order&categoryId=${category.categoryId}" class="">주문하기</a>
	</div>	

  	
  </section>	
</div>

</body>
</html>