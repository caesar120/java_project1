<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><title>Insert title here</title>
</head>
<body>
제목 ${board.title } <br>
내용 ${board.contents } <br>
첨부파일 <a href="BoardControl.do?no=${board.no}&action=download"> ${board.originalfileName } </a>
</body>
</html>