<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function delcheck(no) {
		if (confirm("삭제할까요?")) {
			location.href = "OrdersControl?action=delete&orderId="+no;
		}
	}
</script>
</head>
<body>
	<form action="OrdersControl" method="post">
		<input type="hidden" value="update" name="action"> 
		order_id	<input type="text" name="orderId" value="${orders.orderId}" readonly="readonly" /><br> 
		user_id		<input type="text" name="userId" value="${orders.userId}" readonly="readonly" /><br>
		order_date	<input type="text" name="orderDate" value="${orders.orderDate}" /><br> 
		total_price	<input type="text" name="totalPrice" value="${orders.totalPrice}" /><br> 
		order_addr	<input type="text" name="orderAddr" value="${orders.orderAddr}"  /><br> 
		<input type="submit" value="수정" /> 
		<input type="button" onclick="delcheck(${orders.orderId});" value="삭제" />
	</form>
</body>
</html>