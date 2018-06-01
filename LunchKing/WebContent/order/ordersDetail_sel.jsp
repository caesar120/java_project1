<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function delcheck(no) {
		if (confirm("삭제할까요?")) {
			location.href = "OrdersDetailControl?action=delete&detailId="+no;
		}
	}
	function pause(no) {
		location.href = "OrdersDetailControl?action=pause&detailId="+no;
	}
</script>
</head>
<body>
	<form action="OrdersDetailControl" method="post">
		<input type="hidden" value="update" name="action"> 
		detail_id<input	type="text" name="detailId" value="${od.detailId}"readonly="readonly" /><br> 
		order_id<input type="text"	name="orderId" value="${od.orderId}" readonly="readonly" /><br>
		category_id<input type="text" name="categoryId" value="${od.categoryId}" /><br> 
		order_count<input type="text" name="orderCount"value="${od.orderCount}" /><br> 
		order_term<input type="text" name="orderTerm" value="${od.orderTerm}"  /><br> 
		ship_start_date<input type="text" name="shipStartDate" value="${od.shipStartDate}" /><br> 
		ship_end_date<input	type="text" name="shipEndDate" value="${od.shipEndDate}"/><br> 
		ship_state<input type="text"	name="shipState" value="${od.shipState}"/><br>
		pause_start_date<input type="text" name="pauseStartDate"value="${od.pauseStartDate}" /><br> 
		pause_cancel_date<input type="text" name="pauseCancelDate" value="${od.pauseCancelDate}"  /><br> 
		pause_request_date<input type="text" name="pauseRequestDate" value="${od.pauseRequestDate}"  /><br>
		order_addr<input type="text" name="orderAddr"value="${od.orderAddr}" /><br> 
		<input type="submit" value="수정" /> 
		<input type="button" onclick="delcheck(${od.detailId});" value="삭제" />
		<input type="button" onclick="pause(${od.detailId});" value="일시정지신청" />
	</form>
</body>
</html>