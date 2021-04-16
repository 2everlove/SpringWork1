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
<title>List(${board.writer})</title>
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
		const msg = "${resMsg}";
		if(msg != "")
			alert(msg);	
	});
</script>
</head>
<body>
	<h1>${board.writer}의  작성글</h1>
	<hr>
	<table>
		<tr>
			<th>번호</th><td>${board.bno}</td>
		</tr>
		<tr>
			<th>제목</th><td>${board.title}</td>
		</tr>
		<tr>
			<th>내용</th><td>${board.content}</td>
		</tr>
		<tr>
			<th>작성자</th><td>${board.writer}</td>
		</tr>
		<tr>
			<th>수정일</th>
			<c:choose>
				<c:when test="${empty board.updateDate}">
				<fmt:parseDate var="parseRegDate" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${parseRegDate}" pattern="yy.MM.dd HH:mm:ss" var="time"/>
					<td>${time}</td>
					
				</c:when>
				<c:otherwise>
					<fmt:parseDate var="parseRegDate" value="${board.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate value="${parseRegDate}" pattern="yy.MM.dd HH:mm:ss" var="time"/>
					<td>${time}</td>
				</c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th>작성일</th>
			<fmt:parseDate var="parseRegDate" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
			<fmt:formatDate value="${parseRegDate}" pattern="yy.MM.dd HH:mm:ss" var="time"/>
			<td>${time}</td>
		</tr>
	</table>
	<div style="text-align: right; margin: 20px 20%">
		<button onclick="location.href='edit?bno=${board.bno}'">수정</button>  
		<a href="delete?bno=${board.bno}" onclick="return confirm('삭제하시겠습니까?')")><button>삭제</button></a> 
		<a href="./list2"><input type="button" value="목록으로"></a>
	</div>
</body>
</html>