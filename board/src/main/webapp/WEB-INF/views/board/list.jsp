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
			<div class="panel-heading">Board List Page
				<button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
						<c:forEach items="${list}" var="board">
						<tr class="odd gradeX">
							<td>${board.bno}</td>
							<td><a href='/board/get?bno=${board.bno}'>${board.title}</a></td>
							<td>${board.writer}</td>
							<!-- regdate와 updateDate가 String 형태라 우선 Date형태로 만듬 -->
							<fmt:parseDate var="regDate" value="${board.regdate}" pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:parseDate var="updateDate" value="${board.updateDate}" pattern="yyyy-MM-dd HH:mm:ss" />
							<!-- 따온 Date 형식을 내가 원하는 pattern으로 바꿈 -->
							<fmt:formatDate value="${regDate}" pattern="yy.MM.dd" var="regdate"/>
							<td>${regdate}</td>
							<c:choose>
							<c:when test="${empty board.updateDate}">
							<td>${regdate}</td>
							</c:when>
							<c:otherwise>
							<fmt:formatDate value="${updateDate}" pattern="yy.MM.dd" var="update"/>
							<td>${update}</td>
							</c:otherwise>
							</c:choose>
						</tr>
						</c:forEach>
					</table>
					<!-- /.table-responsive -->
					<div class='pull-right'>
						<ul class="pagination">
							<c:if test="${pageMaker.prev}">
								<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">Previous</a></li>
							</c:if>
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
								<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next}">
								<li class="paginate_button next"><a href="${pageMaker.endPage + 1}">Next</a></li>
							</c:if>
						</ul>
					</div>
					<!-- end Pagination -->
					<form id='actionForm' action="/board/list" method='get'>
						<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
						<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
					</form>
					<!-- modal 추가 -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="mymodalLabel">Modal Title</h4>
								</div>
								<div class="modal-body">처리가 완료되었습니다.</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
									<button type="button" class="btn btn-primary">Save changes</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal -->
				</div>
<!-- /.panel-body -->
		</div>
<!-- /.panel -->
	</div>
<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>
<script type="text/javascript">
	$(document).ready(function(){
		const message = '<c:out value="${resMsg}"/>';
		checkModal(message);
		function checkModal(message){
			if(message === "" || history.state){
				return;
			}
			if("" != message && null != message){
				$(".modal-body").html("게시글 "+parseInt(message)+" 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		$("#regBtn").on("click", function(){
			self.location = "/board/register";
		});
		
		const actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e){
			e.preventDefault();
			console.log('click');
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
		});
	});
</script>
