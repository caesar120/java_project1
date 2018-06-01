<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="orders_insert.jsp">주문등록</a><br>
<a href="OrdersDetailControl?action=list">주문상세목록</a>
<table border="1" style="text-align:center">
		<tr>
			<th>주문번호 </th>
			<th>유저아이디 </th>
			<th>주문일</th>
			<th>주문주소 </th>
			<th>총가격 </th>
		</tr>
	<c:forEach items="${od}" var="orders">
		<tr>
			<td><a href= "OrdersControl?action=select&orderId=${orders.orderId}">${orders.orderId}</a></td>
			<td>${orders.userId}</td>
			<td>${orders.orderDate}</td>
			<td>${orders.orderAddr}</td>
			<td>${orders.totalPrice}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>