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
	
	function check(){
		const form = document.editForm;
		const title = form.title.value;
		const content = form.content.value;
		if(title==""){
			alert('제목을 입력해주세요.');
			form.title.select();
			return false;
		}
		else if(content==""){
			alert('내용을 입력해주세요.');
			form.content.select();
			return false;
		} else
			form.submit();
	}
	
</script>
</head>
<body>
	<h1>${board.writer}의  작성글</h1>
	<hr>
	<form name="editForm" action="/board/edit" method="post">
	<!-- Post는 절대 action태그에 ? 와 같은 쿼리를 전송하면 안된다. -->
		<table>
			<tr>
				<th>번호</th><td>${board.bno}<input type="text" name="bno" value="${board.bno}" hidden></td>
			</tr>
			<tr>
				<th>제목</th><td><input type="text" name="title" value="${board.title}"></td>
			</tr>
			<tr>
				<th>내용</th><td><textarea name="content">${board.content}</textarea></td>
			</tr>
			<tr>
				<th>작성자</th><td><input type="text" name="writer" value="${board.writer}"></td>
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
			<input type="button" value="수정" onclick="check()">  <a href="./list2"><input type="button" value="목록으로"></a>
		</div>
	</form>
	
</body>
</html>