<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	function goUpdForm() {
		location.href = "LoginControl.do?action=updForm";
	}
	function userDel() {
		location.href = "LoginControl.do?action=del";
	}
</script>
</head>
<body>
<div align="center">
		<h1>My page</h1>
		<form action="LoginControl.do" method="post">
		<input type="hidden" name="action" value="sel"/> 
			아이디 : <input type="text" name="userId" value="${login.userId}"  readonly="readonly"/><br>
			패스워드 : <input type="password" name="passwd" value="${login.passwd}"  readonly="readonly"
				required="required" autocomplete="on" autofocus="autofocus"  readonly="readonly"/><br> 
			이름 : <input type="text" name="userName" value="${login.userName}"  readonly="readonly"/><br>
			이메일 : <input type="text" name="email" value="${login.email}"  readonly="readonly"/><br>
			연락처 : <input type="text" name="phone" value="${login.phone}"  readonly="readonly"/><br> 
			주소 : <input type="text" name="addr" value="${login.addr}"  readonly="readonly"/><br> 
			공동현관 비밀번호 : <input type="text" name="gatepw" value="${login.gatepw}"  readonly="readonly"/><br> 
			<input type="button" value="회원정보 수정" onclick="goUpdForm()">
			<INPUT type="reset" value="다시작성"><br>
			<input type="button" value="회원 탈퇴" onclick="userDel()">
		</form>
	</div>
</body>
</html>