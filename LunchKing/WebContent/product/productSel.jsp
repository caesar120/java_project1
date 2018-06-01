<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
#prod_img {
	width: 200px;
	height: 200px;
}
</style>
<script>
function delCheck() {
	if(confirm("이 카테고리를 삭제할까요?")) {
		location.href="ProductControl.do?action=del&prodId=${product.prodId}";
	}
}
</script>
</head>
<body>
<h1> 상품 수정 </h1>
<form action="ProductControl.do?action=upd&prodId=${product.prodId}" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>상품 등록</legend>
		<input type="hidden" name="categoryId" value="${product.categoryId}">
		상품코드 <input type="text" name="prodId" readonly="readonly" value="${product.prodId}"> <br>
		상품명* <input type="text" name="prodName" value="${product.prodName}"> <br>
		상품설명 <textarea name="description">${product.description}</textarea> <br>
		상품구성 <input type="text" name="detail" value="${product.detail}"> <br>
		상품 이미지 <input type="text" name="uploadedImage" value="${product.prodImage}" readonly="readonly"> <br>
		<img src="../uploadedImg/${product.prodImage}" id="prod_img"> <br>
		<input type="file" name="prodImage"> <br>
		<input type="submit" value="수정">
		<input type="button" onclick="delCheck();" value="삭제">
	</fieldset>
</form>
</body>
</html>