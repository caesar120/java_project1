<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script></script>
</head>
<body>
	<div align="center">
		<h1>회원수정</h1>
		<form action="LoginControl.do" method="post">
		<input type="hidden" name="action" value="upd"/>
			아이디 : <input type="text" name="userId" value="${login.userId}"  readonly="readonly"/><br>
			패스워드 : <input type="password" name="passwd" value="${login.passwd}" 
				required="required" autocomplete="on" autofocus="autofocus"/><br>
			이름 : <input type="text" name="userName" value="${login.userName}"  readonly="readonly"/><br>	 
			이메일 : <input type="text" name="email" value="${login.email}"/><br>
			연락처 : <input type="text" name="phone" value="${login.phone}"/><br> 
			주소 : <input type="text" name="addr" value="${login.addr}"/><br> 
			공동현관 비밀번호 : <input type="text" name="gatepw" value="${login.gatepw}"/><br>
			<input type="submit" value="수정완료">
			<INPUT type="reset" value="다시작성"><br>
		</form>
	</div>
</body>
</html>