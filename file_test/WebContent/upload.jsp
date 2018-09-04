<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
String rPath = request.getContextPath();
%> --%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>파일 업로드</title>
</head>
<body>
	<form action="/file_test/up/file" method="post" enctype="multipart/form-data"> 
		이름 : <input type="text" name="name"><br>
		성별 : <select name="trans">
			<option value="1">남</option>
			<option value="2">여</option>
		</select><br>
		파일 : <input type="file" name="file"><br>
		<button>전송</button>		
	</form>
</body>
</html>