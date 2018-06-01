<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
var xhr;

window.onload = function getCategoryList() {
	xhr = new XMLHttpRequest();
	xhr.open("get", "CategoryControl.do?action=categoryList");
	xhr.onreadystatechange = getCategoryListCallback;
	xhr.send();
}

function getCategoryListCallback() {
	if(xhr.readyState == 4) {
		if(xhr.status == 200) {
			var categoryList = eval('(' + xhr.responseText + ')');
			
			for(i=0; i<categoryList.length; i++) {
				var option = document.createElement("option");
				option.setAttribute("value", categoryList[i].categoryId);
				var txt = document.createTextNode(categoryList[i].categoryId + ":" + categoryList[i].categoryName);
				option.appendChild(txt);
				
				var list = document.getElementById("categoryList");
				list.appendChild(option);
			} 
		}
	}
}
</script>
</head>
<body>
<h1> 상품 등록 </h1>
<form action="ProductControl.do?action=ins" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>상품 등록</legend>
		상품분류
			<select id="categoryList" name="categoryId"></select> <br>
		상품명* <input type="text" name="prodName"> <br/>
		상품설명 <textarea name="description"></textarea> <br>
		상품구성 <input type="text" name="detail"> <br>
		상품 이미지 <input type="file" name="prodImage"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</fieldset>
</form>
</body>
</html>