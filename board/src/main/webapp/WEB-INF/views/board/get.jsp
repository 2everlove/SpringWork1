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
                            	Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                       		<div class="form-group">
                       			<label>Bno</label><input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
                       		</div>
                       		<div class="form-group">
                       			<label>Title</label><input class="form-control" name="title" value="${board.title}" readonly="readonly">
                       		</div>
                       		<div class="form-group">
                       			<label>Text area</label><textarea class="form-control" rows="3" name="content" readonly="readonly">${board.content}</textarea>
                       		</div>
                       		<div class="form-group">
                       			<label>Writer</label><input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
                       		</div>
                       		<div>
                       			<button data-oper='edit' class="btn btn-default">Modify</button>
                       			<button data-oper='list' class="btn btn-info">List</button>
                       		</div>
                       		<form id='operForm' action="/board/edit" method="get">
					           	<input type="hidden" id="bno" name="bno" value="<c:out value="${board.bno}" />">
					           	<input type="hidden" name="pageNum" value="${cri.pageNum}">
								<input type="hidden" name="amount" value="${cri.amount}">
								<input type="hidden" name="type" value="${cri.type}">
								<input type="hidden" name="keyword" value="${cri.keyword}">
				            </form>
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
            		const operForm = $("#operForm");
            		$("button[data-oper='edit']").on("click", function(e){
            			operForm.attr("action","/board/edit").submit();
            		});
            		$("button[data-oper='list']").on("click", function(e){
            			operForm.find("#bno").remove();
            			operForm.attr("action","/board/list")
            			operForm.submit();
            		});
            	})
            </script>
