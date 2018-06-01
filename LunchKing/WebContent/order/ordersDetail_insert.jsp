<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<h1>  주문상세등록 </h1>
<form action="OrdersDetailControl">
<input type="hidden" name="action" value="insert"/>
	<label >detail_id	</label><input type="text" name="detailId"><br>
	<label >order_id		</label><input type="text" name="orderId"><br>
	<label >category_id	</label><input type="text" name="categoryId"><br>
	<label >ship_startdate	</label><input type="date" name="shipStartDate"><br>
	<label >ship_enddate	</label><input type="date" name="shipEndDate"><br>
	<label >ship_state	</label><input type="text" name="shipState"><br>
	<label >order_term		</label><input type="text" name="orderTerm"><br>
	<label >order_count	</label><input type="text" name="orderCount"><br>
	<label >pause_start_date	</label><input type="date" name="pauseStartDate"><br>
	<label >pause_request_date	</label><input type="date" name="pauseRequestDate"><br>
	<label >pause_cancle_date	</label><input type="date" name="pauseCancleDate"><br>
	<input type="submit" value ="등록" />
</form>
</body>
</html>