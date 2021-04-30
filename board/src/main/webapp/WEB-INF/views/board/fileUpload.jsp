<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			console.log(formData.get("uploadFile"));
			//파일업로드 컨트롤러 -> 서버에 저장
			$.ajax({
				url : '/fileUploadAjax',
				method : 'POST',
				processData : false,
				contentType : false,
				data : formData,
				success : function(datas){
					console.log("success");
					console.log(datas);
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
	<input type="file" name="uploadFile" multiple="multiple">
	<!-- multiple 파일 여러개 보낼때 -->
</form>
	<button id="uploadBtn">Submit</button>

</body>
</html>