<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>메뉴 상세</title>
<style>
.product_box {
	list-style: none;
	
}
.product_box li {
	float: left;
	display: inline-block;
	margin: 20px;
}
.content {
	width: 300px;
}
.content div {
	margin-top: 30px;
}
</style>
</head>
<body>
<div>
	<h2>메뉴소개</h2>
</div>
<div>
	이해를 돕기위한 사진으로 실 제품과 차이가 있을 수 있습니다.<br>
	원료 수급 등의 문제로 실 제품은 변경될 수 있습니다.
</div>
	<ul class="product_box">
		<li>
			<img src="../uploadedImg/${product.prodImage}" 
				 width="370" height="280" alt="">
		</li>
		<li class="content">
			<div class="title">${product.prodName}</div>
			<div class="ment">
				${product.description}
			</div>
			<div>
				<strong>구성</strong>
				<span>${product.detail}</span>
			</div>
		</li>
	</ul>
</body>
</html>