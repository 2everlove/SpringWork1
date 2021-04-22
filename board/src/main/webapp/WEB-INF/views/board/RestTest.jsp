<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="#">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	getAjaxList();
	
	$("#getListBtn").on("click", function(){
		console.log("test");
	});
});
function getAjaxList(pageNo, bno, callback, error){
	
	$.ajax({
		// 서버 접속 URL
		url : '/reply/list/203',
		method  : 'get',
		// 반환 데이터 타입
		dataType : 'json',
		
		// 처리 성공
		success : function(datas, textStatus, jqXHR){
			console.log("success!");
			console.log("datas", datas);
			console.log("textStatus", textStatus);
			console.log("jqXHR", jqXHR);
			
			
			let tblContent = "";
			$.each(datas, function(i, data){
				tblContent += "<tr><td>"+data.reply+"</td><td>"+data.reply+"</td></tr>";
				
			});
			$('#repleTbl').append(tblContent);
			
			// 콜백함수가 있으면 콜백함수 실행
			if(callback){
				callback(data);
			}
			
		},
		
		// 처리 실패
		error : function(jqXHR, textStatus, errorThrown){
			console.log("error!");
			console.log("errorThrown", errorThrown);
			console.log("textStatus", textStatus);
			console.log("jqXHR", jqXHR);
			// 콜백함수가 있으면 콜백함수 실행
			if(error){
				error(errorThrown);
			}
			
		}
		
	});
	
}
</script>
</head>
<body>
	<button id="getListBtn">리스트</button>
	<br>
	<table border="1" id="repleTbl">
	
		<tr>
			<td>리플</td>
			<td>작성자</td>
		</tr>
	</table>

</body>
</html>