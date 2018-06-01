<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<title>결제페이지</title>
<script>
function out(){
	orderform.submit();
}
function out2(){
	location.href="주문목록 페이지";
}

</script>
</head>
<body>
<h3>아이디</h3>
<form action="OrdersDetailControl" name="orderform" >
<input type="hidden" name="action" value="insert">
<table border="1">
	<tr>
		<td>상품명(카테고리id)</td>
		<td>주문개수</td>
		<td>배송시작일</td>
		<td>배송종료일</td>
		<td>금액</td>
	</tr>
	<c:forEach items="${sessionScope.orderDetails}" var="od">
	<tr>
		<td><input type="text" name="categoryId" value="${od.categoryId }"></td>
		<td><input type="text" name="orderCount" value="${od.orderCount }"></td>
		<td><input type="text" name="shipStartDate" value="${od.shipStartDate }"></td>
		<td><input type="text" name="shipEndDate" value="${od.shipEndDate }"></td>
		<td><input type="text" name="price" value="${od.price }"></td>
	</tr>
	</c:forEach>
	<tr>
		<td>총계</td> 
		<td>A:1</td>
		<td>B:1</td>
		<td>2개</td>
		<td>7000원</td>
	</tr>
	<tr>
		<td>주소</td>
		<td colspan="4"><input type="text" name="orderAddr" value=""></td>
	</tr>
	<tr>
		<td>공동현관비밀번호</td>
		<td colspan="4"><input type="text" name="gatePw" value=""></td>
	</tr>
</table>
<input type="button" value="결제" onclick="out()"/>
<input type="button" value="취소" onclick=""/>
</form>
</body>
</html>