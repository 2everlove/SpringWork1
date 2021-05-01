<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		   function boardWrite(){
			   alert("함수 실행"); 
			   var data_html="";
			   $.ajax({
				  url:"/ajaxBoard",
				  type:"get",
				  data:{
					 "sno":$("#sno").val(),
					 "stitle":$("#stitle").val(),
					 "sdate":$("#sdate").val(),
					 "sname":$("#sname").val(),
					 "shit":$("#shit").val()
				  },
				  contentType:"application/json",
				  success:function(data){
					  data_html += "<tr>";
					  data_html += "<td>"+data.sno+"</td>";
					  data_html += "<td>"+data.stitle+"</td>";
					  data_html += "<td>"+data.sdate+"</td>";
					  data_html += "<td>"+data.sname+"</td>";
					  data_html += "<td>"+data.shit+"</td>";
					  data_html += "</tr>";
					  $("#board").prepend(data_html);  
					  $("#sno").val('');
					  $("#stitle").val('');
					  $("#sdate").val('');
					  $("#sname").val('');
					  $("#shit").val('');
				  },
				  error:function(){
					  alert("에러");
				  }
			   });
		   }
		
		
		</script>
		
		
		<style>
		  table,th,td{border:1px solid black; border-collapse:collapse;}
		</style>
	</head>
	<body>
		  <form action="">
		    <label>번호</label>
		    <input type="text" id="sno" name="sno"><br>
		    <label>글제목</label>
		    <input type="text" id="stitle" name="stitle"><br>
		    <label>날짜</label>
		    <input type="text" id="sdate" name="sdate"><br>
		    <label>작성자</label>
		    <input type="text" id="sname" name="sname"><br>
		    <label>조회수</label>
		    <input type="text" id="shit" name="shit"><br>
		    <input type="button" onclick="boardWrite()" value="글작성"><br>
		  </form>
	      <p></p>
	
		 <table>
		   <tr>
		     <th>번호</th>
		     <th>글제목</th>
		     <th>날짜</th>
		     <th>작성자</th>
		     <th>조회수</th>
		   </tr>
		   <tbody id="board">
		       <!-- prepend추가 -->
		       
		       <!-- prepend끝 -->
			   <tr>
			     <td>${sno}</td>
			     <td>${stitle}</td>
			     <td>${sdate}</td>
			     <td>${sname}</td>
			     <td>${shit}</td>
			   </tr>
			   
		   </tbody>
		 </table>
	
	</body>
</html>