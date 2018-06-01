<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login</title>
<script>
function goInsForm() {
	location.href = "LoginControl.do?action=insForm";
}
function loginCheck() {
	location.href = "LoginControl.do?action=check";
}
</script>
</head>
<body>
<FORM action="LoginControl.do"  method="post">
<input type="hidden" name="action" value="check">
	<table border="1" cellspacing="0" width="400" height="100">
		<tr>
			<td align="right">
				<FONT size="2"> 아이디 : </FONT>
			</td>
			<td>
				<INPUT type="text" name="userId" size="10">
			</td>
		</tr>
		<tr>
			<td align="right">
				<FONT size="2"> 비밀번호 : </FONT>
			</td>
			<td>
				<INPUT type="password" name="passwd" size="12">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" >
				<input type="reset" value="다시작성">
				<input type="button" value="회원가입" onclick="goInsForm();">
			</td>
		</tr>
	</TABLE>
</FORM>
</body>
</html>