<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>  부서등록 </h1>
<form action="OrdersControl">
<input type="hidden" name="action" value="insert"/>
	<label >order_id	</label><input type="text" name="orderId"><br>
	<label >user_id		</label><input type="text" name="userId"><br>
	<label >order_date	</label><input type="date" name="orderDate"><br>
	<label >order_addr	</label><input type="text" name="orderAddr"><br>
	<label >total_price	</label><input type="text" name="totalPrice"><br>
	<input type="submit" value ="등록" />
</form>
</body>
</html>