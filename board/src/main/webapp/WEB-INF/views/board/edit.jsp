<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Board Modify Page
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/edit" method="post">
					<input type="hidden" name="pageNum" value="${cri.pageNum}">
					<input type="hidden" name="amount" value="${cri.amount}">
					<input type="hidden" name="type" value="${cri.type}">
					<input type="hidden" name="keyword" value="${cri.keyword}">
					
					<div class="form-group">
						<label>Bno</label><input class="form-control" name="bno" value='<c:out value="${board.bno}"/>' readonly="readonly">
					</div>
					<div class="form-group">
						<label>Title</label><input class="form-control" name="title" value='<c:out value="${board.title}"/>'>
					</div>
					<div class="form-group">
						<label>Text area</label><textarea class="form-control" rows="3" name="content">${board.content}</textarea>
					</div>
					<div class="form-group">
						<label>Writer</label><input class="form-control" name="writer" value='<c:out value="${board.writer}"/>'>
					</div>
	
					<fmt:parseDate var="regDate" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:parseDate var="updateDate" value="${board.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" />
					<!-- 따온 Date 형식을 내가 원하는 pattern으로 바꿈 -->
					<fmt:formatDate value="${regDate}" pattern="yy.MM.dd" var="regdate"/>
					
					<div class="form-group">
						<label>RegDate</label><input class="form-control" value='<c:out value="${regdate}"/>' readonly="readonly">
						<input type="hidden"  class="form-control" name="regDate" value='<c:out value="${regDate}"/>'>
					</div>
	
					<div class="form-group">
						<label>Update Date</label>
						<c:choose>
							<c:when test="${empty board.updateDate}">
								<input class="form-control" value='<c:out value="${regdate}"/>' readonly="readonly">
								<input type="hidden" class="form-control" name="updateDate" value='<c:out value="${regDate}"/>'>
							</c:when>
							<c:otherwise>
								<fmt:formatDate value="${updateDate}" pattern="yy.MM.dd" var="update"/>
								<input type="hidden"  class="form-control" name="updateDate" value='<c:out value="${update}"/>' readonly="readonly">
							</c:otherwise>
						</c:choose>
					</div>
					<button type="submit" data-oper='edit' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='delete' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		const formObj = $("form");
		
		$('button').on("click", function(e){
			
			e.preventDefault();
			
			const operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'delete'){
				if(confirm('삭제하시겠습니까?'))
					formObj.attr("action","/board/delete");
				else
					return;
			} else if(operation === 'list'){
				formObj.attr("action","/board/list").attr("method","get");
				
				//clone으로 요소값을 const로 선언된 변수에 할당
				const pageNumTag= $("input[name='pageNum']").clone();
				const amountTag= $("input[name='amount']").clone();
				const keywordTag= $("input[name='keyword']").clone();
				const typeTag= $("input[name='type']").clone();
				
				//요소의 내용을 지움
				formObj.empty();
				
				//변수에 할당된 요소 값을 form에 생성해줌
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			formObj.submit();
		});
	});
</script>
<%@include file="../includes/footer.jsp" %>
