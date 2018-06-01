<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<hr>
<table border="1">
	<tr>
		<td>상품명</td>
		<td>개수</td>
		<td>개별가격</td>
		<td>총가격</td>
	</tr>
	<tr>
		<td><input type ="checkbox"> A</td>
		<td><input type="number" value="1">4개</td>
		<td>1000원</td>
		<td>4000원</td>
	</tr>
	<tr>
		<td><input type ="checkbox"> B</td>
		<td><input type="number" value="1">3개</td>
		<td>2000원</td>
		<td>6000원</td>
	</tr>
	<tr>
	<td rowspan="3">A:4 b:3 총 10000원</td>
	</tr>

</table>
<input type="button" value="모두 결제" />
<input type="button" value="선택 결제" />
<input type="button" value="취소" />
<input type="button" value="상품페이지로" />
</body>
</html>