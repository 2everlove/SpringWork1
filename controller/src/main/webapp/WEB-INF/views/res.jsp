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
	RES
</h1>

<P>  The time on the server is 
<br>
<br>
<hr>
<br>
<p style="color: purple;"> 시간  : ${ServerTime}
</body>
</html>
