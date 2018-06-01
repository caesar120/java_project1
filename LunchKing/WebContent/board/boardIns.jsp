<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<title>게시글작성</title>
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
	<h3>게시글작성</h3>
	<form action="<%=request.getContextPath()%>/boardInsert.do">
		제목 : <input type="text" name="subject"><br /> 작성자: <input
			type="text" name="poster"><br /> 내용:
		<textarea name="contents" id="contents" rows="5" cols="40"></textarea>
		<br /> <input type="file" name="attatchFile" /><br /> <input
			type="submit" value="저장">
	</form>
</body>
</html>