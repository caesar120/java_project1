<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% session.invalidate(); %>
<%--// 여러개의 세션들중 선택하여 세션을 지워줍니다.

// 세션 속성명인 "id" 속성을 제거 합니다.

// invalidate : 현재 생성된 세션을 무효화 합니다.. --%>
<div align="center">
	<h3>로그아웃 되었습니다.</h3>
	<table border="1">
		<tr>
			<td><A href="../index.jsp">홈으로</A></td>
			<td><A href="login.jsp">로그인 페이지로 이동</A></td>
		</tr>
	</table>
</div>