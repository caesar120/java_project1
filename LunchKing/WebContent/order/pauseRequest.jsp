<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function sel(no) {
		if (confirm("취소할까요?")) {
			location.href = "OrdersDetailControl?action=sel&detailId="+no;
		}
	}
</script>
</head>
<body>
	<form action="OrdersDetailControl" method="post">
		<input type="hidden" value="cancel" name="action"> 
		pause_cancel_date<input type="text" name="pauseCancelDate" value="${od.pauseCancelDate}"  /><br> 
		pause_request_date<input type="text" name="pauseRequestDate" value="${od.pauseRequestDate}"  /><br>
		order_addr<input type="text" name="orderAddr"value="${od.orderAddr}" /><br> 
		<input type="submit" value="일시정지해제" />
		<input type="button" onclick="sel(${od.detailId});" value="삭제" />
	</form>
</body>
</html>