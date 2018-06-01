<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
	.aa {color:red;
		background-color: #eee;}
</style>
</head>
<body>
<h1> 메뉴 등록 </h1>
<form action="MenuControl.do">
	<input type="hidden" name="action" value="ins"/>
	<fieldset>
		<legend>메뉴 등록</legend>		
		카테고리 &nbsp; <input class = "aa" type="text" name="menuCategoryId" readonly="readonly" value="${param.cate}"> <br>
		날짜 &nbsp; <input class = "aa" type="text" name="menuMonth" readonly="readonly"
						 value="${param.year}/${param.month}/${param.day}"> <br>
		제품ID &nbsp; 
			 <select name="prodId">
		<option>AA1</option>
		<option>AA2</option>
		<option>AB1</option>
		<option>AB2</option>
		<option>AC1</option>
		<option>AC2</option>

    </select ></b><br>
		<!-- prodName &nbsp; <input type="text" name="prodName" value=""> <br> -->
		
		<input type="submit" value="등록">
		<input type="" value="취소">
	</fieldset>
</form>
</body>
</html>