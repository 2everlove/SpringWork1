<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<style type="text/css">
	*{
		align-content: center;
		text-align: center;
		margin: 0 auto;
	}
</style>
	<title>main</title>
</head>
<body>
<h1>
	File Upload
</h1>
<br>
<P>  The FUS (File Upload System) 
<br>
<br>
<hr>
<br>
<form action="/fileUpload" method="post" enctype="multipart/form-data">
	<p><input type="file">
	<p><input type="file">
	<p><input type="file">
	<p><input type="file">
	<p><input type="file">
	<br>
	<p><input type="submit">
	
	<br>
	1.폼을 잘못선택했을 떄
	<br>
	2. name id
</form>
</body>
</html>
