<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- <!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>multiUpload</title>
</head>
 -->
<body>
	<form action="/file_test/up/files" method="post" enctype="multipart/form-data">
		파일1 : <input type="file" name="file1"><br>
		파일2 : <input type="file" name="file2"><br>
		파일3 : <input type="file" name="file3"><br>
		<button>다중전송</button>
	</form>
</body>
</html>