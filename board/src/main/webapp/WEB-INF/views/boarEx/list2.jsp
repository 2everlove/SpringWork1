<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#">
<script type="text/JavaScript"  src=http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js></script>
<meta charset="UTF-8">
<title>List</title>
<style type="text/css">
	h1{text-align: center;}	
	table, tr, td, th{border-collapse: collapse; border: 1px solid black;}
	table{text-align: center; margin: 0 auto; margin-top:30px; width: 500px;}
	th{background-color: #b2bec3;}
	.table__list:nth-child(2n-1) {background-color:#dfe4ea;}
	.table__list:hover {background-color:#dff9fb;}
	a{
		text-decoration: none; color: #0984e3;
	}
</style>
<script type="text/javascript">
	$(document).ready(function(){
		const message = "${resMsg}";
		if("" != message && null != message)
			alert(message);
	});
</script>
</head>
<body>
	<h1>List Page</h1>
	<hr>
	<br>
	<p style="position: absolute; right: 17%; top: 25%;"><a href="./register"><input type="button" value="글작성"></a></p>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	<c:forEach items="${list}" var="board">
		<tr class="table__list">
			<td>${board.bno}</td>
			<td><a href="./get?bno=${board.bno}">${board.title}</a></td>
			<td>${board.writer}</td>
			<fmt:parseDate var="parseRegDate" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
			<fmt:formatDate value="${parseRegDate}" pattern="yy.MM.dd" var="time"/>
			<td>${time}</td>
		</tr>
	</c:forEach> 
	</table>
</body>
</html>