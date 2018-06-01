<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	session.setAttribute("id", request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="refresh" content="3;url='../index.jsp'"/>
<title>Session Login</title>
</head>
<body>
	<div align="center">
		<h3>로그인 되었습니다.</h3>
		<h3>
			<%=session.getAttribute("login")%>
			님 환영합니다.
		</h3>
		<br>
		<h4>
			3초 후 홈으로 이동합니다.
		</h4>
		<table border="1">
			<tr>
				<td><A href="../main_logout.jsp"> 홈으로 </A></td>
				<td><A href="logout.jsp"> 로그아웃 </A></td>
			</tr>
		</table>
	</div>
</body>
</html>