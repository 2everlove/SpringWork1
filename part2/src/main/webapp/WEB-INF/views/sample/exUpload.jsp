<%@ page contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<html>
<head>
<link rel="shortcut icon" href="#">
	<title>Main</title>
</head>
<body>
<h1>파일 등록</h1>
<hr>

<form action="/sample/exUpload" method="post" enctype="multipart/form-data">
	<div><input type="file" name="files"></div>
	<div><input type="file" name="files"></div>
	<div><input type="file" name="files"></div>
	<div><input type="submit" value="등록"></div>
</form>
</body>
</html>
