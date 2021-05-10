<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
<link rel="shortcut icon" href="#">
<style>
.wrapper {
	width: 100%;
	background-color: gray;
}

.wrapper ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.wrapper ul li {
	list-style: none;
	padding: 10px;
}

.wrapper ul li img {
	width: 100px;
}
</style>


<!-- jQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function(){		
		
		$('#attachNo').on("change", function(){
			searchFile($('#attachNo').val());
		});
		

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
					//$('#attachNo').val(datas.attachNo);
					/* $("") 태그 $("#") id $(".") class */
					$('input[name=attachNo]').val(datas.attachNo);
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
					//이미지 썸네일의 경로를 인코딩 처리해서 서버에 보냄
					
					var s_savePath = encodeURIComponent(data.s_savepath);
					var savePath = encodeURIComponent(data.savepath);
					
					console.log("인코딩 후 : "+savePath);
					let fName = data.fileName;
					//만약 이미지면 이미지 보여줌
					if(data.filetype=='Y'){
						result += "<li>"
									+"<img src=/display?fileName="+s_savePath+"><br>"
									+"<a href=/display?fileName="+savePath+" download="+data.fileName+">"
									+data.fileName+"</a>"
									+" <a href=/download?fileName="+savePath+" download="+data.fileName+"><sub>[download]</sub></a>"
									+"  <span onclick=attachFileDelete('"+data.uuid+"','"+data.attachNo+"'); data-type='image' style='cursor: pointer'>❌</span></li>";
					} else {
						//이미지가 아니면 파일이름을 출력
						result += "<li>"
									+"<a href=/display?fileName="+savePath+" download='"+fName +"'><br>"
									+data.fileName+"</a>"
									+" <a href=/download?fileName="+savePath+" download='"+data.fileName+"'><sub>[download]</sub></a>"
									+"  <span onclick=attachFileDelete('"+data.uuid+"','"+data.attachNo+"'); style='cursor: pointer'>❌</span></li>";
					}
					
				});
				if(datas.length == 0){
					alert(attachNo+'번에 해당하는 데이터가 없습니다. 다시 검색해주세요.');
					$('#attachNo').val("");
					$('#attachNo').select();
				}
				$('#fileList').html(result);
				if($(location).attr('pathname').match('/board/get')){
					$('span[data-type=image]').remove();
				}
				
			},
			error : function(){
				
			}
		});
	}
	
	function attachFileDelete(uuid, attachNo){
		console.log(uuid);
		console.log(attachNo);
		$.ajax({
			url:'/attachFileDelete/'+uuid+'/'+attachNo,
			method:'get',
			success: function(datas){
				console.log(datas);
				searchFile(attachNo);
			},
			error : function(errorThrown){
				console.log(errorThrown);
			}
		})
	}
</script>
</head>
<body>

<div id="fileWrapper">
<form name="uploadForm" action="/uploadFormAction" method="post" enctype="multipart/form-data">
	<label>AttachNo: <input type="text" class="form-control" name="attachNo" id="attachNo"></label>
	<br>
	<br>
	<label>파일: <input type="file" name="uploadFile" id="fileUpload" multiple="multiple"></label>
	<br>
	<br>
	<!-- multiple 파일 여러개 보낼때 -->
	<button type="button" id="uploadBtn">Submit</button>
</form>
</div>
<br>
<div class="wrapper">
	<ul id="fileList">
		
	</ul>
</div>
</body>
</html>