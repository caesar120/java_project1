<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function goDetail(no){
		window.event.preventDefault();
		location.href="OrderDetailControl?action=sel&detailId="+no;
	}
</script>
</head>
<body>
<a href="OrdersControl?action=list">주문페이지로</a><br>
<a href="ordersDetail_insert.jsp">주문상세등록</a>
<table border="1" style="text-align:center">
		<tr>
			<th>주문상세 ID</th>
			<th>주문기간 </th>
			<th>배송시작일</th>
			<th>배송종료일 </th>
			<th>배송상태 </th>
			<th>주문ID</th>
			<th>주문갯수</th>
			<th>분류코드</th>
			<th>일시정지시작일</th>
			<th>정지취소일</th>
			<th>정지취소요청일</th>
			<th>주소</th>
		</tr>
	<c:forEach items="${od}" var="ordersDetail">
		<tr>
			<td><a href="OrdersDetailControl?action=sel&detailId=${ordersDetail.detailId }">${ordersDetail.detailId}</a></td>
			<td>${ordersDetail.orderTerm}</td>
			<td>${ordersDetail.shipStartDate}</td>
			<td>${ordersDetail.shipEndDate}</td>
			<td>${ordersDetail.shipState}</td>
			<td>${ordersDetail.orderId}</td>
			<td>${ordersDetail.orderCount}</td>
			<td>${ordersDetail.categotyId}</td>
			<td>${ordersDetail.pauseStartDate}</td>
			<td>${ordersDetail.pauseCancleDate}</td>
			<td>${ordersDetail.pauseRequestDate}</td>
			<td>${ordersDetail.orderAddr }</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>