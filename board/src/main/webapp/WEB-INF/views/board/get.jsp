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
                       			<button type="submit" class="btn btn-default" onclick="location.href='/board/modify?bno=${board.bno}'">Modify</button>
                       			<button type="reset" class="btn btn-info" onclick="location.href='/board/list'">List</button>
                       		</div>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <%@include file="../includes/footer.jsp" %>
