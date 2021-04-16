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
                            	방명록
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover">
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
                                       <td>${board.title}</td>
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
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <%@include file="../includes/footer.jsp" %>
