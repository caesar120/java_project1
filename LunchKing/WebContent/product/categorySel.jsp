<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
function delCheck() {
	if(confirm("이 카테고리를 삭제할까요?")) {
		location.href="CategoryControl.do?action=del&categoryId=${category.categoryId}";
	}
}
</script>
</head>
<body>
<h1> 카테고리 수정 </h1>
<form action="CategoryControl.do?action=upd&categoryId=${category.categoryId}" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>카테고리 수정</legend>
		카테고리코드 <input type="text" name="categoryId" readonly="readonly" value="${category.categoryId}"> <br>
		카테고리명* <input type="text" name="categoryName" value="${category.categoryName}"> <br/>
		카테고리 가격 <input type="text" name="price" value="${category.price}"> <br>
		카테고리 이미지 <input type="text" name="uploadedImage" value="${category.categoryImage}" readonly="readonly"> 
						<input type="file" name="categoryImage"> <br>
		<input type="submit" value="수정">
		<input type="button" onclick="delCheck();" value="삭제">
	</fieldset>
</form>
</body>
</html>