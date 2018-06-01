<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>multipart 폼</title></head>
<body>
<form action="FileUploadServlet.do" method="post" enctype="multipart/form-data" >
title: <input type="text" name="title" /> <br/>
내용: <textarea rows="4" cols="50" name="contents"></textarea><br>
작성자: <input type="text" name="username" /> <br/>
첨부파일: <input type="file" name="file1" /> <br/>

<input type="submit" value="전송" />
</form>
</body>