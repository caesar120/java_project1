<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script>
	function list(no) {
		if (confirm("일시정지 신청을 취소할까요?")) {
			location.href = "OrdersDetailControl?action=list";
		}
	}
</script>
</head>
<body>
<h1>일시정지신청</h1>
	<form action="OrdersDetailControl" method="post">
		<input type="hidden" value="pause" name="action"> 
		pause_start_date<input type="date" name="pauseStartDate"value="${od.pauseStartDate}" /><br>
		pause_cancel_date<input type="date" name="pauseCancelDate"value="${od.pauseCancelDate}" /><br>  
		<input type="submit" value="신청" /> 
		<input type="button" onclick="list(${od.detailId});" value="취소" />
	</form>
</body>
</html>