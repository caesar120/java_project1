<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>�Խñ��ۼ�</title>
<script src="../ckeditor_4/ckeditor.js"></script>
<script>
window.onload = function() { 
	CKEDITOR.replace( 'contents' ,{
			 filebrowserUploadUrl:'<%=request.getContextPath()%>
	/ckeditor_4/fileUpload.jsp?'
+ 'up_dir=/upload' + '&temp_dir=c:/Temp'
						});
	}
</script>
</head>
<body>
	<!-- boardIns.jsp -->
	<h3>�Խñ��ۼ�</h3>
	<form action="<%=request.getContextPath()%>/boardInsert.do">
		���� : <input type="text" name="subject"><br /> �ۼ���: <input
			type="text" name="poster"><br /> ����:
		<textarea name="contents" id="contents" rows="5" cols="40"></textarea>
		<br /> <input type="file" name="attatchFile" /><br /> <input
			type="submit" value="����">
	</form>
</body>
</html>