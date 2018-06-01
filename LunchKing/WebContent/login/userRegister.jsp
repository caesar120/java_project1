<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="login.css" type="text/css" media="screen" />
</head>
<body>
	<div align="center">
		<H1>회원가입</H1>

		<form action="LoginControl.do" method="post">
			<input type="hidden" name="action" value="ins">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="passwd"></td>
				</tr>
				<tr>
					<th>이 름</th>
					<td><input type="text" name="userName" maxlength="12"></td>
				</tr>
				<tr>
					<th>email</th>
					<td><input type="email" name="email" maxlength="50"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="tel" name="phone" maxlength="20"></td>
				</tr>

				<tr>
					<th>주소</th>
					<td><input type="text" name="addr" maxlength="20"></td>
				</tr>
				<tr>
					<th>공동현관 비밀번호</th>
					<td><input type="password" name="gatepw"></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="가입완료" >
					<input type=reset value="취소"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>