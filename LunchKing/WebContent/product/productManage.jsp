<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>메뉴 관리</title>
<style>
ul {
	list-style: none;
}
#title {
	clear: both;
}
#title li {
	float: left;
	margin-right: 30px;
	margin-bottom: 30px;
}
.clear {
	clear: both;
	display: block;
	height: 0px;
}
#content {
	
}
.category {
	clear: both;
	margin-top: 20px;
	font-size: 17px;
	font-weight: bold;
}
.product {
	clear: both;
}
.product li {
	float: left;
	margin: 5px 5px 5px 5px;
}
</style>
<script>
</script>
</head>
<body>
<h3>메뉴 관리</h3>
<hr>
<button onclick="location.href='categoryRegist.jsp'">분류등록</button>
<button onclick="location.href='productRegist.jsp'">상품등록</button>
<ul id="title">
	<li>상품번호</li>
	<li>상품명</li>
	<li>상품설명</li>
	<li>상품구성</li>
</ul>
<ul id="content">
<c:forEach items="${categoryList}" var="category">
	<li class="category">
		<a href="CategoryControl.do?action=sel&categoryId=${category.categoryId}">
			${category.categoryId} | ${category.categoryName}
		</a> 
	</li>
	<li>
	<c:forEach items="${category.productList}" var="product">	
		<ul class="product">
			<li><a href="ProductControl.do?action=sel&prodId=${product.prodId}">${product.prodId}</a></li>
			<li>${product.prodName}</li>
			<li>${product.description}</li>
			<li>${product.detail}</li>
		</ul>
	</c:forEach>	
	</li>
</c:forEach>	
</ul>
</body>
</html>