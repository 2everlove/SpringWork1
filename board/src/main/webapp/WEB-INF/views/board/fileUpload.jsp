<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#uploadBtn").on("click", function(){
			
			let formData = new FormData(document.uploadForm);
			console.log(formData.get("attachNo")+formData.get("uploadFile"));
			//파일업로드 컨트롤러 -> 서버에 저장
			$.ajax({
				url : '/fileUploadAjax',
				method : 'POST',
				dataType : 'json',
				processData : false,
				contentType : false,
				data : formData,
				success : function(datas){
					console.log("success");
					console.log(datas);
					let result =datas.length+"건<br>";
					alert("업로드 성공!");
					$.each(datas, function(i, data){
						result += data.fileName+"<br>";
					});
					$('#wrapper').html(result);
				},
				error : function(errorThrown){
					console.log(errorThrown);
				}
			});
		});
	});
</script>
</head>
<body>

<form name="uploadForm" action="/uploadFormAction" method="post" enctype="multipart/form-data">
	<input type="text" name="attachNo">
	<input type="file" name="uploadFile" multiple="multiple">
	<!-- multiple 파일 여러개 보낼때 -->
</form>
	<button id="uploadBtn">Submit</button>
<div id="wrapper">

</div>
</body>
</html>