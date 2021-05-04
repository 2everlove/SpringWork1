<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<link rel="shortcut icon" href="#">
<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){		
		
		$('#attachNo').on("change", function(){
			searchFile($('#attachNo').val());
		})

		$("#uploadBtn").on("click", function(){
			if($('#fileUpload').val()==""){
				alert("파일을 선택하세요.");
				$('#fileUpload').click();
				return false;
			}
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
					alert(datas.count+"개가 업로드 되었습니다.");
					let attachNo = "";
					$('#attachNo').val(datas.attachNo);
					//document.uploadForm.uploadFile.value="";
					$('#fileupload').val("");
					searchFile(datas.attachNo);
				},
				error : function(errorThrown){
					console.log(errorThrown);
				}
			});
		});
	});
	
	function searchFile(attachNo){
		$.ajax({
			url:'/fileUploadAjax/'+attachNo,
			method : 'get',
			dataType : 'json',
			success : function(datas){
				let result ="";
				$.each(datas, function(i, data){
					console.log(data);
					result += "<li>"+data.fileName+"</li>";
				});
				if(datas.length == 0){
					alert(attachNo+'번에 해당하는 데이터가 없습니다. 다시 검색해주세요.');
					$('#attachNo').select();
				}
				$('#fileList').html(result);
			},
			error : function(){
				
			}
		});
	}
</script>
</head>
<body>

<form name="uploadForm" action="/uploadFormAction" method="post" enctype="multipart/form-data">
	<label>AttachNo: <input type="text" name="attachNo" id="attachNo"></label>
	<br>
	<br>
	<label>파일: <input type="file" name="uploadFile" id="fileUpload" multiple="multiple"></label>
	<br>
	<br>
	<!-- multiple 파일 여러개 보낼때 -->
</form>
	<button id="uploadBtn">Submit</button>
<div id="wrapper">
	<ul id="fileList">
		
	</ul>
</div>
</body>
</html>