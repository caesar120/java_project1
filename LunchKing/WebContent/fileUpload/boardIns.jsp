<%@ page contentType="text/html; charset=euc-kr" %>
<html>
<head><title>multipart ��</title></head>
<body>
<form action="FileUploadServlet.do" method="post" enctype="multipart/form-data" >
title: <input type="text" name="title" /> <br/>
����: <textarea rows="4" cols="50" name="contents"></textarea><br>
�ۼ���: <input type="text" name="username" /> <br/>
÷������: <input type="file" name="file1" /> <br/>

<input type="submit" value="����" />
</form>
</body>