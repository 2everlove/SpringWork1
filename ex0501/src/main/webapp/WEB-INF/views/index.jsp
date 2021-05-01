<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	  <h2>[ 메인 1]</h2>
	  <h2>[섹션 : ${ session_nickName } ]</h2>
	  <ul>
	    <li><a href="./login">로그인</a></li>
	    <li><a href="./logout">로그아웃</a></li>
	  </ul>
	
	</body>
</html>