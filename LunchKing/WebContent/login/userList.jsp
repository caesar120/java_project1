<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>유저 리스트</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>이메일</td>
			<td>연락처</td>
			<td>주소</td>
			<td>공동현관 비밀번호</td>
		</tr>
		<c:forEach items="${datas}" var="LoginBean">

			<tr>
				<td>${LoginBean.userId }</td>
				<td><a
					href="LoginControl.do?action=sel&userId=${LoginBean.userId }">
						${LoginBean.userName }</a></td>
				<td>${LoginBean.email }</td>
				<td>${LoginBean.phone }</td>
				<td>${LoginBean.addr }</td>
				<td>${LoginBean.gatepw }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>