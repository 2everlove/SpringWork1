<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
${resMsg}
<%@include file="../includes/header.jsp" %>
<input type="text" value="203" id="bno"><br>
<input type="text" id="rno">
<input type="text" id="pageNum" value="1">
        <div id="page-wrapper">
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
                        
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            
                            
                            
                           <!-- 답글 -->
                           <div class='row'>

							  <div class="col-lg-12">
							
							    <!-- /.panel -->
							    <div class="panel panel-default">
							      
							      <div class="panel-heading">
							        <i class="fa fa-comments fa-fw"></i> Reply
							        <button id='addReplyBtn' class='btn btn-primary btn-xs pull-right'>New Reply</button>
							      </div>      
							      
							      
							      <!-- /.panel-heading -->
							      <div class="panel-body">        
							      
							        <ul class="chat">
										<!-- <li class='left clearfix' data-rno='"+list.rno+"'>
										<div>
											<div class='header'><strong class='primary-font'>[1] 홍길동</strong> 
				    							<small class='pull-right text-muted'>12:00:00</small>
				    						</div>
				     						<p>수고가 많으십니다!</p>
				     					</div>
				     					</li> -->
				     					<li class='left clearfix' data-rno='"+list.rno+"'>
										<div>
											<textarea class="form-control" rows="3" ></textarea>
				     					</div>
				     					</li>
							        </ul>
							        <!-- ./ end ul -->
							      </div>
							      <!-- /.panel .chat-panel -->
							
								<div class="panel-footer">
					<div class='pull-right'>
						<ul class="pagination">
							<%-- <c:if test="${pageMaker.prev}">
								<li class="paginate_button previous"><a href="${pageMaker.startPage - 1}">Previous</a></li>
							</c:if>
							<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<c:choose>
								<c:when test="${page eq pageMaker.cri.pageNum}">
									<li class="paginate_button active"><a href="${num}">${num}</a></li>
								</c:when>
								<c:otherwise>
									<li class="paginate_button"><a href="${num}">${num}</a></li>
								</c:otherwise>
							</c:choose>
								<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""}"><a href="${num}">${num}</a></li>
							</c:forEach>
							<c:if test="${pageMaker.next}">
								<li class="paginate_button next"><a href="${pageMaker.endPage + 1}">Next</a></li>
							</c:if> --%>
						</ul>
					</div>
					<!-- end Pagination -->
								</div>
								
					
							
							
									</div>
							  </div>
							  <!-- ./ end row -->
							  
							  
							  
							</div>
                            
                            
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            
        </div>
        <!-- /#page-wrapper -->
			
			
			
        <!-- 모달 Modal -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                   <div class="modal-dialog">
                       <div class="modal-content">
                           <div class="modal-header">
                               <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                               <h4 class="modal-title" id="myModalLabel">Reply</h4>
                           </div>
                           <div class="modal-body">
                                 <ul class="list-group list-group-flush">
							    <li class="list-group-item">
									<input type="text" class="form-control ml-2" placeholder="replyer" id="replyer">
								</li>
								<li class="list-group-item">
									<textarea class="form-control" id="reply" placeholder="reply" rows="3"></textarea>
							    </li>
							</ul>
                           </div>
                           <div class="modal-footer">
                               <button type="button" class="btn btn-warnig" data-dismiss="modal" id="modify">Modify</button>
                               <button type="button" class="btn btn-danger" data-dismiss="modal" id="remove">Remove</button>
                               <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                               <button type="button" class="btn btn-primary" id="replyInsertBtn">Save</button>
                           </div>
                       </div>
                       <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>
        <!-- /.modal -->
<script type="text/javascript" src="/resources/js/reply.js"></script>      
<script type="text/javascript">
$(document).ready(function(){
	
	//addReplyBtn 클릭 시 modal창 띄움
	$('#addReplyBtn').on("click",function(){
		$('#replyInsertBtn').show();
		$('#reply').val("");
		$('#replyer').val("");
		$('#modify').hide();
		$('#remove').hide();
		$('#myModal').modal("show");
	});
	
	//저장버튼을 클릭하면 저장하고 모달창을 닫아줌
	//모달창을 닫은 후 리스트를 다시 조회
	$('#replyInsertBtn').on("click",function(){
		ajaxInsert();
	});
	
	$('#remove').on("click", function(){
		if(confirm('댓글('+$('#rno').val()+')을 지우시겠습니까?')){
			deleteAjax();
		}
	});
	
	$('#modify').on("click", function(){
		updateAjax();
	});
	
	//리스트 조회
	ajaxList();
});

function replyDetail(rno){
	//rno설정
	$('#rno').val(rno);
	//버튼 숨김
	$('#replyInsertBtn').hide();
	$('#modify').show();
	$('#remove').show();
	//modal show
	$('#myModal').modal("show");
	//선택한 reply의 값 가져오기
	getAjax();
}//

function replyPaging(pageNum){
	let startPage = pageNum.startPage; 
	let endPage = pageNum.endPage;
	let start = startPage-1;
	let end = endPage+1;
	console.log(pageNum.prev);
	console.log(pageNum.next);
	pageContent="";
	// 이전 페이지
	if(pageNum.prev){
		pageContent += '<li class="paginate_button previous" onclick=getList('+start+');><a href="#">Previous</a></li>';
	}
	console.log(startPage-1);
	for(startPage; startPage<=endPage; startPage++){
		pageContent += '<li class="paginate_button" onclick=getList('+startPage+');><a href="#" data-page="'+startPage+'">'+startPage+'</a></li>'
	}	
	
	//다음 페이지
	if(pageNum.next){
		pageContent += '<li class="paginate_button next" onclick=getList('+end+');><a href="#">Next</a></li>';
	}
	
	$(".pagination").html(pageContent);
	
}//

function getList(page){
	event.preventDefault();
	$('#pageNum').val(page);
	$()
	let pageNo = $('#pageNum').val(page);
	ajaxList();
}
</script>
<jsp:include page="../includes/footer.jsp"/>





