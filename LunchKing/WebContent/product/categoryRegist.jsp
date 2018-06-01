<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1> 카테고리 등록 </h1>
<form action="CategoryControl.do?action=ins" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>카테고리 등록</legend>
		카테고리코드 <input type="text" name="categoryId"> <br>
		카테고리명* <input type="text" name="categoryName"> <br/>
		카테고리 가격 <input type="text" name="price"> <br>
		카테고리 이미지 <input type="file" name="categoryImage"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</fieldset>
</form>
</body>
</html>